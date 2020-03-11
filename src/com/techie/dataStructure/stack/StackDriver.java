package com.techie.dataStructure.stack;

import com.techie.dataStructure.stack.BasicStack;

public class StackDriver {

    public static void main(String args[]){
        BasicStack<Integer> basicStack = new BasicStack<>();

        System.out.println(basicStack.size());
        basicStack.pop();
        System.out.println(basicStack.size());
        basicStack.pop();
        basicStack.pop();
        basicStack.push(7);
        basicStack.push(9);
        basicStack.push(8);
        basicStack.push(5);
        System.out.println(basicStack.size());
        System.out.println(basicStack.contains(9));
        System.out.println(basicStack.access(7));
        System.out.println(basicStack.size());

    }
}
