package Operators;

public class BitwiseOperators {
    public static void main(String[] args) {
        int a = 5; // binary 0101
        int b = 3; // binary 0011
        System.out.println(a & b); // 1 -> 0001 AND: 1 only if BOTH bits are 1
        System.out.println(a | b); // 7 -> 0111 OR : 1 if EITHER bit is 1
        System.out.println(a ^ b); // 6 -> 0110 XOR: 1 if the bits DIFFER
        System.out.println(~a); // -6 NOT: flips every bit
    }
}
