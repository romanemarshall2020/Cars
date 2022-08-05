import { HttpClientModule } from '@angular/common/http';
import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { NgBootstrapFormValidationModule } from 'ng-bootstrap-form-validation';
import { AppRoutingModule } from 'src/app/app-routing.module';
import { AppComponent } from 'src/app/app.component';
import { CarService } from 'src/service/carService/car.service';
import { CustomerService } from 'src/service/customerService/customer.service';
import { NewEntryComponent } from './new-entry.component';


@NgModule({
  declarations: [
    AppComponent,

  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    NgbModule,
    NgBootstrapFormValidationModule.forRoot()
  ],
  providers: [CarService, CustomerService],
  bootstrap: [AppComponent]
})
export class AppModule { }
