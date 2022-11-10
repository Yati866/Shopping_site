import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { DashboardComponent } from './dashboard/dashboard.component';
import { HomeComponent } from './home/home.component';
import { LoginComponent } from './login/login.component';
import { RegistrationComponent } from './registration/registration.component';
import { AddReviewComponent } from './add-review/add-review.component';
import { ProductListComponent } from './product-list/product-list.component';
import { ViewListComponent } from './view-list/view-list.component';
import { AuthGuard } from './services/auth.guard';


const routes: Routes = [
  {path:"login",component:LoginComponent},
  {path:"registration",component:RegistrationComponent},
  {path:"dashboard",component:DashboardComponent,canActivate:[AuthGuard]},
  {path:"home",component:HomeComponent},
  {path:"productlist/:productSearch",component:ProductListComponent,canActivate:[AuthGuard]},
  {path:"viewlist/:productCode",component:ViewListComponent,canActivate:[AuthGuard]}, 
  {path:"addReview/:productCode",component:AddReviewComponent,canActivate:[AuthGuard]},
  {path:"",redirectTo:'/home',pathMatch:'full'}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
  providers: [AuthGuard]
})
export class AppRoutingModule { }
