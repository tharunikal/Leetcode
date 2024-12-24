class Solution {
    public int getDiameter(int[][] graph, int nodes) {
        int[] bfs(int start) {
            int[] dist = new int[nodes];
            Arrays.fill(dist, -1);
            Queue<Integer> q = new LinkedList<>();
            q.add(start);
            dist[start] = 0;
            int farNode = start;
            while (!q.isEmpty()) {
                int curr = q.poll();
                for (int next : graph[curr]) {
                    if (dist[next] == -1) {
                        dist[next] = dist[curr] + 1;
                        q.add(next);
                        if (dist[next] > dist[farNode]) {
                            farNode = next;
                        }
                    }
                }
            }
            return new int[]{farNode, dist[farNode]};
        }
        return bfs(bfs(0)[0])[1];
    }

    public int minimumDiameterAfterMerge(int[][] tree1, int[][] tree2) {
        int n = tree1.length + 1, m = tree2.length + 1;
        int[][] g1 = new int[n][];
        int[][] g2 = new int[m][];
        
        for (int[] edge : tree1) {
            g1[edge[0]].add(edge[1]);
            g1[edge[1]].add(edge[0]);
        }
        for (int[] edge : tree2) {
            g2[edge[0]].add(edge[1]);
            g2[edge[1]].add(edge[0]);
        }
        
        int d1 = getDiameter(g1, n);
        int d2 = getDiameter(g2, m);
        return Math.max(d1, d2, (d1 + 1) / 2 + (d2 + 1) / 2 + 1);
    }
}
