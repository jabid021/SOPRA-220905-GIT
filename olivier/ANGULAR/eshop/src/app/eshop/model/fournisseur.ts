import { Adresse } from './adresse';
import { Personne } from './personne';
export class Fournisseur extends Personne {
  public get societe(): string | undefined {
    return this._societe;
  }
  public set societe(value: string | undefined) {
    this._societe = value;
  }

  constructor(
    _id?: number,
    _nom?: string,
    _prenom?: string,
    _adresse?: Adresse,
    private _societe?: string
  ) {
    super(_id, _nom, _prenom, _adresse);
  }
}
