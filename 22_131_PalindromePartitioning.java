class Solution {
    List<List<String>> result = new ArrayList<>();
    public List<List<String>> partition(String s) {
        dfs(s,0,new ArrayList<>());
        return result;
    }
    void dfs(String s, int start, List<String>List){
        if(s.length()==start){
        result.add(new ArrayList<>(List));
        return;
        }
        for(int i=start; i< s.length(); i++){
            if(isPalindrome(s, start, i)){
                List.add(s.substring(start, i+1));
                dfs(s, i+1, List);
                List.remove(List.size()-1);
            }
        }
    }
    boolean isPalindrome(String s, int start,int end){
        while(start<end){
            if(s.charAt(start)!=s.charAt(end)){
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}
