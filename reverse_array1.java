// Basic Java program that reverses an array 

public class reverseArray { 

	// function that reverses array and stores it 
	// in another array 
	static void reverse(int a[], int n) 
	{ 
		int[] b = new int[n]; 
		int j = n; 
		for (int i = 0; i < n; i++) { 
			b[j - 1] = a[i]; 
			j--; 
		} 

} 
