package tree;

//
public class ParentTree {
    private Node first;



}
class Node{
    Object data;
    Node parent;

    public Node(Object data, Node parent) {
        this.data = data;
        this.parent = parent;
    }
}
