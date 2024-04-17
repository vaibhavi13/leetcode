class Solution {
    public int nextGreaterElement(int n) {
           
           // from backwards, try to find a pos i such that a[i] < a[i+1];

           // from backwards, try to find a pos j such that a[j] > a[i]

           // swap (a, i , j);

           // reverse(a, i + 1);


        char a[] = String.valueOf(n).toCharArray();

        int i = a.length - 2;

        while(i >= 0 && a[i + 1] <= a[i]){
            i--;
        }

        if(i < 0){
            return -1; // not possible as already in desc order
        }   

        int j = a.length - 1;

        while(j >= 0 && a[j] <= a[i]){
            j--;
        }

        swap(a, i , j);

        reverse(a, i + 1);

        String ans = new String(a);

        try{
return Integer.parseInt(ans);
        }catch(Exception e){
            return -1;
        }
        
        
    }

    private void swap(char a[] , int i , int j){
        char t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    private void reverse(char a[], int pos){
        int start = pos;
        int end = a.length - 1;

        while(start <= end){
            swap(a,start,end);
            start++;
            end--;
        }
    }
}