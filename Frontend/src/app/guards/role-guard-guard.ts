import { CanActivateFn } from '@angular/router';
import { UsuarioService } from '../services/usuario-service';
import { inject } from '@angular/core';
import { Router } from '@angular/router';

export const roleGuardGuard: CanActivateFn = (route, state) => {

  const router = inject(Router);
  const usuarioService = inject(UsuarioService);
  const userRole = usuarioService.getRole();
  const isLogged = usuarioService.isLogged();

  if(!isLogged)
    {
      router.navigate(["/inicio"]); // Es un array porque la URL la pide en fragmentos.
      return false; // No redirecciona hacia la ruta requerida.
    }

  if(route.data['role'] === "ADMIN" && userRole !== "ADMIN") // USER no puede entrar en ruta de permisos de ADMIN
    {
      router.navigate(['/inicio']); // 👈 redirige aquí
      return false;
    }

  return true; // Redirecciona hacia la ruta requerida.
};
