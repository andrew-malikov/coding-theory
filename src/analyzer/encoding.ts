export class Encoding {
  private _sizePerSymbol: number;
  public get sizePerSymbol() {
    return this._sizePerSymbol;
  }

  private _name: string;
  public get name() {
    return this._name;
  }

  public get power() {
    return 2 ** this.sizePerSymbol;
  }

  /**
   *
   * @param sizePerSymbol in bits
   */
  constructor(sizePerSymbol: number, name?: string) {
    if (sizePerSymbol < 1) throw new Error();

    this._sizePerSymbol = sizePerSymbol;
    this._name = name;
  }
}
