import {Component, Input, OnInit} from '@angular/core';
import { AlcoholService } from "../shared";
import {Alcohol} from "../domain/Alcohol";
import {FormBuilder} from "@angular/forms";


@Component({
  selector: 'app-alcohol',
  templateUrl: './alcohol.component.html',
  styleUrls: ['./alcohol.component.css']
})
export class AlcoholComponent implements OnInit {

  @Input()
  newAlcohol: Alcohol;
  alcohols: Array<Alcohol>;
  private form;

  constructor(private alcoholService: AlcoholService,
              private formBuilder: FormBuilder) {
  this.form = this.formBuilder.group({
    name: '',
    description: '',
    image: File =  null
  });
}

  ngOnInit() {
    this.refresh();
  }

  refresh() {
    this.alcoholService.getAll().subscribe(
      data => {
        this.alcohols = data;
        console.log(this.alcohols);
      },
      error => console.log(error)
    )
  }

  onSubmit(alcoholData) {
    console.warn('Your alcohol has been submitted', alcoholData);

    console.log("data = " + alcoholData);
    console.log("keys = " + Object.keys(alcoholData));
    this.alcoholService.save(alcoholData).subscribe(data => {
      console.log(data['_body']);
      console.log("Saved descr = " + data.description);
      this.refresh();
      this.form.reset();
    }, error => {
      console.log(error);
    });

  }
}
