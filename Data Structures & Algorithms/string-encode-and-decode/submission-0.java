

class Solution {

    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for (String s : strs) {
            // Append the length, then a '#', then the string itself
            sb.append(s.length()).append('#').append(s);
        }
        return sb.toString();
    }

    public List<String> decode(String str) {
        List<String> result = new ArrayList<>();
        int i = 0;
        
        while (i < str.length()) {
            // 1. Find the position of the next '#'
            int hashIndex = str.indexOf('#', i);
            
            // 2. Extract the length number (everything from 'i' to the '#')
            int length = Integer.parseInt(str.substring(i, hashIndex));
            
            // 3. Find the exact start and end of the actual string
            int wordStart = hashIndex + 1;
            int wordEnd = wordStart + length;
            
            // 4. Grab the string and add it to our list
            result.add(str.substring(wordStart, wordEnd));
            
            // 5. Move our pointer 'i' to the start of the next encoded chunk
            i = wordEnd;
        }
        
        return result;
    }
}