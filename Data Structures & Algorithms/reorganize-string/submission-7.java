class Solution {
    public String reorganizeString(String s) {
        HashMap<Character, Integer> count = new HashMap<>();
        PriorityQueue<int[]> chars = new PriorityQueue<>((a, b) -> a[1] == b[1] ?
        b[0] - a[0] : b[1] - a[1]);
        StringBuilder res = new StringBuilder(); 

        for(int i = 0; i < s.length(); i++){
            Character c = s.charAt(i);
            count.put(Character.valueOf(c), count.getOrDefault(c, 0) + 1);
        }

        for(Character c: count.keySet()){
            chars.offer(new int[]{Integer.valueOf(c), count.get(c)});
        }

        int[] curr = chars.poll();
        Character track = (char) curr[0];
        res.append(track);
        if(chars.isEmpty() && curr[1] == 1){
            return res.toString();
        }
        if(curr[1] != 1){
            chars.offer(new int[]{curr[0], curr[1] - 1});
        }

        while(!chars.isEmpty()){
            curr = chars.poll();
            track = (char) curr[0];

            if(res.charAt(res.length() - 1) == track){
                if(chars.isEmpty()){
                    return "";
                }
                int[] tmp = chars.poll();
                Character tmpTrack = (char) tmp[0];
                res.append(tmpTrack);
                if(tmp[1] != 1){
                    chars.offer(new int[]{tmp[0], tmp[1] - 1});
                }
            }

            res.append(track);

            if(curr[1] != 1){
                chars.offer(new int[]{curr[0], curr[1] - 1});
            }

        }
        return res.toString();
    }
}