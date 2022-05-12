class Solution {
  public int minDistance(String word1, String word2) {
        int len1 = word1.length(), len2 = word2.length();
        int[][] memo = new int[len1 + 1][len2 + 1];
        for (int j = 0; j <= len2; j++) {
            memo[0][j] = j;
        }
        for (int i = 0; i <= len1; i++) {
            memo[i][0] = i;
        }
        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {
                char c1 = word1.charAt(i - 1), c2 = word2.charAt(j - 1);
                if (c1 == c2) {
                    memo[i][j] = memo[i - 1][j - 1];
                } else {
                    memo[i][j] = Math.min(
                        memo[i - 1][j - 1],
                        Math.min(
                            memo[i][j - 1],
                            memo[i - 1][j]
                        )
                    ) + 1;
                }
            }
        }
        return memo[len1][len2];
    }
}