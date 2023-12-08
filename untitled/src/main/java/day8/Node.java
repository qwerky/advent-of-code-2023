package day8;

public class Node {

    String id;
    Node left;
    Node right;

    public Node(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        String r;
        if (right == null)
            r = "null";
        else
            r = right.id;

        String l;
        if (left == null)
            l = "null";
        else
            l = left.id;

        return id + " = (" + l + ", " + r + ")";
    }
}
