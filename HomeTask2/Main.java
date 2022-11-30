import java.util.Arrays;

class Main
{
	public static void main(String[] args)
		{
			int[] arr = { 56, 11, 12, 39, 23, -7, 0, 4, 6 }; //Массив для сортировки
			int[] temp = Arrays.copyOf(arr, arr.length); //Делаем вспом массив - копию
	
			// вызов рекурсивного метода
			mergesort(arr, temp, 0, arr.length - 1);
	
			if (isSorted(arr)) {
				System.out.println(Arrays.toString(arr));
			}
		}
	public static void merge(int[] arr, int[] temp, int low, int mid, int high)
	{
		int k = low, i = low, j = mid + 1;

		// слияние с учётом длины 
		while (i <= mid && j <= high)
		{
			if (arr[i] <= arr[j]) {
				temp[k++] = arr[i++];
			}
			else {
				temp[k++] = arr[j++];
			}
		}
		// копирование элементов левой половины
		while (i <= mid) {
			temp[k++] = arr[i++];
		}
		//копирование из вспомогательного массива в оригинал
		for (i = low; i <= high; i++) {
			arr[i] = temp[i];
		}
	}

	// рекурсивная сортировка путём распиливания массива "до талого" (ломай меня полностью)
	public static void mergesort(int[] arr, int[] temp, int low, int high)
	{
		// выход из рекурсии если длина массива равна или меньше 0
		if (high <= low) {return;}
		// Определение средней позиции
		int mid = (low + ((high - low) / 2));

		mergesort(arr, temp, low, mid);  		// сортировка левой половины
		mergesort(arr, temp, mid + 1, high); 	// сортировка правой половины
		merge(arr, temp, low, mid, high);		// слияние отсортированных половин
	}

	
	public static boolean isSorted(int[] arr) //Метод для проверки отсортирован ли в итоге массив
	{
		int prev = arr[0];
		for (int i = 1; i < arr.length; i++)
		{
			if (prev > arr[i])
			{
				System.out.println("Массив не отсортирован!");
				return false;
			}
			prev = arr[i];
		}

		return true;
	}


}