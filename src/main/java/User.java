import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class User {
    Scanner scanner = new Scanner(System.in);
    private int playCount=0;
    private int winCount=0;
    private String carNames;
    private String arrCarName[];
    private ArrayList<Car> car = new ArrayList<>();

    public User(){
        set();
        repeatGame(this.playCount);
    }

    //기본 셋팅을 설정하는함수
    public void set(){
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분");
        carNames = scanner.nextLine();
        arrCarName = carNames.split(",");
        //car 객체 생성
        for(int i=0; i<arrCarName.length; i++){
            car.add(new Car(arrCarName[i]));
        }
        System.out.println("시도를 회수는 몇 회인가요?");
        this.playCount = scanner.nextInt();

        System.out.println("\n실행화면");
    }

    public void showUser(int length){
        car.get(length).showCar();
    }

    public void repeatGame(int playCount){
        for(int i=0; i<playCount; i++){
            run();
            System.out.println();
        }

        for(int i=0; i<arrCarName.length; i++){
            winner(i);
        }

    }

    public void run(){
        for(int i=0; i<arrCarName.length; i++) {
            car.get(i).setRandomNum();
            showUser(i);
            setWinCount(i);
        }
    }

    public void setWinCount(int length){
        if(winCount < car.get(length).getPosition()){
            winCount = car.get(length).getPosition();
        }
    }

    public void winner(int length){
        if(winCount == car.get(length).getPosition()){
            System.out.print(car.get(length).getName()+" ");
            System.out.println("가 최종 우승했습니다.");
        }

    }

}