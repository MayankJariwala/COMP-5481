import java.util.Scanner;

/**
 * AVL TREE
 *
 * @author Mayank Jariwala
 */
public class Driver {

    private static String preOrderTraversal = "";
    private static Node root = null;
    private static Node newNode = null;
    private static Node currentNode = null;

    static class Node {
        int value;
        Node left;
        Node right;
        int level = 0;

        public Node() {
        }

        private Node(int value) {
            this.value = value;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int i;
        while ((i = scanner.nextInt()) != -1) {
            newNode = createNodeFromInt(i);
            generateBST(newNode);
        }
        if (isAVL(root))
            System.out.print(preOrderTraversal(root).trim());
        else
            System.out.print("NOT");
    }

    /**
     * Reference Code: https://www.geeksforgeeks.org/how-to-determine-if-a-binary-tree-is-balanced/
     *
     * @param node : Any Node of Tree
     * @return Boolean : Whether Tree is balanced or not
     */
    private static boolean isAVL(Node node) {
        int leftHeight, rightHeight;
        if (node == null)
            return true;
        leftHeight = getHeight(node.left);
        rightHeight = getHeight(node.right);
        return Math.abs(leftHeight - rightHeight) <= 1 && isAVL(node.left) && isAVL(node.right);
    }

    private static int getHeight(Node n) {
        if (n == null)
            return 0;
        return 1 + Math.max(getHeight(n.left), getHeight(n.right));
    }

    private static void generateBST(Node node) {
        if (root == null) {
            root = node;
            root.level = 0;
            currentNode = root;
            return;
        }
        if (currentNode.value < newNode.value) {
            if (currentNode.right == null) {
                currentNode.right = newNode;
                newNode.level = currentNode.level + 1;
                currentNode = root;
                return;
            }
            currentNode = currentNode.right;
            generateBST(currentNode);
        } else {
            if (currentNode.left == null) {
                currentNode.left = newNode;
                newNode.level = currentNode.level + 1;
                currentNode = root;
                return;
            }
            currentNode = currentNode.left;
            generateBST(currentNode);
        }
    }

    private static Node createNodeFromInt(int value) {
        Node n = new Node(value);
        n.left = null;
        n.right = null;
        return n;
    }

    private static String preOrderTraversal(Node n) {
        preOrderTraversal += String.valueOf(n.value) + " ";
        if (n.left != null) {
            preOrderTraversal(n.left);
        }
        if (n.right != null) {
            preOrderTraversal(n.right);
        }
        return preOrderTraversal;
    }
}