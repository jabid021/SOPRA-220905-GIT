import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-formulaire-template',
  templateUrl: './formulaire-template.component.html',
  styleUrls: ['./formulaire-template.component.css'],
})
export class FormulaireTemplateComponent implements OnInit {
  input: string = '';

  constructor() {}

  ngOnInit(): void {}

  submit(form: NgForm) {
    console.log(form);
    console.log(form.controls['input'].value);
  }
}
