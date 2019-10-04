import java.util.ArrayList;
import java.util.Scanner;

public class Car {
    private final String name;
    private int position = 0;
    private int randomNum = 0;

    public Car(String name){
        this.name = name;
    }

    public int getPosition(){
        return this.position;
    }

    public String getName(){
        return this.name;
    }

    public void showCar(){
        System.out.print(this.name + " : ");
        draw();
    }

    public void draw(){
        for(int i=0; i<position; i++){
            System.out.print("-");
        }
        System.out.println();
    }

    public void setRandomNum(){
        randomNum = (int)(Math.random() * 10);
        if(randomNum >= 4){
            this.position++;
        }
    }



}