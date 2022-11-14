import { Directive, ElementRef, Renderer2, OnInit } from '@angular/core';

@Directive({
  selector: '[appImportant]',
})
export class ImportantDirective implements OnInit {
  //elementRef:Balise sur laquelle on a place la directive
  //renderer2:Objet pour modifier le DOM (pas de modification en passant directement pas l'element HTML)
  constructor(private el: ElementRef, private renderer: Renderer2) {}

  ngOnInit(): void {
    this.renderer.setStyle(this.el.nativeElement, 'background', 'yellow');
  }
}
