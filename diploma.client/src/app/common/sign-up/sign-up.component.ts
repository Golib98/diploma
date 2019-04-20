import {Component, OnInit} from '@angular/core';
import {RegistrationUserType} from "../../../model/RegistrationUserType";
import {RegistrationUser} from "../../../model/RegistrationUser";
import {UserToSave} from "../../../model/UserToSave";
import {SignUpService} from "./sign-up.service";
import {TextPair} from "../../../model/TextPair";

@Component({
  selector: 'app-sign-up',
  templateUrl: './sign-up.component.html',
  styleUrls: ['./sign-up.component.scss']
})
export class SignUpComponent implements OnInit {
  RegistrationUserType = RegistrationUserType;

  userTypes: RegistrationUser[] = [
    new RegistrationUser('Student', RegistrationUserType.STUDENT),
    new RegistrationUser('Professor', RegistrationUserType.PROFESSOR)
  ];

  universities: TextPair[];
  titles: TextPair[];
  faculties: TextPair[];

  currentUserType: RegistrationUserType;
  currentUniversity: number;
  currentTitle: number;
  currentFaculty: number;
  currentLastName: string;
  currentFirstName: string;
  currentEmail: string;
  currentPhone: string;
  currentUsername: string;

  constructor(private signUpService: SignUpService) {
  }

  ngOnInit() {
    this.signUpService.dict.then(value => {
      this.universities = value.universities;
      this.faculties = value.faculties;
      this.titles = value.titles;
    });
  }

  changeCurrentUserType(value: RegistrationUserType) {
    this.currentUserType = value;
  }

  verify = !(
    this.currentUsername
  );

  verifyForm(): boolean {
    return !!this.currentUniversity;
  }

  saveUser() {
    const userToSave = new UserToSave();
    userToSave.firstName = this.currentFirstName;
    userToSave.lastName = this.currentLastName;
    userToSave.userName = this.currentUsername;
    userToSave.faculty = this.faculties[this.currentFaculty].value;
    userToSave.email = this.currentEmail;
    userToSave.phone = this.currentPhone;
    userToSave.university = 'IITU';

  }
}
