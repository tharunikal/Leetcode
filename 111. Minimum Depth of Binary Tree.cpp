class Solution {
public:
    int minDepth(TreeNode* root) {
        return depth(root);
    }

    int depth(TreeNode* node) {
        ios_base::sync_with_stdio(false);
        if (node == nullptr) { return 0; }

        int left = depth(node->left);
        int right = depth(node->right);
        if (node->left == nullptr || node->right == nullptr) {
            return node->left == nullptr ? right + 1 : left + 1;
        }
        node->left = nullptr;
        node->right = nullptr;

        return std::min(left, right) + 1;
    }
};
