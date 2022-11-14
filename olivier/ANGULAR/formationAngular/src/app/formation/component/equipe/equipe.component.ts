import { Component, Input, OnInit, Output, EventEmitter } from '@angular/core';

@Component({
  selector: 'app-equipe',
  templateUrl: './equipe.component.html',
  styleUrls: ['./equipe.component.css'],
})
export class EquipeComponent implements OnInit {
  @Input()
  nom!: string;
  @Input()
  logo!: string;
  vote: number = 0;
  @Output()
  voteEmit: EventEmitter<any> = new EventEmitter();

  constructor() {}

  ngOnInit(): void {}

  voter() {
    this.vote++;
    this.voteEmit.emit({
      nom: this.nom,
      vote: this.vote,
    });
  }
}
