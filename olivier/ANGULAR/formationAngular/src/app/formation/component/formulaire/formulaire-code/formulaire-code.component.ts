import { CustomValidators } from './../../../validator/custom-validators';
import { Component, OnInit } from '@angular/core';
import {
  FormControl,
  FormGroup,
  Validators,
  AbstractControl,
  ValidationErrors,
  AsyncValidatorFn,
} from '@angular/forms';
import { map, Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-formulaire-code',
  templateUrl: './formulaire-code.component.html',
  styleUrls: ['./formulaire-code.component.css'],
})
export class FormulaireCodeComponent implements OnInit {
  form!: FormGroup;

  constructor(private httpClient: HttpClient) {}

  ngOnInit(): void {
    this.form = new FormGroup({
      inputCtrl: new FormControl('', [
        Validators.required,
        Validators.minLength(3),
        CustomValidators.pasToto,
        CustomValidators.chaineInterdite('tutu'),
        CustomValidators.chaineInterdite('titi'),
      ]),
      autreCtrl: new FormControl('', null, this.produitExist()),
      groupeDix: new FormGroup(
        {
          nombre1Ctrl: new FormControl('', Validators.required),
          nombre2Ctrl: new FormControl(),
        },
        this.egaleADix
      ),
    });
  }

  submit() {
    console.log(this.form);
  }

  egaleADix(control: AbstractControl): ValidationErrors | null {
    return parseInt(control.get('nombre1Ctrl')?.value) +
      parseInt(control.get('nombre2Ctrl')?.value) !=
      10
      ? { pasDix: true }
      : null;
  }

  produitExist(): AsyncValidatorFn {
    return (control: AbstractControl): Observable<ValidationErrors | null> => {
      return this.httpClient
        .get(`http://localhost:8080/eshop/api/produit/${control.value}/exists`)
        .pipe(
          map((booleanDuProvientDuGet) => {
            return booleanDuProvientDuGet ? null : { produitExistePas: true };
          })
        );
    };
  }
}
