package seven;

public class Player {
    int number;
    float x;
    float y;
    float z = 0.0f;

    Player(int number, float x, float y) {
        this.number = number;
        this.x = x;
        this.y = y;
    }

    public void move(float xDisp, float yDisp) {
        this.x += xDisp;
        this.y += yDisp;
    }

    public void jump(float zDisp) {
        this.y += zDisp;
    }

    public boolean near(Ball ball) {
        if (Math.sqrt(
                Math.abs(ball.getX() - this.x) + Math.abs(ball.getY() - this.y) + Math.abs(ball.getZ() - this.z)) < 8) {
            return true;
        } else {
            return false;
        }
    }

    public void kick(Ball ball) {
        if (number >= 11) {
            ball.setXYX(-1 + ball.getX(), ball.getY(), 0.0f);
        } else {
            ball.setXYX(1 + ball.getX(), ball.getY(), 0.0f);
        }
    }
}