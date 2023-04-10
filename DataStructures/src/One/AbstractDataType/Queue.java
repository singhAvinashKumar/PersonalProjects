package One.AbstractDataType;

public class

Queue {

    int size;
    int[] elements;
    int front;
    int back;

    public Queue ( int size){
        this.size = size;
        elements = new int[size];
        front = -1;
        back = 0;
    }

    public boolean push(int number){
        if(queueSize()  == size-1)
        {
            System.out.println("Queue size full " + queueSize());
            return false;
        }
        if(back == (size))
            back = back % (size);
        elements[back++] = number;

        System.out.println("Item Pushed into Queue " + number + "At index " +(back-1));
        System.out.println("Queue Size : "+queueSize());
        return true;
    }

    public int pop(){
        if (queueSize() == 0)
        {
            System.out.println("Queue empty");
            return 0;
        }
        if(front == (size-1))
            front = -1;
        int poppedElement = elements[++front];
        System.out.println("pop location : " + front);
        return poppedElement;
    }

    public int peek(){
        if(queueSize() == 0)
        {
            System.out.println("Queue empty");
            return 0;
        }
        System.out.println("Peek location : " + front);

        return elements[front+1];

    }

    public int queueSize(){
        return ((size-1) - front + back)% size;
    }
    public void queueDisplay(){
        int count = 0;
        System.out.println(" Queue Representaiton ");
        if (back > front)
        {

            for (int i = front+1; i<back; i++)
                System.out.print(elements[i] + ",");
        }
        else if (front >= back){

            for (int i = front+1; count < queueSize() ; i++){
                if (i >= size)
                    i = i% size;
                System.out.print(elements[i]+",");
                count++;
            }
        }

    }

    public static void main(String[] args) {

        Queue queue = new Queue(6);
        System.out.println(queue.peek());
        System.out.println(queue.pop());
        queue.push(25);
        queue.push(35);
        queue.push(05);
        queue.push(78);
        queue.push(45);
        queue.push(15);
        queue.push(43);
        System.out.println("Item at Front : "+queue.peek());
        queue.queueDisplay();
        System.out.println();
        System.out.println("Popped Item : "+queue.pop());
        queue.push(53);
        queue.queueDisplay();
        System.out.println();
        System.out.println("Popped Item : "+queue.pop());
        queue.push(68);
        queue.queueDisplay();

    }

}
