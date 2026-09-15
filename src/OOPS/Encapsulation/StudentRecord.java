package OOPS.Encapsulation;

/*
 =========================================================================
 PRACTICE PROBLEM 2  --  STUDENT RECORD
 =========================================================================

 BankAccount taught you: make fields private, guard the setters.

 This one teaches the part that surprises everybody -- private is NOT
 enough on its own. A private field can still leak, in both directions.

 Read Notes PART 7 and PART 9 alongside this.


 WRITE THE CLASS

   FIELDS  (all private)
       rollNo      int       READ-ONLY   -- final, getter, no setter
       name        String    read/write
       password    String    WRITE-ONLY  -- setter, NO getter ever
       marks       int[]     private, and it must never leak (see below)

   CONSTRUCTOR
       public StudentRecord(int rollNo, String name)
       initialise marks to an empty array:  this.marks = new int[0];

   METHODS
       getRollNo()                -> returns it. No setter.
       getName() / setName()      -> reject null or empty:
                                     "Name cannot be empty"
       setPassword(String pw)     -> reject shorter than 6 characters:
                                     "Password too short"
                                     otherwise print "Password updated"
                                     There is NO getPassword(). Ever.
       setMarks(int[] marks)      -> reject if ANY mark is outside 0-100:
                                     "Invalid marks. Each mark must be 0-100"
       getMarks()                 -> returns the marks
       getAverage()               -> returns the average as a double,
                                     or 0.0 if there are no marks


 THE REAL EXERCISE -- TWO LEAKS TO CLOSE

 An int[] is an OBJECT. When you assign it or return it, you are handing
 over the ARRAY ITSELF, not a copy. So both of these break encapsulation:

     LEAK IN   -- setMarks stores the caller's array:
                      this.marks = marks;
                  The caller still holds that array and can keep editing it.

     LEAK OUT  -- getMarks returns the real array:
                      return marks;
                  The caller can now edit the student's marks directly.

 Close both with a DEFENSIVE COPY -- marks.clone() on the way in AND on
 the way out. Write it the leaky way first, watch it break, then fix it.


 TEST IN MAIN

     StudentRecord s = new StudentRecord(101, "Aditya");

     int[] m = {90, 80, 70};
     s.setMarks(m);
     System.out.println("Average: " + s.getAverage());

     m[0] = 999;                      // ATTACK 1 -- edit the array we passed IN
     System.out.println("Average: " + s.getAverage());

     int[] out = s.getMarks();
     out[1] = 999;                    // ATTACK 2 -- edit the array we got OUT
     System.out.println("Average: " + s.getAverage());

     s.setMarks(new int[]{90, 105, 70});   // 105 is not a valid mark
     System.out.println("Average: " + s.getAverage());

     s.setPassword("abc");
     s.setPassword("secret123");
     s.setName("");

     System.out.println("Name: " + s.getName());
     System.out.println("Roll: " + s.getRollNo());


 EXPECTED OUTPUT

     Average: 80.0
     Average: 80.0
     Average: 80.0
     Invalid marks. Each mark must be 0-100
     Average: 80.0
     Password too short
     Password updated
     Name cannot be empty
     Name: Aditya
     Roll: 101

 Lines 2 and 3 are the whole point. Both attacks must fail, and the
 average must stay 80.0 through all of them.

 EACH LEAK HAS ITS OWN FINGERPRINT -- use this to diagnose:

     line 2 shows 383.0                -> LEAK IN.  setMarks kept the
                                          caller's array instead of a copy.
     line 3 shows 386.3333333333333    -> LEAK OUT. getMarks handed out the
                                          real array instead of a copy.
     both lines show 80.0              -> both leaks are closed. Correct.


 AFTER IT WORKS -- THREE THINGS TO TRY

   A) Delete ONE of the two .clone() calls and rerun. Work out from the
      output alone which direction leaked. Then put it back.

   B) Add  System.out.println(s.getPassword());  to main. It must not
      compile -- there is no such method. A field you never expose is the
      strongest encapsulation there is.

   C) Add  s.rollNo = 999;  to main. Read the error, then move that same
      line INSIDE the class and read the different error you get there.
      Two different protections, private and final.

 =========================================================================
*/

public class StudentRecord {
    private final int rollNo;
    private String name ;
    private String password;
    private int[] marks;

    public StudentRecord(int rollNo, String name){
        this.rollNo=rollNo;
        this.name=name;
        this.marks = new int[0];
    }

    public int getRollNo(){
        return rollNo;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        if(name==null || name.equals("")){
            System.out.println("Name cannot be empty");
            return;
        }
        this.name=name;
    }

    public void setPassword(String password) {
        if(password.length() < 6){
            System.out.println("Password too short");
            return;
        }
        this.password = password;
        System.out.println("Password updated");

    }

    public void setMarks(int[] marks){
        for (int mark : marks) {
            if (mark < 0 || mark > 100) {
                System.out.println("Invalid marks. Each mark must be 0-100");
                return;
            }
        }

        // COPY ON THE WAY IN.
        // marks.clone() builds a brand new array and moves the values
        // across, so the caller's array and this.marks are two separate
        // arrays. Without .clone() they would be one array with two names,
        // and the caller could keep editing our data.
        //
        // The long form of exactly the same thing:
        //     int[] copy = new int[marks.length];
        //     for (int i = 0; i < marks.length; i++) copy[i] = marks[i];
        //     this.marks = copy;
        this.marks = marks.clone();
    }

    public int[] getMarks() {
        // COPY ON THE WAY OUT.
        // Hand back a copy, never the real array. Whatever the caller does
        // to what they receive, our field is untouched.
        return marks.clone();
    }

    public double getAverage(){
        if (marks == null || marks.length == 0) {
            return 0.0;
        }

        int total = 0;

        for (int mark : marks) {
            total += mark;
        }

        return (double) total / marks.length;
    }

    public static void main(String[] args) {
        StudentRecord s = new StudentRecord(101, "Aditya");

        int[] m = {90, 80, 70};
        s.setMarks(m);
        System.out.println("Average: " + s.getAverage());

        m[0] = 999;
        System.out.println("Average: " + s.getAverage());

        int[] out = s.getMarks();
        out[1] = 999;
        System.out.println("Average: " + s.getAverage());

        s.setMarks(new int[]{90, 105, 70});
        System.out.println("Average: " + s.getAverage());

        s.setPassword("abc");
        s.setPassword("secret123");
        s.setName("");

        System.out.println("Name: " + s.getName());
        System.out.println("Roll: " + s.getRollNo());


    }
}
