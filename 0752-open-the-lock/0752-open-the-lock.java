class Solution {
    public void fillNeighbours(Queue<String> queue, StringBuilder curr, Set<String> dead) {
        for(int i=0;i<4;i++) {
            char ch=curr.charAt(i);

            //dec;
            char dec = (ch=='0') ? '9' : (char) (ch-1);
            curr.setCharAt(i,dec);
            String decStr = curr.toString();
            if(!dead.contains(decStr)) {
                dead.add(decStr);
                queue.add(decStr);
            }

             //inc;
            char inc = (ch=='9') ? '0' : (char) (ch+1);
            curr.setCharAt(i,inc);
            String incStr = curr.toString();
            if(!dead.contains(incStr)) {
                dead.add(incStr);
                queue.add(incStr);
            }
            
            curr.setCharAt(i,ch);
        }
    }
    public int openLock(String[] deadends, String target) {
        Set<String> dead = new HashSet<>();
        for(String deadend : deadends) {
            dead.add(deadend);
        }
        String start="0000";

        if(dead.contains(start)) {
            return -1;
        }

        Queue<String> queue = new LinkedList<>();
        queue.add(start);

        int level = 0;

        while(!queue.isEmpty()){
            int n = queue.size();

            while(n-->0) {
                String curr=queue.poll();
                if(curr.equals(target)){
                    return level;
                }

               StringBuilder currBuilder = new StringBuilder(curr);
               fillNeighbours(queue,currBuilder,dead);
            }
            level++;
        }
       return -1;
    }
}