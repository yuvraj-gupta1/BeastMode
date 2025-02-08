package AVL;

import java.util.LinkedList;
import java.util.Queue;

class AVL{
    
    BinaryNode root;
    public AVL(){
        this.root = null;
    }

    public void insert(int val){
        root = insert(root, val);
    }

    private BinaryNode insert(BinaryNode root, int val){
        if(root==null){
            BinaryNode newNode = new BinaryNode(val);
            newNode.height =1;
            return newNode;
        }
        if(val<root.val){
            root.left = insert(root.left, val);
        }else {
            root.right = insert(root.right, val);
        }

        root.height = 1+Math.max(getHeight(root.left), getHeight(root.right));
        int balance = getBalance(root);

        if(balance>1 && val<root.left.val){
            return rotateRight(root);

        } 
        if(balance>1 && val> root.left.val){
            root.left = rotateLeft(root.left);
            return rotateRight(root);
        }
        if(balance<-1 && val>root.right.val){
            return rotateLeft(root);
        }
        if(balance<-1 && val<root.right.val){
            root.right = rotateRight(root.right);
            return rotateLeft(root);
        }


        return root;

    }

    private BinaryNode rotateRight(BinaryNode node){
        BinaryNode newNode = node.left;
        node.left = node.left.right;
        newNode.right = node;
        node.height = 1+Math.max(getHeight(node.left), getHeight(node.right));
        newNode.height = 1+Math.max(getHeight(newNode.left), getHeight(newNode.right));
        return newNode;
    }

    private BinaryNode rotateLeft(BinaryNode node){
        BinaryNode newNode = node.right;
        node.right = node.right.left;
        newNode.left = node;
        node.height = 1+Math.max(getHeight(node.left), getHeight(node.right));
        newNode.height = 1+Math.max(getHeight(newNode.left), getHeight(newNode.right));
        return newNode;
    }

    private int getHeight(BinaryNode node){
        if(node==null){
            return 0;
        }
        return node.height;
    }

    private int getBalance(BinaryNode node){
        if(node==null)
            return 0;
        return getHeight(node.left)-getHeight(node.right);
    }


    public void levelOrder(){
        Queue<BinaryNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            BinaryNode temp = queue.poll();
            System.out.print(temp.val+" ");
            if(temp.left!=null)
                queue.add(temp.left);
            if(temp.right!=null)
                queue.add(temp.right);
        }
    }
    

}