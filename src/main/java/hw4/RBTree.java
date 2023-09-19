package hw4;

public class RBTree<V extends Comparable<V>> {

    RBNode<V> root;

    public RBTree() {
        root = null;
    }

    public void add(V element) {
        RBNode<V> addThis = new RBNode<V>(element);
        if (root == null) {
            root = addThis;
            root.isRed = false;
            root.left = new RBNode<V>();
            root.left.parent = root;
            root.right = new RBNode<V>();
            root.right.parent = root;
            return;
        }

        RBNode<V> position = findAdd(element);
        position.data = element;
        position.left = new RBNode<V>();
        position.left.parent = position;
        position.right = new RBNode<V>();
        position.right.parent = position;
        position.isRed = true;

        if (position.parent.isRed) {
            rotate(position.parent);
        }
    }

    private RBNode<V> findAdd(V element) {
        RBNode<V> index = root;
        // Не лист
        while (index.data != null) {
            if (index.data.compareTo(element) > 0) {
                index = index.left;
                System.out.println("Идем налево");
            } else {
                index = index.right;
                System.out.println("Идем направо");
            }
            // Если оба потомка существуют
            if (index.left != null && index.right != null) {
                // Если оба красные
                if (index.left.isRed && index.right.isRed) {
                    // Делаем родителя красным, а потомков черными
                    index.isRed = true;
                    index.left.isRed = false;
                    index.right.isRed = false;

                    if (index != root && index.parent.isRed) {
                        rotate(index);
                    } else {
                        if (index == root) {
                            index.isRed = false;
                        }
                    }
                }
            }

        }
        return index;
    }

    private void rightRotate(RBNode<V> node) {
        RBNode<V> temp = node.parent;

        if(node.parent == root){
            root = node;
        }
        else if (node.parent.parent.left == node.parent) {
            node.parent.parent.left = node;
        }
        else {
            node.parent.parent.right = node;
        }
        temp.left = node.right;
        node.right = temp;
        node.right.isRed = false;
        node.left.isRed = false;
        node.isRed = false;
    }

    private void leftRotate(RBNode<V> node) {
        RBNode<V> temp = node.parent;
        //
    }

    private void rotate(RBNode<V> node) {
        switch (position(node)) {
            case 1:
                rightRotate(node);
                break;
            case 2:
                leftRotate(node);
                break;
            case 3:
                leftRightRotate(node);
                break;
            case 4:
                rightLeftRotate(node);
                break;
            default:
                break;

        }
    }

    private void leftRightRotate(RBNode<V> node) {
        leftRotate(node);
        rightRotate(node);
        node.isRed = false;
        node.left.isRed = true;
        node.right.isRed = true;
    }

    private void rightLeftRotate(RBNode<V> node) {
        rightRotate(node);
        leftRotate(node);
        node.isRed = false;
        node.left.isRed = true;
        node.right.isRed = true;
    }

    private int position(RBNode<V> node) {
        if (node == root) {
            return -1;
        }
        if (node == root.left) {
            return 1;
        }

        if (node == root.right) {
            return 2;
        }
        if (node.parent.parent.left.left == node) {
            return 1;
        }
        if (node.parent.parent.right.right == node) {
            return 2;
        }
        if (node == node.parent.parent.left.right) {
            return 3;
        }

        return 4;
    }

    public void print(RBNode<V> node) {
        if (node != null) {
            print(node.left);
            System.out.println(node.data);
            print(node.right);
        }
    }
}