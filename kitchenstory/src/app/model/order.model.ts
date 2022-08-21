import { Cart } from "./cart.model";

export class Order{
    id:number;
    cart:Cart[];
    total:number;
}