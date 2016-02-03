package util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Util {
	private static Random rand = new Random(System.currentTimeMillis());	
	
	//Integer[]를 ArrayList<Integer>로 변환
	public static ArrayList<Integer> integerArrToArrList(Integer[] integerArr) {
		ArrayList<Integer> result = new ArrayList<Integer>();
		for(int i=0;i<integerArr.length;i++)
			result.add(new Integer(integerArr[i]));		
		return result;
	}	
	
	//Integer[] 를 int[] 로 변환
	public static int[] integerArrToIntArr(Integer[] integerArr) {
		int[] result = new int[integerArr.length];
		for(int i=0;i<integerArr.length;i++)		
			result[i] = integerArr[i].intValue();
		return result;
	}
	//int[]를 Integer[] 로 변환
	public static Integer[] intArrToIntegerArr(int[] intArr) {
		Integer[] result = new Integer[intArr.length];
		for(int i=0;i<intArr.length;i++)		
			result[i] = new Integer(intArr[i]);
		return result;
	}
	//ArrayList<Integer> 를 Integer[] 로 변환
	public static Integer[] integerArrListToIntegerArr(ArrayList<Integer> arrList) {
		Integer[] result = new Integer[arrList.size()];
		arrList.toArray(result);
		return result;
	}
	//ArrayList<Integer> 를 int[] 로 변환
	public static int[] integerArrListToIntArr(ArrayList<Integer> arrList) {
		return integerArrToIntArr(integerArrListToIntegerArr(arrList));
	}
	
	//int[][] array를 string 으로 변환
	public static String arrayToString(int[][] array,String delim1,String delim2) {
		StringBuffer result = new StringBuffer("");
		
		for(int i=0;i<array.length;i++)
		{
			result.append(arrayToString(array[i],delim1));
			if(i<array.length-1)
				result.append(delim2);
		}
		return result.toString();
	}	
	
	//array를 string 으로 변환
	public static String arrayToString(int[] array,String delim) {
		StringBuffer result = new StringBuffer("");
		
		for(int i=0;i<array.length;i++)
		{			
			result.append(Integer.toString(array[i]));
			if(i<array.length-1)
				result.append(delim);
		}
		
		return result.toString();
	}
	
	//array를 string 으로 변환
	public static String arrayToString(int[] array,String delim,int start,int end) {
		StringBuffer result = new StringBuffer("");
		
		for(int i=start;i<=end;i++)
		{			
			result.append(Integer.toString(array[i]));
			if(i<end)
				result.append(delim);
		}
		
		return result.toString();
	}
	
	//array를 string 으로 변환
	public static String arrayToString(long[] array,String delim) {
		StringBuffer result = new StringBuffer("");
		
		for(int i=0;i<array.length;i++)
		{			
			result.append(Long.toString(array[i]));
			if(i<array.length-1)
				result.append(delim);
		}
		
		return result.toString();
	}
	
	//arraylist를 string 으로 변환
	public static String arrayToString(ArrayList<Integer> array,String delim) {
		Integer[] arr = new Integer[array.size()];
		array.toArray(arr);
		
		return arrayToString(integerArrToIntArr(arr),delim);
	}
	
	//n개의 integer를 랜덤하게 만든다. max는 positive가 true일 때만 의미가 있다.
	public static int[] makeRandIntArr(int size,int max,boolean positive) {
		int[] result = new int[size];
		
		for(int i=0;i<result.length;i++)
		{
			if(positive)
				result[i] = rand.nextInt(max);
			else
				result[i] = rand.nextInt();				
		}
		
		return result;
	}
	
	//n개의 integer를 랜덤하게 만든다. max는 positive가 true 일때만 의미가 있다.
	public static ArrayList<Integer> makeRandIntArrayList(int size,int max,boolean positive) {
		ArrayList<Integer> result = new ArrayList<Integer>();
		int[] arr = makeRandIntArr(size,max,positive);
		
		for(int i=0;i<size;i++)
			result.add(arr[i]);
		
		return result;
	}
	
	//binary search(iterative)
	public static int binarySearch(int[] data, int num,int l,int r) {		
		while(l<=r)
		{
			int m = (l+r)/2;
			if(num==data[m])
				return m;		
			if(num>data[m])		
				l = m+1;				
			if(num<data[m])
				r = m-1;
		}
		return -1;		
	}
	
	//binary search
	public static int binarySearch(ArrayList<Integer> data, int num,int l,int r) {
		Integer[] arr = new Integer[data.size()];
		data.toArray(arr);
		
		return binarySearch(integerArrToIntArr(arr),num,l,r);
	}
	
	//max 값 찾기
	public static int max(int[] array)	{
		int maxVal = array[0];
		for(int i=1;i<array.length;i++)
		{
			if(array[i]>maxVal)
				maxVal = array[i];
		}
		return maxVal;
	}
	
	//max 값 찾기
	public static long max(long[] array)	{
		long maxVal = array[0];
		for(int i=1;i<array.length;i++)
		{
			if(array[i]>maxVal)
				maxVal = array[i];
		}
		return maxVal;
	}
	
	//min 값 찾기
	public static int min(int[] array)	{
		int minVal = array[0];
		for(int i=1;i<array.length;i++)
		{
			if(array[i]<minVal)
				minVal = array[i];
		}
		return minVal;
	}
	

	//min 값 찾기
	public static long min(long[] array)	{
		long minVal = array[0];
		for(int i=1;i<array.length;i++)
		{
			if(array[i]<minVal)
				minVal = array[i];
		}
		return minVal;
	}
	
	//array를 정렬한다.
	public static void sort(int[] array) {		
		ArrayList<Integer> arrList = integerArrToArrList(intArrToIntegerArr(array));
		Collections.sort(arrList);
		for(int i=0;i<array.length;i++)
			array[i] = arrList.get(i);
	}		
	
	//값이 array에 포함되어 있는지 검사한다.
	public static boolean isInArray(int[] array,int value) {
		for(int i=0;i<array.length;i++)
		{
			if(array[i]==value)
				return true;
		}
		return false;
	}

	//두 수를 swap 한다.
	public static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
	
	//n by n int array를 string으로 변환
	public static String matrixToString(int[][] matrix,String delim) {
		StringBuffer sb = new StringBuffer();
		
		int n = matrix.length;
		for(int i=0;i<n;i++)
		{
			for(int j=0;j<n;j++)
			{
				sb.append(matrix[i][j]);
				if(j!=n-1)
					sb.append(delim);
			}
			sb.append('\n');
		}
		
		return sb.toString();
	}
}
