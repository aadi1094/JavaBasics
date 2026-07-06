package OOPS.Inheritance.SingleInheritance.ProductLaptop;

public class Main {
    public static void main(String[] args) {
        Discount discount = new Discount();
        discount.displayProduct();
        System.out.println("Product discount is "+discount.discountPercentage);
        System.out.println("Final price is "+discount.finalprice());
    }

}
