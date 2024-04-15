class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {

        int ans[] = new int[m + n];

        int pm = 0;
        int pn = 0;
        int pa = 0;

        while(pm < m && pn < n){
            if(nums1[pm] < nums2[pn]){
                ans[pa++] = nums1[pm++];
            }else{
                ans[pa++] = nums2[pn++];
            }
        }

        while(pm < m){
            ans[pa++] = nums1[pm++];
        }

        while(pn < n){
            ans[pa++] = nums2[pn++];
        }

        for(int i = 0 ; i < m + n ; i++){
            nums1[i] = ans[i];
        }
        
    }
}