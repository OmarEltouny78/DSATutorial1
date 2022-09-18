public class DoublyLinkedList<E> {
    private Node<E> header;
    private Node<E> tail;
    private int size=0;

    public DoublyLinkedList() {
        header=new Node<>(null,null,null);
        tail=new Node<>(null,header,null);
        header.setNext(tail);
    }

    public int getSize() {
        return size;
    }
    public boolean isEmpty(){
        return size==0;
    }
    public E first(){
        if (isEmpty()){
            return null;
        }
        return header.getNext().getElement();
    }
    public E last(){
        if (isEmpty()){
            return null;
        }
        return tail.getPrev().getElement();
    }
    public void addNode(E e){
        addBetween(e,header,header.getNext());
    }
    public void addLast(E e){
        addBetween(e,tail.getPrev(),tail);
    }
    public E removeLast(){
        if (isEmpty()){
            return null;
        }
        return remove(tail.getPrev());
    }
    public E removeFirst(){
        if(isEmpty()){
            return null;
        }
        return remove(header.getNext());
    }
    private E remove(Node<E>node){
        Node<E>successor=node.getNext();
        Node<E>predessor =node.getPrev();
        successor.setPrev(predessor);
        predessor.setNext(successor);
        size--;
        return node.getElement();
    }

    private void addBetween(E e, Node<E> predecessor, Node<E> successor){
        Node<E>newest=new Node<E>(e,predecessor,successor);

        predecessor.setNext(newest);
        successor.setNext(newest);
        size++;
    }

    private static class Node<E>{

        private E element;
        private Node<E> prev;
        private Node<E> next;


        public Node(E element, Node<E> prev, Node<E> next) {
            this.element = element;
            this.prev = prev;
            this.next = next;
        }

        public E getElement() {
            return element;
        }

        public void setElement(E element) {
            this.element = element;
        }

        public Node<E> getPrev() {
            return prev;
        }

        public void setPrev(Node<E> prev) {
            this.prev = prev;
        }

        public Node<E> getNext() {
            return next;
        }

        public void setNext(Node<E> next) {
            this.next = next;
        }
    }
}
