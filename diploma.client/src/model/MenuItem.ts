export class MenuItem {
  public label: string;
  public routerLink: string;

  public static of(label: string, routerLink: string): MenuItem {
    let ret = new MenuItem();
    ret.label = label;
    ret.routerLink = routerLink;
    return ret;
  }
}
