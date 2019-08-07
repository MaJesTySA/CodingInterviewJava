package q9_两个栈实现队列;

import java.util.Collections;
import java.util.Stack;

public class QueueWithTwoStacks {
    public static void main(String[] args) {
        Queue<String> queue=new Queue<>();
        queue.append("a");
        queue.append("b");
        queue.append("c");
        System.out.print("abc入队：");
        queue.printQueue();
        System.out.print("\n"+queue.delete()+"出队: ");
        queue.printQueue();
        System.out.print("\n"+queue.delete()+"出队: ");
        queue.printQueue();
        queue.append("d");
        System.out.print("\nd入队: ");
        queue.printQueue();
        queue.append("e");
        System.out.print("\ne入队: ");
        queue.printQueue();
        System.out.print("\n"+queue.delete()+"出队: ");
        queue.printQueue();
        System.out.print("\n"+queue.delete()+"出队: ");
        queue.printQueue();
        System.out.print("\n"+queue.delete()+"出队: ");
        queue.printQueue();
    }
}

class Queue <T>{
    private Stack<T> stack1=new Stack<>();
    private Stack<T> stack2=new Stack<>();

    public boolean isEmpty(){
        if (stack1.size()==0 && stack2.size()==0){
            return true;
        }else
            return false;
    }
    
    public void append(T node){
        stack1.push(node);
    }
    public T delete(){
        if (stack2.size()<=0){
            while (stack1.size()>0){
                stack2.push(stack1.pop());
            }
        }
        if (stack2.size()==0){
            System.out.println("队列已空");
            return null;
        }
        return stack2.pop();
    }

    public void printQueue(){
        if (stack1.size()==0 && stack2.size()==0 ){
            System.out.println("队列已空");
        }
        if (stack2.size()>0 && stack1.size()>0){
            for (T ele:stack2) {
                System.out.print(ele+"<-");
            }
            for (T ele:stack1){
                System.out.print(ele+"<-");
            }
            return;
        }
        if (stack2.size()>0&&stack1.size()==0){
            Collections.reverse(stack2);
            for (T ele: stack2) {
                System.out.print(ele+"<-");
            }
            Collections.reverse(stack2);
            return;
        }
        if (stack2.size()==0 && stack1.size()>0){
            for (T ele:stack1){
                System.out.print(ele+"<-");
            }
        }
    }
}
