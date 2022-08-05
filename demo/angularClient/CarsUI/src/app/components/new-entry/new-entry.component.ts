import { Component, OnInit } from '@angular/core';
import { FormGroup } from '@angular/forms';

@Component({
  selector: 'app-new-entry',
  templateUrl: './new-entry.component.html',
  styleUrls: ['./new-entry.component.css']
})
export class NewEntryComponent implements OnInit {

  newCarForm: FormGroup;

  constructor() {
    this.newCarForm = new FormGroup({

    })
  }

  ngOnInit(): void {
  }

  
}
