export class Adresse {
  public get cp(): string | undefined {
    return this._cp;
  }
  public set cp(value: string | undefined) {
    this._cp = value;
  }
  public get ville(): string | undefined {
    return this._ville;
  }
  public set ville(value: string | undefined) {
    this._ville = value;
  }
  public get voie(): string | undefined {
    return this._voie;
  }
  public set voie(value: string | undefined) {
    this._voie = value;
  }
  public get numero(): string | undefined {
    return this._numero;
  }
  public set numero(value: string | undefined) {
    this._numero = value;
  }
  constructor(
    private _numero?: string,
    private _voie?: string,
    private _ville?: string,
    private _cp?: string
  ) {}
}
