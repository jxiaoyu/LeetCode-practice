public class Solution {
    public List<String> readBinaryWatch(int num) {
        getCompositions(num, -1, new ArrayList<Integer>());
        List<String> possibleTimes = new ArrayList<>();
        for (List<Integer> seq : compositions) {
            String time = toTime(seq);
            if (time != null) {
                possibleTimes.add(time);
            }
        }
        return possibleTimes;
    }
    
    private List<List<Integer>> compositions = new ArrayList<>();
    
    private void getCompositions(int num, int lastIndex, List<Integer> seq) {
        if (num == 0) {
            compositions.add(seq);
            return;
        }
        for (int i = lastIndex + 1; i < 10; i++) {
            List<Integer> newSeq = new ArrayList(seq);
            newSeq.add(i);
            getCompositions(num - 1, i, newSeq);
        }
    }
    
    private String toTime(List<Integer> seq) {
        int hour = 0, min = 0;
        for (int i : seq) {
            if (i < 4) {
                hour += 1 << i;
            } else {
                min += 1 << (i - 4);
            }
        }
        if (hour > 11 || min > 59) {
            return null;
        }
        if (min < 10) {
            return hour + ":" + "0" + min;
        } else {
            return hour + ":" + min;
        }
    }
}