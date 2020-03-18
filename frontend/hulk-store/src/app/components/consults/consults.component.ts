import { Component } from '@angular/core';
import { ProductService } from '../stock/stock.service';
import { Product } from '../stock/stock.model';

@Component({
  selector: 'app-consults',
  templateUrl: './consults.component.html',
  styleUrls: ['./consults.component.css']
})
export class ConsultsComponent{

  id: number;
  name: string;
  quantity: number;
  product = new Product();
  message: string;

  constructor(private stockService: ProductService) { }

  getProduct() {
    this.message="";
    this.stockService.getProduct(this.id).subscribe((product) => {
      this.product=product;
    },
    (error) => {this.message = error.error.message});   
  }

  updateProduct() {
    this.message=""
    this.stockService.getProduct(this.id).subscribe((product) => {
      this.product=product;
      this.product.name=this.name;
      this.stockService.updateProduct(this.id, this.product).subscribe(() => {
        this.stockService.listProducts();
        this.getProduct();
        this.message="Updated name"
      },
      (error) => {this.message = error.error.message});
    },
    (error) => {this.message = error.error.message}); 
  }

  deleteProduct() {
    this.message="";
    console.log(this.id)
    this.stockService.getProduct(this.id).subscribe((product) => {
      this.product=product;
      console.log("Cantidad stock")
      console.log(this.product.quantity)
      if (this.product.quantity == 0) {
        this.stockService.deleteProduct(this.id).subscribe(()=>{ 
          this.message="Item removed";
        },
        (error)=>{this.message = error.error.message});
      }
      this.message="Cannot be removed. There are units in stock."      
    },
    (error) => {this.message = error.error.message});     
  }
}
