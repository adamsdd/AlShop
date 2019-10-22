import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Wine} from "../../domain/alcohol/Wine";

@Injectable({
  providedIn: 'root'
})

export class WineService {
  private listPath: string = 'http://localhost:60069/wines';
  private singlePath: string = 'http://localhost:60069/wine';

  constructor(private http: HttpClient) {
  }

  getAll(): Observable<any> {
    return this.http.get<any>(this.listPath);
  }

  save(wine: Wine): Observable<any> {
    return this.http.post(this.singlePath, wine)
  }

  delete(wine: Wine): Observable<any> {
    return this.http.delete(this.singlePath + "/" + wine.id);
  }
}
