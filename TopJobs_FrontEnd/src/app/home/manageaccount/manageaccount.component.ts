import { Component, OnInit } from '@angular/core';
import { environment } from 'src/environments/environment';
import { HttpClient } from '@angular/common/http';
import { ToastrService } from 'ngx-toastr';

@Component({
  selector: 'app-manageaccount',
  templateUrl: './manageaccount.component.html',
  styleUrls: ['./manageaccount.component.css']
})
export class ManageaccountComponent implements OnInit {

  getuserurl=environment.apiBaseUrl+"getuserbyid";
  User:any;
  manage={'oldPwd':"",'newPwd':"",'confPwd':""};
  updateuserurl=environment.apiBaseUrl+"edituser";
  constructor(private http:HttpClient,private Toaster:ToastrService) { }



  ngOnInit() {

    this.getUser();
  }

  getUser(){
    this.http.get(this.getuserurl+"/"+sessionStorage.getItem('user_id')).subscribe((Response)=>{
      this.User=Response;
      console.log(this.User);
    })
  }
  onNext(){
    if(this.manage.oldPwd!=this.User.password ){
      this.Toaster.error("old password doesn't match!!!!");
    }
    if(this.manage.newPwd!=this.manage.confPwd){
      this.Toaster.error("new password doesn't match confirmed password");
    }
    if(this.manage.newPwd==this.User.password){
      this.Toaster.error("new password cannot be same as old password");
    }
    if(this.manage.oldPwd==this.User.password && this.manage.newPwd==this.manage.confPwd){
      this.User.password=this.manage.newPwd;
      console.log(this.User);
      this.http.put(this. updateuserurl,this.User).subscribe((Response)=>{

        this.Toaster.success("password changed");
        
      })
    }
  }
}
