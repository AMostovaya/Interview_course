package Errors;

class Lorry extends Car, Moveable, Stoppable { // интерфейсы Moveable, Stoppable должны быть помечены как implemenets

    public void Move() { // метод не является переопределяемым
        System.out.println("Car is moving");
    }

    public void Stop() { // метод не является переопределяемым
        System.out.println("Car is stop");
    }

    // не переопределен метод open() абстрактного класса Car
}
