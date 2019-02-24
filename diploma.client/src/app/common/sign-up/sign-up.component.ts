import {Component, OnInit} from '@angular/core';
import {RegistrationUserType} from "../../../model/RegistrationUserType";
import {RegistrationUser} from "../../../model/RegistrationUser";
import {Pair} from "../../../model/Pair";

@Component({
  selector: 'app-sign-up',
  templateUrl: './sign-up.component.html',
  styleUrls: ['./sign-up.component.scss']
})
export class SignUpComponent implements OnInit {
  RegistrationUserType = RegistrationUserType;

  userTypes = [
    new RegistrationUser('Student', RegistrationUserType.STUDENT),
    new RegistrationUser('Professor', RegistrationUserType.PROFESSOR)
  ];
  universities = [
    new Pair<number, string>(1, 'IITU'),
    new Pair<number, string>(2, 'IITU2')
  ];
  titles = [
    new Pair<number, string>(1, 'TITLE'),
    new Pair<number, string>(2, 'TITLE2')
  ];
  faculties = [
    new Pair<number, string>(1, 'Faculty'),
    new Pair<number, string>(2, 'Faculty2')
  ];

  currentUniversity: number;
  currentTitle: number;
  currentFaculty: number;
  currentUserType: RegistrationUserType;

  constructor() {
  }

  ngOnInit() {
  }

  changeCurrentUserType(value: RegistrationUserType) {
    this.currentUserType = value;
  }

  verifyForm(): boolean {
    return !!this.currentUniversity;
  }
}
