class Solution {
    public String smallestNumber(String pattern) {

        Stack<Integer> stack = new Stack<>();

        StringBuilder sb = new StringBuilder();
        int count = 1;
        stack.push(count);

        for(int i = 0 ; i < pattern.length() ; i++){

            if(pattern.charAt(i) == 'I'){
              
              while(stack.size() > 0){
                sb.append(stack.pop());
              }
            }
            count++;
            stack.push(count);
        }

        while(stack.size() > 0){
            sb.append(stack.pop());
        }

        return sb.toString();
        
    }
}