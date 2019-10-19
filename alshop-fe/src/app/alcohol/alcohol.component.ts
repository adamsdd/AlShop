import { Component, OnInit } from '@angular/core';
import { AlcoholService } from "../shared";


@Component({
  selector: 'app-alcohol',
  templateUrl: './alcohol.component.html',
  styleUrls: ['./alcohol.component.css']
})
export class AlcoholComponent implements OnInit {

  alcohols: Array<any>;

  constructor(private alcoholService: AlcoholService) { }

  ngOnInit() {
    this.alcoholService.getAll().subscribe(
      data => {
        this.alcohols = data;
        console.log(this.alcohols);
      },
      error => console.log(error)
    )
  }

}
