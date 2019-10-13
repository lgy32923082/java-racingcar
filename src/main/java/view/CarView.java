package view;

import model.Car;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class CarView {
    private final Scanner scanner;

    public CarView(){
        scanner = new Scanner(System.in);
    }

    public int setPlayCount(){
        System.out.println("input play count : ");
        int playCount = scanner.nextInt();
        return playCount;
    }

    public List<String> setName(List<Car> car){
        System.out.println("input car names (names split by ,) : ");
        String carNames = scanner.nextLine();
        List<String> cars = Arrays.asList(carNames.split(","));
        return cars;
    }

    public void setReName(List<String> cars, int index){
        cars.set(index,scanner.nextLine());
    }

    public void nameWarningMessage(){
        System.out.println("Reduce name length");
    }

    public void reNameMessage(List<String> cars, int index){
        System.out.println(cars.get(index) + " : name length = " + cars.get(index).length());
        System.out.println("input car name ( Limit name length : 5)");
    }

    public void showUserPrint(List<Car> car, int length){
        int moveCount = car.get(length).getPosition();
        System.out.print(car.get(length).getName() + " : ");
        carMovePrint(moveCount);
        System.out.println();
    }

    public void enter(){
        System.out.println();
    }

    public void carMovePrint(int moveCount){
        for(int i=0; i<moveCount; i++){
            System.out.print("-");
        }
    }

    public void playScreen(){
        System.out.println("\nResult ");
    }

    public void winMessage(){
        System.out.println("Winner!!");
    }

    public void winnerPrint(List<Car> car,int length, int winCount){
        if(car.get(length).getPosition() == winCount){
            System.out.print(car.get(length).getName() + " ");
        }
    }
}