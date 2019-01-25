package sort;

/**
 * 归并排序：
 * 主要思想：
 *      现将整个数组进行拆分，然后将筛分后的小数组，最后将排序好的小数组排序并合并
 * ---------------------------------------------------------------------------
 * Q1:如何拆分数组？
 * A1:将数组每次对半分为两个数组，[low,mid] + [mid+1,high]
 * Q2:如何合并两个小数组？
 * A1:我们引入help临时数组存储当前需要合并的数组help[low,high]，
 *      当前参数传入的整个数组被分为已经排好序的两部分，通过逐个比较前后两部分进行合并
 *      合并细节：1.第一个数组的起始元素标记是否已经超过mid+1,超过则说明第一个数组比较结束，
 *                  所以放入原数组中之后的元素为第二个元素标记元素之后的元素
 *               2.第二个数组起始元素标记是否已经超过high，原理同上
 *               3.以上情况都不满足，说明前后两个数组都没有结束，则继续比较，
 *                  当前者大于后者(array[i]>array[j])，则原数组当前位置应该存放较小元素array[j]，标记值j++
 *               4.排除以上情况则(array[i]<=array[j])，同理存放较小元素array[i]，标志值i++，
 *               即使两个值相等但是相对位置没有发生改变，所以归并排序是稳定排序
 */
public class MergeSort {

    public static void main(String[] args) {
        int unsortedArray[] = new int[]{ 6, 5, 3, 1, 8, 7, 2, 4 };
        mergeSort(unsortedArray);
        System.out.println("After sort: ");
        for (int item : unsortedArray) {
            System.out.print(item + " ");
        }
    }

    private static void merge(int[] array, int low, int mid, int high) {
        int[] help = new int[array.length];
        for (int i = low; i <= high; i++) {
            help[i] = array[i];
        }
        int j = mid + 1;
        int i = low;
        for (int k = low; k <= high; k++) {
            if (i > mid + 1) {
                array[k] = help[j];
                j++;
            } else if (j > high) {
                array[k] = help[i];
                i++;
            } else if (help[i] > help[j]) {
                array[k] = help[j];
                j++;
            } else {
                array[k] = help[i];
                i++;
            }
        }
    }

    private static void sort(int[] array, int low, int high) {
        if (low >= high) {
            return;
        }
        int mid = low + (high - low) / 2;
        sort(array, low, mid);
        sort(array, mid + 1, high);
        merge(array, low, mid, high);
    }

    private static void mergeSort(int[] array) {
        sort(array, 0, array.length - 1);
    }
}
