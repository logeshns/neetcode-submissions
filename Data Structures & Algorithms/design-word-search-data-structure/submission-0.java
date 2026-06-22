public class TrieNode{
        TrieNode[] children;
        boolean endOfWord;
        TrieNode(){
            this.children=new TrieNode[26];
            this.endOfWord=false;
        }
    }
class WordDictionary {
    private TrieNode root;
    public WordDictionary() {
        this.root=new TrieNode();
    }

    public void addWord(String word) {
        TrieNode curr=root;
        for(char ch:word.toCharArray()){
            if(curr.children[ch-'a']==null){
                curr.children[ch-'a']=new TrieNode();
            }
            curr=curr.children[ch-'a'];
        }
        curr.endOfWord=true;
    }

    public boolean search(String word) {
        return dfs(word, 0, root);
    }

    private boolean dfs(String word, int j, TrieNode root) {
        TrieNode cur = root;

        for (int i = j; i < word.length(); i++) {
            char c = word.charAt(i);
            if (c == '.') {
                for (TrieNode child : cur.children) {
                    if (child != null && dfs(word, i + 1, child)) {
                        return true;
                    }
                }
                return false;
            } else {
                if (cur.children[c - 'a'] == null) {
                    return false;
                }
                cur = cur.children[c - 'a'];
            }
        }
        return cur.endOfWord;
    }
}
