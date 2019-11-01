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

  topics = ["JobSeeker","Employer","Admin"];

  userModel = new loginUser('', '',"");
  

  goRegister(){
    this.router.navigate(['register']);
  }

  validateTopic(value) {
    if (value === 'default') {
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
            if(this.userModel.userType=="Employer"){
              
             sessionStorage.setItem('user_id',this.response.userId);
             sessionStorage.setItem('company_id',this.response.companyId);
             setTimeout(() => 
             {
               
               this.router.navigate(['company/jobpost']);
             },
             2000);
             this.Toaster.success("successfully logged In");
           }

            else {
              setTimeout(() => 
              {
                sessionStorage.setItem('user_id',this.response.userId);
                this.router.navigate(['seeker/home']);
              },
              2000);
              this.Toaster.success("successfully logged In");
            }
          }  
    
      }


      
    )
    
      
    }

    

  }
