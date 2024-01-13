import java.util.Arrays;

public class MergeSort {
    public static void mergeSort(int[] arr) {
        if (arr.length > 1) {
            int mid = arr.length / 2;

            // 创建左右两个子数组
            int[] left = Arrays.copyOfRange(arr, 0, mid);
            int[] right = Arrays.copyOfRange(arr, mid, arr.length);

            // 递归地对左右两个子数组进行归并排序
            mergeSort(left);
            mergeSort(right);

            // 合并两个有序子数组
            merge(arr, left, right);
        }
    }

    private static void merge(int[] arr, int[] left, int[] right) {
        int i = 0, j = 0, k = 0;

        // 比较左右两个子数组的元素，将较小的元素放入原数组
        while (i < left.length && j < right.length) {
            if (left[i] <= right[j]) {
                arr[k++] = left[i++];
            } else {
                arr[k++] = right[j++];
            }
        }

        // 处理剩余元素（如果有）
        while (i < left.length) {
            arr[k++] = left[i++];
        }

        while (j < right.length) {
            arr[k++] = right[j++];
        }
    }

    public static void main(String[] args) {
        int[] arr = {64, 34, 25, 12, 22, 11, 90};

        System.out.println("Original Array: " + Arrays.toString(arr));

        // 调用归并排序
        mergeSort(arr);

        System.out.println("Sorted Array: " + Arrays.toString(arr));
    }
}
