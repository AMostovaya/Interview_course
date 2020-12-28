import PingPong.PingPong;


public class GameMain {

    public static void main(String[] args) throws InterruptedException {
        
        PingPong pingPong = new PingPong();
        pingPong.startGame();

        Counter counter1 = new Counter();
        Counter counter2 = new Counter();
        Counter counter3 = new Counter();

        counter1.start();
        counter2.start();
        counter3.start();
        
    }
}
