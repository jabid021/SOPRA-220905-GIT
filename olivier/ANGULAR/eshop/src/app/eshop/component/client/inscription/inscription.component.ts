import { ClientService } from './../../../service/client.service';
import { map, Observable } from 'rxjs';
import { Component, OnInit } from '@angular/core';
import {
  AbstractControl,
  AsyncValidatorFn,
  FormControl,
  FormGroup,
  ValidationErrors,
  Validators,
} from '@angular/forms';

@Component({
  selector: 'app-inscription',
  templateUrl: './inscription.component.html',
  styleUrls: ['./inscription.component.css'],
})
export class InscriptionComponent implements OnInit {
  form!: FormGroup;

  constructor(private clientService: ClientService) {}

  ngOnInit(): void {
    this.form = new FormGroup({
      numero: new FormControl(),
      voie: new FormControl(),
      cp: new FormControl(),
      ville: new FormControl(),
      naissance: new FormControl(''),
      email: new FormControl(
        '',
        [Validators.required, Validators.email],
        this.emailNotExists()
      ),
      groupeInfo: new FormGroup(
        {
          prenom: new FormControl('', [
            Validators.required,
            Validators.minLength(2),
          ]),
          nom: new FormControl('', Validators.required),
          groupePassword: new FormGroup(
            {
              password: new FormControl(
                '',
                Validators.pattern(
                  /^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[@*!-_])([a-zA-Z0-9@*!-_]{4,25})$/
                )
              ),
              confirmation: new FormControl(),
            },
            this.passwordAndConfirmatonEquals
          ),
        },
        this.contientPrenomOuNom
      ),
    });
  }

  emailNotExists(): AsyncValidatorFn {
    return (control: AbstractControl): Observable<ValidationErrors | null> => {
      return this.clientService.checkEmailExists(control.value).pipe(
        map((bool) => {
          return bool ? { emailExists: true } : null;
        })
      );
    };
  }

  passwordAndConfirmatonEquals(
    control: AbstractControl
  ): ValidationErrors | null {
    let password = control.get('password');
    if (password?.invalid) {
      return null;
    }
    return password?.value == control.get('confirmation')?.value
      ? null
      : { passwordAndConfirmationNotEquals: true };
  }

  contientPrenomOuNom(control: AbstractControl): ValidationErrors | null {
    let password = control.get('groupePassword.password');
    console.log(password?.value);
    console.log(
      password?.value
        .toString()
        .includes(control.get('prenom')?.value.toString())
    );
    return password?.value
      .toString()
      .includes(control.get('prenom')?.value.toString()) ||
      password?.value.toString().includes(control.get('nom')?.value.toString())
      ? { contientPrenomOuNom: true }
      : null;
  }

  save() {
    console.log(this.form);
  }
}
