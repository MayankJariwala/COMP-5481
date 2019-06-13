import java.util.*;

public class Problem3 {

    private Node rootNode = null;
    private String levelOrderTraversalStr = "";
    private Stack<Node> nodeStack = new Stack<>();
    private Stack<String> nodeString = new Stack<>();
    private Queue<Node> nodeQueue = new LinkedList<>();
    private StringBuilder stringBuilder = new StringBuilder();

    public static void main(String[] args) {
        Problem3 problem3 = new Problem3();
        Scanner scanner = new Scanner(System.in);
        String[] input = "(8 (10 (5)) (12))".replaceAll("\\s", "").split("");
        System.out.println(Arrays.toString(input));
        problem3.generateTree(input);
//        problem3.printLevelOrderTraversal();
    }

    private void generateTree(String[] data) {
        StringBuilder value = new StringBuilder();
        Node newNode = null;
        for (int i = 0; i < data.length; i++) {
            if (data[i].equals("(")) {
                i++;
                while (!data[i].equals(")")) {

                }
            }
        }

//        for (char datum : data) {
//            if (datum == '(') {
//                // ok prepare for new node
//                if (newNode != null) {
//                    newNode.setValue(value.toString());
//                    nodeStack.push(newNode);
//                    value = new StringBuilder();
//                }
//                newNode = new Node();
//            } else if (datum == ')') {
//                Node topStackNode = nodeStack.pop();
//                if (nodeStack.isEmpty()) {
////                    rootNode = topStackNode;
//                    if (newNode != null) {
//                        if (topStackNode.getLeftChild() == null)
//                            topStackNode.setLeftChild(newNode);
//                        else
//                            topStackNode.setRightChild(newNode);
//                    }
//                    nodeQueue.add(topStackNode);
//                    return;
//                }
//                if (newNode != null) {
//                    newNode.setValue(value.toString());
//                    if (topStackNode.getLeftChild() == null)
//                        topStackNode.setLeftChild(newNode);
//                    else
//                        topStackNode.setRightChild(newNode);
//                    nodeStack.push(topStackNode);
//                } else {
//                    Node peekNode = nodeStack.peek();
//                    if (peekNode.getLeftChild() == null)
//                        peekNode.setLeftChild(topStackNode);
//                    else
//                        peekNode.setRightChild(topStackNode);
//                }
//                newNode = null;
//                value = new StringBuilder();
//            } else {
//                if (datum != ' ')
//                    value.append(datum);
//            }
//        }
    }

    private void printLevelOrderTraversal() {
        while (!nodeQueue.isEmpty()) {
            Node node = nodeQueue.remove();
            if (node.getValue() != null)
                System.out.print(node.getValue() + " ");
            if (node.getLeftChild() != null) {
                printIfNotVisited(node.getLeftChild());
            }
            if (node.getRightChild() != null) {
                printIfNotVisited(node.getRightChild());
            }
        }
    }

    private void printIfNotVisited(Node node) {
        if (!node.isVisited()) {
            node.setVisited(true);
            nodeQueue.add(node);
        }
    }
}
