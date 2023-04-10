package One.AbstractDataType;

import java.util.Optional;

public interface BHeap {

    void buildHeap();
    //void heapify(Node node);

    void heapify(Optional<Node> node);

    void insertElement(Node newNode);

    void insertAllElement(int[] nodes);
    Optional<Node> min();
    Node deleteMin(Node node);

}
