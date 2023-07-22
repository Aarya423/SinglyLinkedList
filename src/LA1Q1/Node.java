package LA1Q1;

public class Node <T>{
    //setting up private fields
    private T element;
    private Node <T> next;
    //constructor with no arguments
    public Node(){}
    //constructor with arguments
    public Node( T t, Node <T> n){
        this.element=t;
        this.next=n;
    }
    //getting element and next, also setting for next
    public T getElement() {
        return element;
    }
    public Node<T> getNext() {
        return next;
    }
    public void setNext(Node<T> next) {
        this.next = next;
    }
}
