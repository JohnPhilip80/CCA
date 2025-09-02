import { ComponentFixture, TestBed } from '@angular/core/testing';

import { RolesRead } from './roles-read';

describe('RolesRead', () => {
  let component: RolesRead;
  let fixture: ComponentFixture<RolesRead>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [RolesRead]
    })
    .compileComponents();

    fixture = TestBed.createComponent(RolesRead);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
