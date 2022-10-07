package advanceDataStructure;

public class AbstractTree {
    public Node root;


    public AbstractTree(int key){
        root = new Node(key);
    }

    public void preOrder(Node next){
        if (next == null)
            return;
        System.out.print(next.getKey() + " , ");
        preOrder(next.getLeftChild());
        preOrder(next.getRightChild());
    }

    public void postOrder(Node begin){
        if (begin == null)
            return;

        postOrder(begin.getLeftChild());
        postOrder(begin.getRightChild());
        System.out.print(begin.getKey() + " , ");
    }

    public void inOrder(Node begin){
        if (begin == null)
            return;
        inOrder(begin.getLeftChild());
        System.out.print(begin.getKey() + " , ");
        inOrder(begin.getRightChild());
    }

    public void insertKey(int key){
       Node current = root;
       Node newNode = new Node(key);
        while (current != null){
            if (newNode.getKey() > current.getKey()  )
                {
                    if (current.getRightChild() == null)
                    {
                        current.setRightChild(newNode);
                        current.getRightChild().setParent(current);
                        //System.out.println(newNode.getKey()+ " Right Child ADDED");
                    }
                    current = current.getRightChild();
                }
            else if (newNode.getKey() < current.getKey() )
                {
                    if ( current.getLeftChild() == null)
                    {
                        current.setLeftChild(newNode);
                        current.getLeftChild().setParent(current);
                       // System.out.println(current.getLeftChild().getParent().getKey());
                      //  System.out.println(newNode.getKey()+ " Left child ADDED");
                    }
                    current = current.getLeftChild();
                }
            else
                break;
        }
    }

    public Node findKey(int key){
        Node current = root;
        while (current != null){
            if (current.getKey() == key)
                break;
            else if (current.getKey() < key)
                current = current.getRightChild();
            else
                current = current.getLeftChild();
        }
        return current;
    }
    public Node min(Node root){
        Node current = root;
        if(current.getLeftChild() == null)
            return   current;

        return min(current.getLeftChild());

    }

    public Node max(Node root){
        Node current = root;
        if(current.getRightChild() == null)
            return   current;

        return max(current.getRightChild());

    }

    public Node findSuccessor(int key){
        Node keyNode = findKey(key);
        Node current = keyNode;

        if (keyNode.getRightChild() != null)
            return min(keyNode.getRightChild());
        else
            {
                while (current.getParent().getRightChild() == current){
                current = current.getParent();
            }
            return current.getParent();
            }
    }

    public Node findPredecessor(int key){
        Node keyNode = findKey(key);
        Node current = keyNode;

        if (current.getLeftChild() == null && current.getParent() == null)
            return  null;

        if (keyNode.getLeftChild() != null)
            return max(keyNode.getLeftChild());
        else
        {
            while (current.getParent().getLeftChild() == current){
                current = current.getParent();
            }
            return current.getParent();
        }
    }

    public void deleteNode(Node keyNode){
        if (keyNode == null)
            return;
        if (keyNode.getLeftChild() == null && keyNode.getRightChild() == null)
            {
                if (keyNode.getParent().getRightChild() == keyNode)
                keyNode.getParent().setRightChild(null);
                else if (keyNode.getParent().getLeftChild() == keyNode)
                    keyNode.getParent().setLeftChild(null);
            }
        else if (keyNode.getLeftChild() == null && keyNode.getRightChild() != null){

                if (keyNode.getParent().getRightChild() == keyNode)
                {
                    keyNode.getRightChild().setParent(keyNode.getParent());

                    keyNode.getParent().setRightChild(keyNode.getRightChild());
                    System.out.println("deleted " + keyNode.getKey());
                }
                else if (keyNode.getParent().getLeftChild() == keyNode)
                    {
                        keyNode.getRightChild().setParent(keyNode.getParent());
                        keyNode.getParent().setLeftChild(keyNode.getRightChild());
                        System.out.println("deleted " + keyNode.getKey());
                    }
        }
        else if (keyNode.getLeftChild() != null && keyNode.getRightChild() == null) {
            if (keyNode.getParent().getRightChild() == keyNode)
                {
                    keyNode.getLeftChild().setParent(keyNode.getParent());
                    keyNode.getParent().setRightChild( keyNode.getLeftChild());
                    System.out.println("deleted " + keyNode.getKey());
                }
            else if (keyNode.getParent().getLeftChild() == keyNode)
              {
                  keyNode.getLeftChild().setParent(keyNode.getParent());
                  keyNode.getParent().setLeftChild(keyNode.getLeftChild());
                  System.out.println("deleted " + keyNode.getKey());
              }
    }
        else if (keyNode.getLeftChild() != null && keyNode.getRightChild() != null){
            Node predecessor = findPredecessor(keyNode.getKey());
            deleteNode(predecessor);
            keyNode.setKey(predecessor.getKey());
        }
    }

    public static void main(String[] args) {
        AbstractTree tree = new AbstractTree(9);
        tree.insertKey(3);
        tree.insertKey(7);
        tree.insertKey(12);
        tree.insertKey(33);
        tree.insertKey(24);
        tree.preOrder(tree.root);
        System.out.println();
        tree.postOrder(tree.root);
        System.out.println();
        tree.inOrder(tree.root);
        System.out.println(" key "+tree.findKey(12).getKey());
        System.out.println("Successor of 12 : "+tree.findSuccessor(12).getKey());
        tree.insertKey(2);
        System.out.println(tree.min(tree.root).getKey() + " Minm elem ");
        System.out.println("Predecessor of 9 : "+tree.findPredecessor(9).getKey());
        tree.insertKey(4);
        tree.insertKey(8);
        System.out.println("Predecessor of 9 : "+tree.findPredecessor(9).getKey());
        tree.deleteNode(tree.findKey(9));
        //System.out.println(tree.findKey(33).getKey());
        System.out.println(tree.root.getKey());
        tree.preOrder(tree.root);
    }

}
