import { ComponentFixture, TestBed } from '@angular/core/testing';

import { BrokerComponent } from './broker.component';

describe('BrokerComponent', () => {
  let component: BrokerComponent;
  let fixture: ComponentFixture<BrokerComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [BrokerComponent]
    });
    fixture = TestBed.createComponent(BrokerComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
