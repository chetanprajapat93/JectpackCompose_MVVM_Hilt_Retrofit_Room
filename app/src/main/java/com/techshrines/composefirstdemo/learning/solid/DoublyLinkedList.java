package com.techshrines.composefirstdemo.learning.solid;

public class DoublyLinkedList {
    Node root = null;
    public static void main(String[] args) {
        System.out.println("Hello, World!");
        DoublyLinkedList list = new DoublyLinkedList();
        list.root = new Node(1);
        list.root.next = new Node(2);
        list.root.prev = list.root;
        list.root.next.next = new Node(3);
        list.root.next.prev = list.root.next;
        list.root.next.next.next = new Node(4);
        list.root.next.next.prev = list.root.next.next;
        //insertAfterItem(list.root, 4, 10);
        //deleteItem(list.root, 6);
        printLinkedList(list.root);
    }

    static void reverse(Node root){
        Node prev = null;
        Node current = root;
        Node next = null;
        while(root != null){
            if(root.next != null){

            }

        }
    }


    static void insertAfterItem(Node root, int item, int newItem){
        while(root != null){
            if(item == root.data){
                Node temp = root.next;
                root.next = new Node(newItem);
                if(temp != null){
                    root.next.next = temp;
                }
                if(temp != null){
                    root.next.prev = temp.prev;
                }
                break;
            }
            root = root.next;
        }
    }

    static void deleteItem(Node root, int item){
        Node node = root;
        while(node != null){
            if(item == node.data){
                Node temp = node.next;
                node = temp;
                node.prev = null;
                root = temp;
                root.prev = null;
                break;
            }
            else if(node.next != null && item == node.next.data){
                if(node.next.next != null){
                    Node temp = node.next.next;
                    node.next = temp;
                    node.prev = node.next.prev;
                }else{
                    node.next = null;
                }
                break;
            }else{
                node = node.next;
            }
        }
        printLinkedList(root);
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
    Node prev;
    int data;
    public Node(int data){
        this.data = data;
        this.next = null;
        this.prev = null;
    }
}