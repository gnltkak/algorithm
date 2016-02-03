package interview;

import util.Util;

public class _2011_12_30_Sorting {
	public static void quickSort(int[] arr) {
		doQuickSort(arr, 0, arr.length - 1);
	}

	private static void doQuickSort(int[] arr, int i, int j) {
		if (i >= j)
			return;
		
		int p = partition(arr, i, j);
		doQuickSort(arr, i, p-1);
		doQuickSort(arr, p+1, j);
	}

	private static int partition(int[] arr, int i, int j) {
		int l = i;
		int u = i + 1;
		int pivot = arr[i];
		while (u <= j) {
			if (arr[u] <= pivot) {
				++l;
				Util.swap(arr, l, u);
			}
			++u;
		}
		Util.swap(arr, i, l);
		return l;
	}
	
	///////////////////////////////////////////////////////////
	public static void mergeSort(int[] arr) {
		doMergeSort(arr, 0, arr.length - 1);
	}

	private static void doMergeSort(int[] arr, int l, int r) {
		if (l == r)
			return;
		
		int m = (l + r) / 2;
		doMergeSort(arr, l, m);
		doMergeSort(arr, m + 1, r);
		merge(arr, l, m, r);
	}

	private static void merge(int[] arr, int l, int m, int r) {
		int i = l;
		int j = m + 1;
		int[] temp = new int[r - l + 1];
		int k = 0;
		
		while (i <= m && j <= r) {
			if (arr[i] < arr[j])
				temp[k++] = arr[i++];
			else
				temp[k++] = arr[j++];
		}
		
		while (i <= m)
			temp[k++] = arr[i++];
		while (j <= r)
			temp[k++] = arr[j++];
		
		for (int p = 0; p < temp.length; ++p) {
			arr[l + p] = temp[p];
		}
	}
}
