package OOPS.Polymorphism.MethodOverloading;

//Base rate        = ₹50 per kg
//Zone multiplier  = "Local"         → 1.0
//                   "National"      → 2.0
//                   "International" → 5.0
//Speed surcharge  = "Express"  → +₹100 flat
//                   "Standard" → +₹0
//Insurance        = 2% of declared value
//
//Charge = (weight × 50 × zoneMultiplier) + speedSurcharge + insurance
//
//Defaults when the caller doesn't specify:  zone = "Local",  speed = "Standard"



public class ShippingCharge {

    int rate = 50;
    double calculate(double weight){

        return (rate *weight);
    }

    double calculate(double weight , String zone){
        if (zone.equalsIgnoreCase("International")){
            return (rate*weight)*5.0;
        } else if (zone.equalsIgnoreCase("National")) {
            return (rate*weight)*2.0;
        }else {
            return (rate*weight)*1.0;
        }
    }

    double calculate(String zone, double weight){
        if (zone.equalsIgnoreCase("International")){
            return (rate*weight)*5.0;
        } else if (zone.equalsIgnoreCase("National")) {
            return (rate*weight)*2.0;
        }else {
            return (rate*weight)*1.0;
        }
    }

    double calculate(double weight , String zone, String surcharge){
        if (surcharge.equalsIgnoreCase("Express")){
            if (zone.equalsIgnoreCase("International")){
                return (rate*weight)*5.0+100;
            } else if (zone.equalsIgnoreCase("National")) {
                return (rate*weight)*2.0+100;
            }else {
                return (rate*weight)*1.0+100;
            }
        }else{
            if (zone.equalsIgnoreCase("International")){
                return (rate*weight)*5.0;
            } else if (zone.equalsIgnoreCase("National")) {
                return (rate*weight)*2.0;
            }else {
                return (rate*weight)*1.0;
            }
        }
    }

    double calculate(double weight, int declaredValue) {
        return calculate(weight) + (declaredValue * 0.02);
    }


    public static void main(String[] args) {
        ShippingCharge s = new ShippingCharge();
        System.out.println(s.calculate(5.0));
        System.out.println(s.calculate(5.0, "National"));
        System.out.println(s.calculate("International", 2.0));
        System.out.println(s.calculate(3.0f, "National", "Express"));
        System.out.println(s.calculate(2.0, 10000));   // expected 300.0

    }



}
