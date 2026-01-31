import { Routes } from '@angular/router';
import { UsuarioCrear } from './components/usuario-crear/usuario-crear';
import { UsuarioListar } from './components/usuario-listar/usuario-listar';
import { UsuarioEliminar } from './components/usuario-eliminar/usuario-eliminar';
import { UsuarioBuscar } from './components/usuario-buscar/usuario-buscar';

export const routes: Routes = [
    {path: 'registro', component: UsuarioCrear},
    {path: 'listado', component: UsuarioListar},
    {path: 'eliminado', component: UsuarioEliminar},
    {path: 'buscado', component: UsuarioBuscar}
];
