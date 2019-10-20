import { Component } from '@angular/core';
import {Alcohol} from "./domain/Alcohol";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'alshop-fe';

  public newAlcohol: Alcohol;

  addedNewAlcohol(alcohol: Alcohol) {
    this.newAlcohol= alcohol;
  }

}
