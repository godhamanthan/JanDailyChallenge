class Solution {
    public int findMinArrowShots(int[][] points) {
        if(points.length<1) return 0;
        int count=1;
        Arrays.sort(points,(a,b)->a[1]>b[1]?1:-1);
        int initial = points[0][1];
        for(int i=1;i<points.length;i++){
            if(points[i][0]>initial){
                count++;
                initial=points[i][1];
            }
        }
        return count;
    }
}
