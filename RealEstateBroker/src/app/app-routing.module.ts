import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LoginComponent } from './users/login/login.component';
import { SignupComponent } from './users/signup/signup.component';
import { BrokerComponent } from './users/broker/broker.component';

const routes: Routes = [
  {path:'signIn',component:LoginComponent},
  {path:'signup',component:SignupComponent},
  {path:'broker',component:BrokerComponent}

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
