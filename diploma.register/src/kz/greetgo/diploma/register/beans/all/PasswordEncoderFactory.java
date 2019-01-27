package kz.greetgo.diploma.register.beans.all;

import kz.greetgo.depinject.core.Bean;
import kz.greetgo.security.password.PasswordEncoder;

import static kz.greetgo.security.SecurityBuilders.newPasswordEncoderBuilder;

@Bean
public class PasswordEncoderFactory {
  @Bean
  public PasswordEncoder createPasswordEncoder() {
    return newPasswordEncoderBuilder().setSalt("Tg7k3CJ7Ar").build();
  }
}
