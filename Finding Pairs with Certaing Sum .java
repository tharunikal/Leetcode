class FindSumPairs {
    private int[] nums1;
    private int[] nums2;
    private Map<Integer, Integer> counts;

    public FindSumPairs(int[] nums1, int[] nums2) {
        this.nums1 = nums1;
        this.nums2 = nums2;
        this.counts = new HashMap<>();

        for (int num : nums2) {
            counts.put(num, counts.getOrDefault(num, 0) + 1);
        }
    }
    
    public void add(int index, int val) {
        int oldValue = nums2[index];
        nums2[index] += val;
        int newValue = nums2[index];

        counts.put(oldValue, counts.get(oldValue) - 1);
        if (counts.get(oldValue) == 0) {
            counts.remove(oldValue); 
        }

        counts.put(newValue, counts.getOrDefault(newValue, 0) + 1);
    }
    
    public int count(int tot) {
        int totalPairs = 0; 
        for (int i = 0; i < nums1.length; i++) {
            int target = tot - nums1[i]; 
            totalPairs += counts.getOrDefault(target, 0); 
        }
        return totalPairs; 
    }
}
