import {Component, OnInit} from '@angular/core';
import {Company} from "../domain/company/Company";
import {CompanyService} from "../shared/company/company.service";
import {AbstractControl, FormBuilder, ValidatorFn, Validators} from "@angular/forms";
import {ModalDismissReasons, NgbModal, NgbModalOptions} from "@ng-bootstrap/ng-bootstrap";
import {DatePipe} from "@angular/common";
import {EnumConverterService} from "../shared/utils/enum-converter.service";

@Component({
  selector: 'app-company',
  templateUrl: './company.component.html',
  styleUrls: ['./company.component.css']
})
export class CompanyComponent implements OnInit {

  companies: Array<Company>;
  contactMethods: Array<string>;
  modalOptions: NgbModalOptions;
  private form;
  private closeResult: string;
  private submitted: boolean = false;
  dateFrom = new Date();
  dateTo = new Date();

  constructor(private companyService: CompanyService,
              private formBuilder: FormBuilder,
              private modalService: NgbModal,
              private datePipe: DatePipe,
              private enumConverter: EnumConverterService) {
    this.form = this.formBuilder.group({
      id: null,
      name: ['', [Validators.required, Validators.minLength(3)]],
      bossName: ['', [Validators.required, Validators.minLength(3), Validators.pattern("^[a-zA-Z]*$")]],
      bossSecondName: ['', [Validators.minLength(3), Validators.pattern("^[a-zA-Z]*$")]],
      bossSurname: ['', [Validators.required, Validators.minLength(3), Validators.pattern("^[a-zA-Z|-]*-*[a-zA-Z|-]*$")]],
      country: ['', [Validators.required, Validators.minLength(3)]],
      city: '',
      postCode: '',
      preferredContactMethod: ['', Validators.required],
      contactNumber: ['', Validators.pattern("[0-9]{3} [0-9]{3} [0-9]{3}")],
      mail: ['', Validators.email],
      dateFrom: ['', Validators.required],
      dateTo: ['', Validators.required]
    },  { validator: Validators.compose([
        this.dateLessThan('dateFrom', 'dateTo', { 'dateValidation': true }),
      ])});
  }

  ngOnInit() {
    this.getAll();
    this.getContactForms();
  }

  private getContactForms() {
    this.companyService.getContactMethods().subscribe(data => {
      this.contactMethods = data;
    })
  }

  onSubmit(companyData, modal) {
    if (this.form.valid) {
      companyData.dateFrom = this.transformDate(companyData.dateFrom);
      companyData.dateTo = this.transformDate(companyData.dateTo);
      this.companyService.save(companyData).subscribe(() => {
        modal.close('Save click');
        this.getAll();
        this.resetForm();
      }, error => {
        console.log(error);
      });
    } else {
      this.submitted = true;
      return;
    }

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
      return `with: ${reason}`;
    }
  }

  resetForm() {
    this.submitted = false;
    this.form.reset();
  }

  closeModal(modal) {
    this.resetForm();
    modal.close('Close');
  }

  transformDate(date) {
    let newDate = new Date(date.year + "-" + date.month + "-" + date.day);
    return this.datePipe.transform(newDate, 'yyyy-MM-dd');
  }

  convertEnumToString(value: string) {
    return this.enumConverter.convertEnumToString(value);
  }

  dateLessThan(dateField1: string, dateField2: string, validatorField: { [key: string]: boolean }): ValidatorFn {
    return (c: AbstractControl): { [key: string]: boolean } | null => {
      const date1 = c.get(dateField1).value;
      const date2 = c.get(dateField2).value;

      if (date1 && date2) {
        let dateOne = new Date(this.transformDate(date1));
        let dateTwo = new Date(this.transformDate(date2));

        if ((dateOne !== null && dateTwo !== null) && dateOne > dateTwo) {
          return validatorField;
        }
        return null;
      }
    };
  }

}
