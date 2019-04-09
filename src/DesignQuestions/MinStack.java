package DesignQuestions;

import java.util.Stack;

public class MinStack {

    Stack<Integer> stack;
    Stack<Integer> auxStack;
    int min = Integer.MAX_VALUE;

    /** initialize your data structure here. */
    /* Using two Stacks
    public MinStack() {
        stack = new Stack<Integer>();
        auxStack = new Stack<Integer>();
    }

    public void push(int x) {
        stack.push(x);
        if(auxStack.isEmpty()||auxStack.peek()>= x){
            auxStack.push(x);
        }
    }

    public void pop() {
        int x = stack.pop();
        if(x == auxStack.peek()){
            auxStack.pop();
        }
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return auxStack.peek();
    }
    */
    /*Using Single Stack*/
    public MinStack() {
        stack = new Stack<Integer>();
    }

    public void push(int x) {
        if(min<=x){
            stack.push(min);
            min = x;
        }
        stack.push(x);
    }

    public void pop() {
        if(min==stack.pop()){
            min = stack.pop();
        }
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return min;
    }

    public static void main(String args[]){
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        minStack.getMin();   //--> Returns -3.
        minStack.pop();
        minStack.top();     // --> Returns 0.
        minStack.getMin();   //--> Returns -2.
    }
}
