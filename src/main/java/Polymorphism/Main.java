package Polymorphism;

public class Main {
    public static void main(String[] args) {
        Shape[] figure = new Shape[]{new Shape(), new Square(), new Circle(), new Triangle()};

        for (int i = 0; i<figure.length; i++) {
            figure[i].Draw();
        }
    }
}
