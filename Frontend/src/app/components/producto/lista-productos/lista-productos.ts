import { Component } from '@angular/core';
import { OnInit } from '@angular/core';
import { Producto } from '../../../models/producto.model';
import { ProductoService } from '../../../services/producto-service';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-lista-productos',
  imports: [CommonModule],
  templateUrl: './lista-productos.html',
  styleUrl: './lista-productos.css',
})
export class ListaProductos {

  listaProductos?: Producto[];
  
  constructor(private productoService: ProductoService){}

  ngOnInit()
  {
    this.productoService.getProductList().subscribe
    (
      data => { this.listaProductos = data; console.log(this.listaProductos)}     
    )
  }
}
