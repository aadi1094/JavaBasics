package OOPS.Inheritance.SingleInheritance.ProductLaptop;

public class Discount extends Product {
    int discountPercentage = 10;

    double finalprice(){
        double result = price-(((discountPercentage)/100.0)*price);
        return result ;
    }
}
