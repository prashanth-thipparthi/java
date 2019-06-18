package BasicDataStructures.stack;

class stackDataStructure {
    int top = -1;
    int size = 5;
    int arr[] = new int[5];

    public boolean isEmpty() {
        if (top == -1)
            return true;
        return false;
    }

    public boolean isFull() {
        if (top + 1 == size)
            return true;
        return false;
    }

    public boolean push(int x) {

        if (!isFull()) {
            top += 1;
            arr[top] = x;
            return true;
        } else {
            return false;
        }
    }

    public int pop() {
        if (!isEmpty()) {
            System.out.println("Element popped: " + arr[top]);
            int ele = arr[top];
            top -= 1;
            return ele;
        } else {
            return -1;
        }
    }

    public void display() {

        for (int i = top; i >= 0; i--) {
            System.out.println(arr[i]);
        }
    }
}
public class Stack{

    public static void main(String args[]){

        stackDataStructure s = new stackDataStructure();
        if(s.push(2)){
            System.out.println("Element successfully pushed in");
        }

        s.push(3);
        s.push(4);
        s.push(5);
        s.push(6);
        if(!s.push(7)){
            System.out.println("Failed to push Element");
        }
        s.display();
        s.pop();
        s.pop();

    }

}

