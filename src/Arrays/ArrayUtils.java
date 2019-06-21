package Arrays;

public class ArrayUtils {

    public static <T> void printArray(T[] arr) {
        for(int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " | ");
        }
        System.out.println();
    }

    public static <T> void swap(T[] arr, int first, int second) {
        T tmp = arr[first];
        arr[first] = arr[second];
        arr[second] = tmp;
    }
}
