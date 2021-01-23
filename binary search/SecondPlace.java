import java.util.*;

/**
 * public class Tree {
 *   int val;
 *   Tree left;
 *   Tree right;
 * }
 */
class Solution {
    public int solve(Tree root) {
        int maxDepth = getMaxDepth(root)-1;
        helper(root, 0, maxDepth);
        return secondMax;
    }

    int secondMax=0;
    private void helper(Tree node, int curDepth, int maxDepth){
        if(node==null)
            return;
        
        if(node.left==null && node.right==null){
            if(curDepth<maxDepth && curDepth>secondMax){
                secondMax = curDepth;
            }
        }

        helper(node.left, curDepth+1, maxDepth);
        helper(node.right, curDepth+1, maxDepth);
    }

    private static int getMaxDepth(Tree node){
        if(node==null)
            return 0;

        return 1+Math.max(getMaxDepth(node.left), getMaxDepth(node.right));
    }
}