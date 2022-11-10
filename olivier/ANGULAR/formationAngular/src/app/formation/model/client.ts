import { Personne } from './personne';

export class Client extends Personne {
  public get adresse(): string | undefined {
    return this._adresse;
  }
  public set adresse(value: string | undefined) {
    this._adresse = value;
  }
  public constructor(prenom?: string, nom?: string, private _adresse?: string) {
    super(prenom, nom);
  }
}
