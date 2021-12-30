package Medium;

import java.util.Arrays;
import java.util.HashMap;

public class eight_hundred_forty_six {
    public static void main(String[] args){
        int[] hand = {1,2,3,6,2,3,4,7,8};
        int groupSize = 3;
        Solution_eight_hundred_forty_six s = new Solution_eight_hundred_forty_six();
        System.out.println(s.isNStraightHand(hand, groupSize));
    }
}


class Solution_eight_hundred_forty_six{
    public boolean isNStraightHand(int[] hand, int groupSize) {
        int n = hand.length;
        if(n%groupSize != 0){
            return false;
        }
        Arrays.sort(hand);
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int each: hand){
            map.put(each, map.getOrDefault(each, 0)+1);
        }
        for(int each: hand){
            if(map.containsKey(each)){
                for(int i=0; i<groupSize; i+=1){
                    if(!map.containsKey(each+i)){
                        return false;
                    }
                    int preNum = map.get(each+i);
                    if(preNum-1==0){
                        map.remove(each+i);
                    }else{
                        map.put(each+i, preNum-1);
                    }
                }
            }
        }
        return true;
    }
}