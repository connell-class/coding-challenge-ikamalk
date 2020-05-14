import { GroceryList } from './GroceryList';

export interface GroceryItem {
    id: number;
    grocerylist:GroceryList;
    content:string;
    type:string;
  }