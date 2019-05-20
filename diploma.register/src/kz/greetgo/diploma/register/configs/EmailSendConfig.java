package kz.greetgo.diploma.register.configs;

import kz.greetgo.conf.hot.DefaultBoolValue;
import kz.greetgo.conf.hot.DefaultIntValue;
import kz.greetgo.conf.hot.DefaultStrValue;
import kz.greetgo.conf.hot.Description;

@Description("Параметры сервера отправки писем")
public interface EmailSendConfig {
  @Description("Количество дней хранения отправленных писем")
  @DefaultIntValue(5)
  int daysToSaveSended();

  @Description("Дополнительный параметр отправки писем")
  @DefaultBoolValue(false)
  boolean mailDebug();

  @Description("Хост сервера отправки писем")
  @DefaultStrValue("smtp.gmail.com")
  String serverHost();

  @Description("Пароль акаунта на сервере отправки писем")
  @DefaultStrValue("aogaasiftgvyivsh")
  String serverPassword();

  @Description("Порт сервера отправки писем")
  @DefaultIntValue(465)
  int serverPort();

  @Description("Имя акаунта на сервере отправки писем")
  @DefaultStrValue("golibjon98@gmail.com")
  String serverUsername();

  @Description("Хост сервера отправки писем")
  @DefaultBoolValue(true)
  boolean smtpAuth();

  @Description("Дополнительный параметр отправки писем")
  @DefaultBoolValue(true)
  boolean smtpSSLEnable();

  @Description("Дополнительный параметр отправки писем")
  @DefaultBoolValue(true)
  boolean smtpStartTlsEnable();

  @Description("Протокол отправки писем")
  @DefaultStrValue("smtp")
  String transportProtocol();

  @Description("Нужен ли новый инстанс объекта отправки email")
  @DefaultBoolValue(false)
  boolean needNewInstance();
}
