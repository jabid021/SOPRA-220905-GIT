export class Personne {
  public get nom(): string | undefined {
    return this._nom;
  }
  public set nom(value: string | undefined) {
    this._nom = value;
  }
  //attributs
  //visibilite attribut:type
  // private prenom: string | undefined;
  // private nom: string;

  // public constructor(prenom?: string, nom: string = 'inconnu') {
  //   this.prenom = prenom;
  //   this.nom = nom;
  // }

  public constructor(private _prenom?: string, private _nom?: string) {}

  public get prenom(): string | undefined {
    return this._prenom;
  }

  public set prenom(value: string | undefined) {
    this._prenom = value;
  }
}
