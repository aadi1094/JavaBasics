package OOPS.Inheritance.HierarchicalInheritance.FoodDeliveryPlatform;

public class Burger extends FoodItem{
    boolean doublepatty;
    boolean extraMayo;

    double calculateBurgerBill(boolean d,boolean e){
        if(d){
            if(e){
                return basePrice+70.0+80.0;

            }else{
                return basePrice+70.0;
            }
        }else{
            if(e){
                return basePrice+80.0;
            }else{
                return basePrice;
            }
        }
    }
}
