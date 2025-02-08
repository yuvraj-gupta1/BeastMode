package AVL;

class AVLMain{

    public static void main(String[] args) {
        AVL avlTree = new AVL();
        avlTree.insert(5);
        avlTree.insert(10);
        avlTree.insert(15);
        avlTree.insert(20);
        avlTree.insert(25);
        avlTree.insert(30);
        avlTree.insert(40);
        avlTree.insert(50);
        avlTree.insert(45);
        System.out.println("\n --OUTPUT---\n");
        avlTree.levelOrder();
    }
}