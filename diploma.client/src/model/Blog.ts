import {environment} from "../environments/environment";

export class Blog {
  public id: string;
  public title: string;
  public article: string;
  public imageId: string;
  public files: FileList;


  url() {

    if (this.imageId) {
      return environment.urlPrefix + '/files/get2?fileId=' + this.imageId;
    }
    
    return 'assets/img/blog1.jpg';
  }

}
