export class AllAssistantCard {
  public name: string;
  public isButtonsDisabled: boolean = false;
  public photoUrl: string;

  public static of(a: any): AllAssistantCard {

    let ret = new AllAssistantCard();
    ret.name = a.fio;
    ret.photoUrl = a.fio + 'url';

    return ret;
  }
}
