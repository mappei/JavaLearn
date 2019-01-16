package sort;

import java.util.Arrays;

//冒泡，插入，选择，希尔
//1.数组
//2.特定数据结构
public class Sort {

    public static void main(String[] args) {
        int[] arr = { 2, 4, 6, 7, 2, 1, 3 };
        System.out.println(Arrays.toString(bubbleSort(arr)));
        System.out.println(Arrays.toString(insertionSort(arr)));
        System.out.println(Arrays.toString(selectionSort(arr)));
    }

    private static int[] bubbleSort(int[] arr) {
        for (int j = 0; j < arr.length - 1; j++) {
            for (int i = 0; i < arr.length - j - 1; i++) {
                if (arr[i] > arr[i + 1]) {
                    int temp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = temp;
                }
            }
        }
        return arr;
    }

    /**
     * 插入排序 主要思想： 整个序列可以视为已排序和未排序两部分
     */
    private static int[] insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int value = arr[i];
            int j = i - 1;
            for (; j >= 0; j--) {
                if (arr[j] > value) {
                    arr[j + 1] = arr[j];
                } else {
                    break;
                }
            }
            arr[j + 1] = value;
        }
        return arr;
    }

    private static int[] selectionSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int k = i;
            for (int j = i; j < arr.length - 1 - i; j++) {
                if (arr[k] > arr[k + 1]) {
                    k = k + 1;
                }
            }
            if (arr[i] < arr[k]) {
                int temp = arr[i];
                arr[i] = arr[k];
                arr[k] = temp;
            }
        }
        return arr;
    }

}
