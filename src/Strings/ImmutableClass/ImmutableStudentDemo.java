package Strings.ImmutableClass;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/*
 * Proof that ImmutableStudent really cannot be changed.
 * Run this and read the output line by line.
 */
public class ImmutableStudentDemo {

    public static void main(String[] args) {

        Date joinDate = new Date();
        List<String> subjectList = new ArrayList<>();
        subjectList.add("Java");
        subjectList.add("DSA");

        ImmutableStudent s1 = new ImmutableStudent(101, "Aditya", joinDate, subjectList);
        System.out.println("Original object : " + s1);

        // ATTACK 1: change the Date object we passed into the constructor
        joinDate.setTime(0);
        System.out.println("\nAfter changing the outside Date : " + s1);
        System.out.println("-> date did NOT change, because the constructor made a copy");

        // ATTACK 2: change the List we passed into the constructor
        subjectList.add("Python");
        System.out.println("\nAfter adding to the outside List : " + s1);
        System.out.println("-> subjects did NOT change, because the constructor made a copy");

        // ATTACK 3: change the objects returned by the getters
        s1.getAdmissionDate().setTime(0);
        s1.getSubjects().add("Hacked");
        System.out.println("\nAfter changing the getter results : " + s1);
        System.out.println("-> still unchanged, because the getters return copies");

        // The only way to "change" something: get a NEW object (like String does)
        ImmutableStudent s2 = s1.withName("Aditya Chawale");
        System.out.println("\nOld object : " + s1);
        System.out.println("New object : " + s2);
        System.out.println("s1 == s2 : " + (s1 == s2) + "   (two different objects)");

        // Same idea with String, to connect it back to your Strings chapter
        String str = "java";
        str.toUpperCase();                   // result is thrown away
        System.out.println("\nstr after toUpperCase() without assigning : " + str);
        System.out.println("str = str.toUpperCase() : " + str.toUpperCase());
    }
}
