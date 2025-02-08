class BSTMain{
    public static void main(String[] args) {
        BST bstObj = new BST();
        bstObj.insertValue(5);
        bstObj.insertValue(10);
        bstObj.insertValue(3);
        bstObj.insertValue(2);
        bstObj.insertValue(15);
        bstObj.insertValue(4);
        System.out.println(" \n----- \n");
        bstObj.levelOrderTravelser();

        bstObj.deleteNode(bstObj.root,10);
        System.out.println(" \n----- \n");
        bstObj.levelOrderTravelser();
    }
}