package com.company;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class leetcode {
    //整数反转
    public int reverse(int x) {
        int rev = 0;
        while(x != 0){
            int pop = x % 10;
            x = x / 10;
            if(rev > Integer.MAX_VALUE / 10 || (rev == Integer.MAX_VALUE / 10 && pop > Integer.MAX_VALUE % 10)){
                rev = 0;
                break;
            }else if(rev < Integer.MIN_VALUE / 10 || (rev == Integer.MIN_VALUE / 10 && pop < Integer.MIN_VALUE % 10)){
                rev = 0;
                break;
            }
            rev = rev * 10 + pop;
        }
        return rev;
    }

    //括号匹配
    public boolean isValid(String s){
        int n=s.length();
        if(n%2==1){
            return false;
        }
        Map<Character,Character> pairs=new HashMap<Character,Character>(){
            {put(')','(');
            put(']','[');
            put('}','{');}
        };
        Deque<Character> stack=new LinkedList<Character>();
        for (int i=0;i<n;i++){
            char ch=s.charAt(i);
            if(pairs.containsKey(ch)){
                if(stack.isEmpty() || stack.peek()!=pairs.get(ch)){
                    return false;
                }
                stack.pop();
            }else{
                stack.push(ch);
            }
        }
        return stack.isEmpty();
    }




}
