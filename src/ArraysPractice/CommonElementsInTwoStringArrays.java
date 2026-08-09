package ArraysPractice;

public class CommonElementsInTwoStringArrays {
    public static void main(String[] args) {
        String[] arr1={"Bhaiya","Dj","Cute","Panda"};
        String[] arr2={"me","nahi","cute","panda"};

        for (int i = 0; i < arr1.length; i++) {
            for (int j = 0; j < arr2.length; j++) {
                if(arr1[i].equalsIgnoreCase(arr2[j])){
                    System.out.println("Comman Elements are :"+arr1[i]);
                }

            }

        }
    }
}
