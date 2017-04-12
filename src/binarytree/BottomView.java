package binarytree;

/**
 * Created by rohanrampuria on 4/11/17.
 */
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.TreeMap;
class NodeT
{
    int data; //data of the node
    int hd; //horizontal distance of the node
    NodeT left, right; //left and right references

    // Constructor of tree node
    public NodeT(int key)
    {
        data = key;
        hd = Integer.MAX_VALUE;
        left = right = null;
    }
}
public class BottomView {

    private NodeT root;

    public BottomView(NodeT node){
        this.root = node;
    }


    public static void main(String[] args)
    {
        NodeT root = new NodeT(20);
        root.left = new NodeT(8);
        root.right = new NodeT(22);
        root.left.left = new NodeT(5);
        root.left.right = new NodeT(3);
        root.right.left = new NodeT(4);
        root.right.right = new NodeT(25);
        root.left.right.left = new NodeT(10);
        root.left.right.right = new NodeT(14);
        BottomView tree = new BottomView(root);
        System.out.println("Bottom view of the given binary tree:");
        tree.bottomView();
    }

    private void bottomView() {

        if(root == null){
            return;
        }
        //initialize horizontal distance
        int hd = 0;

        TreeMap<Integer,Integer> map = new TreeMap<>();

        //Queue to store tree nodes in level order traversal
        Queue<NodeT> queue = new LinkedList<NodeT>();

        root.hd = hd;
        queue.add(root);
        while (!queue.isEmpty()){
            NodeT temp = queue.remove();
            hd = temp.hd;

            map.put(hd,temp.data);
            if(temp.left != null){
                temp.left.hd = hd -1;
                queue.add(temp.left);
            }
            if (temp.right != null)
            {
                temp.right.hd = hd+1;
                queue.add(temp.right);
            }
        }

        Iterator i = map.keySet().iterator();
        while (i.hasNext()){
            int key = (int)i.next();
            System.out.print(map.get(key)+" ");
        }
    }
}
