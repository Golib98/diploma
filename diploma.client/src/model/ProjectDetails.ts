import {FileWrapper} from "./gen/FileWrapper";

export class ProjectDetails {
  public id: string;
  public title: string;
  public description: string;
  public updateDate: Date;
  public deadline: Date;
  public publishedDate: Date;
  public fileIds: FileWrapper[];
  public isOpened: boolean;
  public author: string;
}
