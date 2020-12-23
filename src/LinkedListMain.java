import java.util.ListIterator;

public class LinkedListMain {

    public static void main(String[] args) {


        LinkedListExample<String> myLinkedList = new LinkedListExample<>();
        myLinkedList.insertFirst("Katia");
        myLinkedList.insertFirst("Maria");
        myLinkedList.insertFirst("Luba");
        myLinkedList.insertFirst("Luba");
        myLinkedList.insertFirst("Luba");

        System.out.println(myLinkedList);
        myLinkedList.insertLast("Sania");
        System.out.println(myLinkedList);

        myLinkedList.insert(3, "Petia");
        System.out.println(myLinkedList);

        myLinkedList.remove("Luba");
        System.out.println(myLinkedList);

        for (String s : myLinkedList) {
            System.out.print(s + " ");
        }

        // реализация ListIterator
        ListIterator<String> iterator = myLinkedList.listIterator();
        while(iterator.hasNext()){
            String element = iterator.next();
            iterator.set(element + "*");
        }

        System.out.println("ListIterator в обратном порядке:");
        while (iterator.hasPrevious()) {
            String element = iterator.previous();
            System.out.print(element + " ");
        }

    }
}
