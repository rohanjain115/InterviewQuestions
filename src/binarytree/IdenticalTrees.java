package binarytree;

/**
 * Created by rohanrampuria on 4/11/17.
 */
public class IdenticalTrees {

    public static void main(String [] args){
        Node root = new Node(4);
        root.left = new Node(3);
        root.right = new Node(2);
        root.left.left = new Node(5);
        root.left.right = new Node(6);

        Node s= new Node(3);
        s.left = new Node(5);
        s.right = new Node(6);
        System.out.print(isSubTree(root,s));

    }
    private static boolean isSubTree(Node m, Node s){
        if(s == null){
            return true;
        }
        if(m == null){
            return false;
        }
        if(check(m,s)){
            return true;
        }
        return (isSubTree(m.left,s) || isSubTree(m.right,s));

    }

    private static boolean check(Node root1, Node root2){
        if(root1 == null && root2 == null){
            return true;
        }
        if(root1 != null && root2 != null){
            if(root1.data == root2.data && check(root1.left, root2.left) && check(root1.right, root2.right)){
                return true;
            }
        }
        return false;
    }
}
