package four;

public class TestMyTime {
    public static void main(String... args) {
        MyTime time = new MyTime();

        try {
            System.out.println("trying to put 24:59:59");
            time = new MyTime(24, 59, 59);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("alright alright putting 23:59:59");
        time = new MyTime(23,59,59);
        System.out.println(time.toString());
        
        System.out.println(time.nextHour().toString() + " next hour");
        System.out.println(time.previousHour().toString()+ " going back");

        System.out.println();

        System.out.println(time.nextSecond().toString() + " a second passes");
        System.out.println(time.previousSecond().toString() + " entropy goes nuts");
        time.setTime(10, 10, 10);
        System.out.println(time.toString() + " idk what's even happening anymore");

    }
}