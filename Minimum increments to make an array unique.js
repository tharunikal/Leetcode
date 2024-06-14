/**
 * @param {number[]} nums
 * @return {number}
 */
var minIncrementForUnique = function (nums) {
    // Sort the array first
    nums.sort((a, b) => a - b);

    let numTracker = 0;   // Tracks the next unique number that should be set.
    let minIncrement = 0; // Counts the total increments required.

    for (let num of nums) {
        numTracker = Math.max(numTracker, num);
        minIncrement += numTracker - num;
        numTracker++; // Increment the tracker for the next number.
    }

    return minIncrement;
};
