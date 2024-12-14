package String;

import jdk.internal.net.http.common.Pair;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 1249. Minimum Remove to Make Valid Parentheses
 * https://leetcode.com/problems/minimum-remove-to-make-valid-parentheses/description/?envType=company&envId=facebook&favoriteSlug=facebook-thirty-days
 */
public class MinimumRemoveToMakeValidParentheses_med {

    public String minimumRemoveToMakeValidParentheses(String str) {
        // '))abc(d)((cd)))' => 'abc(d)((cd))'
        StringBuilder strBuilder = new StringBuilder(str);
        Stack<Pair<Character, Integer>> parentheses = new Stack<>();
        List<Integer> indsToBeRemoved = new ArrayList<>();

        // remove parentheses that doesn't complete each other
        for (int i = 0; i < strBuilder.length(); i++) {
            char curr = strBuilder.charAt(i);
            if (curr == '(') {
                parentheses.add(new Pair<>('(', i));
            } else if (curr == ')') {
                if (!parentheses.isEmpty()) {
                    parentheses.pop();
                } else {
                    indsToBeRemoved.add(i);
                }
            }
        }

        // remove remaining open parentheses
        for (Pair<Character, Integer> parenthesis : parentheses) {
            strBuilder.setCharAt(parenthesis.second.intValue(), '-');
        }

        // remove closing parentheses
        for (int i = 0; i < indsToBeRemoved.size(); i++) {
            strBuilder.setCharAt(indsToBeRemoved.get(i), '-');
        }

        cleanStringFromSign(strBuilder);
        return strBuilder.toString();
    }

    private static void cleanStringFromSign(StringBuilder strBuilder) {
        int i = 0;
        while (i < strBuilder.length()) {
            if (strBuilder.charAt(i) == '-') {
                strBuilder.deleteCharAt(i);
            } else {
                i++;
            }
        }
    }
}
