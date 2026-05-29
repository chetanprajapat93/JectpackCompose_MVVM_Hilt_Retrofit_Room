package com.techshrines.composefirstdemo.learning.solid;

public class TreeTraversal {
    Node root = null;
    public static void main(String[] args) {
        System.out.println("Hello, World!");
        TreeTraversal tree = new TreeTraversal();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        tree.root.right.left = new Node(6);
        tree.root.right.right = new Node(7);
        System.out.println("zigzagTraversal");
        zigzagTraversal(tree.root);
        System.out.println("printPreOrderTraversal");
        printPreOrderTraversal(tree.root);
        System.out.println("printInOrderTraversal");
        printInOrderTraversal(tree.root);
        System.out.println("printPostOrderTraversal");
        printPostOrderTraversal(tree.root);
    }

    static void zigzagTraversal(Node root){
        boolean leftToRight = true;
        java.util.Stack<Node> current = new java.util.Stack<Node>();
        java.util.Stack<Node> next = new java.util.Stack<Node>();
        current.push(root);
        while(current != null && !current.isEmpty()){
            Node node = current.pop();
            System.out.println("Item : "+node.data);
            if(leftToRight){
                if(node.left != null){
                    next.push(node.left);
                }
                if(node.right != null){
                    next.push(node.right);
                }
            }else{
                if(node.right != null){
                    next.push(node.right);
                }
                if(node.left != null){
                    next.push(node.left);
                }
            }
            if(current.isEmpty()){
                leftToRight = !leftToRight;
                java.util.Stack temp = next;
                current = temp;
                next = new java.util.Stack<Node>();
            }
        }
    }

    static void printPreOrderTraversal(Node node){
        while(node!= null){
            System.out.println("Item : "+node.data);
            if(node.left != null){
                printPreOrderTraversal(node.left);
            }
            if(node.right != null){
                printPreOrderTraversal(node.right);
            }
            return;
        }
    }

    static void printInOrderTraversal(Node node){
        while(node!= null){
            if(node.left != null){
                printInOrderTraversal(node.left);
            }
            System.out.println("Item : "+node.data);
            if(node.right != null){
                printInOrderTraversal(node.right);
            }
            return;
        }
    }

    static void printPostOrderTraversal(Node node){
        while(node!= null){
            if(node.left != null){
                printPostOrderTraversal(node.left);
            }
            if(node.right != null){
                printPostOrderTraversal(node.right);
            }
            System.out.println("Item : "+node.data);
            return;
        }
    }
}
class Node{
    int data;
    Node left;
    Node right;
    public Node(int data){
        this.data = data;
        this.left=null; this.right=null;
    }
}

