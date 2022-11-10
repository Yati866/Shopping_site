import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
 
@Injectable({
  providedIn: 'root'
})
export class LoginService {
  baseUrl = 'http://localhost:8081/auth';

  constructor(private http:HttpClient) { }

  doLogin(credentials : any){
      return this.http.post(`${this.baseUrl}`,credentials);
  }
  loginUser(token: any){
     localStorage.setItem("token",token);
     return true;
  }
  loggedinUser(userName:any){
    localStorage.setItem("userName",userName);
    return true;
  }
  isLoggedIn(){
    let token = localStorage.getItem("token");
    if(token == undefined && token == null && token==='' ){
      return false;
    }else{
      return true;
    }
  }

  logout(){
    localStorage.removeItem("token")
    return true;
  }

  getToken(){
    return localStorage.getItem("token")
  }
}
