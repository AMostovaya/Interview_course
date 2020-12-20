package Errors;

class LightWeightCar extends Car implements Moveable {
    @Override
    void open() {
        System.out.println("Car is open");
    }

    @Override
    public void Move() {
        System.out.println("Car is moving");
    }
}
