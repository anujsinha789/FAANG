package biweekly31;

/**
 * Created on:  Jul 25, 2020
 * Questions: https://leetcode.com/problems/number-of-sub-arrays-with-odd-sum
 */
public class NumberOfSubArraysWithOddSum {
    public static void main(String[] args) {

    }

    public static int numOfSubarrays_optimal(int[] arr) {
//            even + even = even, odd + odd = even
//            even + odd = odd, odd + even = odd
        int cur = 0;
        int res = 0;
        int[] count = {1, 0};
        int mod = 1_000_000_007;
        for (int num : arr) {
//            Check if the sum of previous values and current value is odd or even.
            cur ^= num & 1;
//            Number sub array at each element will the amount of opposite counts.
            res = (res + count[1 - cur]) % mod;
//            At each level increment the occurance count.
            count[cur]++;
        }
        return res;
    }

    public static int numOfSubarrays(int[] ar) {
        long result = 0;
        int mod = 1_000_000_009;
        for (int i = 0; i < ar.length; i++) {
            int val = 0;
            for (int j = i; j < ar.length; j++) {
                val = val + ar[j];
                if (val % 2 != 0)
                    result++;
            }
        }

        return (int) (result % mod);
    }
}
