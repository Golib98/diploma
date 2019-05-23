package kz.greetgo.diploma.controller.register;

import java.util.List;
import kz.greetgo.diploma.controller.model.AllAssistantsIn;
import kz.greetgo.diploma.controller.model.PersonRecord;
import kz.greetgo.diploma.controller.model.ProfessorInfo;

public interface PersonRegister {
  List<PersonRecord> list();

  List<PersonRecord> listOf(AllAssistantsIn allAssistantsIn);

  List<PersonRecord> myAssistants(String personId);

  ProfessorInfo professorInfo(String personId);

  ProfessorInfo studentInfo(String personId);

  List<PersonRecord> myResponds(String personId);

  void sendMail(String fromIf, String toId, String topic, String body);
}
