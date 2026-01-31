import { ComponentFixture, TestBed } from '@angular/core/testing';

import { UsuarioBuscar } from './usuario-buscar';

describe('UsuarioBuscar', () => {
  let component: UsuarioBuscar;
  let fixture: ComponentFixture<UsuarioBuscar>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [UsuarioBuscar]
    })
    .compileComponents();

    fixture = TestBed.createComponent(UsuarioBuscar);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
