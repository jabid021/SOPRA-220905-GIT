import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-sondage',
  templateUrl: './sondage.component.html',
  styleUrls: ['./sondage.component.css'],
})
export class SondageComponent implements OnInit {
  equipePopulaire!: string;
  vote: number = 0;

  constructor() {}

  ngOnInit(): void {}

  voteRecu(infos: any) {
    if (this.vote < infos.vote) {
      this.equipePopulaire = infos.nom;
      this.vote = infos.vote;
    }
  }
}
