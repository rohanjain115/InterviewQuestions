package binarytree;

/**
 * Created by rohanrampuria on 4/2/17.
 *
 */
public class LeftViewTree {

    Node root;
    int max_level =0;

    public static void main(String[] args) {
        LeftViewTree tree = new LeftViewTree();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.left.left = new Node(10);
        tree.root.left.right = new Node(5);
        tree.root.left.right.right = new Node(11);
        tree.root.right.left = new Node(6);
        tree.root.right.right = new Node(7);
        tree.leftView();

    }

    private void leftView() {
        leftViewUtil(root,1);
    }



    public void leftViewUtil(Node node, int level){

        if(node == null){
            return;
        }
        if(max_level < level){
            System.out.print(node.data+ " ");
            max_level = level;
        }
        leftViewUtil(node.left, level+1);
        //leftViewUtil(node.right, level+1);

    }

}
