package OOPS.Inheritance.HierarchicalInheritance.FoodDeliveryPlatform;

public class Pizza extends FoodItem {
    String Size;
    boolean extraCheese;

    double calculatePizzaPrice(String s, boolean b){
        if (s.equalsIgnoreCase("Small")){
            if (b){
                return basePrice+70;
            }else{
                return basePrice;
            }
        }else if (s.equalsIgnoreCase("Medium")){
            if (b){
                return basePrice+70.0+100.0;
            }else{
                return basePrice+100.0;
            }
        }else{
            if (b){
                return basePrice+70.0+200.0;
            }else{
                return basePrice+200.0;
            }
        }
    }


}
