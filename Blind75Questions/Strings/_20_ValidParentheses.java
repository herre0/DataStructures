package com.mert.Blind75Questions.Strings;

import java.util.HashMap;
import java.util.Stack;

/*
20. Valid Parentheses

Input: s = "()[]{}"
Output: true
*/
public class _20_ValidParentheses {
    public static void main(String[] args) {
        System.out.print(isValid( "()[]{}"));
    }

    public static boolean isValid(String s) {
        HashMap<Character, Character> map = new HashMap();
        map.put('[', ']');
        map.put('(', ')');
        map.put('{', '}');

        Stack<Character> stack = new Stack();
        for(int i = 0; i < s.length(); i++) {
            char p = s.charAt(i);
            if(map.containsKey(p))
                stack.push(p);
            else {
                if(stack.isEmpty()) {
                    return false;
                } else if(p == map.get(stack.peek()))
                    stack.pop();
                else
                    return false;
            }
        }

        return stack.isEmpty();
    }
}
