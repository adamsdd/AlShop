import {Component, Input, OnInit} from '@angular/core';
import {ModalDismissReasons, NgbModal, NgbModalOptions} from "@ng-bootstrap/ng-bootstrap";
import {FormBuilder} from "@angular/forms";
import {Beer} from "../domain/alcohol/Beer";
import {BeerService} from "../shared/beer/beer.service";

@Component({
  selector: 'app-beer',
  templateUrl: './beer.component.html',
  styleUrls: ['./beer.component.css']
})
export class BeerComponent implements OnInit {

  title = 'ng-bootstrap-modal-demo';
  closeResult: string;
  @Input()
  newAlcohol: Beer;
  alcohols: Array<Beer>;
  private form;
  modalOptions: NgbModalOptions;

  constructor(private beerService: BeerService,
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
    this.beerService.getAll().subscribe(
      data => {
        this.alcohols = data;
        console.log(this.alcohols);
      },
      error => console.log(error)
    )
  }

  onSubmit(alcoholData, modal) {
    this.beerService.save(alcoholData).subscribe(data => {
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

  deleteAlcohol(beer: Beer) {
    console.log("REMOVE!");
    this.beerService.delete(beer).subscribe(data => {
      this.refresh();
    });
  }
}
