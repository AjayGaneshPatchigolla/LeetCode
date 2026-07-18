class Solution {
    public int[][] sortTheStudents(int[][] score, int k) {
        Arrays.sort(score, (a,b) -> {
            if(a[k]<b[k])
            return 1;
            else
            return -1;
        });
        return score;
    }
}