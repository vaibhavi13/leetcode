class Solution {
    public String reverseParentheses(String s) {
        
        Stack<Character> stack = new Stack<>();

        for(int i = 0 ; i < s.length() ; i++){
            if(s.charAt(i) != ')'){
                stack.push(s.charAt(i));
            }else{
                StringBuilder sb = new StringBuilder();

                while(stack.peek() != '('){
                    sb.append(stack.pop());
                }
                stack.pop();

                for(int j = 0 ; j < sb.length() ; j++){
                    stack.push(sb.charAt(j));
                }
            }
        }

        StringBuilder ans = new StringBuilder();

        while(stack.size() > 0){
            ans.insert(0,stack.pop());
        }

        return ans.toString();

    }
}