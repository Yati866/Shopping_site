import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class HomestatsService {
 
  

  token = localStorage.getItem("token");
  baseUrl = "http://localhost:8081/";

  constructor(private httpClient : HttpClient) {
    this.getPokemon();
   }

  getPokemon() {
    let headers = new Headers();
    headers.append('Content-Type', 'application/json');
    return  this.httpClient.get('http://localhost:8081/getstats', {
      headers : {
        Authorization: `Bearer ${this.token}`
      }  } ) 
  
  }
  
}
