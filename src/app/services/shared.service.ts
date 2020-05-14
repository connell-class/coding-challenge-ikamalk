import { Injectable } from '@angular/core';
import { Subject, Observable } from 'rxjs';
import { GroceryList } from '../Model/GroceryList';

@Injectable({
  providedIn: 'root'
})
export class SharedService {
  private GroceryListSubject = new Subject<any>();

  constructor() { }

  sendGroceryList(GroceryList:GroceryList) {
    this.GroceryListSubject.next(GroceryList);
  }
  getGroceryList(): Observable<any>{ 
    return this.GroceryListSubject.asObservable();
  }
}
