class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> set=new HashSet<>(wordList);
        if(!wordList.contains(endWord)){
            return 0;
        }
        Queue<String> queue=new LinkedList<>();
        queue.add(beginWord);
        int level=1;
        while(!queue.isEmpty()){
            int n=queue.size();
            for(int i=0;i<n;i++){
                String original=queue.poll();
                if (original.equals(endWord))
                    return level;
                char[] chArray=original.toCharArray();
                for(int j=0;j<chArray.length;j++){
                    char or=chArray[j];
                    for(char ch='a';ch<='z';ch++){
                        chArray[j]=ch;
                        if(set.contains(new String(chArray))){
                            queue.add(new String(chArray));
                            set.remove(new String(chArray));
                        }
                    }
                    chArray[j]=or;
                }
            }
            level++;
        }
        return 0;
    }
}
