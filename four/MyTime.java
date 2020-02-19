package four;

public class MyTime {
    private int hour;
    private int minute;
    private int second;

    public MyTime() {
        this.hour = 0;
        this.minute = 0;
        this.second = 0;
    }

    public MyTime(int hour, int minute, int second) throws IllegalArgumentException {
        if (hour < 0 || hour > 23) {
            throw new IllegalArgumentException("Hour is out of bounds dumdum");
        } else if (minute < 0 || minute > 59) {
            throw new IllegalArgumentException("Minute is out of bounds dummy");
        } else if (second < 0 || second > 59) {
            throw new IllegalArgumentException("Second is out of bounds testing humanoid");
        } else {
            this.hour = hour;
            this.minute = minute;
            this.second = second;
        }
    }

    public void setTime(int hour, int minute, int second) throws IllegalArgumentException {
        if (hour < 0 || hour > 23) {
            throw new IllegalArgumentException("Hour is out of bounds dumdum");
        } else if (minute < 0 || minute > 59) {
            throw new IllegalArgumentException("Minute is out of bounds dummy");
        } else if (second < 0 || second > 59) {
            throw new IllegalArgumentException("Second is out of bounds testing humanoid");
        } else {
            this.hour = hour;
            this.minute = minute;
            this.second = second;
        }
    }

    public int getHour() {
        return hour;
    }

    public int getMinute() {
        return minute;
    }

    public int getSecond() {
        return second;
    }

    public void setHour(int hour) {
        if (hour < 0 || hour > 23) {
            throw new IllegalArgumentException("Hour is out of bounds dumdum");
        } else {
            this.hour = hour;
        }
    }

    public void setMinute(int minute) {
        if (minute < 0 || minute > 59) {
            throw new IllegalArgumentException("Minute is out of bounds dummy");
        } else {
            this.minute = minute;
        }
    }

    public void setSecond(int second) {
        if (second < 0 || second > 59) {
            throw new IllegalArgumentException("Second is out of bounds testing humanoid");
        } else {
            this.second = second;
        }
    }

    @Override
    public String toString() {
        String[] times = new String[3];
        times[0] = ""+this.hour;
        times[1] = ""+this.minute;
        times[2] = ""+this.second;
        for(int i = 0; i < 3; i++){
            if(times[i].length()!=2){
                times[i]='0'+times[i];
            }
        }
        return times[0] +':'+times[1]+':'+times[2];
    }

    public MyTime nextSecond() {
        if (this.second == 59) {
            this.second = 0;
            nextMinute();
        } else {
            this.second++;
        }
        return this;
    }

    public MyTime nextMinute() {
        if (this.minute == 59) {
            this.minute = 0;
            nextHour();
        } else {
            this.hour++;
        }
        return this;
    }

    public MyTime nextHour() {
        if (this.hour == 23) {
            this.hour = 0;
        } else {
            this.hour++;
        }
        return this;
    }

    public MyTime previousSecond() {
        if (this.second == 0) {
            this.second = 59;
            previousMinute();
        } else {
            this.second--;
        }
        return this;
    }

    public MyTime previousMinute() {
        if (this.minute == 0) {
            this.minute = 59;
            previousHour();
        } else {
            this.minute--;
        }
        return this;
    }

    public MyTime previousHour() {
        if (this.hour == 0) {
            this.hour = 23;
        } else {
            this.hour--;
        }
        return this;
    }
}