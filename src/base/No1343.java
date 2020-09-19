package base;

public class No1343 {

	public int numOfSubarrays(int[] arr, int k, int threshold) {
		long target = threshold * k;
		long sum = 0;
		for (int i = 0; i < k; i++) {
			sum += arr[i];
		}

		int res = 0;
		if (sum >= target) {
			res++;
		}

		for (int i = k; i < arr.length; i++) {
			sum += arr[i];
			sum -= arr[i-k];
			if (sum >= target) {
				res++;
			}
		}
		return res;
    }

}