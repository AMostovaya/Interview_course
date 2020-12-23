import java.util.*;

public class ArrayListClass {

    public static void main(String[] args) {

        ArrayList<Student> students = new ArrayList<>();
        students.ensureCapacity(7);

        students.add(new Student("Ivanov", "Boris", 21));
        students.add(new Student("Sidorova", "Svetlana", 20));
        students.add(new Student("Petrov", "Petr", 18));
        students.add(new Student("Lenkov", "Andrey", 23));
        students.add(new Student("Ivanov", "Artem", 21));

        // Поиск элементов по индексу
        Student studentThird = students.get(3);
        System.out.println(studentThird);

        // Перебор элементов
        String nameSurname = "";
        for (Student student: students ) {
            nameSurname = nameSurname + student + " ";
        }

        System.out.println(nameSurname);

        // Поиск элемента по содержимому
        System.out.println(nameSurname.contains("Ivanov"));

        // Удаление элемента по индексу
        students.remove(0);

        // Сортировка
        List<Integer> items = new ArrayList<>();
        items.add(23);
        items.add(21);
        items.add(333);
        items.add(54);
        Collections.sort(items);
        System.out.println(items.toString());

        // ListIterator
        ArrayList<Integer> items_ = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
        ListIterator iterator = items_.listIterator();
        System.out.println("Iterating in forward direction: ");
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        System.out.println();
        System.out.println("Iterating in backward direction: ");
        while (iterator.hasPrevious()) {
            System.out.println(iterator.previous());
        }

    }
}
