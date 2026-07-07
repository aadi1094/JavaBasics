package OOPS.Inheritance.HybridInheritance.SmartHomeSystem;

public class Main {
    public static void main(String[] args) {
        Channel ch=new Channel();
        SmartDevice s=new SmartDevice();
        ch.brandName();
        ch.modelName();
        s.WifiStatus();
        ch.Tv();
        ch.channel();
    }
}
