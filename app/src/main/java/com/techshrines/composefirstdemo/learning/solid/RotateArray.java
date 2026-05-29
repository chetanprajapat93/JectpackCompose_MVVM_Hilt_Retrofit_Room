package com.techshrines.composefirstdemo.learning.solid;

public class RotateArray {
    public static void main(String[] args) {
        System.out.println("Hello, World!");
        int a[] = {1,2,3,4,5,6,7};
        int n = a.length - 1;
        java.util.Scanner s = new java.util.Scanner(System.in);
        int r = s.nextInt();
        for(int i = 0; i<r; i++){
            int temp = a[0];
            for(int j=0; j<n; j++){
                a[j] = a[j+1];
            }
            a[n] = temp;
            /*int temp = a[n];
            for(int j=n; j>0; j--){
                a[j] = a[j-1];
            }
            a[0] = temp;*/
        }

        for(int i=0; i<=n; i++){
            System.out.println("Array "+a[i]);
        }
    }
}