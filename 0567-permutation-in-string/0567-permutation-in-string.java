class Solution {

    public static boolean checkFre(int[] count1, int[] count2) {
        for(int i=0; i<26; i++) {
            if(count1[i] != count2[i]) {
                return false;
            }
        }
        return true;
    }

    public static boolean permutationInStrings(String s1, String s2) {
        // basic check - s1 ki length should be less than s2 length
        if(s1.length() > s2.length()) {
            return false;
        }
        // s1 ka frequency table ready
        int[] count1 = new int[26];
        for(int i=0; i<s1.length(); i++) {
            char ch = s1.charAt(i);
            int index = ch - 'a';
            count1[index]++;
        }
        // s2 ki first window ka frequency table
        int i=0;
        int windowLength = s1.length();
        int[] count2 = new int[26];
        for(i=0; i<windowLength; i++) {
            char ch = s2.charAt(i);
            int index = ch - 'a';
            count2[index]++;
        }

        if(checkFre(count1, count2) == true) {
            return true;
        } else {
            // s2 ki remaining window ko process karte hai
            while(i<s2.length()) {
                // new character add in window
                char newChar = s2.charAt(i);
                int newCharIndex = newChar - 'a';
                count2[newCharIndex]++;

                // now remove old char or decrement old char frequency
                int oldCharIndex = i - windowLength;
                char oldChar = s2.charAt(oldCharIndex);
                int freqTableIndexOfOldChar = oldChar - 'a';
                count2[freqTableIndexOfOldChar]--;

                if(checkFre(count1, count2) == true) {
                    return true;
                }
                i++;
            }
        }
        return false;
    }

    public boolean checkInclusion(String s1, String s2) {
        boolean ans = permutationInStrings(s1,s2);
        return ans;
    }
}