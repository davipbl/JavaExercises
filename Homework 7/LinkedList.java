import java.util.NoSuchElementException;

public class LinkedList<T> implements List<T> {

    private Node<T> head;
    private Node<T> tail;
    private int size;
    
    public LinkedList() {
        head = null;
        tail = null;
        size = 0;
    }

    public Node<T> getHead() {
        return head;
    }

    public Node<T> getTail() {
        return tail;
    }

    public void addAtIndex(T data, int index) {
        
        int counter = 0;
        Node<T> node = new Node<T>(data, null);
        Node<T> current = this.getHead();

        try {
            if (this.isEmpty() && index == 0) {
                head = new Node<T>(data, head);
                tail = head;
                size = 1;
                return;
            }
            while (current.next != null && counter < index ) {
                current = current.next;
                counter++;
            }
            if (index < 0 || counter != index) {
                throw new IllegalArgumentException();
            }
            if (counter == index) {
                if (counter == 0) {
                    head = new Node<T>(data, head);
                }
                node.next = current.next;
                current.next = node;
                
                while (current.next != null) {
                    current = current.next;
                    counter++;
                }
                tail = current;
                size++;
            }
        } catch (IllegalArgumentException e) {
            System.out.println("Your index is out of the list bounds");
        }
    }
    
    public T getAtIndex(int index) {
        int counter = 0;
        Node<T> current = this.getHead();

        try {
            while (current.next != null && counter < index ) {
                    current = current.next;
                    counter++;
                }
            if (index < 0 || counter != index) {
                throw new IllegalArgumentException();
            }
            if (counter == index) {
                return current.data;
            }
        } catch (IllegalArgumentException e) {
            System.out.println("Your index is out of the list bounds");
        }
        return null;
    }

    public T removeAtIndex(int index) {
        if (isEmpty()) {
            return null;
        }
        int counter = 0;
        Node<T> current = this.getHead();
        T found = null;

        try {
            while (current.next != null && counter < index ) {
                    current = current.next;
                    counter++;
                }
            if (index < 0 || counter != index) {
                throw new IllegalArgumentException();
            }
            if (counter == index) {
                found = current.data;
                current = current.next;

                if (counter == 0) {
                    head = current;
                }
                while (current.next != null) {
                    current = current.next;
                    counter++;
                }
                tail = current;
                size = size - 1;

                return found;
            }
        } catch (IllegalArgumentException e) {
            System.out.println("Your index is out of the list bounds");
        }
        return null;
    }

    public T remove(T data) {
        if (isEmpty()) {
            return null;
        }
        int counter = 0;
        Node<T> node = new Node<T>(data, null);
        Node<T> current = this.getHead();
        T found = null;

        try {
            System.out.println(current.data);
            while (current != null) {
                System.out.println(data + " / " + current.data);
                if (data.equals(current.data))
                {
                    found = current.data;
                    current = current.next;
                    break;
                } else {
                    current = current.next;
                    counter++;
                }   
            }
            if (counter == 0) {
                head = current;
            }
            while (current.next != null) {
                current = current.next;
                counter++;
            }
            tail = current;
            size--;

            return found;
        } catch (NoSuchElementException e) {
            System.out.println("The data is not present in the list");
        } catch (IllegalArgumentException e) {
            System.out.println("You cannot remove null data from the list");
        }
        return null;
    }

    public void clear() {
        head = null;
    }

    public boolean isEmpty() {
        return (head == null);
    }

    public int size() {
        return size;
    }

    public String toString() {
        return "My current size is " + size + " and my head and tail are (" + head.data + ", " + tail.data + ").";
    }

    public void addToFront(T newData) {
        head = new Node<T>(newData, head);
        size++;
    }
}