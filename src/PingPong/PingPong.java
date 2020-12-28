package PingPong;

public class PingPong {

    private PingPongThread player1 = new PingPongThread("Ping");
    private PingPongThread player2 = new PingPongThread("Pong");

    public PingPong() {
        Ball ball = Ball.getBall();
    }

    public void startGame() throws InterruptedException {
        player1.start();
        player2.start();
    }
}
