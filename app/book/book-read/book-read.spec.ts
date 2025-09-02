import { ComponentFixture, TestBed } from '@angular/core/testing';

import { BookRead } from './book-read';

describe('BookRead', () => {
  let component: BookRead;
  let fixture: ComponentFixture<BookRead>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [BookRead]
    })
    .compileComponents();

    fixture = TestBed.createComponent(BookRead);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
