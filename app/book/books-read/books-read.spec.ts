import { ComponentFixture, TestBed } from '@angular/core/testing';

import { BooksRead } from './books-read';

describe('BooksRead', () => {
  let component: BooksRead;
  let fixture: ComponentFixture<BooksRead>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [BooksRead]
    })
    .compileComponents();

    fixture = TestBed.createComponent(BooksRead);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
