import { Component, Input, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Product } from '../product';
import { Review } from '../review';
import { DashboardService } from '../dashboard.service';
import { RegisterService } from '../register.service';


@Component({
  selector: 'app-add-review',
  templateUrl: './add-review.component.html',
  styleUrls: ['./add-review.component.css']
})
export class AddReviewComponent implements OnInit {
  selectedValue = 0;
  error = "";
  @Input() productData :any;
  product: Product = new Product();
  review : Review = new Review();
  stars: number[] = [1, 2, 3, 4, 5];

  constructor(private dashBoardservice: DashboardService, private registerService: RegisterService, private route: ActivatedRoute, private router: Router) { }
   id: any
  ngOnInit(): void {
    // this.id = this.route.snapshot.paramMap.get('productCode');
    console.log(this.productData);
    this.id= this.productData.productCode;
    // if (this.registerService.getloginUserName() != null) {
    //   this.review.userName = this.registerService.getloginUserName()
    // }
    // this.getProduct()
    
  }
 

  //This method is used to initialize the value in selectedValue 
  countStar(star: any) {
    this.selectedValue = star;
    console.log('Value of star', star);
  }

  //This method is used to get  reviews from client side and store into  database through api
  getFormData() {
    this.review.rating = this.selectedValue;
    if (this.review.rating == 0) {
      this.error = "Please rate in between 1 and 5!";
    }
    else {
      this.error = "";
      console.log(this.review);
      this.dashBoardservice.putReview(this.review, this.id).subscribe((data: any) => {
        this.id = data;
        alert("Review submitted successfully !!")
      }, (error: any) => {
        alert("Oops! Something went wrong.")
        console.log(error)
        this.ngOnInit();
      })


    }
  }

  //This method is used for logout user
  logOutLogin() {
    this.registerService.logOut();
    location.reload();
  }

}
