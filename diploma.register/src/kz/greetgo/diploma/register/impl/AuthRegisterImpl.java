package kz.greetgo.diploma.register.impl;

import kz.greetgo.depinject.core.Bean;
import kz.greetgo.depinject.core.BeanGetter;
import kz.greetgo.diploma.controller.errors.IllegalLoginOrPassword;
import kz.greetgo.diploma.controller.model.PersonDisplay;
import kz.greetgo.diploma.controller.model.SessionHolder;
import kz.greetgo.diploma.controller.model.UserToSave;
import kz.greetgo.diploma.controller.register.AuthRegister;
import kz.greetgo.diploma.register.dao.AuthDao;
import kz.greetgo.diploma.register.model.PersonLogin;
import kz.greetgo.email.Email;
import kz.greetgo.email.EmailSender;
import kz.greetgo.security.password.PasswordEncoder;
import kz.greetgo.security.session.SessionIdentity;
import kz.greetgo.security.session.SessionService;
import kz.greetgo.util.RND;

@Bean
public class AuthRegisterImpl implements AuthRegister {

  public BeanGetter<AuthDao> authDao;
  public BeanGetter<PasswordEncoder> passwordEncoder;
  public BeanGetter<SessionService> sessionService;

  @Override
  public SessionIdentity login(String username, String password) {

    PersonLogin personLogin = authDao.get().selectByUsername(username);
    if (personLogin == null) {
      throw new IllegalLoginOrPassword();
    }

    if (!passwordEncoder.get().verify(password, personLogin.encodedPassword)) {
      throw new IllegalLoginOrPassword();
    }

    SessionHolder sessionHolder = new SessionHolder(personLogin.id, null);

    return sessionService.get().createSession(sessionHolder);
  }

  private final ThreadLocal<SessionHolder> sessionDot = new ThreadLocal<>();

  @Override
  public void resetThreadLocalAndVerifySession(String sessionId, String token) {
    sessionDot.set(null);

    if (!sessionService.get().verifyId(sessionId)) {
      return;
    }

    if (!sessionService.get().verifyToken(sessionId, token)) {
      return;
    }

    sessionDot.set(sessionService.get().getSessionData(sessionId));
  }

  @Override
  public SessionHolder getSession() {
    return sessionDot.get();
  }

  @Override
  public PersonDisplay displayPerson(String personId) {
    PersonDisplay ret = authDao.get().loadDisplayPerson(personId);

    if (ret == null) {
      throw new NullPointerException("No person with id = " + personId);
    }

    return ret;
  }

  @Override
  public void deleteSession(String sessionId) {
    sessionService.get().removeSession(sessionId);
  }

  public BeanGetter<EmailSender> emailSender;

  @Override
  public void signUpPerson(UserToSave userToSave) {

    String roleId = authDao.get().loadRoleId(userToSave.type);
    String univerId = authDao.get().loadUniverId(userToSave.university);

    String pass = RND.str(10);
    String encodedPass = passwordEncoder.get().encode(pass);

    authDao.get().insertPerson(userToSave, roleId, univerId, encodedPass);

    Email email = new Email();
    email.setBody("You pass is " + pass + "<br> and login " + userToSave.userName);
    email.setFrom("golibjon98@gmail.com");
    email.setTo(userToSave.email);
    email.setSubject("Registration in diploma!");

    System.out.println("PASS " + pass);

    new Thread(() -> emailSender.get().send(email)).start();

  }
}
