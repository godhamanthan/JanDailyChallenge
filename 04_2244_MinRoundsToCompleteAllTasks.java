class Solution {
  public int minimumRounds(int[] tasks) {
    int ans = 0;
    Map<Integer, Integer> count = new HashMap<>();

    for (final int task : tasks)
      count.merge(task, 1, Integer::sum);

    
    for (final int freq : count.values())
      if (freq == 1)
        return -1;
      else
        ans += (freq + 2) / 3;

    return ans;
  }
}
