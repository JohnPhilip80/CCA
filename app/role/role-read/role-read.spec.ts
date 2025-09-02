import { ComponentFixture, TestBed } from '@angular/core/testing';

import { RoleRead } from './role-read';

describe('RoleRead', () => {
  let component: RoleRead;
  let fixture: ComponentFixture<RoleRead>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [RoleRead]
    })
    .compileComponents();

    fixture = TestBed.createComponent(RoleRead);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
