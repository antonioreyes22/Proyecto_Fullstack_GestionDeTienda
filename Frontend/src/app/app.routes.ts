import { Routes } from '@angular/router';
import { UsuarioCrear } from './components/usuario-crear/usuario-crear';
import { UsuarioListar } from './components/usuario-listar/usuario-listar';
import { UsuarioEliminar } from './components/usuario-eliminar/usuario-eliminar';
import { UsuarioBuscar } from './components/usuario-buscar/usuario-buscar';
import { Login } from './components/login/login';
import { Inicio } from './components/inicio/inicio';
import { roleGuardGuard } from './guards/role-guard-guard';
import { Crud } from './components/crud/crud';
import { Perfil } from './components/perfil/perfil';
import { ProductoDetalle } from './components/producto/producto-detalle/producto-detalle';

export const routes: Routes = [
    {path: 'inicio', component: Inicio},
    {path: 'registro', component: UsuarioCrear},
    {path: 'listado', component: UsuarioListar, canActivate: [roleGuardGuard], data: {role: 'ADMIN'}},
    {path: 'eliminado', component: UsuarioEliminar, canActivate: [roleGuardGuard], data: {role: 'ADMIN'}},
    {path: 'buscado', component: UsuarioBuscar, canActivate: [roleGuardGuard], data: {role: 'ADMIN'}},
    {path: 'crud', component: Crud, canActivate: [roleGuardGuard], data: {role: 'ADMIN'}},
    {path: 'login', component: Login},
    {path: 'perfil', component: Perfil},
    {path: 'producto/:id', component: ProductoDetalle}
];
