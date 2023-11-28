class Solution {
    public int numberOfWays(String corridor) {

        char[] array = corridor.toCharArray();
        int chairs = 0;
        long result = 1;

        for (int i = 0; i < array.length; i++) {

            // seat encountered
            if (array[i] == 'S') {
                chairs++;

                // advance to the next seat ignoring plants along the way
                while (++i < array.length && array[i] != 'S');
                if (i < array.length && array[i] == 'S') {
                    chairs++;
                }


                // there is one guaranteed division between adjacent pairs of seats
                // each plant between them adds an extra 1 division
                int divisions = 1;
                while (++i < array.length && array[i] != 'S') {
                    divisions++;
                }

                // if any extra divisions are possible, multiply our result by the divisions                
                if (divisions > 1 && i < array.length) {
                    result = (result * divisions) % 1000000007;
                }
                i--;
            }
        }

        // if there are no chairs or an odd number of chairs there are no possible divisions
        // otherwise return our calculated result
        return (chairs != 0 && chairs % 2 == 0) ? (int) result : 0;
    }
}
