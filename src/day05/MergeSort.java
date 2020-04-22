package day05;

public class MergeSort {
    public static void main(String[] args) {
        MergeSort mergeSort = new MergeSort();
        //生成随机数组
        int number = 10000;
        int temp[] = new int[number];
        int a[] = new int[number];
        for (int i = 0; i < number; i++) {
            a[i] = (int) (Math.random() * number);
        }
        mergeSort.mergeSort(0, a.length - 1, a, temp);
        for (int i = 0; i < number; i++) {
            System.out.print(a[i] + "->");
        }
    }

    public static void mergeSort(int start, int end, int a[], int temp[]) {
        if (start < end) {
            int mid = (start + end) >> 1;
            mergeSort(start, mid, a, temp);
            mergeSort(mid + 1, end, a, temp);
            mergeArray(start, mid, end, a, temp);
        }
    }

    public static void mergeArray(int start, int mid, int end, int a[], int temp[]) {
        int i = start, j = mid, m = mid + 1, n = end, k = 0;
        while (i <= mid && m <= end) {
            if (a[i] < a[m]) {
                temp[k++] = a[i++];
            } else {
                temp[k++] = a[m++];
            }
        }
        while (i <= mid) {
            temp[k++] = a[i++];
        }
        while (m <= end) {
            temp[k++] = a[m++];
        }
        for (int l = 0; l < k; l++) {
            a[start+l] = temp[l];
        }
    }
}
