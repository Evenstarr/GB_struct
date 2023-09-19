package hw4;

public class Main {
    public static void main(String[] args) {
        RBTree tree = new RBTree();
        tree.add(6);
        tree.print(tree.root);
        tree.add(5);
        tree.print(tree.root);
        tree.add(7);
        tree.print(tree.root);
        tree.add(3);
        tree.print(tree.root);
    }
}
