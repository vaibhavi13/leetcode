class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
        
        int sign = 1;
        if((numerator < 0 && denominator > 0) || (numerator > 0 && denominator < 0)){
            sign = -1;
        }

        StringBuilder sb = new StringBuilder();

        if(sign == -1){
            sb.append("-");
        }

        long num = (long) Math.abs((long) numerator);
        long den = (long) Math.abs((long) denominator);

        long quo = num/den;
        long rem = num % den;
        
        sb.append(quo);

        if(rem == 0){
          return sb.toString();
        }

        sb.append(".");

        HashMap<Long,Integer> map = new HashMap<>();

        while(rem != 0){ // rem == 1
            if(map.containsKey(rem)){
                int pos = map.get(rem);
                sb.insert(pos, "(");
                sb.append(")");
                return sb.toString();
            }else{
                map.put(rem, sb.length()); // 1, 2
                rem = rem * 10;
                quo = rem / den;
                sb.append(quo);
                rem = rem % den;
            }
        }

        return sb.toString();
    }
}