package Medium.NO28;


class Solution {
    public int strStr(String haystack, String needle) {
        int lenOfHaystack = haystack.length(), lenOfNeedle = needle.length();
        if (lenOfNeedle==0){
            return 0;
        }
        int[] next = new int[lenOfNeedle];
        int len = 0;
        for (int pos=1; pos<lenOfNeedle; pos++){
            while (len>0 && needle.charAt(len)!=needle.charAt(pos)){
                len = next[len-1];
            }
            if (needle.charAt(len)==needle.charAt(pos)){
                len++;
            }
            next[pos] = len;
        }

        int posOfNeedle = 0;
        for (int posOfHayStack=0; posOfHayStack<lenOfHaystack; posOfHayStack++){
            while (posOfNeedle>0 && haystack.charAt(posOfHayStack)!=needle.charAt(posOfNeedle)){
                posOfNeedle = next[posOfNeedle-1];
            }
            if (haystack.charAt(posOfHayStack)==needle.charAt(posOfNeedle)){
                posOfNeedle++;
            }
            if (posOfNeedle==lenOfNeedle){
                return posOfHayStack-lenOfNeedle+1;
            }
        }
        return -1;
    }
}
