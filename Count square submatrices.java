class Solution {
    public int countSquares(int[][] matrix) {
        // Get the dimensions of the matrix (number of rows and columns)
        int rows = matrix.length; 
        int cols = matrix[0].length; 
        
        // Initialize the counter for all the squares we can find
        int count = 0; 

        // Base cases: Mark every '1' in the first row and the first column as '1'.
        // This is the initialization for our dynamic programming.
        for (int i = 1; i < rows; i++) if (matrix[i][0] == 1) matrix[i][0] = 1; 
        for (int j = 1; j < cols; j++) if (matrix[0][j] == 1) matrix[0][j] = 1;  

        // Main logic: Look at the other elements to see how big of a square can we build until this point
        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < cols; j++) {
                // If the current element is 1, it means we can potentially build a square
                if (matrix[i][j] == 1) {
                    // Find the minimum value of the top, left, and top-left diagonal neighbors
                    // and add 1 to it. This tells us the size of the biggest square we can make
/*
Imagine that you are building squares from units in a matrix. You want to find out which is the largest square you can build so that it ends in each cell.

**Briefly:**

* Look at the cell from above, on the left and diagonally.
* Take the smallest square size from these cells.
* Add 1 (if the current cell is also a unit). This will be the size of the largest square that ends in the current cell.

**Example:**

[
  [1, 1, 1],
  [1, 1, 1],
  [1, 1, 1]
]

You're in a cage `[1][1]'.

* Top: 1x1 square
* On the left: 1x1 square
* Diagonal: 1x1 square

The smallest size: 1. Add 1 (because the current cell is also 1). We get 2. This means that the largest square that ends in the cell is `[1][1]`, — this is a 2x2 square.
*/
                    matrix[i][j] = Math.min(matrix[i - 1][j], Math.min(matrix[i][j - 1], matrix[i - 1][j - 1])) + 1;
                }
            }
        }

        // Add the size of all the squares we found to the count
        // Now, loop through all the matrix to add all the valid square sizes.
        for (int i = 0; i < rows; i++) for (int j = 0; j < cols; j++) count += matrix[i][j];

        // All Done! Return total number of squares that exist in the matrix
        return count;
    }
}
