class Solution {
    public int search(int[] nums, int target) {

        int pivot = 0;

        int start = 0 ;
        int end = nums.length - 1;

        while(start < end){
            int mid = start + (end-start)/2;

            if(nums[mid] > nums[end]){
                start = mid + 1;
            }else{
                end = mid;
            }
        }

        int ans = binarySearch(start,nums.length - 1 , target, nums);

        if(ans != -1){
            return ans;
        }

        ans = binarySearch(0, start - 1, target, nums);

        return ans;
    }

    private int binarySearch(int start, int end, int target, int nums[]){

        while(start <= end){
            int mid = start + (end-start)/2;
            if(nums[mid] == target){
                return mid;
            }else if(nums[mid] < target){
                start = mid + 1;
            }else{
                end = mid - 1;
            }
        }

        return -1;
    }
}