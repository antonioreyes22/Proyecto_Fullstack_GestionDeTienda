import { Component } from '@angular/core';
import { RouterLink, RouterOutlet } from '@angular/router';

@Component({
  selector: 'app-crud',
  imports: [RouterOutlet, RouterLink],
  templateUrl: './crud.html',
  styleUrl: './crud.css',
})
export class Crud {

}
