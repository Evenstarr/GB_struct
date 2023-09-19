package hw4;

public class RBNode<V extends Comparable<V>> {
    V data;
    RBNode parent;
    RBNode left;
    RBNode right;
    boolean isRed;


    public RBNode() {
        data = null;
        parent = null;
        left = null;
        right = null;
        isRed = false;
    }

    /*
     * Create the first node, supplying data to be storedData is set equal
     * to the data passed to the methodNext remains null as this is a
     * starting node
     */
    RBNode(V d) {
        data = d;
        left = null;
        right = null;
        parent = null;
        isRed = true;
    }

}