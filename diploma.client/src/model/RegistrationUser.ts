import {RegistrationUserType} from "./RegistrationUserType";

export class RegistrationUser {
  public title: string;
  public type: RegistrationUserType;

  constructor(title: string, type: RegistrationUserType) {
    this.title = title;
    this.type = type;
  }
}
