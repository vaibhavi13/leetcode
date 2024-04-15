class Solution {
    public boolean haveConflict(String[] event1, String[] event2) {
        
        boolean a = event1[1].compareTo(event2[0]) >=0;  // endTime1 >= startTime1;
        boolean b = event2[1].compareTo(event1[0]) >= 0 ; // endTime2 >= startTime1;
        
        return a && b;

    }
}