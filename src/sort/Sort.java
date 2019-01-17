package sort;

import java.util.Arrays;

//冒泡，插入，选择，希尔
//1.数组
//2.特定数据结构

/**
 * 算法执行效率，内存消耗，稳定性
 * 1.执行效率：
 *      a).最好时间复杂度，最坏时间复杂度，平均时间复杂度
 *      b).比较次数和交换(或移动)次数
 * 2.内存消耗：
 * 通过时间复杂度【原地排序 = 空间复杂度为O(1)】
 * 3.稳定性：
 * 相邻两个相同元素之间相对位置是否发生改变，相对位置不变即为稳定，反之相对位置发生改变即为不稳定
 */
public class Sort {

    public static void main(String[] args) {
        int[] arr = { 2, 4, 6, 7, 2, 1, 3 };
        System.out.println(Arrays.toString(bubbleSort(arr)));
        System.out.println(Arrays.toString(insertionSort(arr)));
        System.out.println(Arrays.toString(selectionSort(arr)));
    }

    /**
     * 冒泡排序（从小到大排序）
     * 主要思想：1,3,2,1
     *  此排序为相邻两个元素进行比较，当两元素不满足大小关系则交换两元素位置，i++，进行下一轮
     *  ---------------------------------------------------------------------------
     * 整个排序过程包括两层循环：
     * 1、外层循环：表示需要从头开始比较的趟数=arr.length(loop [begin with index=0, end with index=arr.length-1])
     *      因为每次最大值冒泡之后都要重新开始寻找下一个最大值
     * 2、内层循环：表示查找序列中的最大值并放在相应位置(loop [begin with index=0, end with index=arr.length-1-i],i是外层趟数)
     * -------------------------------------------------------------------------------------------
     * Q1:为什么外层循环限制条件为(arr.length-1)?
     * A1:在非优化的冒泡排序中比较趟数=arr.length，因为初始值j=0，只要保证趟数=arr.length即可。
     * Q2:为什么内层循环限制条件为(arr.length-1-i)?
     * A2:
     * @param arr
     * @return
     */
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

    private static int[] bubbleSortBetter(int[] arr){
        return arr;
    }

    /**
     * 插入排序
     * 主要思想：
     *  整个序列可以视为已排序列和未排序列两部分，当未排序列为空时则排序结束
     *  插入是通过取未排序列中第一个元素，插入到已排序的相应位置中
     *  ---------------------------------------------------
     *  整个插入排序包括两层循环:
     *  1、外层循环：每次循环取当前需要插入的元素a[i](loop [begin with index=1, end with index=arr.length])
     *  2、内层循环：循环已排序列从而寻找插入元素的位置(loop [begin with index=i-1, end with index>=0])
     *  --------------------------------------------------------------------------------------
     *  Q1:如何找到插入位置？[设当前插入元素为a[i]，从小到大排序]
     *  A1:已知a[0]~a[i-1]为已排序，想要找到插入位置，即可遍历已排序列。
     *      通过反向遍历已排序列(loop from a[i-1]), 通过比较a[i]与当前遍历元素(a[j]),
     *          a). a[i]<a[j] --> a[j+1] = a[j]：即已排序列的a[j]向后移动一位，空出当前位置，直到情况(b)
     *          b). a[i]<=a[j]：即当前插入元素要大于已排序a[j]之前的元素，则 index=j+1 的位置即为当前插入位置
     *  Q2:为什么反向遍历已排序列？
     *  A2:如果正向遍历，那么当每次找到大于a[i]的元素，则会联动后面的元素一起移动，增加了移动次数，执行效率降低
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
