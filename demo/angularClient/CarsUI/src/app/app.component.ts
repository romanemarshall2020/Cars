import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  cars: any;
  title: string;
  constructor() {
    this.title = 'Cars Homepage';
  }
}
