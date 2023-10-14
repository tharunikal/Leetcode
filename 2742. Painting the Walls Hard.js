var paintWalls = function(cost, time) {
    const memo = new Map();

    function knapsack(pos, paintedCount, takenTime) {
        if (paintedCount + takenTime >= cost.length) {
            return 0;
        }

        const key = `${pos}_${paintedCount + takenTime}`;
        if (memo.has(key)) {
            return memo.get(key);
        }

        let res1 = -1, res2 = -1;

        if (pos < cost.length) {
            res1 = knapsack(pos + 1, paintedCount + 1, takenTime + time[pos]);
            if (res1 !== -1) {
                res1 += cost[pos];
            }
            res2 = knapsack(pos + 1, paintedCount, takenTime);
        }

        let output = -1;
        if (res1 !== -1 || res2 !== -1) {
            output = (res1 !== -1 && res2 !== -1) ? Math.min(res1, res2) : (res1 !== -1 ? res1 : res2);
        }

        memo.set(key, output);
        return output;
    }

    return knapsack(0, 0, 0);
};
