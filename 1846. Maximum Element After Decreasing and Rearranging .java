class Solution {
    private static final int MAXN = 100000;
    private static int[] freqs = new int[MAXN];

    public int maximumElementAfterDecrementingAndRearranging(int[] arr) {
        final int n = arr.length;
        if (n == 1) return 1;
        for (int v : arr) {
            if (v <= n) freqs[v - 1]++;
        }
        int maxe = n, c = -1;
        for (int v = 0; v < maxe; v++) {
            c += freqs[v];
            if (c > v) {
                maxe -= c - v;
                c = v;
            }
            freqs[v] = 0;
        }
        Arrays.fill(freqs, maxe, n, 0);
        return maxe;
    }
}
