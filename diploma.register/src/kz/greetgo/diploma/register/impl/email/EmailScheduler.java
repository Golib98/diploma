package kz.greetgo.diploma.register.impl.email;

import java.util.Properties;
import kz.greetgo.depinject.core.Bean;
import kz.greetgo.depinject.core.BeanGetter;
import kz.greetgo.diploma.register.configs.EmailSendConfig;
import kz.greetgo.email.EmailSender;
import kz.greetgo.email.from_spring.javamail.JavaMailSenderImpl;

@Bean
public class EmailScheduler {

  public BeanGetter<EmailSendConfig> config;

  @Bean
  public EmailSender emailSender() {
    JavaMailSenderImpl javaMailSender = new JavaMailSenderImpl();
    {
      javaMailSender.setHost(config.get().serverHost());
      javaMailSender.setPort(config.get().serverPort());
      javaMailSender.setUsername(config.get().serverUsername());
      javaMailSender.setPassword(config.get().serverPassword());
      Properties pp = new Properties();
      pp.setProperty("mail.transport.protocol", config.get().transportProtocol());
      pp.setProperty("mail.smtp.auth", config.get().smtpAuth() + "");
      pp.setProperty("mail.smtp.ssl.enable", config.get().smtpSSLEnable() + "");
      pp.setProperty("mail.smtp.starttls.enable", config.get().smtpStartTlsEnable() + "");
      pp.setProperty("mail.debug", config.get().mailDebug() + "");
      javaMailSender.setJavaMailProperties(pp);
    }

    return new EmailSender_to_JavaMailSender(javaMailSender);
  }
}
