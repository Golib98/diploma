export class MenuItem {
  public label: string;
  public routerLink: string;
  public subMenu: MenuItem[] = [];

  public static of(label: string, routerLink: string): MenuItem {
    let ret = new MenuItem();
    ret.label = label;
    ret.routerLink = routerLink;
    return ret;
  }

  public static defaultList(): MenuItem[] {
    let ret: MenuItem[] = [];
    ret.push(
      MenuItem.of("Organizations", "/universities"),
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

    let assistants: MenuItem = new MenuItem();
    assistants.label = 'Assistants';
    assistants.subMenu.push(MenuItem.of('My assistants', '/my-assistants'));
    assistants.subMenu.push(MenuItem.of('All assistants', '/all-assistants'));

    ret.push(
      MenuItem.of("Organizations", "/universities"),
      assistants,
      MenuItem.of("My projects", "/my-projects"),
    );

    return ret;
  }

  public static assistantList(): MenuItem[] {
    let ret: MenuItem[] = [];


    let professional: MenuItem = new MenuItem();
    professional.label = 'Professional';
    professional.subMenu.push(MenuItem.of('Organizations', '/universities'));
    professional.subMenu.push(MenuItem.of('Projects', '/all-projects'));


    ret.push(
      professional,
      MenuItem.of("Blogs", "/my-projects"),
      MenuItem.of("News", ""),
      MenuItem.of("Jobs", ""),
      MenuItem.of("About", ""),
      MenuItem.of("Help", ""),
    )
    ;

    return ret;
  }
}
