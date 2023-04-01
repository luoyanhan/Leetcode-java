package Medium.NO208;

import java.util.HashMap;
import java.util.Map;

class Trie {
    public Map<Character, Trie> children;
    public boolean isEnd;

    public Trie() {
        children = new HashMap<Character, Trie>();
        isEnd = false;
    }

    public void insert(String word) {
        Trie curNode = this;
        for (int i=0; i<word.length(); i++){
            Character idx = word.charAt(i);
            if (!curNode.children.containsKey(idx)){
                curNode.children.put(idx, new Trie());
            }
            curNode = curNode.children.get(idx);
        }
        curNode.isEnd = true;
    }

    public Trie getPrefix(String prefix){
        Trie curNode = this;
        for (int i=0; i<prefix.length(); i++){
            Character idx = prefix.charAt(i);
            if (!curNode.children.containsKey(idx)){
                return null;
            }
            curNode = curNode.children.get(idx);
        }
        return curNode;
    }

    public boolean search(String word) {
        Trie curNode = getPrefix(word);
        return curNode!=null && curNode.isEnd;
    }

    public boolean startsWith(String prefix) {
        return getPrefix(prefix)!=null;
    }
}

