package PingPong;

public class Ball {

    private int strikes = 0;
    private static Ball instance = new Ball();
    private String side = "";

    private Ball() {
    }

    static Ball getBall() {
        return instance;
    }

    String getSide() {
        return side;
    }

    boolean isInGame() {
        return (strikes < 10);
    }

    synchronized void strikeBall(String playerName) {
        strikes++;
        side = playerName;
        System.out.println(strikes + " " + side);
    }

}
