import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class Lab3 {
    private class Node {
        Node left;
        Node right;
        char data;

        Node(char data) {
            left = null;
            right = null;
            this.data = data;
        }
    }

    static List<Node> lst = new ArrayList<>();
    static Lab3 l2 = new Lab3();
    static Node last = l2.new Node('\0');
    static Integer parent = null;

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner scn = new Scanner(System.in);
        String in = "(F(B(A)(D(C)(E)))(G()(I(H))))";
        Node root = null;
        root = createTree(in, root);

        System.out.println(root.data);
        levelOrder(root);
    }

    public static void levelOrder(Node root) {
        List<Node> nodeList = new ArrayList<>();
        if (root == null)
            return;
        nodeList.add(root);
        for (int i = 0; i < nodeList.size(); i++) {
            if (nodeList.get(i).left != null)
                nodeList.add(nodeList.get(i).left);
            if (nodeList.get(i).right != null)
                nodeList.add(nodeList.get(i).right);
        }
        for (int i = 0; i < nodeList.size(); i++) {
            System.out.print(nodeList.get(i).data + " ");
        }
    }

    private static void traverPreorder(Node root) {
        if (root == null)
            return;
        System.out.println(root.data);
        traverPreorder(root.left);
        traverPreorder(root.right);
    }

    public static Node createTree(String in, Node root) {

        Stack<Integer> stc = new Stack<>();
        boolean flag;
        for (int i = 0; i < in.length(); i++) {
            flag = false;
            if (!(in.charAt(i) == ')')) {
                stc.push((int) in.charAt(i));
                if (in.charAt(i) >= 'A' && in.charAt(i) <= 'Z') {
                    root = addNode(root, in.charAt(i));
                    System.out.println(parent);
                }
            } else {
                while (true) {
                    if (stc.lastElement() == '(') {
                        flag = true;
                    }
                    stc.pop();
                    if (flag) {
                        if (stc.size() > 0) {
                            if (stc.lastElement() >= 'A' && stc.lastElement() <= 'Z')
                                parent = stc.lastElement();
                        }
                        break;
                    }
                }
            }

        }

        return root;

    }

    private static Node addNode(Node root, char data) {
        // TODO Auto-generated method stub
        if (root == null) {
            Lab3 l = new Lab3();
            parent = (int) data;
            System.out.println(parent);
            return l.new Node(data);
        }
        System.out.println((int) root.data + " : " + parent);
        if (root.data == parent) {
            if (root.left == null)
                root.left = addNode(root.left, data);
            else
                root.right = addNode(root.right, data);

        } else {
            if (!(root.left == null))
                addNode(root.left, data);
            if (!(root.right == null))
                addNode(root.right, data);
        }
        return root;
    }

}
