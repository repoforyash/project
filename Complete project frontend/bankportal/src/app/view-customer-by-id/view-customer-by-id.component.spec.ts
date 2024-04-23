import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ViewCustomerByIdComponent } from './view-customer-by-id.component';

describe('ViewCustomerByIdComponent', () => {
  let component: ViewCustomerByIdComponent;
  let fixture: ComponentFixture<ViewCustomerByIdComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ViewCustomerByIdComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ViewCustomerByIdComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
