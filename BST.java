import java.util.LinkedList;
import java.util.Queue;

class BST{
    
    BinaryNode root;

    public BST(){
        root = null;
    }

    public void insertValue(int val){
        insert(root, val);
    }

    private void insert(BinaryNode root, int val){
        BinaryNode newNode = new BinaryNode(val);
        if(root==null){
            this.root= newNode;
            return;
        }
        if(val <= root.val){
            if(root.left==null){
                root.left = newNode;
                return;
            }else{
                insert(root.left, val);
            }
        }else{
            if(root.right == null){
                root.right = newNode;
                return;
            }else{
                insert(root.right, val);
            }
        }
    }

    public void levelOrderTravelser(){
        BinaryNode temp = root;
        Queue<BinaryNode> queue = new LinkedList<>();
        queue.add(temp);

        while(!queue.isEmpty()){
            BinaryNode node = queue.poll();
            System.out.print(node.val+" ");
            if(node.left!=null)
                queue.add(node.left);
            if(node.right!=null)
                queue.add(node.right);
        }

    }




    public BinaryNode deleteNode(BinaryNode node, int val){
        
        if(node==null){
            System.out.println("Val is not present is Tree");
            return null;
        }
        if(val<node.val){
            node.left = deleteNode(node.left,val);
        }else if(val>node.val){
            node.right = deleteNode(node.right, val);
        }else{
            if(node.left !=null && node.right !=null){
                BinaryNode minimumNode = getMinimumNode(node.right);
                node.val = minimumNode.val;
                node.right = deleteNode(node.right, minimumNode.val);
            }else if(node.left!=null){
                node = node.left;
            }else if(node.right!=null){
                node=node.right;
            }else{
                node=null;
            }
        }

        return node;

    }
    // get minimum node // sucessor -> minimum node from right subtree
    private BinaryNode getMinimumNode(BinaryNode node){
        if(node.left==null){
            return node;
        }else{
            return getMinimumNode(node.left);
        }
    }
    
}