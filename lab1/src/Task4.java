
public class Task4 {
    public static void qSort(int[] arr) {
        quicksort(arr, 0, arr.length - 1);
    }

    private static void quicksort(int[] arr, int left, int right) {
        if (left < right) {
            int pivotIndex = partition(arr, left, right);
            quicksort(arr, left, pivotIndex - 1);
            quicksort(arr, pivotIndex + 1, right);
        }
    }

    static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private static int partition(int[] array, int left, int right) {

        int pivotIndex = right;
        int i = left - 1;

        for (int j = left; j < right; j++) {
            if (array[j] <= array[pivotIndex]) {
                i++;
                swap(array, i, j);
            }
        }

        swap(array, i + 1, right);

        return i + 1;
    }
    
    public static int findMax(int[] array)
    {
        int el = array[0];
        for (int i : array) {
            if (i > el) {
                el = i;
            }
        }
        return el;
    }

    public static int findMaxComplicatedVersion(int[] array)
    {
        qSort(array);
        return array[array.length - 1];
    }

    public static void main(String[] args) {
        int[] arr = { 12, 43, 12, -65, 778, 123, 32, 76 };
        //int[] arr = {};
        //int[] arr = { 1 };
        //int[] arr = { 1, 2 };
        //int[] arr = { 2, 1 };
        //int[] arr = { 3, 5, 2, 5, 1 };
        //int[] arr = { 9, 2, 5, 1, 8, 6, 7, 3, 4, 0 };

        for (int el : arr) {
            System.out.print(el);
            System.out.print('\t');
        }
        System.out.println();
        qSort(arr);

        for (int el : arr) {
            System.out.print(el);
            System.out.print('\t');
        }
        System.out.println('\n');
        System.out.println(findMax(arr));
        System.out.println(findMaxComplicatedVersion(arr));
    }
}
