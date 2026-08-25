package Constructor.Practice;

public class ProductDiscount {
    int id;
    String name;
    double price;

    ProductDiscount(int id , String name , double price){
        this.id= id;
        this.name= name;
        this.price= price;
    }

    double applyDiscount(double percentage){
        return (price - price*(percentage/100));
    }

    public static void main(String[] args) {
        ProductDiscount pd = new ProductDiscount(100,"Iphone", 30000);
        System.out.println("Id : "+pd.id);
        System.out.println("Name : "+pd.name);
        System.out.println("Price : "+pd.price);


        System.out.println("Discounted price : "+pd.applyDiscount(10));
    }
}
