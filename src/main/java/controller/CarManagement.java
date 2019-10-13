package controller;

import model.Car;
import view.CarView;
import java.util.ArrayList;
import java.util.List;

public class CarManagement {

    private final int playCount;
    private int winCount = 0;
    private List<Car> car;
    private List<String> cars;
    CarView carView;

    public CarManagement(){
        car = new ArrayList<>();
        carView = new CarView();
        cars = carView.setName(car);
        addCar();
        playCount = carView.setPlayCount();
        carView.playScreen();
        run();
    }

    public void moveCar(){
        for (int i = 0; i <car.size(); i++) {
            int randomNum = (int)(Math.random() * 10);
            car.get(i).moveCar(randomNum);
        }
    }

    public void addCar(){
        for (int i = 0; i <cars.size() ; i++) {
            checkName(i);
            car.add(new Car(cars.get(i)));
        }
    }

    public void checkName(int index){
         if(cars.get(index).length()>5){
             carView.nameWarningMessage();
             reName(index);
         }
    }

    public void reName(int index){
        while(cars.get(index).length()>5){
            carView.reNameMessage(cars,index);
            carView.setReName(cars,index);
        }
    }

    public void win(int index){
        if(car.get(index).getPosition()>getWinCount()){
            setWinCount(car.get(index).getPosition());
        }
    }

    public void showRun(){
        for (int i = 0; i <car.size(); i++) {
            carView.showUserPrint(car,i);
        }
        carView.enter();
    }

    public void winner(){
        for (int i = 0; i <car.size(); i++) {
            win(i);
        }
    }

    public void setWinCount(int winCount) {
        this.winCount = winCount;
    }

    public int getWinCount() {
        return this.winCount;
    }

    public void run(){
        for (int i = 0; i <playCount; i++) {
            moveCar();
            showRun();
        }
        winner();
        carView.winMessage();
        for (int i = 0; i <car.size() ; i++) {
            carView.winnerPrint(car,i,getWinCount());
        }
    }
}
