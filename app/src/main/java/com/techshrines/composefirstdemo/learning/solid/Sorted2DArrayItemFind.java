package com.techshrines.composefirstdemo.learning.solid;

public class Sorted2DArrayItemFind {


    public static void main(String args[]){
        System.out.println("*******************************");
        int arr[][] = {{1,2,3},{4,5,6},{7,8,9}};
        int length1 = arr.length-1;
        int length2 = arr[0].length-1;
        int row = 0, col = length2;
        int element = 10;
        while(row >= 0 && col >= 0){

            if(arr[row][col] == element){
                System.out.println("Item found "+ row + "Column "+ col );
                break;
            }else if(arr[row][col] > element){
                --col;
            } else{
                ++row;
            }

            if(row > length1 || col<0){
                System.out.println("Item not found");
                break;
            }

        }

    }


}