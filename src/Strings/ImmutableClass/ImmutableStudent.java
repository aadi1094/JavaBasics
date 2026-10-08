package Strings.ImmutableClass;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/*
 * A custom immutable class, built with the standard 6 rules:
 *
 * 1. class is final                  -> nobody can extend and break the rules
 * 2. all fields are private final    -> nobody can read-write them directly, value is set once
 * 3. no setter methods               -> nothing can be changed after creation
 * 4. values come only from constructor
 * 5. mutable fields are deep copied WHILE COMING IN  (constructor)
 * 6. mutable fields are deep copied WHILE GOING OUT  (getters)
 */

// STEP 1: final class
public final class ImmutableStudent {

    // STEP 2: private + final
    private final int rollNo;                 // primitive  -> already safe
    private final String name;                // String     -> already immutable, safe
    private final Date admissionDate;         // MUTABLE    -> needs copying
    private final List<String> subjects;      // MUTABLE    -> needs copying

    // STEP 4: the only place where values are assigned
    public ImmutableStudent(int rollNo, String name, Date admissionDate, List<String> subjects) {
        this.rollNo = rollNo;
        this.name = name;

        // STEP 5: deep copy while coming IN.
        // If we wrote "this.admissionDate = admissionDate;" the caller would still hold
        // the same Date object and could change it later using setTime().
        this.admissionDate = new Date(admissionDate.getTime());
        this.subjects = new ArrayList<>(subjects);
    }

    // Only getters, NO setters (STEP 3)

    public int getRollNo() {
        return rollNo;                        // int is copied by value, safe to return
    }

    public String getName() {
        return name;                          // String is immutable, safe to return
    }

    // STEP 6: deep copy while going OUT.
    // Returning the real object would let the caller do student.getAdmissionDate().setTime(0)
    public Date getAdmissionDate() {
        return new Date(admissionDate.getTime());
    }

    public List<String> getSubjects() {
        return new ArrayList<>(subjects);     // caller gets a copy; our list stays untouched
    }

    /*
     * BONUS: the "String way" of changing a value.
     * We never modify this object. We return a NEW object with the new name,
     * exactly like s.toUpperCase() returns a new String.
     */
    public ImmutableStudent withName(String newName) {
        return new ImmutableStudent(this.rollNo, newName, this.admissionDate, this.subjects);
    }

    @Override
    public String toString() {
        return "ImmutableStudent{rollNo=" + rollNo
                + ", name='" + name + '\''
                + ", admissionDate=" + admissionDate
                + ", subjects=" + subjects
                + '}';
    }
}
