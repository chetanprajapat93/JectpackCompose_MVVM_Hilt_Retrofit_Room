package com.techshrines.composefirstdemo.learning.solid;

public class ArrayInsertDelete {

    public static void main(String[] args) {
        System.out.println("Hello, World!");

        int a[] = new int[10];
        int cap = 10; //Capacity of array
        a[0] = 1;
        a[1] = 2;
        a[2] = 3;
        a[3] = 4;
        a[4] = 5;
        int n = 5; // Size of array
        deleteItem(a, 5, n);//array, item, filled data size
        insertAtPos(a, 15, n, cap, 5);
        insertAtEnd(a, 11, n, cap);
        print(a);
    }

    static void deleteItem(int a[], int item, int n){
        for(int i=0; i<n; i++){
            if(a[i] == item){
                for(int j=i; j<n; j++){
                    a[j] = a[j+1];
                }
                break;
            }
        }
    }

    static void insertAtPos(int a[], int item, int n, int cap, int pos){
        if(pos >= n && pos<cap){
            a[pos] = item;
        } else if(pos < n && pos<cap){
            for(int i=n; i>pos; i--){//5
                a[i] = a[i-1];
            }
            a[pos] = item;
        }
    }

    static void insertAtEnd(int a[], int item, int n, int cap){
        if(n>cap){
            return;
        }else{
            a[n] = item;
        }
    }

    static void print(int a[]){
        for(int i=0; i<a.length; i++){
            System.out.println("Item "+ a[i]);

        }
    }

}