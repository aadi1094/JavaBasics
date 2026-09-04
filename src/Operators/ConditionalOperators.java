package Operators;

// There are two groups. The conditional logical operators && (AND), || (OR) and ! (NOT) combine
//boolean conditions. The conditional ternary operator ? : chooses between two values based on a condition and is
//the only three-operand operator in Java.

public class ConditionalOperators {

    public static void main(String[] args) {
        int age = 20;
        boolean hasLicence = true;
    // && AND - true only if BOTH sides are true
        if (age >= 18 && hasLicence) System.out.println("Can drive");
        // || OR - true if EITHER side is true
        if (age < 18 || !hasLicence) System.out.println("Cannot drive");
    // ! NOT - reverses the value
        System.out.println(!hasLicence); // false


        int marks = 75;
        String result = (marks >= 40) ? "Pass" : "Fail";
        System.out.println(result); // "Pass"
        int a = 10, b = 20;
        int max = (a > b) ? a : b;
        System.out.println(max);// 20
    }
}
