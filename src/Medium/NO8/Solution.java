package Medium.NO8;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int myAtoi(String s) {
        Automaton automaton = new Automaton();
        for (char c : s.toCharArray()){
            automaton.getOne(c);
        }
        return (int) (automaton.ans * automaton.sign);
    }

}

class Automaton {
    public long ans = 0;
    public int sign = 1;
    private String state = "start";
    private Map<String, String[]> table = new HashMap<String, String[]>(){
        {
            put("start", new String[]{"start", "sign", "number", "end"});
            put("sign", new String[]{"end", "end", "number", "end"});
            put("number", new String[]{"end", "end", "number", "end"});
            put("end", new String[]{"end", "end", "end", "end"});
        }
    };

    public void getOne(char c){
        state = table.get(state)[getCol(c)];
        if (state.equals("number")){
            ans = ans*10 + c - '0';
            ans = sign == 1 ? Math.min(ans, (long) Integer.MAX_VALUE) : Math.min(ans, -(long) Integer.MIN_VALUE);
        }else if (state.equals("sign")){
            sign = c == '+' ? 1 : -1;
        }
    }

    public int getCol(char c){
        if (c == ' '){
            return 0;
        }
        if (c == '+' || c == '-'){
            return 1;
        }
        if (Character.isDigit(c)){
            return 2;
        }
        return 3;
    }
}
