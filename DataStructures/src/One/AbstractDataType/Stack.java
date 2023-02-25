package One.AbstractDataType;

public class Stack {
    int size;
    int[] elements;
    int top = -1;

    public Stack ( int size){
        this.size = size;
        elements = new int[size];
    }

    public boolean push(int number){
        if(stackSize() == size)
        {
            System.out.println("Stack size full " + stackSize());
            return false;
        }
        elements[++top] = number;
        System.out.println("Item Pushed into stack " + number);
        return true;
    }

    public int pop(){
        if (stackSize() == 0)
            {
                System.out.println("Stack empty");
                return 0;
            }
        int poppedElement = elements[top--];
        return poppedElement;
    }

    public int peek(){
        if(stackSize() == 0)
            {
                System.out.println("Stack empty");
                return 0;
            }
        return elements[top];
    }

    public int stackSize(){
        return top%size + 1;
    }
    public void stackDisplay(){
        System.out.println(" Stack Representaiton ");

        for(int i = 0; i<stackSize(); i++){
            System.out.print(elements[i] + ",");
        }
    }

    public static void main(String[] args) {
        Stack stack = new Stack(6);
        System.out.println(stack.peek());
        System.out.println(stack.pop());
        stack.push(25);
        stack.push(35);
        stack.push(05);
        stack.push(78);
        stack.push(45);
        stack.push(15);
        stack.push(43);
        System.out.println("Item at TOP : "+stack.peek());

        stack.stackDisplay();
        System.out.println();
        System.out.println("Popped Item : "+stack.pop());
        stack.stackDisplay();
        System.out.println();
        System.out.println("Popped Item : "+stack.pop());
        stack.stackDisplay();
    }


}
