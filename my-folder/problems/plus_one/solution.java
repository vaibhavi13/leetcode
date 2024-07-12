class Solution {
    public int[] plusOne(int[] digits) {
        
        List<Integer> list = new ArrayList<>();
        int sum = digits[digits.length - 1] + 1;
        list.add(sum % 10);
        int carry = sum / 10;
        
        for(int i = digits.length - 2 ; i >= 0 ; i--){
            sum = digits[i] + carry;
            list.add(sum % 10);
            carry = sum / 10;
        }
        
        if(carry > 0){
            list.add(carry);
        }
        
        Collections.reverse(list);
        
        return list.stream().mapToInt( i -> i).toArray();
        
    }
}