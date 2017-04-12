package binarytree;

/**
 * Created by rohanrampuria on 4/11/17.
 */

import java.util.Stack;

public class BSTPreorderTraversal {

    public static void main(String[] args) {
        new BSTPreorderTraversal();
    }

    public BSTPreorderTraversal() {
        int[] preOrderTraversal = {5,2,1,3,4,7,6,9,2};

        boolean flag = checkPreorderCanRepresentBST(preOrderTraversal);

        if(flag){
            System.out.println("Valid Preorder traversal");
        }else{
            System.out.println("Invalid Preorder traversal");
        }
    }

    private static boolean checkPreorderCanRepresentBST(int[] preOrderTraversal){

        //Stack for holding elements in Preorder fashion.
        Stack<Integer> stack = new Stack<Integer>();

        //Instead of Stack, we are taking variable which will hold last value at top of Inorder stack.
        //initializing it to Integer.MIN_VALUE, So that next value should be greater than this atleast.
        int lastInOrderNumber = Integer.MIN_VALUE;

        for (int i=0; i<preOrderTraversal.length; i++) {
            int data = preOrderTraversal[i];

            //If any value we encounter which is less than already stored last value in Inorder stack(lastInOrderNumber), return false.
            //If the value coming in is less it means preorder is not valid otherwise it will always be in increasing order.
            if(data < lastInOrderNumber){
                return false;
            }

            //If the Preorder stack peek contains element which is smaller than current working data,
            //then pop till you find element greater than current working data.
            //also mark last poped data as lastInOrderNumber.
            while(!stack.isEmpty() && stack.peek() < data ){
                lastInOrderNumber = stack.peek();
                stack.pop();
            }
            stack.add(data);
        }
        return true;
    }

}