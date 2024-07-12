class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        
        List<Integer> ans = new ArrayList<>();
        int ans_p = 0;
        
        
        int n1_p = 0;
        int n2_p = 0;
        
        while(n1_p < nums1.length && n2_p < nums2.length){
            if(nums1[n1_p] == nums2[n2_p]){
                ans.add(nums1[n1_p]);
                n1_p++;
                n2_p++;
            }else if(nums1[n1_p] < nums2[n2_p]){
                n1_p++;
            }else{
                n2_p++;
            }
        }
        
        return ans.stream().mapToInt(i -> i).toArray();
        
    }
}