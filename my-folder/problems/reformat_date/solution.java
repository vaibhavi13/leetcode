class Solution {
    public String reformatDate(String date) {
        String month[] = {"","Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};

        
        String values[] = date.split(" ");
        StringBuilder sb = new StringBuilder();
        sb.append(values[2]);
        sb.append("-");
        for(int i = 1 ; i < month.length ; i++){
            if(month[i].equals(values[1])){
               if(i < 10){
                sb.append("0");
                sb.append(i);
               }else{
                sb.append(i);
               }
               break;
            }
        }
        sb.append("-");
        
        if(values[0].length() == 3){
            sb.append("0");
            sb.append(values[0].substring(0,1));
        }else{
            sb.append(values[0].substring(0,2));
        }

        return sb.toString();
    }
}