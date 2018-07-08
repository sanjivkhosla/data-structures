import java.util.Arrays;

public class DedupeSortedArray {

	public static void main(String[] args) {

		int arr[] = { 1, 2, 2, 3, 4, 4, 4, 5, 6, 6, 7, 8, 9 };
		int n = arr.length;
		System.out.println("Length of input array is: " + n);
		System.out.println(Arrays.toString(arr));
		n = removeDuplicates(arr);
		System.out.println("Length of deduped array is: " + n);
		System.out.println(Arrays.toString(Arrays.copyOfRange(arr, 0, n)));
	}

	private static int removeDuplicates(int[] arr) {
		int n = arr.length;

		if (n == 0 || n == 1)
			return n;

		// stores index of the next unique element
		int j = 0;
		for (int i = 0; i < n-1; i++) {
			if (arr[i] != arr[i + 1]) {
				arr[j] = arr[i];
				j = j + 1;
			}
		}
		arr[j] = arr[n-1];

		return j + 1;
	}

}
