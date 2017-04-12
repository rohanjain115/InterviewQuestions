package binarytree;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.TreeMap;

/**
 * Created by rohanrampuria on 4/11/17.
 */

public class TopView {

    private NodeT root;

    public TopView(NodeT node){
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
        TopView tree = new TopView(root);
        System.out.println("Top view of the given binary tree:");
        tree.topView();
    }

    private void topView() {

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
            if(!map.containsKey(hd)){
                map.put(hd,temp.data);
            }
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
