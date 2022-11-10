import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { User } from './user';

@Injectable({
  providedIn: 'root'
})
export class RegisterService {
  logOut() {
    throw new Error('Method not implemented.');
  }
 
  baseUrl = "http://localhost:8081/registerUser";
  constructor(private httpClient : HttpClient) { }

  registerUser(user : User) : Observable<Object>{
    console.log(user);
    return this.httpClient.post(`${this.baseUrl}`,user);
  }
  getloginUserName() {
   console.log("Hi");
  }
}
