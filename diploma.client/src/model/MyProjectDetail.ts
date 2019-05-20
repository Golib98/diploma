import {FileWrapper} from "./gen/FileWrapper";

export class MyProjectDetail {
  public id: string;
  public title: string;
  public description: string;
  public requirements: string;
  public suggestions: string;
  public link: string;
  public deadline: Date;
  public isOpened: boolean;
  public files: FileList;
  public fileIds: FileWrapper[];
}
