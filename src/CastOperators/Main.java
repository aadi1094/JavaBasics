package CastOperators;

//The cast operator (type) converts a value from one type to another. There are two kinds: widening (a
//smaller type into a larger one), which the compiler does automatically because no data is lost, and narrowing (a
//larger type into a smaller one), which you must write explicitly because data can be lost.

public class Main {
    // WIDENING - automatic, safe
    byte b = 10;
    int i = b; // byte -> int : no cast needed
    long l = i; // int -> long
    double d = l; // long -> double
// order: byte -> short -> int -> long -> float -> double
// char -> int


    // NARROWING - explicit cast required, data may be lost
    double x = 9.78;
    int m = (int) x; // 9 - the decimal part is TRUNCATED, not rounded
    int big = 130;
    byte k = (byte) big; // -126, NOT 130 - the value overflowed byte's range
}
