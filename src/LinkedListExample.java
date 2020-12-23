import java.util.Iterator;
import java.util.ListIterator;
import java.util.NoSuchElementException;

public class LinkedListExample <Item> implements Iterable<Item> {

    private Node firstItem;
    private Node lastItem;
    private int size = 0;

    @Override
    public Iterator<Item> iterator() {
        return new Iter();
    }

    public ListIterator<Item> listIterator() {
        return new listiterator();
    }

    // Вспомогательный класс, реализует узел связанного списка
    private class Node<Item> {

        Item value; // элемент
        Node nextItem; // ссылка на следующий элемент
        Node prevItem; // ссылка на предыдущий элемент


        public Node(Node prev, Item value, Node next) {
            this.value = value;
            this.nextItem = next;
            this.prevItem = prev;
        }

        public Node(Item value, Node next) {
            this.value = value;
            this.nextItem = next;
        }

        public Node(Item value) {
            this.value = value;
        }
    }

    private class listiterator implements  ListIterator<Item> {

        Node current = new Node(null,firstItem);

        @Override
        public boolean hasNext() {
            return current.nextItem != null;
        }

        @Override
        public Item next() {
            current = current.nextItem;
            return (Item) current.value;
        }

        @Override
        public boolean hasPrevious() {
            return current.prevItem != null;
        }

        @Override
        public Item previous() {
            current = current.prevItem;
            return (Item) current.value;
        }

        @Override
        public int nextIndex() {
            return 0;
        }

        @Override
        public int previousIndex() {
            return 0;
        }

        @Override
        public void remove() {

        }

        @Override
        public void set(Item item) {
            current.value = item;
        }

        @Override
        public void add(Item item) {

        }

    }

    private class Iter implements Iterator<Item>{
        Node current = new Node(null,firstItem);

        @Override
        public boolean hasNext() {
            return current.nextItem != null;
        }

        @Override
        public Item next() {
            current = current.nextItem;
            return (Item) current.value;
        }
    }

    // добавление элемента в начало списка
    public void insertFirst(Item value) {
        Node newNode = new Node(value, firstItem);
        if (isEmpty()) {
            lastItem = newNode;
        } else {
            firstItem.prevItem = newNode;
        }
        firstItem = newNode;
        size++;
    }

    // добавление элемента в конец списка
    public void insertLast(Item value) {
        Node newNode = new Node(value);
        if (isEmpty()) {
            firstItem = newNode;
        } else {
            newNode.prevItem = lastItem;
            lastItem.nextItem = newNode;
        }
        lastItem = newNode;
        size++;
    }

    // удаление элемента из начала списка
    public Item removeFirst() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        Node oldFirst = firstItem;
        firstItem = firstItem.nextItem;
        if (isEmpty()) {
            lastItem = null;
        } else {
            firstItem.prevItem = null;
        }
        size--;
        return (Item) oldFirst.value;
    }

    // удаление элемента из конца списка
    public Item removeLast() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        Node oldLast = lastItem;
        if (lastItem.prevItem != null) {
            lastItem.prevItem.nextItem = null;
        } else {
            firstItem = null;
        }
        lastItem = lastItem.prevItem;
        size--;
        return (Item) oldLast.value;
    }

    public void insert(int index, Item value) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }
        if (index == 0) {
            insertFirst(value);
            return;
        }
        if (index == size) {
            insertLast(value);
            return;
        }

        Node current = firstItem;
        int i = 0;
        while (i < index - 1) {
            current = current.nextItem;
            i++;
        }
        Node newNode = new Node(value);
        newNode.nextItem = current.nextItem;
        newNode.prevItem = current;
        current.nextItem = newNode;
        newNode.nextItem.prevItem = newNode;
        size++;
    }

    public boolean remove(Item value) {
        if (isEmpty()) {
            return false;
        }
        if (firstItem.value.equals(value)) {
            removeFirst();
            return true;
        }
        Node current = firstItem;
        while (current != null && !current.value.equals(value)) {
            current = current.nextItem;
        }
        if (current == null) {
            return false;
        }
        if(current == lastItem){
            removeLast();
            return true;
        }
        current.prevItem.nextItem = current.nextItem;
        current.nextItem.prevItem = current.prevItem;
        size--;
        return true;
    }

    public int indexOf(Item value) {
        return index(value);
    }

    private int index(Item value) {
        Node current = firstItem;
        int index = 0;
        while (current != null) {
            if (current.value.equals(value)) {
                return index;
            }
            current = current.nextItem;
            index++;
        }
        return -1;
    }

    public boolean contains(Item value) {
        return index(value) > -1;
    }

    public Item getFirst() {
        return (Item) firstItem.value;
    }

    // извлечение элемента из конца списка
    public Item getLast() {
        return (Item) lastItem.value;
    }

    //список пуст
    public boolean isEmpty() {
        return firstItem == null;
    }

    public int size() {
        return size;
    }

    @Override
    public String toString() {
        if (isEmpty()) {
            return "[ ]";
        }
        Node current = firstItem;
        StringBuilder sb = new StringBuilder("[ ");

        while (current != null) {
            sb.append(current.value.toString() + ", ");
            current = current.nextItem;
        }
        sb.delete(sb.length() - 2, sb.length());
        sb.append(" ]");
        return sb.toString();
    }
}
