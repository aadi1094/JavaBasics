package OOPS.Polymorphism.MethodOverriding;

class A
{
    void m1()
    {
        System.out.println("A-m1");
    }
    // Overridden method.
    void m2()
    {
        System.out.println("A-m2");
    }
}
class B extends A
{
    // Overriding method.
    void m2()
    {
        System.out.println("B-m2");
    }
    // Newly defined method in class B.
    void m3()
    {
        System.out.println("B-m3");
    }
}
public class MyTest {
    public static void main(String[] args)
    {
        A a = new A();
        a.m1();
        a.m2();

        //A-m1
        //A-m2

        B b = new B();
        b.m1();
        b.m2();
        b.m3();

        //A-m1
        //B-m2
        //B-m3

        A a1 = new B();
        a1.m1();
        a1.m2();

        //A-m1
        //B-m2

    }
}
