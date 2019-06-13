public class Node {

    private String value;
    private Node leftChild;
    private Node rightChild;


    private boolean isVisited = false;

    Node() {
    }

    Node(String value) {
        this.value = value;
        this.leftChild = null;
        this.rightChild = null;
    }

    String getValue() {
        return value;
    }

    void setValue(String value) {
        this.value = value;
    }

    Node getLeftChild() {
        return leftChild;
    }

    void setLeftChild(Node leftChild) {
        this.leftChild = leftChild;
    }

    Node getRightChild() {
        return rightChild;
    }

    void setRightChild(Node rightChild) {
        this.rightChild = rightChild;
    }

    public boolean isVisited() {
        return isVisited;
    }

    public void setVisited(boolean visited) {
        isVisited = visited;
    }

    @Override
    public String toString() {
        return "Node{" +
                "value='" + value + '\'' +
                ", leftChild=" + leftChild +
                ", rightChild=" + rightChild +
                '}';
    }
}
