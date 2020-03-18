import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { ProductComponent } from './components/stock/stock.component';
import { FormsModule } from '@angular/forms';
import { ProductService } from './components/stock/stock.service';
import { HttpClientModule } from '@angular/common/http';
import { SaleComponent } from './components/sale/sale.component';
import { AppComponent } from './app.component';
import { HomeComponent } from './components/home/home.component';
import { ConsultsComponent } from './components/consults/consults.component';


@NgModule({
  declarations: [
    ProductComponent,
    SaleComponent,
    AppComponent,
    HomeComponent,
    ConsultsComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule
  ],
  providers: [ProductService],
  bootstrap: [AppComponent]
})
export class AppModule { }
