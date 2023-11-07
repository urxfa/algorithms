class LinkedList {
    private Node head;
    
    // Constructor for an empty linked list
    public LinkedList() {
        head = null;
    }
    
    // Constructor for creating a linked list with a single node
    public LinkedList(int x) {
        head = new Node(x);
    }

    // Check if the linked list is empty
    public boolean isEmpty() {
        return head == null;
    }

    // Insert a new node at the end of the linked list
    public void insertEnd(int item) {
        if (isEmpty()) {
            // If the list is empty, create the first node
            head = new Node(item);
        } else {
            // Otherwise, traverse to the end and add a new node
            Node aux = head;
            while (aux.link != null) {
                aux = aux.link;
            }
            aux.link = new Node(item);
        }
    }

    // Insert a new node at the beginning of the linked list
    public void insertBeginning(int item) {
        if (isEmpty()) {
            head = new Node(item);
        } else {
            Node aux = new Node(item);
            aux.link = head;
            head = aux;
        }
    }

    // Insert a new node at a specified position
    public void insert(int item, int pos) {
        if (pos < 0) {
            System.out.println("Invalid position: " + pos);
            return;
        }
        if (pos == 0 || isEmpty()) {
            // If the position is 0 or the list is empty, insert at the beginning
            insertBeginning(item);
        } else {
            Node aux = head;
            for (int i = 0; i < pos - 1 && aux != null; i++) {
                aux = aux.link;
            }
            Node tmp = new Node(item);
            tmp.link = aux.link;
            aux.link = tmp;
            tmp = null;
        }
    }

    // Remove the last node from the linked list
    public void removeLast() {
        Node aux = head;
        Node prev = head;

        while (aux.link != null) {
            prev = aux;
            aux = aux.link;
        }

        prev.link = null;
        aux = null;
    }

    // Remove the first node from the linked list
    public void removeFirst() {
        Node aux = head;
        if (!isEmpty())
            head = head.link;
        else {
            System.out.println("Linked List is empty.");
        }
    }

    // Remove a node at a specified position
    public void remove(int pos) {
        if (pos < 0) {
            System.out.println("Invalid position: " + pos);
            return;
        }
        if (pos == 0 || isEmpty()) {
            // If the position is 0 or the list is empty, remove the first node
            removeFirst();
        } else {
            Node aux = head;
            for (int i = 0; i < pos - 1; i++) {
                aux = aux.link;
            }
            aux.link = aux.link.link;
        }
    }

    // Reverse the linked list
    public void reverse() {
        Node aux = head;
        Node prev = null;
        Node current = null;

        while (aux.link != null) {
            current = aux;
            aux = aux.link;
            current.link = prev;
            prev = current;
        }
        aux.link = current;
        head = aux;
    }

    // Display the elements in the linked list
    public void showElements() {
        Node aux = head;

        while (aux != null) {
            System.out.print(aux.item + " ");
            aux = aux.link;
        }
        System.out.println();
    }

    // Main method to demonstrate the LinkedList operations
    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        
        list.insertEnd(1);
        list.insertEnd(2);
        list.insertEnd(3);
        list.insertEnd(4);
        list.insertEnd(5);

        list.insertBeginning(-1);
        list.insertBeginning(-2);
        list.insertBeginning(-3);
        list.insertBeginning(-4);
        list.insertBeginning(-5);

        list.insert(0, 5);
        list.insert(10000, 0);

        list.showElements();

        list.removeLast();
        list.removeLast();

        list.showElements();

        list.removeFirst();
        list.removeFirst();

        list.showElements();

        list.remove(4);

        list.showElements();

        list.reverse();

        list.showElements();
    }
}
