import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import {Alcohol} from "../../domain/Alcohol";

@Injectable({
  providedIn: 'root'
})
export class AlcoholService {

  private listPath: string = 'http://localhost:60069/alcohols';
  private singlePath: string = 'http://localhost:60069/alcohol';

  constructor(private http: HttpClient) { }

  getAll(): Observable<any> {
    return this.http.get<any>(this.listPath);
  }

  save(alcoholData: Alcohol): Observable<any> {
    console.log("AlcoholData.name from servis = " + alcoholData.name);
    return this.http.post(this.singlePath, alcoholData)
  }

  delete(alcohol: Alcohol): Observable<any> {
    return this.http.delete(this.singlePath + "/" + alcohol.id);
  }Your
}
