class Solution {
    public boolean isValid(String s) {

        Stack<Character> stack = new Stack<>();

        for(int i = 0 ; i < s.length() ; i++){
            if(s.charAt(i) == '(' || s.charAt(i) == '[' || s.charAt(i) == '{'){
                stack.push(s.charAt(i));
            }else{
                if(stack.size() == 0){
                    return false;
                }
                if(s.charAt(i) == ')'){
                    if(stack.peek() != '('){
                        return false;
                    }
                }else if(s.charAt(i) == ']'){
                     if(stack.peek() != '['){
                        return false;
                    }

                }else{
                    if(stack.peek() != '{'){
                        return false;
                    }
                }
                stack.pop();              
            }

        }

        return stack.size() == 0;
        
    }
}