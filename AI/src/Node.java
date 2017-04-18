/**
 * Created by suraj on 4/15/17.
 * Basic node methods and variables
 */
public class Node {
    private int value;
    private boolean isEndNode;
    private Node[] children;

    public Node(int value)
    {
        this.value = value;
        this.isEndNode = false;
    }

    public Node(int value, boolean isEndNode)
    {
        this.value = value;
        this.isEndNode = isEndNode;
    }

    public Node(int value, boolean isEndNode, Node[] children)
    {
        this.value = value;
        this.isEndNode = isEndNode;
        this.children = children;
    }

    public boolean isEndNode()
    {
        return isEndNode;
    }

    public int evaluate()
    {
        return value;
    }

    public Node[] getChildren()
    {
        if(isEndNode())
            return null;
        else
            return children;
    }

}
