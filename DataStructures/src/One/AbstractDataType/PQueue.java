package One.AbstractDataType;


import java.util.*;

public class PQueue implements BHeap{
    private Node root;
    private List<Node> heap;
    private static int index;
    public Node getRoot() {
        return root;
    }
    public void setRoot(Node root) {
        this.root = root;
    }
    public List<Node> getHeap() {
        return heap;
    }
    public void setHeap(List<Node> heap) {
        this.heap = heap;
    }


    public PQueue() {
        heap = new ArrayList<>();
        index = 1;
        heap.add(0,null);
    }

    @Override
    public void buildHeap() {
        for (int i = heap.size()-1; i>0; i--){
            heapify(Optional.ofNullable(heap.get(i)));
        }
    }

    @Override
    public void heapify(Optional<Node> node) {

        node.ifPresent(node1 -> {
            int leftChildIndex = node1.getCurrentIndex() * 2;
            int rightChildIndex = (node1.getCurrentIndex() * 2) + 1;

            // since heap initial index is 1
            int heapSize = heap.size()-1;

            if (!(leftChildIndex > heapSize || rightChildIndex > heapSize))
            {
                Node leftChild = heap.get(leftChildIndex);
                Node rightChild = heap.get(rightChildIndex);
                Node temp;
                if (node1.getPriority() > leftChild.getPriority()
                        || node1.getPriority() > rightChild.getPriority()) {
                    if (leftChild.getPriority() <= rightChild.getPriority())
                        temp = leftChild;
                    else
                        temp = rightChild;
                    swap(node1.getCurrentIndex(), temp.getCurrentIndex());
                    heapify(Optional.of(node1));
                }
            }
        });
    }

    private void swap(int index1, int index2) {
        Node temp = heap.get(index2);
        //swapping position in heap
        heap.set(index2, heap.get(index1));
        heap.set(index1, temp);

        //swapping node currentIndex
        heap.get(index2).setCurrentIndex(index2);
        heap.get(index1).setCurrentIndex(index1);
    }
    @Override
    public void insertElement(Node newNode) {
        heap.add(index,newNode);
        index++;
        Node parent = heap.get(newNode.getCurrentIndex()/2);
        if (parent.getPriority() > newNode.getPriority()) {
            swap(parent.getCurrentIndex(), newNode.getCurrentIndex());
            propagate(newNode);
        }
    }

    private void propagate(Node newNode) {
        Node parent = heap.get(newNode.getCurrentIndex()/2);
        if (parent.getPriority() > newNode.getPriority()) {
            swap(parent.getCurrentIndex(), newNode.getCurrentIndex());
            propagate(newNode);
        }
    }

    @Override
    public void insertAllElement(int[] priority) {
        Arrays.stream(priority).forEach(e-> {
            Node currentNode = new Node(e);
            currentNode.setCurrentIndex(index);
           // System.out.println(index+ " "+ heap.size());
            heap.add(index,currentNode);
            if (index == 1)
                root = heap.get(index);
            index++;
        });
    }

    @Override
    public Optional<Node> min() {
        return Optional.of(heap.get(1));
    }

    @Override
    public Node deleteMin(Node node) {
        if (node == null)
            return null;
        Node toBeDeleted = node;
        Node lastNode = heap.get(heap.size()-1);
        swap(toBeDeleted.getCurrentIndex(),lastNode.getCurrentIndex());
        Node removed = heap.remove(heap.size() - 1);
        heapify(Optional.of(lastNode));
        return removed;
    }
    public static void main(String[] args) {
        PQueue queue = new PQueue();
        queue.insertAllElement(new int[]{10,8,21,29,15,7,35,65});
        System.out.println("Element inserted");
        printBinaryHeap(queue.heap);
        //queue.heap.stream().mapToInt(Node::getPriority).forEach(System.out::println);
        queue.buildHeap();
        System.out.println("Heap Built");
        printBinaryHeap(queue.heap);
        Node newNode = new Node(19);
        newNode.setCurrentIndex(index);
        queue.insertElement(newNode);
        System.out.println("Node inserted");
        printBinaryHeap(queue.heap);
         queue.min().ifPresent(node -> System.out.println("Min Elm:"+node.getPriority()));
         Node removed = queue.deleteMin(queue.heap.get(1));
        System.out.println("Deleted: "+removed.getPriority());
        printBinaryHeap(queue.heap);
        heapSort(queue);
    }

    private static void heapSort(PQueue queue) {
        List<Node> newHeap = new ArrayList<>();
        int count = 1;
        while (queue.heap.size()>1) {
            newHeap.add(queue.deleteMin(queue.heap.get(1)));
            printBinaryHeap(queue.heap);
        }
        System.out.println("-------------Sorted --------------");
        printBinaryHeap(newHeap);
        /*System.out.println("Old heap");
        printBinaryHeap(queue.heap)*/;
    }

    private static void printBinaryHeap(List<Node> heap) {
        heap.stream().filter(Objects::nonNull).map(Node::getPriority)
                .forEach(val-> System.out.print(val + ", "));
        System.out.println();
    }


}