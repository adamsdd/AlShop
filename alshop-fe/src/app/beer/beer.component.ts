import {Component, Input, OnInit} from '@angular/core';
import {ModalDismissReasons, NgbModal, NgbModalOptions} from "@ng-bootstrap/ng-bootstrap";
import {FormBuilder} from "@angular/forms";
import {Beer} from "../domain/alcohol/Beer";
import {BeerService} from "../shared/beer/beer.service";
import {EnumConverterService} from "../shared/utils/enum-converter.service";
import {CompanyService} from "../shared/company/company.service";
import {Company} from "../domain/company/Company";

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
  private editForm;
  modalOptions: NgbModalOptions;
  companies: Array<Company>;
  beerTypes: Array<string>;
  private testImage;

  constructor(private beerService: BeerService,
              private formBuilder: FormBuilder,
              private modalService: NgbModal,
              private enumConverter: EnumConverterService,
              private companyService: CompanyService) {
    this.form = this.formBuilder.group({
      id: null,
      name: '',
      description: '',
      beerType: null,
      company: null,
      country: '',
      city: '',
      rate: null,
      image: File = null
    });
    this.editForm = this.formBuilder.group({
      editId: '',
      editName: '',
      editDescription: '',
      editImage: File = null,
      editCompany: '',
      editBeerType: ''
    });
    this.modalOptions = {
      backdrop: 'static',
      backdropClass: 'customBackdrop'
    };
  }

  ngOnInit() {
    this.refresh();
    this.companyService.getAll().subscribe(data => {
      this.companies = data;
    });
    this.beerService.getBeerTypes().subscribe(data => {
      this.beerTypes = data;
    })
  }

  convertEnumToString(value: string) {
    return this.enumConverter.convertEnumToString(value);
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
    alcoholData.image = this.testImage;
    this.beerService.save(alcoholData).subscribe(() => {
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
    this.prepareEmptyForm();
    if (reason === ModalDismissReasons.ESC) {
      return 'by pressing ESC';
    } else if (reason === ModalDismissReasons.BACKDROP_CLICK) {
      return 'by clicking on a backdrop';
    } else {
      return `with: ${reason}`;
    }
  }

  closeModal(modal) {
    this.form.reset();
    modal.close('Close');
  }

  deleteAlcohol(beer: Beer) {
    console.log("REMOVE!");
    this.beerService.delete(beer).subscribe(() => {
      this.refresh();
    });
  }

  readImage(inputValue: any): void {
    let file: File = inputValue.files[0];
    let myReader: FileReader = new FileReader();

    myReader.onloadend = () => {
      this.testImage = myReader.result;
    };
    myReader.readAsDataURL(file);
  }

  onFileChanged(event) {
    this.readImage(event.target);
  }

  edit(modal, beer: Beer) {
    this.form = this.formBuilder.group({
      id: beer.id,
      name: beer.name,
      description: beer.description,
      beerType: beer.beerType,
      company: beer.company,
      country: beer.country,
      city: beer.city,
      rate: beer.rate,
      image: File = null
    });
    this.modalService.open(modal, this.modalOptions).result.then((result) => {
      this.closeResult = `Closed with: ${result}`;
    }, (reason) => {
      this.closeResult = `Dismissed ${this.getDismissReason(reason)}`;
    });
  }

  private prepareEmptyForm() {
    this.form = this.formBuilder.group({
      id: null,
      name: '',
      description: '',
      beerType: null,
      company: null,
      country: '',
      city: '',
      rate: null,
      image: File = null
    });
  }
}
