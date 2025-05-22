class Solution {
    public int maxRemoval(int[] a, int[][] q) {

        Arrays.sort(q, (x, y) -> x[0] - y[0]);
        PriorityQueue<Integer> heap = new PriorityQueue<>((x, y) -> y - x);

        int sum = 0, n = a.length, m = q.length;
        int[] f = new int[n + 1];
        int k = 0;

        for (int i = 0; i < n; i++) {
            sum += f[i];
            while (k < m && q[k][0] == i) heap.add(q[k++][1]);

            while (sum < a[i] && !heap.isEmpty() && heap.peek() >= i) {
                sum++;
                f[heap.remove() + 1]--;
            }

            if (sum < a[i]) return -1;
        }
        return heap.size();
    }
}
