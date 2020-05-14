import { Injectable } from '@angular/core';
import { GroceryList } from '../Model/GroceryList';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { GroceryItem } from '../Model/GroceryItem';

@Injectable({
  providedIn: 'root'
})
export class GroceryService {

  constructor(private http:HttpClient) { }



  getAll(): Promise<GroceryList[]> {
    return this.http
      .get<GroceryList[]>("http://localhost:8999/grocerylist/")
      .toPromise();
}

getItemsById(id:number): Promise<GroceryItem[]> {
  return this.http
    .get<GroceryItem[]>("http://localhost:8999/grocerylist/"+id)
    .toPromise();
}

insertItem(groceryItem:GroceryItem): Promise<GroceryItem> {
  return this.http
    .post<GroceryItem>("http://localhost:8999/grocerylist/item",groceryItem)
    .toPromise();
}

deleteItem(id:number) {
  const headers = new HttpHeaders().set('Content-Type', 'text/plain; charset=utf-8');

  return this.http
    .delete("http://localhost:8999/grocerylist/item/"+id,{headers, responseType: 'text'})
    .toPromise();
}


deleteList(id:number) {
  const headers = new HttpHeaders().set('Content-Type', 'text/plain; charset=utf-8');

  return this.http
    .delete("http://localhost:8999/grocerylist/"+id,{headers, responseType: 'text'})
    .toPromise();
}

insertList(GroceryList:GroceryList): Promise<GroceryList> {
  return this.http
    .post<GroceryList>("http://localhost:8999/grocerylist/",GroceryList)
    .toPromise();
}
}
