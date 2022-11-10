import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class DashboardService {
  token = localStorage.getItem("token");
  baseUrl = "http://localhost:8081/";
  username = localStorage.getItem("userName");
  constructor(private httpClient: HttpClient) { }
  putReview(review: any, id: any): Observable<any> {

    let headers = new Headers();

    headers.append('Content-Type', 'application/json');

    return this.httpClient.put(`${this.baseUrl}insertReview/` + id, review,
      {
        headers: {
          Authorization: `Bearer ${this.token}`
        }
      });
  }
  getProductById(id: any): Observable<any> {
    return this.httpClient.get(`${this.baseUrl}getProductById/{id}`, id);
  }

  getProductReviews(productObj:any) :Observable<any>{
    let id= productObj.productCode;
    let headers = new Headers();
    headers.append('Content-Type', 'application/json');
    return this.httpClient.get('http://localhost:8081/getAllReview/'+id, {
      headers: {
        Authorization: `Bearer ${this.token}`
      }
    })
  }

  getAllProducts() :Observable<any>{
    console.log("Products fetched");
    let headers = new Headers();
    headers.append('Content-Type', 'application/json');
    return this.httpClient.get('http://localhost:8081/getAllProducts', {
      headers: {
        Authorization: `Bearer ${this.token}`
      }
    })
  }
  getProductListBySearch(productSearch: any): Observable<any> {
    console.log(productSearch);
    let headers = new Headers();
    headers.append('Content-Type', 'application/json');
    return this.httpClient.get('http://localhost:8081/getProductBySearch/' + productSearch.productCode, {
      headers: {
        Authorization: `Bearer ${this.token}`
      }
    })
  }
}
