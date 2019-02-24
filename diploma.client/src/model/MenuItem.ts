export class MenuItem {
  public label: string;
  public routerLink: string;

  public static of(label: string, routerLink: string): MenuItem {
    let ret = new MenuItem();
    ret.label = label;
    ret.routerLink = routerLink;
    return ret;
  }

  public static defaultList(): MenuItem[] {
    let ret: MenuItem[] = [];
    ret.push(
      MenuItem.of("Universities", "/universities"),
      MenuItem.of("Rankings", ""),
      MenuItem.of("Best Students", ""),
      MenuItem.of("News", ""),
      MenuItem.of("Jobs", ""),
      MenuItem.of("About", ""),
      MenuItem.of("Help", ""),
      MenuItem.of("Login/Sign Up", "/registration")
    );
    return ret;
  }

  public static professorList(): MenuItem[] {
    let ret: MenuItem[] = [];
    ret.push(
      MenuItem.of("Universities", "/universities"),
      MenuItem.of("Assistants", "/assistants"),
      MenuItem.of("My projects", "/my-projects"),
    );
    return ret;
  }
}
