import { Component } from '@angular/core';
import { Product } from '../stock/stock.model';
import { ProductService } from '../stock/stock.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent {

  id:number;
  name:string;
  quantity:number;
  textMessage:string;
  products:Product[];

  constructor(private stockService: ProductService) {
    this.listProducts();
  }

  listProducts() {
    this.textMessage="";
    this.stockService.listProducts().subscribe((products) => {
      this.products=products;      
    },
    (error) => {this.textMessage = error.error.message});
  }
}
