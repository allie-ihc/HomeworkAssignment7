package HomeworkAssignment7Driver;

import java.util.Random;

public class HomeworkAssignment7 {
	public static void main(String[] args) {
		int size = 100000;
		int[] selectArray = RandomizedArray(size, 1);
		int[] bubbleArray = new int[size];
		for (int i = 0; i < size-1; i++)
		{
			bubbleArray[i] = selectArray[i];
		}
		long selectStart = System.currentTimeMillis();
		selectSort(selectArray);
		long selectFinish = System.currentTimeMillis();
		long selectTimeElapsed = selectFinish - selectStart;
		long bubbleStart = System.currentTimeMillis();
		bubbleSort(bubbleArray);
		long bubbleFinish = System.currentTimeMillis();
		long bubbleTimeElapsed = bubbleFinish - bubbleStart; 
		long insertStart = System.currentTimeMillis();
		selectSort(selectArray);
		long insertFinish = System.currentTimeMillis();
		long insertTimeElapsed = insertFinish - insertStart;
		System.out.println("Sorting a random array of size " + size + " took selection sort " + selectTimeElapsed + "ms to complete");
		System.out.println("Sorting a random array of size " + size + " took bubble sort " + bubbleTimeElapsed + "ms to complete");
		System.out.println("Sorting a random array of size " + size + " took insertion sort " + insertTimeElapsed + "ms to complete");
	}
	
	//size = size of array, start = number to start array with
	public static int[] RandomizedArray(int size, int start)
	{
		Random rand = new Random();
		int[] tempArray = new int[size];
		for (int i = 0; i<tempArray.length-1; i++)
		{
			tempArray[i] = i + start;
		}
		for (int i = 0; i < 10000; i++)
		{
			//find two random indexes of array
			int firstRandIndex = rand.nextInt(tempArray.length);
			int secondRandIndex = rand.nextInt(tempArray.length);
			int temp = tempArray[firstRandIndex];
			//swap indexes
			tempArray[firstRandIndex] = tempArray[secondRandIndex];
			tempArray[secondRandIndex] = temp;
		}
		return tempArray;
	}
	public static void insertionSort(int[] array)
	{
		for(int i = 1; i < array.length; i++)
		{
			int temp = array[i];
			int tempIndex = 0;
			for(int j = 0; j <= i; j++)
			{
				if(array[j] > temp)
				{
					tempIndex = j;
				}
			}
			for (int j = tempIndex; j <=i; j++)
			{
				array[j] = array[j+1];
			}
			array[tempIndex] = temp;
		}
	}
	public static void bubbleSort(int[] array)
	{
		for(int i = 0; i < array.length; i++)
		{
			for (int j = 0; j < array.length - i - 1; j++)
			{
				if (array[j] > array[j+1])
				{
					int temp = array[j];
					array[j] = array[j+1];
					array[j+1] = temp;
				}
			}
		}
		
	}
	public static void selectSort(int[] array)
	{
		int tempIndex = 0;
		for(int i = 0; i < array.length-1; i++)
		{
			tempIndex = i;
			for(int j = i+1; j < array.length; j++)
			{
				if(array[j] < array[tempIndex])
				{
					tempIndex = j;
				}
			}
			if (tempIndex != i)
			{
				int temp = array[i];
			array[i] = array[tempIndex];
			array[tempIndex] = temp;
			}
			
			
		}
	}
}
