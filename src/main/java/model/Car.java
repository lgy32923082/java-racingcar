package model;

public class Car {
    private final String name;
    private final int GOANDSTOP = 4;
    private int position = 0;

    public Car(String name){
        this.name = name;
    }

    public int getPosition(){
        return this.position;
    }

    public String getName(){
        return this.name;
    }

    public void moveCar(int randomNum){
        if (randomNum >= GOANDSTOP) {
            this.position++;
        }
    }
}