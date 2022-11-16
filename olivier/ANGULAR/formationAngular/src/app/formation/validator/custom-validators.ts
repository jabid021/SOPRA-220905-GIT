import { AbstractControl, ValidationErrors, ValidatorFn } from '@angular/forms';

export class CustomValidators {
  public static pasToto(control: AbstractControl): ValidationErrors | null {
    return control.value == 'toto' ? { toto: true } : null;
  }

  public static chaineInterdite(chaine: string): ValidatorFn {
    return (control: AbstractControl): ValidationErrors | null => {
      return control.value == chaine ? { chaineInterdite: true } : null;
    };
  }
}
