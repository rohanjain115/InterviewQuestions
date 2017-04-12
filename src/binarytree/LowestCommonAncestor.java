package binarytree;

/**
 * Created by rohanrampuria on 4/2/17.
 */

class Node{
     int data;
     Node left, right;
    public Node(int item){
        this.data= item;
        left = right = null;
    }
}
public class LowestCommonAncestor {

    Node root;



    public static void main(String[] args){
        LowestCommonAncestor tree = new LowestCommonAncestor();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.left.left = new Node(10);
        tree.root.left.right = new Node(5);
        tree.root.left.right.right = new Node(11);
        tree.root.right.left = new Node(6);
        tree.root.right.right = new Node(7);
        System.out.print(tree.findLCA(10,11).data);

    }

    Node findLCA(int n1, int n2)
    {
        return findLCA(root, n1, n2);
    }

    public static Node findLCA(Node node, int n1, int n2){
        if(node == null){
            return null;
        }
        if(node.data == n1 || node.data == n2){
            return node;
        }
        Node left_lca = findLCA(node.left, n1, n2);
        Node right_lca = findLCA(node.right, n1, n2);
        if(left_lca != null && right_lca != null){
            return node;
        }
        return (left_lca!= null)?left_lca:right_lca;
    }


}
