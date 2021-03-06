import java.util.Random;

/**
 * Created by Brandon Ly on 1/18/2018.
 * CSC 320A
 */
public class InsertionSort {
    public static int[] createRandomIntArray( int size) {
        int[] answer = new int[size];
        Random generator = new Random();
        for( int i = 0; i < size; i++) {
            answer[i] = generator.nextInt(100) + 1;
        }
        return answer;
    }

    public static int sort(int[] A) {
        int n = 1;
        for(int i = 1; i < A.length; i++) {
            int key = A[i];
            int j = i - 1;
            n+=2;
            while(j >= 0 && A[j] > key) {
                A[j + 1] = A[j];
                j--;
                n+=2;
            }
            n+=2;
            A[j + 1] = key;
            n++;
        }
        return n;
    }

    public static void main(String[] args) {
        /*
            Initializing test arrays of varying sizes to sort with insertion sort from n = 10 up to n = 100000
            The array average holds the values the number of operations on average each array from n = 10 to n = 100000
        */ 
        int[][] Arrays = new int[5][];
        float[] avg = new float[5];

        /* 
            Fills the arrays with varying sizes of n.
            the variable, j, holds the values for the different sizes of n ranging from 10 to 100000
        */
        int j = 1;
        for(int i = 0; i < Arrays.length; i++) {
            j *= 10;
            Arrays[i] = new int[j+1];

            /*
                call insertion sort 10 times on each array of size n. 
                Creates a new random array for each iteration.
            */
            for(int k = 0; k < 10; k++){
                Arrays[i] = createRandomIntArray(j);
                avg[i] += sort(Arrays[i]);
            }
        }
        /* 
            this loop divides the average number of operations by 10 because each 
            array is sorted 10 times and each time it is sorted, the function returns the number of operations it took.
            The results are then displayed in the print statement
        */
        System.out.println(Arrays.toString(Arrays[1]));
        for(int i = 0; i < avg.length; i++) {
            avg[i] = avg[i] / 10;
            System.out.println("Size of the array: " + Arrays[i].length + " Estimated number of operations: " + avg[i]);
        }
    }
}
