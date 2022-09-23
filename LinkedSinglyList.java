public class LinkedSinglyList<E> {
    Node<E>head;
    private static class Node<E>{

        private E element;
        private Node<E>next;

        public Node(E element) {
            this.element = element;
            this.next=null;
        }

        public E getElement() {
            return element;
        }
    }
    public void middle(){
        Node<E>slow_ptr=head;
        Node<E>fast_ptr=head;
        while (fast_ptr!=null && fast_ptr.next!=null){
            fast_ptr=fast_ptr.next.next;
            slow_ptr=slow_ptr.next;
        }
        System.out.println(slow_ptr.getElement() );
    }
    public void printList(){
        Node tnode=head;
        while (tnode!=null){
            System.out.println(tnode.getElement() );
            tnode=tnode.next;
        }
    }
    public void push(E new_data){
        Node new_node=new Node(new_data);
        new_node.next=head;
        head=new_node;
    }
    public void reverse(Node node){
        Node prev=null;
        Node current=node;
        Node next=null;
        while (current!=null){
            next=current.next;
            current.next=prev;
            prev=current;
            current=next;
        }
        node=prev;
    }
}
