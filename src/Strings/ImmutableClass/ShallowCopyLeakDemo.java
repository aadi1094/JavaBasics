package Strings.ImmutableClass;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/*
 * WHY an immutable class needs deep copy (deep clone).
 *
 * BrokenStudent below follows rules 1-4 perfectly:
 *      final class, private final fields, no setters, values only from constructor.
 * It still is NOT immutable, because it skips the deep copy.
 *
 * Run this file and compare the two halves of the output.
 */

// Looks immutable... but is not.
final class BrokenStudent {

    private final int rollNo;
    private final Date admissionDate;
    private final List<String> subjects;

    BrokenStudent(int rollNo, Date admissionDate, List<String> subjects) {
        this.rollNo = rollNo;
        this.admissionDate = admissionDate;   // MISTAKE: only the address is copied
        this.subjects = subjects;             // MISTAKE: same list is now shared
    }

    public int getRollNo() {
        return rollNo;
    }

    public Date getAdmissionDate() {
        return admissionDate;                 // MISTAKE: handing out our real object
    }

    public List<String> getSubjects() {
        return subjects;                      // MISTAKE: handing out our real list
    }

    @Override
    public String toString() {
        return "BrokenStudent{rollNo=" + rollNo
                + ", admissionDate=" + admissionDate
                + ", subjects=" + subjects + '}';
    }
}

public class ShallowCopyLeakDemo {

    public static void main(String[] args) {

        System.out.println("========== BROKEN (no deep copy) ==========");

        Date date1 = new Date();
        List<String> list1 = new ArrayList<>();
        list1.add("Java");

        BrokenStudent broken = new BrokenStudent(101, date1, list1);
        System.out.println("Created      : " + broken);

        // LEAK 1 - through the variable we passed IN
        date1.setTime(0);
        list1.add("Hacked-from-outside");
        System.out.println("After attack1: " + broken + "   <-- CHANGED!");

        // LEAK 2 - through what the getter handed OUT
        broken.getSubjects().add("Hacked-via-getter");
        System.out.println("After attack2: " + broken + "   <-- CHANGED AGAIN!");

        System.out.println("\n========== CORRECT (with deep copy) ==========");

        Date date2 = new Date();
        List<String> list2 = new ArrayList<>();
        list2.add("Java");

        ImmutableStudent safe = new ImmutableStudent(102, "Aditya", date2, list2);
        System.out.println("Created      : " + safe);

        date2.setTime(0);
        list2.add("Hacked-from-outside");
        System.out.println("After attack1: " + safe + "   <-- same");

        safe.getSubjects().add("Hacked-via-getter");
        System.out.println("After attack2: " + safe + "   <-- same");
    }
}
