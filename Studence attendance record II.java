class Solution {

    private static final int MOD = 1000000000 + 7;

    public int checkRecord(int n) {
        return numPossibleRecords(n, 1, 2);
    }

    private int numPossibleRecords(int n, int numAbsensesRemaining, int numLatesRemaining) {
        if(n == 0) {
            return 1;
        }
        int total = 0;

        // Pick P
        total += numPossibleRecords(n - 1, numAbsensesRemaining, 2);
        
        if(numAbsensesRemaining > 0) {
            // Pick A
            total += numPossibleRecords(n - 1, numAbsensesRemaining - 1, 2);
            total %= MOD;
        }

        if(numLatesRemaining > 0) {
            // Pick L
            total += numPossibleRecords(n - 1, numAbsensesRemaining, numLatesRemaining - 1);
            total %= MOD;
        }

        return total;
    }
}
