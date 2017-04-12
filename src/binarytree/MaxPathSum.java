package binarytree;

/**
 * Created by rohanrampuria on 4/11/17.
 */

class Res{
    public int val;
}
public class MaxPathSum {
    Node root;

    public static void main(String args[]) {
        MaxPathSum tree = new MaxPathSum();
        tree.root = new Node(10);
        tree.root.left = new Node(2);
        tree.root.right = new Node(10);
        tree.root.left.left = new Node(20);
        tree.root.left.right = new Node(1);
        tree.root.right.right = new Node(-25);
        tree.root.right.right.left = new Node(3);
        tree.root.right.right.right = new Node(4);
        System.out.println("maximum path sum is : " +
                tree.findMaxSum());
    }

    public int findMaxSum() {
        return findMaxSum(root);
    }

    private int findMaxSum(Node node) {
        Res res = new Res();
        res.val = Integer.MIN_VALUE;
        findMaxSumUtil(node,res);
        return res.val;
    }

     int findMaxSumUtil(Node node, Res res) {
        //Base Case
        if(node == null){
            return 0;
        }
         // l and r store maximum path sum going through left and
         // right child of root respectively
        int l = findMaxSumUtil(node.left,res);
        int r = findMaxSumUtil(node.right,res);

        int max_single = Math.max(node.data, Math.max(l,r)+node.data);
        int max_top = Math.max(max_single, l+r+node.data);

        res.val = Math.max(res.val,max_top);

        return max_single;
    }

}
