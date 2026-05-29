package com.techshrines.composefirstdemo.learning.solid;

public class ArrayMerging {
        public static void main(String[] args) {
            System.out.println("Hello, World!");
            int mul[][] = {{1,2,3},{4,5,6},{7,8,9}};
            System.out.println("Hello, "+mul.length*mul[0].length);
            int[] arr = new int[mul.length*mul[0].length];

            int i=0;
            for(int j=0; j<mul.length; j++){
                for(int k=0; k<mul[j].length; k++){
                    arr[i] = mul[j][k];
                    System.out.println("\n");
                    System.out.println("Array "+ arr[i]);
                    i++;
                }
            }
        }

}
