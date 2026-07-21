class Solution {
    public String longestDiverseString(int a, int b, int c) {
        PriorityQueue<int[]> happy = new PriorityQueue<>((x, y) -> y[1] - x[1]);
        StringBuilder res = new StringBuilder();
        if(a != 0){
            happy.offer(new int[]{(int) 'a', a});
        }
        if(b != 0){
            happy.offer(new int[]{(int) 'b', b});
        }
        if(c != 0){
            happy.offer(new int[]{(int) 'c', c});
        }

        char curChar = '?';
        int tracker = 0;

        while(!happy.isEmpty()){    
            int[] cur = happy.poll();
            char cc = (char) cur[0];
            int occ = cur[1];

            if(cc == curChar){
                tracker++;
                if(tracker == 3){
                    tracker = 1;
                    if(happy.isEmpty()){
                        break;
                    }
                    int[] tmp = happy.poll();
                    char cTmp = (char) tmp[0];
                    int occTmp = tmp[1];
                    res.append(cTmp);

                    if(occTmp != 1){
                        happy.offer(new int[]{tmp[0], tmp[1] - 1});
                    }
                }
                res.append(cc);

                if(occ != 1){
                    happy.offer(new int[]{cur[0], cur[1] - 1});
                }

            }

            else{
                curChar = cc;
                tracker = 1;
                res.append(cc);
                if(occ != 1){
                    happy.offer(new int[]{cur[0], cur[1] - 1});
                }
            }

        }

        return res.toString();
    }
}