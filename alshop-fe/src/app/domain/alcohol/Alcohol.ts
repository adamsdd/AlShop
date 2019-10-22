import {Company} from "../company/Company";

export class Alcohol {
  public id: Number = null;
  public name: string;
  public description: string;
  public country: string;
  public city: string;
  public company: Company;
  public rate: Number;
  public image: File;
}
