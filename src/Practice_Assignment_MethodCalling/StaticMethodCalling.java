package Practice_Assignment_MethodCalling;

public class StaticMethodCalling {
    static void showCountry() {
        System.out.println("Country:India");
    }
    static void showState() {
        System.out.println("State:Maharashtra");
    }
    static void showCity() {
        System.out.println("City:Latur");
    }
    static void showLang() {
        System.out.println("Language:Java");
    }

    public static void main(String[] args) {
        showCountry();
        showState();
        showCity();
        showLang();
    }
}

//OP : Country:India
//State:Maharashtra
//City:Latur
//Language:Java