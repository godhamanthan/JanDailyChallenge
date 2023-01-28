class SummaryRanges {

    private Map<Integer, Integer> map;

    /**
     * Initialize your data structure here.
     */
    public SummaryRanges() {
        map = new TreeMap<>();
    }

    public void addNum(int val) {
        if (map.containsKey(val)) {
            return;
        }
        map.put(val, val);

        int left = val;
        int right = val;

        if (map.containsKey(val - 1)) {
            left = map.get(val - 1);
        }

        if (map.containsKey(val + 1)) {
            right = map.get(val + 1);
        }
        map.put(right, left);
        map.put(left, right);
    }

    public int[][] getIntervals() {
        List<int[]> intervals = new ArrayList<>();
        int min = -1;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getKey() > min) {
                intervals.add(new int[]{entry.getKey(), entry.getValue()});
                min = entry.getValue();
            }

        }
        int len = intervals.size();
        int[][] res = new int[len][2];
        for (int i = 0; i < len; i++) {
            res[i] = intervals.get(i);
        }
        return res;
    }

    public static void main(String[] args) {
        SummaryRanges obj = new SummaryRanges();
        obj.addNum(49);
        int[][] res1 = obj.getIntervals();
        for (int[] arr : res1) {
            System.out.print(Arrays.toString(arr));
        }
        System.out.println();

        obj.addNum(97);
        int[][] res2 = obj.getIntervals();
        for (int[] arr : res2) {
            System.out.print(Arrays.toString(arr));
        }
        System.out.println();

        obj.addNum(53);
        int[][] res3 = obj.getIntervals();
        for (int[] arr : res3) {
            System.out.print(Arrays.toString(arr));
        }
        System.out.println();

        obj.addNum(5);
        int[][] res4 = obj.getIntervals();
        for (int[] arr : res4) {
            System.out.print(Arrays.toString(arr));
        }
        System.out.println();

        obj.addNum(33);
        int[][] res5 = obj.getIntervals();
        for (int[] arr : res5) {
            System.out.print(Arrays.toString(arr));
        }
    }


}

