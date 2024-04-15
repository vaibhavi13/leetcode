class Solution {
    public int minimumLength(String s) {

        int start = 0 ;
        int end = s.length() - 1;


        while(start < end){
            if(s.charAt(start) == s.charAt(end)){

                char c = s.charAt(start);

                while(start <= end && s.charAt(start) == c){
                        start++;
                }

                while(end > start && s.charAt(end) == c){
                        end--;
                }

            }else{
                break;
            }
        }




        return end - start + 1;
        
    }
}