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
 * 通过空间复杂度【原地排序 = 空间复杂度为O(1)】
 * 空间复杂度的影响因素包括：算法本身的存储，输入输出参数的存储，算法运行时临时的占用
 * 在平时计算中我们使用运行中的局部变量的存储空间计算，包括算法中的局部变量和参数
 * 3.稳定性：
 * 相邻两个相同元素之间相对位置是否发生改变，相对位置不变即为稳定，反之相对位置发生改变即为不稳定
 */
public class Sort {

    public static void main(String[] args) {
        int[] arr = { 2, 4, 6, 7, 2, 1, 3, 87, 45, 876, 34, 6, 32, 23, 65 };
        System.out.println(Arrays.toString(bubbleSort(arr)));
        System.out.println(Arrays.toString(insertionSort(arr)));
        System.out.println(Arrays.toString(selectionSort(arr)));
        System.out.println(Arrays.toString(shellSort(arr)));
        System.out.println(Arrays.toString(effectiveBubbleSort(arr)));
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
     * 执行效率： 最好时间复杂度：O(n)\最坏时间复杂度：O(n*n)
     * 内存消耗： 空间复杂度：O()
     * 稳定性：我们在代码中可以看到，如果相邻两个元素相等不需要进行位置交换，即相对位置没有发生改变，因此冒泡排序是稳定排序
     * （不进行交换的目的也是降低执行效率）
     * ------------------------------------------
     * Q1:为什么外层循环限制条件为(arr.length-1)?
     * A1:在非优化的冒泡排序中比较趟数=arr.length，因为初始值j=0，只要保证趟数=arr.length即可。
     * Q2:为什么内层循环限制条件为(arr.length-1-i)?
     * A2:内层循环的目的是每次从头排序，从而找到每一趟中的最大值，因此一个序列就会分为已排序列和未排序列，
     *      所以内层循环的循环次数=未排序列的长度=外层循环总次数-当前外层循环值
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

    private static int[] effectiveBubbleSort(int[] arr) {
        boolean swapped = true;
        for (int i = arr.length - 1; i >= 0 && swapped; i--) {
            swapped = false;
            for (int j = 0; j < i; j++) {
                if (arr[j] > arr[j + 1]) {
                    swapped = true;
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
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
     *  执行效率：最好时间复杂度：O(n), 最坏时间复杂度：O(n*n)
     *  内存消耗：空间复杂度：
     *  稳定性：当我们发现插入元素与当前比较元素相等时，我们不进行位移操作，即相对位置没有发生改变，所以插入排序是稳定排序
     *  --------------------------------------------------
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

    /**
     * 选择排序：
     * 主要思想：
     *      选择未排序列中的最小值放到已排序列的最后，因此第一步就要找到未排序列中的最小值，然后与未排序列的首元素比较大小，
     *      当min<a[i],交换量元素位置，否则不交换
     * ---------------------------------------------------------------------------------------------
     * 选择排序的过程需要两层循环：
     * 1、外层循环：与插入排序同理，寻找下一次内循环中最小值元素
     * 2、内层循环：遍历未排序列，寻找最小值元素并记录位置
     * -----------------------------------------------------
     * 执行效率：最好时间复杂度：O(n)，最坏时间复杂度：O(n*n)
     * 内存消耗：空间复杂度
     * 稳定性：当最小值元素与当前元素不满足大小关系时，两个元素的位置会交换，则会使两个同值元素的相对位置发生改变，即选择排序为不稳定排序
     * ---------------------------------------------------------------------------------------------
     * Q1:如何寻找最小元素？
     * A1:我们通过记录最小元素的下标来获取最小元素值。同样我们可以把整个列表视为两部分已排序列和未排序列，通过遍历未排序列获取最小元素的下标。
     *
     * @param arr
     * @return
     */
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

    /**
     * 希尔排序：是插入排序的优化？
     * 主要思想：
     *      将序列分为gap个组，然后对每组小序列进行排序，以此循环，直到n=1时结束循环得到最后结果
     *      gap：称为增量值，计算方法：gap0 = length/2,下一次循环的增量值gap1 = gap0/2 .... 就会形成增量序列。
     *      增量序列：{length/2, (length/2)/2, ((length/2)/2)/2, .....}
     * ---------------------------------------------------------------------------------------------
     *
     * @param arr
     * @return
     */
    private static int[] shellSort(int[] arr) {
        for (int i = arr.length / 2; i <= 1; i /= 2) {
            for (int j = 0; j <= i; j++) {
                if (arr[j] > arr[j + i]) {
                    int temp = arr[j];
                    arr[j] = arr[j + i];
                    arr[j + i] = temp;
                }
            }
        }
        return arr;
    }

}
