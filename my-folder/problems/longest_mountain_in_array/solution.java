class Solution {
    public int longestMountain(int[] arr) {

        if(arr.length < 3){
            return 0;
        }

        boolean uphill = false;
        boolean downhill = false;

        int i = 1;

        int max = 0;

        while(i < arr.length){
            int start = i - 1;

            while(i < arr.length && arr[i] > arr[i-1]){
                i++;
                uphill = true;
            }

            while(i < arr.length && arr[i] < arr[i-1]){
                i++;
                downhill = true;
            }

            if(uphill && downhill){
                if(i - start >= 3){
                    max = Math.max(max, i - start);
                }
            }else{
                while(i < arr.length && arr[i] == arr[i-1]){
                    i++;
                }
            }

            uphill = false;
            downhill = false;
        }

        return max;
        
    }
}