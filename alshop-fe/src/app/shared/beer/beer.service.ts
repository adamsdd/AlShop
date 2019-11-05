import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Beer} from "../../domain/alcohol/Beer";

@Injectable({
  providedIn: 'root'
})
export class BeerService {
  private listPath: string = 'http://localhost:60069/beers';
  private singlePath: string = 'http://localhost:60069/beer';
  private typesPath: string = 'http://localhost:60069/beer-types';

  constructor(private http: HttpClient) {
  }

  getAll(): Observable<any> {
    console.log("Get all beers!");
    return this.http.get<any>(this.listPath);
  }

  save(beer: Beer): Observable<any> {
    console.log("AlcoholData.name from servis = " + beer.name);
    return this.http.post(this.singlePath, beer)
  }

  delete(beer: Beer): Observable<any> {
    return this.http.delete(this.singlePath + "/" + beer.id);
  }

  getBeerTypes(): Observable<any> {
    return this.http.get(this.typesPath);
  }
}
