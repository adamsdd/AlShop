import {Component, Input, OnInit} from '@angular/core';
import {Beer} from "../domain/alcohol/Beer";
import {ModalDismissReasons, NgbModal, NgbModalOptions} from "@ng-bootstrap/ng-bootstrap";
import {FormBuilder} from "@angular/forms";
import {WineService} from "../shared/wine/wine.service";
import {Wine} from "../domain/alcohol/Wine";

@Component({
  selector: 'app-wine',
  templateUrl: './wine.component.html',
  styleUrls: ['./wine.component.css']
})
export class WineComponent implements OnInit {

  title = 'ng-bootstrap-modal-demo';
  closeResult: string;
  @Input()
  newAlcohol: Wine;
  alcohols: Array<Wine>;
  private form;
  modalOptions: NgbModalOptions;

  constructor(private wineService: WineService,
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
    console.log("GET WINES!");
    this.refresh();
  }

  refresh() {
    this.wineService.getAll().subscribe(
      data => {
        this.alcohols = data;
        console.log(this.alcohols);
      },
      error => console.log(error)
    )
  }

  onSubmit(alcoholData, modal) {
    this.wineService.save(alcoholData).subscribe(data => {
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

  deleteAlcohol(wine: Wine) {
    console.log("REMOVE!");
    this.wineService.delete(wine).subscribe(data => {
      this.refresh();
    });
  }
}
