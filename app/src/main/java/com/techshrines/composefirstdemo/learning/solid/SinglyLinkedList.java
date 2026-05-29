package com.techshrines.composefirstdemo.learning.solid;

public class SinglyLinkedList {
    Node root = null;
    public static void main(String[] args) {
        System.out.println("Hello, World!");
        SinglyLinkedList list = new SinglyLinkedList();
        list.root = new Node(1);
        list.root.next = new Node(2);
        list.root.next.next = new Node(3);
        list.root.next.next.next = new Node(4);
        list.root.next.next.next.next = new Node(5);
        //insertAfterItem(list.root, 5, 10);
        //deleteItem(list.root, 10);
        System.out.println("****Forward List****");
        printLinkedList(list.root);
        System.out.println("****Reversed List****");
        list.root = reverse(list.root);
        printLinkedList(list.root);
    }

    static Node reverse(Node root){
        Node current = root;
        Node prev = null;
        Node next = null;

        while(current != null){
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        return prev;
    }

    static void deleteItem(Node root, int item){
        Node node = root;
        while(node != null){
            if(item == node.data){
                Node temp = node.next;
                node = temp;
                root = temp;
                break;
            }
            else if(node.next != null && item == node.next.data){
                Node temp = node.next.next;
                node.next = temp;
                break;
            }else{
                node = node.next;
            }
        }
        printLinkedList(root);
    }

    static void insertAfterItem(Node root, int item, int newItem){
        while(root != null){
            if(item == root.data){
                Node temp = root.next;
                root.next = new Node(newItem);
                root.next.next = temp;
                break;
            }
            root = root.next;
        }
    }

    static void printLinkedList(Node root){
        while(root != null){
            System.out.println("Node "+ root.data);
            root = root.next;
        }
    }



}

class Node{
    Node next;
    int data;
    public Node(int data){
        this.data = data;
        this.next = null;
    }
}

