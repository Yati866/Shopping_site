import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';


@Injectable({
  providedIn: 'root'
})
export class ProductService {
   token = localStorage.getItem("token");

  baseUrl = "http://localhost:8081";
  constructor(private httpClient : HttpClient) { }
  getProductById(id:any): Observable<any>{
    console.log(id)
    // return this.httpClient.get(`${this.baseUrl}/getProductById/{id}`,id);
    let headers = new Headers();
      headers.append('Content-Type', 'application/json');
  return  this.httpClient.get('http://localhost:8081/getProductById/'+id.productCode, {
    headers : {
      Authorization: `Bearer ${this.token}`
    }  } ) 
  }

  getProductListBySearch(productSearch : any) :  Observable<any>{
    console.log(productSearch);
    let headers = new Headers();
    headers.append('Content-Type', 'application/json');
    return  this.httpClient.get('http://localhost:8081/getProductBySearch/'+productSearch, {
      headers : {
        Authorization: `Bearer ${this.token}`
      }  } ) 
  }
}

