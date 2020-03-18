import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { SaleComponent } from './components/sale/sale.component';
import { ProductComponent } from './components/stock/stock.component';
import { HomeComponent } from './components/home/home.component';
import { ConsultsComponent } from './components/consults/consults.component';


const routes: Routes = [
  { path: '', redirectTo:'/home', pathMatch:'full'},
  { path: 'home', component: HomeComponent },
  { path: 'stock', component: ProductComponent },
  { path: 'sale', component: SaleComponent },
  { path: 'consult', component: ConsultsComponent },
  { path: '**', redirectTo: '/home', pathMatch:'full'}

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
