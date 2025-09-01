import java.util.PriorityQueue;

class Solution {
    public double maxAverageRatio(int[][] classes, int extraStudents) {
        // PriorityQueue stores {gain, index}, sorted by gain descending
        PriorityQueue<double[]> pq = new PriorityQueue<>((a, b) -> Double.compare(b[0], a[0]));

        // Push initial marginal gain for each class
        for (int i = 0; i < classes.length; i++) {
            double curr = (double) classes[i][0] / classes[i][1];
            double newPr = (double) (classes[i][0] + 1) / (classes[i][1] + 1);
            pq.offer(new double[]{newPr - curr, i});
        }

        // Distribute extra students
        while (extraStudents-- > 0) {
            double[] top = pq.poll();
            int i = (int) top[1];
            classes[i][0] += 1;
            classes[i][1] += 1;
            double curr = (double) classes[i][0] / classes[i][1];
            double newPr = (double) (classes[i][0] + 1) / (classes[i][1] + 1);
            pq.offer(new double[]{newPr - curr, i});
        }

        // Compute final average pass ratio
        double ans = 0.0;
        for (int[] c : classes) {
            ans += (double) c[0] / c[1];
        }

        return ans / classes.length;
    }
}
