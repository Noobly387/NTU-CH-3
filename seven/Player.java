package seven;

import java.util.concurrent.ThreadLocalRandom;

public class Player {
    int number;
    float x;
    float y;
    float z = 0.0f;
    ThreadLocalRandom local;

    /**
     * Constructs players with fields
     * 
     * @param number number
     * @param x      x
     * @param y      y
     */
    Player(int number, float x, float y) {
        local = ThreadLocalRandom.current();
        this.number = number;
        this.x = x;
        this.y = y;
    }

    /**
     * Moves the player based on a random number to add some spice
     * 
     * @param xDisp horizontal direction of movement
     * @param yDisp vertical direction of movement
     */
    public void move(float xDisp, float yDisp) {
        if (xDisp > 0) {
            x += local.nextInt(5);
        } else {
            x -= local.nextInt(5);
        }
        if (yDisp > 0) {
            y += local.nextInt(5);
        } else {
            y -= local.nextInt(5);
        }
    }

    /**
     * Jumping.
     * 
     * @param zDisp Increases height
     */
    public void jump(float zDisp) {
        this.z += zDisp;
    }

    /**
     * Determines if ball is in range to kick
     * 
     * @param ball ball being examined
     * @return whether it is or not
     */
    public boolean near(Ball ball) {
        if (Math.sqrt(Math.pow(ball.getX() - this.x, 2) + Math.pow(ball.getY() - this.y, 2)
                + Math.pow(ball.getZ() - this.z, 2)) < 8) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * moves the ball a random amount
     * 
     * @param ball ball to move
     */
    public void kick(Ball ball) {
        if (number >= 11) {
            ball.setXYX(local.nextInt(5) + ball.getX(), ball.getY(), 0.0f);
        } else {
            ball.setXYX(-local.nextInt(5) + ball.getX(), ball.getY(), 0.0f);
        }
    }
}