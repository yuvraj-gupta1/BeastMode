package AVL;
class BinaryNode{
    int val;
    int height;
    BinaryNode left;
    BinaryNode right;
    public BinaryNode(int val){
        this.val = val;
        this.height=0;
        left = right = null;
    }
}