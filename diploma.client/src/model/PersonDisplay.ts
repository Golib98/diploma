import {UserCan} from "./UserCan";

export class PersonDisplay {
  public fio: string;
  public username: string;
  public role: string;
  public cans: UserCan[];

  public static of(a: any): PersonDisplay {
    const ret = new PersonDisplay();
    ret.assign(a);
    return ret;
  }

  assign(a: any) {
    this.fio = a.fio;
    this.role = a.role;
    this.username = a.username;
    this.cans = (a.cans instanceof Array) ? a.cans.map(c => c) : [];
  }
}
