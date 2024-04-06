class Solution {
    public int[] asteroidCollision(int[] asteroids) {
          
        Stack<Integer> stack = new Stack<>();

        for(int i = 0 ; i < asteroids.length ; i++){
            boolean add = true;

            while(stack.size() > 0 && asteroids[i] < 0 && stack.peek() > 0){

                if(Math.abs(asteroids[i]) == stack.peek()){
                    stack.pop();
                    add = false;
                    break;
                }

                if(Math.abs(asteroids[i]) < stack.peek()){
                   add = false;
                   break;
                }

                if(Math.abs(asteroids[i]) > stack.peek()){
                    stack.pop();
                }

               
            }

            if(add){
                stack.push(asteroids[i]);
            } 
        }

        int ans[] = new int[stack.size()];
        for(int i = ans.length - 1 ; i >= 0 ; i--){
            ans[i] = stack.pop();
        }

        return ans;
    }
}