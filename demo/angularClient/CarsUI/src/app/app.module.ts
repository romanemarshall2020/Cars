import { HttpClient, HttpClientModule } from '@angular/common/http';
import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { CarService } from 'src/service/car.service';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { InventoryComponent } from './inventory/inventory.component';


@NgModule({
  declarations: [
    AppComponent,
    InventoryComponent,

  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
  ],
  providers: [CarService],
  bootstrap: [AppComponent]
})
export class AppModule { }
