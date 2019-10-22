import {Component, Input, OnInit} from '@angular/core';
import {AlcoholService} from "../shared";
import {Alcohol} from "../domain/alcohol/Alcohol";
import {FormBuilder} from "@angular/forms";
import {NgbModal, ModalDismissReasons, NgbModalOptions } from '@ng-bootstrap/ng-bootstrap';

@Component({
  selector: 'app-alcohol',
  templateUrl: './alcohol.component.html',
  styleUrls: ['./alcohol.component.css']
})
export class AlcoholComponent implements OnInit {

  title = 'ng-bootstrap-modal-demo';
  closeResult: string;
  @Input()
  newAlcohol: Alcohol;
  alcohols: Array<Alcohol>;
  private form;
  modalOptions:NgbModalOptions;

  constructor(private alcoholService: AlcoholService,
              private formBuilder: FormBuilder,
              private modalService: NgbModal) {
    this.form = this.formBuilder.group({
      name: '',
      description: '',
      image: File = null
    });
    this.modalOptions = {
      backdrop:'static',
      backdropClass:'customBackdrop'
    };
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

  onSubmit(alcoholData, modal) {
    this.alcoholService.save(alcoholData).subscribe(data => {
      modal.close('Save click')
      this.refresh();
      this.form.reset();
    }, error => {
      console.log(error);
    });
  }

  open(content) {
    this.modalService.open(content, this.modalOptions).result.then((result) => {
      this.closeResult = `Closed with: ${result}`;
    }, (reason) => {
      this.closeResult = `Dismissed ${this.getDismissReason(reason)}`;
    });
  }

  private getDismissReason(reason: any): string {
    if (reason === ModalDismissReasons.ESC) {
      return 'by pressing ESC';
    } else if (reason === ModalDismissReasons.BACKDROP_CLICK) {
      return 'by clicking on a backdrop';
    } else {
      return  `with: ${reason}`;
    }
  }

  closeModal(modal) {
    this.form.reset();
    modal.close('Close');
  }

  deleteAlcohol(alcohol: Alcohol) {
    console.log("REMOVE!");
    this.alcoholService.delete(alcohol).subscribe(data => {
      this.refresh();
    });
  }
}
