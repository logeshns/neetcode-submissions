class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> ll=new ArrayList<>();
        if(strs.length==1){
            ll.add(Arrays.asList(strs[0]));
            return ll;
        }
        if(isAnagram(strs[0],strs[1])){
            ll.add(new ArrayList<>(Arrays.asList(strs[0],strs[1])));
        }else{
            ll.add(new ArrayList<>(Arrays.asList(strs[0])));
            ll.add(new ArrayList<>(Arrays.asList(strs[1])));
        }
        for(int i=2;i<strs.length;i++){
            String s=strs[i];
            int j=0;
            boolean f=false;
            while(j<ll.size()){
                if(isAnagram(s,ll.get(j).get(0))){
                    f=true;
                    ll.get(j).add(s);
                    break;
                }
                j++;
            }
            if(f==false){
                ll.add(new ArrayList<>(Arrays.asList(s)));
            }
        }
        return ll;
    }
    public static boolean isAnagram(String s,String t){
        if(s.length()!=t.length())return false;
        HashMap<Character,Integer> map=new HashMap<>();
        for(int i=0;i<s.length();i++){
            map.put(s.charAt(i),map.getOrDefault(s.charAt(i),0)+1);
        }
        for(int i=0;i<t.length();i++){
            if(!map.containsKey(t.charAt(i)) || map.get(t.charAt(i))<=0){
                return false;
            }
            map.put(t.charAt(i),map.get(t.charAt(i))-1);
        }
        return true;
    }
}
