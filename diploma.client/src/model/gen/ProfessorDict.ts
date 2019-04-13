export class ProfessorDict {
  public id: string;
  public fio: string;

  static of(id: string, fio: string): ProfessorDict {
    let ret: ProfessorDict = new ProfessorDict();
    ret.fio = fio;
    ret.id = id;
    return ret;
  }
}
