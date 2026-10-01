package Strings;

public class StringHeapDemo {

    public static void main(String[] args) throws InterruptedException {

        // A unique word, so it's easy to find in the heap dump
        String s1 = "HeapDemoWord";                // 1 object: SCP
        String s2 = new String("HeapDemoWord2");   // 2 objects: SCP + heap
        String s3 = new String("HeapDemoWord3");   // 2 objects: SCP + heap

        System.out.println("s1 == s2 : " + (s1 == s2));   // false
        System.out.println("s2 == s3 : " + (s2 == s3));   // false
        System.out.println("s1 == s2.intern() : " + (s1 == s2.intern()));  // true

        // Print this program's process id (needed for Option B)
        System.out.println("PID = " + ProcessHandle.current().pid());
        System.out.println("Program is sleeping. Take the heap dump now...");

        // Keep the program alive for 5 minutes so we can take the dump
        Thread.sleep(5 * 60 * 1000);

        // Use the variables so Java keeps them alive until here
        System.out.println(s1 + s2 + s3);
    }
}