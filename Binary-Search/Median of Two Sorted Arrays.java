public class Solution {
    public double findMedianSortedArrays(int A[], int B[]) {
        int length = A.length + B.length;
        if (length % 2 == 1) {
            return findMedianHelper(A, B, 0, A.length - 1, 0, B.length - 1, length / 2 + 1);
        }
        else {
            return (findMedianHelper(A, B, 0, A.length - 1, 0, B.length - 1, length / 2 + 1) + findMedianHelper(A, B, 0, A.length - 1, 0, B.length - 1, length / 2)) / 2.0;
        }
        
    }
    private double findMedianHelper(int[] A, int[] B, int leftA, int rightA, int leftB, int rightB, int k) {
        int lenA = rightA - leftA + 1;
        int lenB = rightB - leftB + 1;
        if (lenA > lenB) {
            return findMedianHelper(B, A, leftB, rightB, leftA, rightA, k);
        }
        if (lenA == 0)
            return B[leftB + k - 1];
        if (k == 1)
            return Math.min(A[leftA], B[leftB]);
        int posA = Math.min(k / 2, lenA);
        int posB = k - posA;
        if (A[leftA + posA - 1] == B[leftB + posB - 1])
            return A[leftA + posA - 1];
        else if (A[leftA + posA - 1] > B[leftB + posB - 1]) {
            return findMedianHelper(A, B, leftA, leftA + posA - 1, leftB + posB, rightB, k - posB);
        }
        else {
            return findMedianHelper(A, B, leftA + posA, rightA, leftB, leftB + posB - 1, k - posA);
        }
    }

}
