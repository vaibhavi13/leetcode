class Solution {

   private int gcd(int n1, int n2){
       if(n2 == 0){
        return n1;
       }
       return gcd(n2, n1 % n2);
   }

   private long lcm(int n1, int n2){
      return (1L * n1 * n2)/ gcd(n1, n2);
   }


    public int minimizeSet(int divisor1, int divisor2, int uniqueCnt1, int uniqueCnt2) {

        long start = 1;
        long end = (int) (2 * 1e9);
        long ans = end;


        while(start <= end){
            long mid = (start+end)/2;

            long a = mid - (mid/divisor1);

            long b = mid - (mid/divisor2);

            long c = mid - (mid/divisor1) - (mid/divisor2) + (mid/lcm(divisor1, divisor2));

            if(a >= 1L * uniqueCnt1 && b >= 1L * uniqueCnt2 && a + b - c >= (uniqueCnt1 + uniqueCnt2)){
                ans = Math.min(ans, mid);
                end = mid - 1;
            }else{
                start = mid + 1;
            }
        }
        return (int) ans;
        
    }
}