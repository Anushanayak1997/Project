import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class UsermodelService {

  constructor( public firstName:string,
    public lastName: string,
    public emailID:string,
    public password:string,
    public contactNumber:string,
    public userType:string,
    public companyID:string = null,
    public companyName:string = null) { }
}


