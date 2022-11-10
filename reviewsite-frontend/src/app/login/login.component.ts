import { Component, OnInit } from '@angular/core';
import { LoginService } from '../login.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

 

  credentials={
    emailId:'',
    password:''
  }

  constructor(private loginService : LoginService) { }

  ngOnInit(): void {
  }
  onSubmit(){
   
    if((this.credentials.emailId!='' && this.credentials.password!='') && (this.credentials.emailId!=null && this.credentials.password!=null)) {
      console.log("login sucess");
      this.loginService.doLogin(this.credentials).subscribe(
        (response:any)=>{
            console.log(response.token);
            this.loginService.loginUser(response.token)
            this.loginService.loggedinUser(response.userName)
            window.location.href = "/dashboard"
        },
        error=>{
          alert("Bad Credentials! Please enter correct details !");
          console.log(error);
        }
        
      )
    }
    else{
      alert("Please enter credentials !!");
      console.log("Fields are empty");
    }
  }

}
