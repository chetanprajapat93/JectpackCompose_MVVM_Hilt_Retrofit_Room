package com.techshrines.composefirstdemo.learning.solid;

public class SinglyLinkedListIntersection {
    Node root = null;
    public static void main(String[] args) {
        System.out.println("Hello, World!");
        SinglyLinkedListIntersection list = new SinglyLinkedListIntersection();
        list.root = new Node(1);
        list.root.next = new Node(2);
        list.root.next.next = new Node(3);
        list.root.next.next.next = new Node(4);
        list.root.next.next.next.next = new Node(5);

        SinglyLinkedListIntersection list2 = new SinglyLinkedListIntersection();
        list2.root = new Node(10);
        list2.root.next = new Node(4);
        list2.root.next.next = new Node(11);

        int c1 = getCount(list.root);
        int c2 = getCount(list2.root);
        int point;
        if(c1>c2){
            int d = c1-c2;
            point = getIntersectionPoint(d, list.root, list2.root);
        }else{
            int d = c2-c1;
            point = getIntersectionPoint(d, list2.root, list.root);
        }
        System.out.println("Intersection point : "+point);
        //printLinkedList(list.root);
    }

    static int getIntersectionPoint(int d, Node list1, Node list2){
        Node current1 = list1;
        Node current2 = list2;
        for(int i=0; i<d; i++){
            if(current1 == null){
                return -1;
            }
            current1 = current1.next;
        }
        while(current1 != null && current2 != null){
            if(current1.data == current2.data){
                return current1.data;
            }
            current1 = current1.next;
            current2 = current2.next;
        }
        return -1;
    }

    static void printLinkedList(Node root){
        while(root != null){
            System.out.println("Node "+ root.data);
            root = root.next;
        }
    }

    static int getCount(Node root){
        int count = 0;
        while(root != null){
            count++;
            System.out.println("Node "+ root.data);
            root = root.next;
        }
        return count;
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
