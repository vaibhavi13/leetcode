class Solution {
    public boolean isValid(String s) {

        Stack<Character> stack = new Stack<>();

        for(int i = 0 ; i < s.length() ; i++){
            char curr = s.charAt(i);

            if(curr == '(' || curr == '[' || curr == '{'){
                stack.push(curr);
            }else{
                if(stack.size() == 0){
                    return false;
                }
                if( (curr == ')' && stack.peek() != '(') 
                    || (curr == ']' && stack.peek() != '[')
                    || (curr == '}' && stack.peek() != '{')
                    ){
                    return false;
                }
                stack.pop();
            }
        }

        return stack.size() == 0;
        
    }
}