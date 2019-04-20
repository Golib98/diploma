package kz.greetgo.diploma.register.impl.email;

import java.io.ByteArrayInputStream;
import javax.mail.internet.MimeUtility;
import kz.greetgo.email.Attachment;
import kz.greetgo.email.Email;
import kz.greetgo.email.EmailSender;
import kz.greetgo.email.from_spring.javamail.JavaMailSender;
import kz.greetgo.email.from_spring.javamail.MimeMessageHelper;
import org.fest.util.Strings;

public class EmailSender_to_JavaMailSender implements EmailSender {

  private JavaMailSender javaMailSender;


  public EmailSender_to_JavaMailSender(JavaMailSender javaMailSender) {
    this.javaMailSender = javaMailSender;
  }

  @Override
  public void send(final Email email) {

    // checking consistency of email - if there is any data in FROM and TO fields
    if (!Strings.isNullOrEmpty(email.getTo())) {
      if (Strings.isNullOrEmpty(email.getFrom()))
        email.setFrom(email.getTo());
      javaMailSender.send(mimeMessage -> {
        MimeMessageHelper message = new MimeMessageHelper(mimeMessage, true, "UTF-8");
        message.setFrom(email.getFrom());
        message.setTo(email.getTo());
        message.setSubject(email.getSubject());
        message.setText(email.getBody(), true);

        for (final Attachment attachment : email.getAttachments()) {
          message.addAttachment(MimeUtility.encodeText(attachment.name), () -> new ByteArrayInputStream(attachment.data));
        }
      });
    }
  }

}
