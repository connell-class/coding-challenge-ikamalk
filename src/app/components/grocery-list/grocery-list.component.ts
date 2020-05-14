import { Component, OnInit } from '@angular/core';
import { GroceryService } from 'src/app/services/grocery.service';
import { GroceryList } from 'src/app/Model/GroceryList';
import { SharedService } from 'src/app/services/shared.service';

@Component({
  selector: 'app-grocery-list',
  templateUrl: './grocery-list.component.html',
  styleUrls: ['./grocery-list.component.scss']
})
export class GroceryListComponent implements OnInit {
  grocerylists:GroceryList[];
  titleList:string;
  idSelected:number = 0;
  constructor(private groceryService:GroceryService,private sharedService:SharedService) { }

  ngOnInit(): void {
    this.getAllList();
  }

  getAllList(){
    this.groceryService.getAll().then((resp)=>{
      this.grocerylists = resp;
      console.log(this.grocerylists);
      this.selectList( this.grocerylists[0]);
    })
  }

  insertList(){
    let grocerylist:GroceryList ={
      id:0,
      title:this.titleList,
      createdAt:"now"
    }
    this.groceryService.insertList(grocerylist).then((resp)=>{
      this.getAllList();
      this.titleList = "";
    })
  }

  selectList(grocerylist:GroceryList){
    this.idSelected = grocerylist.id;
    this.sharedService.sendGroceryList(grocerylist);
  }

  deleteList(id:number){
    this.groceryService.deleteList(id).then(resp=>{
      this.getAllList();
    })
  }

}
