package three;
import java.math.BigInteger;
public class TestBigInteger{
    /**
     * Tests BigInteger
     * @param args doesn't matter, not used
     */
    public static void main(String...args) {
        BigInteger int1 = new BigInteger("11111111111111111111111111111111111111111111111111111111111111");
        BigInteger int2 = new BigInteger("22222222222222222222222222222222222222222222222222");
        System.out.println(int1.add(int2));
        System.out.println(int1.multiply(int2));
    }
}