public class LinkedDoublyList<E> {
    Node<E> head;
    private static class Node<E>{


        private E element;
        private Node<E> next;
        private Node<E> prev;

        public Node(E element) {
            this.element = element;
            this.next=null;
            this.prev=null;
        }

        public E getElement() {
            return element;
        }
    }

    public void push(int new_data)
    {
        Node new_Node = new Node(new_data);

        new_Node.next = head;
        new_Node.prev = null;

        if (head != null)
            head.prev = new_Node;

        head = new_Node;
    }
    public void reverse(){
        Node temp = null;
        Node current = head;
        while (current != null) {
            temp = current.prev;
            current.prev = current.next;
            current.next = temp;
            current = current.prev;
        }
        if (temp != null) {
            head = temp.prev;
        }
    }
    void printList(Node node)
    {
        while (node != null) {
            System.out.print(node.getElement() + " ");
            node = node.next;
        }
    }

}
