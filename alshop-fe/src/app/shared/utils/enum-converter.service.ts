import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class EnumConverterService {

  constructor() { }

  convertEnumToString(value: string) {
    return value.replace(new RegExp(/_/g), ' ');
  }

  convertStringToEnum(value: string) {
    return value.replace(/ /g, '_');
  }
}
