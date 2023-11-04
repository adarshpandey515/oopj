public class Exp7 {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        reverseAndPrint(arr);
    }

    public static void reverseAndPrint(int[] arr) {
        for (int i = arr.length - 1; i >= 0; i--) {
            System.out.print(arr[i] + " ");
        }
    }
}
