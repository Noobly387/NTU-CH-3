package seven;

public class Ball {
    float x;
    float y;
    float z;

    Ball(float x, float y, float z) {
        this.x = x;
        this.y = y;
        this.z= z;
    }

    public float getX() {
        return this.x;
    }

    public float getY() {
        return this.y;
    }

    public float getZ() {
        return this.z;
    }

    public void setXYX(float x, float y, float z) {
        this.x = x;
        this.y = y;
        this.z= z;
    }

    @Override
    public String toString() {
        return "(" + x + ", " + y + ", " + z + ")";
    }
}