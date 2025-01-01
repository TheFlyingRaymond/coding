public class LC474findMaxForm {

    public int findMaxForm(String[] strs, int m, int n) {
        int[][] funcPre = new int[m + 1][n + 1];
        int[][] funcCur = new int[m + 1][n + 1];

        for (String str : strs) {
            funcCur = combine(funcPre, str);
            funcPre = funcCur;
        }

        return funcPre[m][n];
    }

    private int[][] combine(int[][] funcPre, String str) {
        int[][] funcCur = new int[funcPre.length][funcPre[0].length];

        int cnt0 = (int) str.chars().filter(ch -> ch == '0').count();
        int cnt1 = (int) str.chars().filter(ch -> ch == '1').count();

        for (int i = 0; i < funcCur.length; i++) {
            for (int j = 0; j < funcCur[0].length; j++) {
                if(i >= cnt0 && j>= cnt1){
                    funcCur[i][j] = Math.max(funcPre[i][j], funcPre[i - cnt0][j - cnt1] + 1);
                }else {
                    funcCur[i][j] = funcPre[i][j];
                }
            }
        }
        return funcCur;
    }
}
