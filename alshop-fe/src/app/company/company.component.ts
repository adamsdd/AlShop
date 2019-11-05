import { Component, OnInit } from '@angular/core';
import {Company} from "../domain/company/Company";
import {CompanyService} from "../shared/company/company.service";
import {FormBuilder} from "@angular/forms";
import {ModalDismissReasons, NgbModal, NgbModalOptions} from "@ng-bootstrap/ng-bootstrap";
import {DatePipe} from "@angular/common";

@Component({
  selector: 'app-company',
  templateUrl: './company.component.html',
  styleUrls: ['./company.component.css']
})
export class CompanyComponent implements OnInit {

  companies: Array<Company>;
  modalOptions: NgbModalOptions;
  private form;
  private closeResult: string;
  dateFrom: any;
  testDate;

  constructor(private companyService: CompanyService,
              private formBuilder: FormBuilder,
              private modalService: NgbModal,
              private datePipe: DatePipe) {
    this.form = this.formBuilder.group({
      id: null,
      name: '',
      country: '',
      city: '',
      postCode:  '',
      preferContactForm: null,
      contactNumber: '',
      mail: '',
      dateFrom: new Date(),
      dateTo: new Date(),
    });
  }

  ngOnInit() {
    this.getAll();
  }

  onSubmit(companyData, modal) {
    companyData.dateFrom = this.transformDate(companyData.dateFrom);
    companyData.dateTo = this.transformDate(companyData.dateTo);
    // companyData.dateFrom = companyData.dateFrom.toLocaleDateString();
    // companyData.dateTo = companyData.dateTo.toLocaleDateString();
    // console.log("KEYS = " + Object.keys(companyData.dateFrom));
    // companyData.dateFrom = "2019-11-04";
    // companyData.dateTo = "2019-11-15";
    //  this.datePipe.transform(companyData.dateFrom, 'yyyy-MM-dd');
    //  this.datePipe.transform(companyData.dateTo, 'yyyy-MM-dd');
    this.companyService.save(companyData).subscribe(() => {
      modal.close('Save click');
      this.getAll();
      this.form.reset();
    }, error => {
      console.log(error);
    });
  }

  getAll() {
    this.companyService.getAll().subscribe(data => {
      this.companies = data;
    })
  }

  add(company: Company) {
    this.companyService.save(company).subscribe(comp => {
      this.companies.push(comp);
    })
  }

  delete(company: Company) {
    this.companyService.delete(company).subscribe(() => {
      this.getAll();
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

  transformDate(date) {
    let newDate = new Date(date.year + "-" + date.month + "-" + date.day);
    return this.datePipe.transform(newDate, 'yyyy-MM-dd');
  }
}
