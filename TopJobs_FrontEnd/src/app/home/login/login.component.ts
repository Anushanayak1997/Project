import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { loginUser } from '../H_user';
import { HttpClient } from '@angular/common/http';
import { environment } from 'src/environments/environment';
import { CookieService } from 'ngx-cookie-service';
import { ToastrService } from 'ngx-toastr';



@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})


export class LoginComponent implements OnInit {
  topicHasError = true;
  submitted = false;
  errorMsg = '';
  login:any;
  url = environment.apiBaseUrl +"loginuser";
  status:boolean = false;
  cookieValue:string;
  response: any;


  constructor(private router: Router,private _http: HttpClient,private cookieService: CookieService,private Toaster:ToastrService) { }
  
  ngOnInit() {
    this.cookieValue = this.cookieService.get('firstName');
  }

  topics = ["JobSeeker","Employer"];

  userModel = new loginUser('', '',"");
  

  goRegister(){
    this.router.navigate(['register']);
  }

  validateTopic(value) {
    if (value === '') {
      this.topicHasError = true;
    } else {
      this.topicHasError = false;
    }
  }

  onSubmit(){
  //  this.cookieValue = this.cookieService.get('firstName');
   
    console.log("before")

    this.login={
      emailId:this.userModel.emailID,
      password:this.userModel.password
    }

  /*  this.cookieService.set("email",this.login.email);
    this.cookieValue = this.cookieService.get('email');
    console.log("-->"+this.cookieValue)
    this.router.navigate(['home'])*/
    
    this._http.post(this.url,this.login).subscribe(
      (response)=>{
        console.log(response);
        if(response!=null){
          
          this.response=response;

          console.log(response)
          this.status = true;
        }
        else{
          this.Toaster.error("error")
        }

          if(this.status==true){
            sessionStorage.setItem('user_type',this.userModel.userType);
            
            if(this.userModel.userType=="Employer"){
              console.log("employer enetered"); 
             sessionStorage.setItem('user_id',this.response.userId);
            
              console.log("hi employeer");
              console.log(sessionStorage.getItem('company_id'));

             if( !this.response.companyId){
              console.log("plss go");
            
             this.router.navigate(['company/details']);

             }
            else{
            sessionStorage.setItem('company_id',this.response.companyId);
            this.router.navigate(['company/jobpost'])
            }
             this.Toaster.success("successfully logged In");
           }

            else {
              
             
                console.log("jobseeker");
                sessionStorage.setItem('user_id',this.response.userId);
                console.log("user_id")
                console.log(sessionStorage.getItem('user_id'));
                this.router.navigate(['loading...']);
              
              
              this.Toaster.success("successfully logged In");
            }
          }  
    
      }


      
    )
    
      
    }

    register(){
      this.router.navigate(['register']);
    }
    }