import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root',
})
export class DemoService {
  constructor() {}

  hello(): string {
    return 'hello du service';
  }
}
