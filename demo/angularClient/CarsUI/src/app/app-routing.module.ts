import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { InventoryComponent } from './components/inventory/inventory.component';
import { CustPageComponent } from './cust-page/cust-page.component';

const routes: Routes = [
  { path: 'inventory', component: InventoryComponent},
  { path: 'customers', component: CustPageComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
