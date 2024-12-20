class Solution {
    // Helper function to perform level order traversal and reverse odd levels
    public TreeNode reverseOddLevels(TreeNode root) {
        // Edge case: if the tree is empty, return null
        if (root == null) return root;

        // Queue for level order traversal
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);  // Start with the root node

        // Boolean flag to track whether we are at an odd level
        boolean isOddLevel = false;

        // Perform level order traversal using the queue
        while (!q.isEmpty()) {
            // Get the size of the current level
            int levelSize = q.size();

            // List to hold all the nodes at the current level
            List<TreeNode> currentLevelNodes = new ArrayList<>();

            // Process all nodes at the current level
            for (int i = 0; i < levelSize; i++) {
                TreeNode node = q.poll();  // Dequeue the current node

                // Add left and right children to the queue for the next level
                if (node.left != null) q.offer(node.left);
                if (node.right != null) q.offer(node.right);

                // Add the current node to the list of nodes at this level
                currentLevelNodes.add(node);
            }

            // If we are at an odd level, reverse the nodes at this level
            if (isOddLevel) {
                int left = 0;
                int right = currentLevelNodes.size() - 1;

                // Swap nodes from left to right to reverse the level
                while (left < right) {
                    TreeNode temp = currentLevelNodes.get(left);
                    currentLevelNodes.set(left, currentLevelNodes.get(right));
                    currentLevelNodes.set(right, temp);
                    left++;
                    right--;
                }

                // Assign reversed values back to the nodes at this level
                for (int i = 0; i < currentLevelNodes.size(); i++) {
                    TreeNode node = currentLevelNodes.get(i);
                    node.val = currentLevelNodes.get(i).val;
                }
            }

            // Toggle the isOddLevel flag for the next level
            isOddLevel = !isOddLevel;
        }

        // Return the modified root after reversing odd levels
        return root;
    }
}
