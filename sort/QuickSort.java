import java.util.Arrays;

public class QuickSort {
    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            // 先进行partition
            int partitionIndex = partition(arr, low, high);


            // Recursively sort elements before and after the partition index
            quickSort(arr, low, partitionIndex - 1);
            quickSort(arr, partitionIndex + 1, high);
        }
    }

    private static int partition(int[] arr, int low, int high) {
        // select pivot from the last element of arr
        int pivot = arr[high];

        //
        int i = low;
        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {


                //遍历j 当j小于pivot的时候，把A[i]和A[j]换位置
                // 选最后一个元素作为pivot 然后从第一个元素开始遍历j，如果j小于pivot 就把A[j]放到前面，i++ 这样交换保证前面的元素一直到i都是小于pivot的
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++;
            }
        }

        //  最后把pivot和i的元素兑换
        int temp = arr[i];
        arr[i] = arr[high];
        arr[high] = temp;

        return i;
    }

    public static void main(String[] args) {


        int[] arr = {64, 34, 25, 12, 22, 11, 90};
        int n = arr.length;

        System.out.println("Original Array: " + Arrays.toString(arr));

//        quickSort(arr, 0, n - 1);

        sortArray(arr);

        System.out.println("Sorted Array: " + Arrays.toString(arr));
    }


    // quick if we do not use last element as pivot
    public static int[] partitionRandomPivot(int[] nums, int left, int right) {
        int i = left;
        int j = right;
        int pivot = nums[left + (int)(Math.random() * (right - left + 1))];
        System.out.println("current pivot:" + String.valueOf(pivot));
        while (i <= j) {
            while (nums[i] < pivot) {
                i += 1;    // i 左边的数小于pivot
            }
            while (nums[j] > pivot) {
                j -= 1;  // j 右边的数大于pivot
            }
            if (i <= j) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                i += 1;
                j -= 1;
            }
        }
        return new int[]{i, j};
    }

    public static void dfs(int[] nums, int left, int right) {
        if (left >= right) {
            return;
        }
        int[] res = partitionRandomPivot(nums, left, right);
        System.out.println(Arrays.toString(res));
        System.out.println(Arrays.toString(nums));
        dfs(nums, left, res[1]);
        dfs(nums, res[0], right);
    }

    public static int[] sortArray(int[] nums) {
        dfs(nums, 0, nums.length - 1);
        return nums;
    }

}
