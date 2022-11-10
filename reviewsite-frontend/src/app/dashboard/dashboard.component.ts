import { Component, OnInit } from '@angular/core';
import { LoginService } from '../login.service';
import { RegisterService } from '../register.service';
import { Product } from '../product';
import { User } from '../user';
import { ProductService } from '../product.service';
import { DashboardService } from '../dashboard.service';

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.css']
})

export class DashboardComponent implements OnInit {

  routeToAddreview = false;
  user:any;
  product : Product = new Product();
  public loggedIn = false;
  productList! : any;
  productData : any;
  proData:any;
  routeToReview =false;
  reviewArr : any = []; 

  constructor( private loginService : LoginService,private dashboardService:DashboardService, private registerService : RegisterService, private productService : ProductService) { }
    
  ngOnInit(): void {
    this.user = this.dashboardService.username;
    this.routeToReview = false;
    this.getAllProducts();
    this.loggedIn = this.loginService.isLoggedIn()
  }
   
  getReviews(productObj : any){
    this.dashboardService.getProductReviews(productObj).subscribe((data:any)=>{
      this.reviewArr = data;
      console.log(this.reviewArr);
    }, (error: any) => {
      console.log(error);
    })
  }

  getAllProducts(){
    this.dashboardService.getAllProducts().subscribe((data:any)=>{
      this.productList = data;
      console.log("Products are here.");
    }, (error: any) => {
      console.log(error);
    })
  }

  getProductByCode(data:any){
    this.proData = data;
    console.log("routing fomdashborad ")
    this.routeToReview = true;
    console.log(data);
  }
  getProductListBySearchs(searchValue:any){
    this.productList =[];
    console.log(searchValue.search)
    this.productService.getProductListBySearch(searchValue.search).subscribe((data: Product) => {
      this.productList = data;
      console.log(this.productList);
    }, (error: any) => {
      console.log(error)
    })
  }
  logoutUser(){ 
    this.loginService.logout();
    location.reload();
  }
}
