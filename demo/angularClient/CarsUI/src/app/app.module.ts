import { HttpClient, HttpClientModule } from '@angular/common/http';
import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { CarService } from 'src/service/carService/car.service';


import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { InventoryComponent } from './components/inventory/inventory.component';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { NavBarComponent } from './components/nav-bar/nav-bar.component';
import { CustPageComponent } from './components/cust-page/cust-page.component';
import { CustomerService } from 'src/service/customerService/customer.service';


@NgModule({
  declarations: [
    AppComponent,
    InventoryComponent,
    NavBarComponent,
    CustPageComponent,

  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    NgbModule,
  ],
  providers: [CarService, CustomerService],
  bootstrap: [AppComponent]
})
export class AppModule { }
