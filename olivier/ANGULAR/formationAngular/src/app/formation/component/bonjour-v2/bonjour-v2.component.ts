import { Personne } from './../../model/personne';
import { Component, Input, OnInit } from '@angular/core';

@Component({
  selector: 'app-bonjour-v2',
  templateUrl: './bonjour-v2.component.html',
  styleUrls: ['./bonjour-v2.component.css'],
})
export class BonjourV2Component implements OnInit {
  @Input()
  personne!: Personne;

  constructor() {}

  ngOnInit(): void {}
}
