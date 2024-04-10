class Solution {
    public int romanToInt(String s) {

        HashMap<String,Integer> map = new HashMap<>();

        map.put("I", 1);
        map.put("IV",4);
        map.put("V",5);
        map.put("IX",9);
        map.put("X",10);
        map.put("XL",40);
        map.put("L",50);
        map.put("XC",90);
        map.put("CD",400);
        map.put("CM",900);
        map.put("C",100);
        map.put("D",500);
        map.put("M",1000);

        int n = 0;

        int c = 0 ;

        while(c < s.length()){
            if(c+1 < s.length() && map.containsKey(s.substring(c,c+2))){
                n += map.get(s.substring(c,c+2));
                c += 2;
            }else{
                n += map.get(s.substring(c,c+1));
                c++;
            }
        }


        return n;

           

        
    }
}