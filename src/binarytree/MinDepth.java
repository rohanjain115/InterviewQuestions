package binarytree;

/**
 * Created by rohanrampuria on 4/11/17.
 * Find minimum depth of binary tree
 */
public class MinDepth {
    class TreeNode{
        int data;
        TreeNode left;
        TreeNode right;
        public TreeNode(int data){
            this.data = data;
            this.left= null;
            this.right = null;
        }
    }


    public int minDepth(TreeNode root){
        return getMin(root);
    }

    private int getMin(TreeNode node) {
        if(node == null){
            return 0;
        }
        if(node.left == null && node.right == null){
            return 1;
        }

        if(node.left == null){
            return getMin(node.right)+1;
        }
        if(node.right == null){
            return getMin(node.left)+1;
        }
        return (Math.min(getMin(node.right), getMin(node.left))+1);

    }
}
