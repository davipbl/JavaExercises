import java.util.NoSuchElementException;

public class LinkedList<T extends Node<T>> implements List<T> {
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
            while (current.next != null && counter < index ) {
                    current = current.next;
                    counter++;
                }
            if (index < 0 || counter != index) {
                throw new IllegalArgumentException();
            }
            if (counter == index) {
                node.next = current;
                current = node;

                if (counter == 0) {
                    head = current;
                }
                while (current.next != null) {
                    current = current.next;
                    counter++;
                }
                tail = current.next;
                size = counter + 1;
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
                tail = current.next;
                size = counter + 1;

                return found;
            }
        } catch (IllegalArgumentException e) {
            System.out.println("Your index is out of the list bounds");
        }
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
            while (current != null) {
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
            tail = current.next;
            size = counter + 1;

            return found;
        } catch (NoSuchElementException e) {
            System.out.println("The data is not present in the list");
        } catch (IllegalArgumentException e) {
            System.out.println("You cannot remove null data from the list");
        }
    }

    public void clear() {
        head = null;
    }

    public boolean isEmpty() {
        return (head == null);
    }

    public int size() {
        int counter = 0;
        Node<T> current = this.getHead();

        while (current.next != null) {
            current = current.next;
            counter++;
        }
        return counter + 1;
    }
}