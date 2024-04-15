class Solution {
    public String decodeString(String s) {
        

        Stack<String> stack = new Stack<>();
        int p = 0;
        int number = 0;

        while(p < s.length()){
            if(s.charAt(p) == ']'){
              StringBuilder sb = new StringBuilder();
              while(!stack.peek().equals("[")){
                sb.insert(0, stack.pop());
              }
              stack.pop();
              int counter = Integer.parseInt(stack.pop());
              StringBuilder temp = new StringBuilder();
              for(int i = 0 ; i < counter ; i++){
                temp.append(sb);
              }
              stack.push(temp.toString());
            }else{ 
               if(Character.isDigit(s.charAt(p))){
                  number = number * 10 + Character.getNumericValue(s.charAt(p));
               }else if(s.charAt(p) == '['){
                  stack.push(String.valueOf(number));
                  number = 0;
                  stack.push(String.valueOf(s.charAt(p)));

               }else{
                  stack.push(String.valueOf(s.charAt(p)));
               } 
            }
            p++;
        }

        StringBuilder ans = new StringBuilder();
        while(stack.size() > 0){
            ans.insert(0, stack.pop());
        }
        return ans.toString();

    }
}