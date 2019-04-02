export class AllAssistantsIn {
  public firstName: string;
  public lastName: string;
  public birthDate: Date;

  constructor(name: string, lastName: string, birthDate: Date) {
    this.firstName = name;
    this.lastName = lastName;
    this.birthDate = birthDate;
  }
}
