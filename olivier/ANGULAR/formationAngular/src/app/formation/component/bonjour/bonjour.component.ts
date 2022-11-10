import { Personne } from './../../model/personne';
import { Component, Input, OnInit } from '@angular/core';

@Component({
  selector: 'app-bonjour',
  templateUrl: './bonjour.component.html',
  styleUrls: ['./bonjour.component.css'],
})
export class BonjourComponent implements OnInit {
  personne!: Personne;
  @Input()
  prenom!: string;
  @Input()
  nom!: string;
  @Input()
  photo!: string;

  constructor() {}
  ngOnInit(): void {
    this.personne = new Personne(this.prenom, this.nom);
  }
}
