import { Component } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { OnInit } from '@angular/core';

@Component({
  selector: 'app-producto-detalle',
  imports: [],
  templateUrl: './producto-detalle.html',
  styleUrl: './producto-detalle.css',
})
export class ProductoDetalle {

  productoid!: string;

  constructor(private route: ActivatedRoute) {}

  ngOnInit()
  {
    this.productoid = this.route.snapshot.paramMap.get('id')!;
  }
}
