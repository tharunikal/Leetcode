class Solution {
    public double mincostToHireWorkers(int[] quality, int[] wage, int k) {
        
        int n = quality.length;
        
        List<Pair<Double, Integer>> wageToQualityRatioList = new ArrayList<>();
        
        for (int i = 0 ; i < n ; i++) {
            wageToQualityRatioList.add(new Pair((double) wage[i] / quality[i], quality[i]));
        }
        
        Collections.sort(wageToQualityRatioList, (x, y) -> Double.compare(x.getKey(), y.getKey()));
        
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((x, y) -> (y - x));
        
        
        double ans = Double.MAX_VALUE;
        
        int curTotalQuality = 0;
        
        for (Pair<Double, Integer> wageToQualityRatio : wageToQualityRatioList) {
            double curRatio = wageToQualityRatio.getKey();
            int curQuality = wageToQualityRatio.getValue();
            
            curTotalQuality += curQuality;
            
            maxHeap.add(curQuality);
            
            if (maxHeap.size() == k) {
                ans = Math.min(ans, curTotalQuality * curRatio);
            } else if (maxHeap.size() > k) {
                curTotalQuality -= maxHeap.poll();
                ans = Math.min(ans, curTotalQuality * curRatio);
            }
            
        }
        
        return ans;
    }
}
