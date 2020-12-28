package PingPong;

public class PingPongThread extends Thread {

    PingPongThread(String name) {
        this.setName(name);
    }

    @Override
    public void run() {
        Ball ball = Ball.getBall();
        while (ball.isInGame()) {
            game(ball);
        }
    }

    private void game(Ball ball) {
        if (!ball.getSide().equals(getName())) {
            ball.strikeBall(getName());
        }
    }

}
