class Solution {
    public int[] getOrder(int[][] tasks) {
        PriorityQueue<int[]> available = new PriorityQueue<>((a, b) ->
            a[0] == b[0] ? Integer.compare(a[1], b[1]) : Integer.compare(a[0], b[0]));

        PriorityQueue<int[]> pending = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));

        for(int i = 0; i < tasks.length; i++){
            pending.offer(new int[]{tasks[i][0], tasks[i][1], i});
        }

        long time = 1; //handles potential int overflow
        int index = 0;
        int[] res = new int[tasks.length];
        while(!pending.isEmpty() || !available.isEmpty()){
            while(!pending.isEmpty() && pending.peek()[0] <= time) {
                int[] task = pending.poll();
                available.offer(new int[]{task[1], task[2]});
            }

            if(available.isEmpty()) {
                time = pending.peek()[0]; //fast-forwarding time to next available thread open for queuing
                continue;
            }

            int[] task = available.poll();
            time += task[0];
            res[index++] = task[1];
        }

        return res;
    }
}