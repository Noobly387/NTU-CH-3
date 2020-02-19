package five;

public class MyDate {
    private int year;
    private int month;
    private int day;
    private static String[] strMonths = new String[] { "Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep",
            "Oct", "Nov", "Dec" };
    private static String[] strDays = new String[] { "Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday",
            "Saturday" };
    private static int[] dayInMonths = new int[] { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

    /**
     * Tests.
     */
    public static void main(String... args) {
        MyDate d1 = new MyDate(2012, 2, 28);
        System.out.println(d1); // Tuesday 28 Feb 2012
        System.out.println(d1.nextDay()); // Wednesday 29 Feb 2012
        System.out.println(d1.nextDay()); // Thursday 1 Mar 2012
        System.out.println(d1.nextMonth()); // Sunday 1 Apr 2012
        System.out.println(d1.nextYear()); // Monday 1 Apr 2013

        MyDate d2 = new MyDate(2012, 1, 2);
        System.out.println(d2); // Monday 2 Jan 2012
        System.out.println(d2.previousDay()); // Sunday 1 Jan 2012
        System.out.println(d2.previousDay()); // Saturday 31 Dec 2011
        System.out.println(d2.previousMonth()); // Wednesday 30 Nov 2011
        System.out.println(d2.previousYear()); // Tuesday 30 Nov 2010

        MyDate d3 = new MyDate(2012, 2, 29);
        System.out.println(d3.previousYear()); // Monday 28 Feb 2011
        try {
            MyDate d4 = new MyDate(2099, 11, 31); // Invalid year, month, or day!
            System.out.println(d4.toString());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        try {
            MyDate d5 = new MyDate(2011, 2, 29); // Invalid year, month, or day!
            System.out.println(d5.toString());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        MyDate date = new MyDate(2011, 10, 28);
        while(true){
            if(date.getYear()!=2012 || date.getMonth()!=3 || date.getDay() != 2){
                System.out.println(date.nextDay());
            }else{
                System.out.println(date);
                break;
            }
        }
    }

    /**
     * Checks if year is a leap
     * 
     * @param year year to check
     * @return whether it is or isn't a leap
     */
    public static boolean isLeapYear(int year) {
        if (year % 400 == 0) {
            return true;
        } else if (year % 100 == 0) {
            return false;
        } else if (year % 4 == 0) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Checks whether the paramters are within valid ranges
     * 
     * @param year  to check
     * @param month to check
     * @param day   to check
     * @return whether it is a valid date or not
     */
    public static boolean isValidDate(int year, int month, int day) {
        if (year > 9999 || year < 1) {
            return false;
        } else if (month > 12 || month < 1) {
            return false;
        } else if (isLeapYear(year) && month == 2 && day == 29) {
            return true;
        } else if (day > dayInMonths[month - 1] || day < 1) {
            return false;
        } else {
            return true;
        }
    }

    /**
     * What day of the week it is based on the date
     * 
     * @param year  to check
     * @param month to check
     * @param day   to check
     * @return day of week
     * @throws IllegalArgumentException if date is invalid
     */
    public static int getDayOfWeek(int year, int month, int day) throws IllegalArgumentException {
        if (!isValidDate(year, month, day)) {
            throw new IllegalArgumentException("Invalid date");
        }
        int fTwo = year / 100;
        int cent;
        int lTwo = year % 100;
        int frac = lTwo / 4;
        int num = 0;
        switch (fTwo % 4) {
        case 1:
            cent = 4;
        case 2:
            cent = 2;
        case 3:
            cent = 0;
        default:
            cent = 6;
        }
        if (!isLeapYear(year)) {
            if (month == 1) {
                num = 0;
            }
            if (month == 2) {
                num = 3;
            }
            if (month == 3) {
                num = 3;
            }
            if (month == 4) {
                num = 6;
            }
            if (month == 5) {
                num = 1;
            }
            if (month == 6) {
                num = 4;
            }
            if (month == 7) {
                num = 6;
            }
            if (month == 8) {
                num = 2;
            }
            if (month == 9) {
                num = 5;
            }
            if (month == 10) {
                num = 0;
            }
            if (month == 11) {
                num = 3;
            }
            if (month == 12) {
                num = 5;
            }
        } else {
            if (month == 1) {
                num = 6;
            }
            if (month == 2) {
                num = 2;
            }
            if (month == 3) {
                num = 3;
            }
            if (month == 4) {
                num = 6;
            }
            if (month == 5) {
                num = 1;
            }
            if (month == 6) {
                num = 4;
            }
            if (month == 7) {
                num = 6;
            }
            if (month == 8) {
                num = 2;
            }
            if (month == 9) {
                num = 5;
            }
            if (month == 10) {
                num = 0;
            }
            if (month == 11) {
                num = 3;
            }
            if (month == 12) {
                num = 5;
            }
        }
        return (cent + lTwo + frac + num + day) % 7;
    }

    /**
     * Constructs MyDate with the dates passed
     * 
     * @param year  for field
     * @param month for field
     * @param day   for field
     * @throws IllegalArgumentException if date is invalid
     */
    public MyDate(int year, int month, int day) throws IllegalArgumentException {
        if (!isValidDate(year, month, day)) {
            throw new IllegalArgumentException("Invalid year, month, or day");
        } else {
            this.year = year;
            this.month = month;
            this.day = day;
        }
    }

    /**
     * Sets the date of the instance
     * 
     * @param year  for field
     * @param month for field
     * @param day   for field
     * @throws IllegalArgumentException if date is invalid
     */
    public void setDate(int year, int month, int day) throws IllegalArgumentException {
        if (!isValidDate(year, month, day)) {
            throw new IllegalArgumentException("Invalid year, month, or day");
        } else {
            this.year = year;
            this.month = month;
            this.day = day;
        }
    }

    /**
     * Returns year
     * 
     * @return year
     */
    public int getYear() {
        return this.year;
    }

    /**
     * returns month
     * 
     * @return month
     */
    public int getMonth() {
        return this.month;
    }

    /**
     * returns day
     * 
     * @return day
     */
    public int getDay() {
        return this.day;
    }

    /**
     * Sets year if within bounds
     * 
     * @param year for field
     * @throws IllegalArgumentException if out of bounds
     */
    public void setYear(int year) throws IllegalArgumentException {
        if (year > 9999 || year < 1) {
            throw new IllegalArgumentException("Invalid year");
        } else {
            this.year = year;
        }
    }

    /**
     * Sets month within bounds
     * 
     * @param month for field
     * @throws IllegalArgumentException if out of bounds
     */
    public void setMonth(int month) throws IllegalArgumentException {
        if (month > 12 || month < 1) {
            throw new IllegalArgumentException("Invalid month");
        } else {
            this.month = month;
        }
    }

    /**
     * Sets day within bounds of month
     * 
     * @param day for field
     * @throws IllegalArgumentException if out of bounds
     */
    public void setDay(int day) throws IllegalArgumentException {
        if (day > dayInMonths[this.month - 1] || day < 1) {
            throw new IllegalArgumentException("Invalid day");
        } else {
            this.day = day;
        }
    }

    @Override
    public String toString() {
        return strDays[getDayOfWeek(this.year, this.month, this.day)] + ' ' + this.day + ' ' + strMonths[this.month - 1]
                + ' ' + this.year;
    }

    /**
     * Increments the date by one day
     * 
     * @return the instance
     * @throws IllegalStateException if incrementation is not possible
     */
    public MyDate nextDay() throws IllegalStateException {
        if (isLeapYear(this.year) && this.month == 2 && this.day == 28) {
            this.day++;
        } else if (this.day >= dayInMonths[this.month - 1]) {
            try {
                nextMonth();
            } catch (IllegalStateException e) {
                throw e;
            }
            this.day = 1;
        } else {
            this.day++;
        }
        return this;
    }

    /**
     * Increments the date by one month
     * 
     * @return the instance
     * @throws IllegalStateException if incrementation is not possible
     */
    public MyDate nextMonth() throws IllegalStateException {
        if (this.month == 12) {
            try {
                nextYear();
            } catch (IllegalStateException e) {
                throw e;
            }
            this.month = 1;
            this.day = dayInMonths[0];
        } else {
            this.month++;
            if (this.day == dayInMonths[this.month - 2]) {
                this.day = dayInMonths[this.month - 1];
            }
        }
        return this;
    }

    /**
     * Increments the date by one year
     * 
     * @return the instance
     * @throws IllegalStateException if incrementation is not possible
     */
    public MyDate nextYear() throws IllegalStateException {
        if (this.year == 9999) {
            throw new IllegalStateException("Year out of range");
        } else {
            this.year++;
        }
        return this;
    }

    /**
     * Decrements the date by one day
     * 
     * @return the instance
     * @throws IllegalStateException if decrementation is not possible
     */
    public MyDate previousDay() throws IllegalStateException {
        if (this.day == 1) {
            try {
                previousMonth();
                this.day = dayInMonths[this.month - 1];
            } catch (IllegalStateException e) {
                throw e;
            }
        } else {
            this.day--;
        }
        return this;
    }

    /**
     * Decrements the date by one month
     * 
     * @return the instance
     * @throws IllegalStateException if decrementation is not possible
     */
    public MyDate previousMonth() {
        if (this.month == 1) {
            try {
                previousYear();
                this.month = 12;
            } catch (IllegalStateException e) {
                throw e;
            }
        } else {
            this.month--;
            if (this.day == dayInMonths[this.month]) {
                this.day = dayInMonths[this.month - 1];
            }
        }
        return this;
    }

    /**
     * Decrements the date by one year
     * 
     * @return the instance
     * @throws IllegalStateException if decrementation is not possible
     */
    public MyDate previousYear() {
        if (this.year == 1) {
            throw new IllegalStateException("Year out of range");
        } else {
            this.year--;
            if (this.day == 29) {
                this.day = 28;
            }
        }
        return this;
    }
}