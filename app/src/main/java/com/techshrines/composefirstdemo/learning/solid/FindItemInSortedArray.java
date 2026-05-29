package com.techshrines.composefirstdemo.learning.solid;

//[12,34,45,56,78,90]
//78 AND 80
class FindItemInSortedArray {
    public static void main(String[] args) {
        System.out.println("*************");
        int a[] = {12,34,45,56,78,90};
        int size = a.length - 1;
        int item = 80;
        int max = size;
        int min = 0;
        boolean isFound = checkItem(a, item, min, max);
        System.out.println("Item is "+ isFound);
    }

    static boolean checkItem(int a[], int item, int min, int max){

        if(a[min] == item){
            return true;
        }else if(a[max] == item){
            return true;
        }else{
            int mid = (min+max)/2;
            if(mid == min || mid == max){
                return false;
            }
            if(a[mid] == item){
                return true;
            }else{
                if(a[mid] > item){
                    max = mid;
                }else{
                    min = mid;
                }
                System.out.println("Next : "+min +" max "+max);
                return checkItem(a, item, min, max);
            }
        }
    }
}
