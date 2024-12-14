package String;

import java.util.Stack;

/**
 * 227. Basic Calculator II
 * https://leetcode.com/problems/basic-calculator-ii/description/?envType=company&envId=facebook&favoriteSlug=facebook-thirty-days
 */
public class BasicCalculatorII_med {
    //" 3+5 / 2 " => 3+2 = 5
    // " -3+500 / 2 * 8 /4 -3"
    int index = 0;
    boolean isPositive = true;
    String str;

    public int calculate(String s) {
        str = s;
        Stack<Integer> numbers = new Stack<>();
        int currNum;
        char curr;

        while(index < s.length()) {
            curr = s.charAt(index);
            if(isNumberChar(curr)) {
                currNum = getNumber();
                numbers.add(currNum);
            } else if(isMathChar(curr)) {
                index++;
                int nextNum = getNumber();
                int prevNum = numbers.pop();
                numbers.add(curr == '*' ? prevNum*nextNum : prevNum/nextNum);
            } else if(curr == ' ') {
                index++;
            } else { // the char is + or -
                isPositive = isPositiveChar(curr);
                index++;
            }
        }
        int res=0;
        while(!numbers.isEmpty()) {
            res+=numbers.pop();
        }
        return res;
    }

    public int getNumber() {
        StringBuilder generatedString = new StringBuilder();
        char ch = str.charAt(this.index);
        while(this.index<str.length () && (isNumberChar((ch = str.charAt(this.index))) || (ch = str.charAt(this.index)) == ' ')) {
            if(ch != ' ') {
                generatedString.append(ch);
            }
            this.index++;
        }
        int res = this.isPositive ? Integer.parseInt(generatedString.toString()) :
                -1 * Integer.parseInt(generatedString.toString());
        this.isPositive = true;
        return res;
    }

    public boolean isPositiveChar(char c) {
        return c == '+';
    }

    public boolean isNumberChar(char c) {
        return (c >= '0' && c <= '9');
    }

    public boolean isMathChar(char c) {
        return (c == '*' || c == '/');
    }
}
