import { ComponentFixture, TestBed } from '@angular/core/testing';

import { RoleUpdate } from './role-update';

describe('RoleUpdate', () => {
  let component: RoleUpdate;
  let fixture: ComponentFixture<RoleUpdate>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [RoleUpdate]
    })
    .compileComponents();

    fixture = TestBed.createComponent(RoleUpdate);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
