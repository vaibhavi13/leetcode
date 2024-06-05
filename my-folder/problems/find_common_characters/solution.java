class Solution {
    public List<String> commonChars(String[] words) {
        
        List<String> ans = new ArrayList<>();

        int commonChars[] = new int[26];

        for(int i = 0 ; i < words[0].length() ; i++){
            commonChars[words[0].charAt(i) - 'a']++;
        }
        
        int ch[] = new int[26];
        for(int i = 1 ; i < words.length ; i++){
            Arrays.fill(ch,0);
            for(int j = 0 ; j < words[i].length() ; j++){
                ch[words[i].charAt(j) - 'a']++;
            }

            for(int j = 0 ; j < 26 ; j++){
                commonChars[j] = Math.min(commonChars[j], ch[j]);
            }
        }

        for(int i = 0 ; i < 26 ; i++){
            for(int j = 0 ; j < commonChars[i] ; j++){
                ans.add(String.valueOf((char)('a' + i)));
            }
        }

        return ans;
    }
}