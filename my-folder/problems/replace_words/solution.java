class Solution {
    public String replaceWords(List<String> dictionary, String sentence) {

        StringBuilder sb = new StringBuilder();

        String sentArray[] = sentence.split(" ");

        Set<String> set = new HashSet<>();
        set.addAll(dictionary);

        for(String word : sentArray){
            sb.append(result(set, word));
            sb.append(" ");
        }

        return sb.toString().trim();
        
    }

    public String result(Set<String> set, String word){


        for(int i = 0 ; i < word.length() ; i++){
            if(set.contains(word.substring(0,i + 1))){
                return word.substring(0, i + 1);
            }
        }

        return word;
    }
}