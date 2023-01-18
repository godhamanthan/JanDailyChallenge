class Solution {
    public int maxSubarraySumCircular(int[] A) {
        int min = Integer.MIN_VALUE;
        boolean positive = false;
        for (int i = 0; i < A.length; i++) {
            if (A[i] >= 0) {
                positive = true;
                break;
            } else {
                if (A[i] > min) {
                    min = A[i];
                }
            }
        }
        if (!positive) {
            return min;
        }
        for (int i = 0; i < A.length; i++) {
            A[i] = -A[i];
        }

        
        int negMaxSum = kadane(A);

        
        for (int i = 0; i < A.length; i++) {
            A[i] = -A[i];
        }

    
        return Integer.max(kadane(A), Arrays.stream(A).sum() + negMaxSum);
    }

    int kadane(int[] a) {
        int sum = 0;
        int maxSum = 0;
        int firstIndex = -1;

        for (int i = 0; i < a.length; i++) {
            sum += a[i];
            if (sum < 0) {
                sum = 0;
            } else {
                maxSum = Math.max(sum, maxSum);
                if (firstIndex == -1)
                    firstIndex = i;
            }
        }
        
        for (int i = 0; i < firstIndex; i++) {
            sum += a[i];
            if (sum < 0) {
                sum = 0;
            } else {
                maxSum = Math.max(sum, maxSum);
            }
        }
        return maxSum;
    }
}
