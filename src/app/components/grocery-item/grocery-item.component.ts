import { Component, OnInit } from '@angular/core';
import { SharedService } from 'src/app/services/shared.service';
import { GroceryList } from 'src/app/Model/GroceryList';
import { GroceryService } from 'src/app/services/grocery.service';
import { GroceryItem } from 'src/app/Model/GroceryItem';

@Component({
  selector: 'app-grocery-item',
  templateUrl: './grocery-item.component.html',
  styleUrls: ['./grocery-item.component.scss']
})
export class GroceryItemComponent implements OnInit {
  groceryList:GroceryList;
  newGroceryItem:GroceryItem;
  groceryItems:GroceryItem[];
  displayedColumns: string[] = ['id', 'content', 'type','actions'];

  constructor(private sharedService:SharedService,private groceryService:GroceryService) {
    this.sharedService.getGroceryList().subscribe((groceryList)=>{
      this.newGroceryItem = {
        id:0,
        grocerylist:{
          id:groceryList.id,
          createdAt:groceryList.createdAt,
          title:groceryList.title
        },
        content:"",
        type:""
      };
      console.log(groceryList);
      this.groceryList = groceryList;
      this.getItems();
    })
  }

  getItems(){
    this.groceryService.getItemsById(this.groceryList.id).then((resp)=>{
      console.log(resp);
      this.groceryItems =resp;
    })
  }

  ngOnInit(): void {
  }

  insertItem(){
    console.log(this.newGroceryItem);
    this.groceryService.insertItem(this.newGroceryItem).then((resp)=>{
      console.log(resp);
      this.getItems();
    })
  }

  removeItem(id:number){
    console.log(id);
    this.groceryService.deleteItem(id).then((resp)=>{
      this.getItems();
    })
  }

}
