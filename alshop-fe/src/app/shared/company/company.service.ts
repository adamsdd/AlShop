import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Company} from "../../domain/company/Company";

@Injectable({
  providedIn: 'root'
})
export class CompanyService {

  constructor(private http: HttpClient) {
  }

  private listPath: string = 'http://localhost:60069/companies';
  private rootPath: string = 'http://localhost:60069/company';
  private contactMethodsPath: string = 'http://localhost:60069/company/contactMethods';

  getAll(): Observable<any> {
    return this.http.get(this.listPath);
  }

  delete(company: Company): Observable<any> {
    return this.http.delete(this.rootPath + "/" + company.id);
  }

  save(company: Company): Observable<any> {
    console.log("Save new company");
    return this.http.post(this.rootPath, company);
  }

  getContactMethods(): Observable<any> {
    return this.http.get(this.contactMethodsPath);
  }
}
