class Solution {
    public int compress(char[] chars) {
        int n = chars.length;
        int readIndex = 0;
        int writeIndex = 0;
        while(readIndex < n) {
            int count = 0;
            char ch = chars[readIndex];
            while(readIndex < n && ch == chars[readIndex]) {
                count++;
                readIndex++;
            }

            chars[writeIndex] = ch;
            writeIndex++;
            if(count > 1) {
                String str = String.valueOf(count);
                char[] charArr = str.toCharArray();
                for(char digit : charArr) {
                    chars[writeIndex] = digit;
                    writeIndex++;
                }
            }
        }
        return writeIndex;
    }
}