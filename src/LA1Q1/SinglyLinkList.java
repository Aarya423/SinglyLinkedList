package LA1Q1;

public class SinglyLinkList <T>{
    //setting up private fields
    private Node<T> head;
    private Node<T> tail;
    private int size;
    //constructor with no arguments
    public SinglyLinkList(){}
    //constructor with arguments/parameters
    public SinglyLinkList(Node<T> h, Node<T> t, int s){
        this.head=h;
        this.tail=t;
        this.size=s;
    }
    //getting size
    public int getSize() {
        return size;
    }
    //set size to 0 if empty
    public boolean isEmpty(){
        return getSize()==0;
    }
    //prints the array for integer and string, if empty print [], else then show the result of the array to the user,
    //return the array with the help of string format
    public String toString() {
        if (isEmpty()){
            return "[]\n";
        }
        else {
        Node<T> h=new Node<>(head.getElement(),head.getNext());
        String result = "";
        while (h.getNext()!=null){
            result+=(h.getElement());
            if (h.getNext()!=null) {
                result+=", ";
            }
            h=h.getNext();
        }

        result= result+(h.getElement());
        return String.format("[%s]\n",result);
        }
    }
    //adding elements from the head, increasing the size
    public void addFirst(T t){
        head=new Node<>(t, head);
        if (size==0){
            tail=head;
        }
        size++;
    }
    //adding elements from the tail, increasing the size
    public void addLast(T t){
        Node<T> newest=new Node<>(t, null);
        if (isEmpty()){
            head=newest;
        }
        else {
            tail.setNext(newest);
        }
        tail=newest;
        size++;
    }
    //removes starting from the head of the linked list and returns the new array
    public T removeFirst() {
        if (isEmpty()){
            return null;
        }
        T answer=head.getElement();
        head=head.getNext();
        size--;
        if (size==0){
            tail=null;
        }
        return answer;
    }
    //removes starting from the tail of the linked list and returns the new array
    public T removeLast(){
        if (isEmpty()){
            return null;
        }
        T answer=tail.getElement();
        Node<T> h=head;
        while(true){
        if(h.getNext()!=tail){
            h=h.getNext();
        }
        else {
            break;
        }
        }
        h.setNext(null);
        tail=h;
        size--;
        if (size==0){
            tail=null;
        }
        return answer;
    }
    //pushes new element into the linked list from the head
    public void pushAtHead(T element){
        addFirst(element);
    }
    //removes the head of the linked list
    public T popFromHead(){
        return removeFirst();
    }
    //pushes new element into the linked list from the tail
    public void pushAtTail(T element){
        addLast(element);
    }
    //removes the tail of the linked list
    public T popFromTail(){
        return removeLast();
    }
    //similar to pushAtTail as it pushes the new element into the linked list from the tail
    public void enqueueAtTail(T element){
        addLast(element);
    }
    //similar to popAtHead as it removes the head of the linked list
    public T dequeueAtHead(){
        return removeFirst();
    }
    //searches in array to see it the user's input matches with the value in the array
    public int searchStack(T element){
        Node<T> present = head;
        int i=1;
        while(present != null) {
            if(present.getElement() == element) {
                break;
            }
            i++;
            present = present.getNext();
        }
        if (present==null){
            i=0;
        }
    return i;


    }
}
