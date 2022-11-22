import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.util.Scanner;

class information {
    private int day;

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    private int month;

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    private int year;

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    private float kilometers;

    public float getKilometers() {
        return kilometers;
    }

    public void setKilometers(float kilometers) {
        this.kilometers = kilometers;
    }

    String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private float time;

    public float getTime() {
        return time;
    }

    public void setTime(float time) {
        this.time = time;
    }

    private DayOfWeek dayOfWeek;

    public DayOfWeek getDayOfWeek() {
        return dayOfWeek;
    }

    public void setDayOfWeek(DayOfWeek dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
    }

    float totalForCompany1;

    public float getTotalForCompany1() {
        return totalForCompany1;
    }

    public void setTotalForCompany1(float totalForCompany1) {
        this.totalForCompany1 = totalForCompany1;
    }

    float totalForCompany2;

    public float getTotalForCompany2() {
        return totalForCompany2;
    }

    public void setTotalForCompany2(float totalForCompany2) {
        this.totalForCompany2 = totalForCompany2;
    }

    float totalForCompany3;

    public float getTotalForCompany3() {
        return totalForCompany3;
    }

    public void setTotalForCompany3(float totalForCompany3) {
        this.totalForCompany3 = totalForCompany3;
    }
}

public class rideSharing {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        for (int i = 1; i < 70; i++) {
            System.out.printf("*");
        }
        System.out.println("");
        System.out.println("WELCOME TO RIDE-SHARING CHARGES ESTIMATOR AND COMPARISON SYSTEM \n");
        System.out.println("Developed by Vatsal, 0123");
        System.out.println("OODP101 Object Oriented Design and Programming \n");
        java.util.Date date = new java.util.Date();
        System.out.println(date + "\n");
        for (int i = 1; i < 70; i++) {
            System.out.printf("*");
        }
        System.out.println("");
        int choice, MonthofTravel, DateOfTravel;
        float ApproximateKilometerTravel;
        DayOfWeek dayOfWeek;
        int year = 2021;
        float TimeOfTravel;
        String name;
        information information = new information();
        do {
            System.out.println("1. Enter Usage Details");
            System.out.println("2. Dispaly charges under OLA");
            System.out.println("3. Dispaly charges under UBER");
            System.out.println("4. Dispaly charges under RAPIDO");
            System.out.println("5. Show Report");
            System.out.println("6. Exit");
            System.out.println("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine();
            switch (choice) {
                case 1:
                    System.out.println("Enter your name: ");
                    name = sc.next();
                    information.setName(name);

                    System.out.println("Enter your approximate kilometers of travel: ");
                    ApproximateKilometerTravel = sc.nextInt();
                    information.setKilometers(ApproximateKilometerTravel);

                    do {
                        System.out.println("Month of travel: ");
                        MonthofTravel = sc.nextInt();

                    } while (MonthofTravel < 1 || MonthofTravel > 12);
                    information.setMonth(MonthofTravel);

                    do {
                        System.out.println("On which date of this month , you wish to travel!!");
                        DateOfTravel = sc.nextInt();

                    } while (DateOfTravel < 1 || DateOfTravel > 31);
                    information.setDay(DateOfTravel);

                    System.out.println(
                            "Now enter the time of travel using 24 hour clock just like 9.00 for 9am, 13.00 for 1 pm, 14.30 for 2:30pm etc");
                    do {
                        TimeOfTravel = sc.nextFloat();
                    } while (TimeOfTravel < 0.00 || TimeOfTravel > 24.00);
                    information.setTime(TimeOfTravel);

                    LocalDate localDate = LocalDate.of(year, MonthofTravel, DateOfTravel);
                    dayOfWeek = localDate.getDayOfWeek();
                    information.setDayOfWeek(dayOfWeek);
                    System.out.println("Enter your choice using numbers");
                    break;

                case 2:
                    System.out.println("Dispaly Charges under OLA");
                    TimeOfTravel = information.getTime();
                    ApproximateKilometerTravel = information.getKilometers();
                    float perKm = (float) 0.75;
                    float baseCharges = (float) 5.50;
                    float peakTimeCharge = (float) 2.50;
                    float weekendCharge = (float) 3.00;
                    dayOfWeek = information.getDayOfWeek();
                    System.out.println("Your travel details:- Day of the week on " + information.getDay()
                            + " of the month - " + Month.of(information.getMonth()) + " is "
                            + information.getDayOfWeek());
                    if (TimeOfTravel >= 7.00 && TimeOfTravel <= 9.00
                            || TimeOfTravel >= 16.00 && TimeOfTravel <= 18.00) {
                        if (dayOfWeek.getValue() == 6 || dayOfWeek.getValue() == 7) {
                            information.totalForCompany1 = baseCharges + ApproximateKilometerTravel * perKm
                                    + peakTimeCharge
                                    + weekendCharge;
                            System.out.println("\nYour day of travels does falls under weekend categories");
                            System.out.println(
                                    "\nTime falls in peaktime category and it is weekend \n\nSo charges will be applied accordingly\n");
                        } else {
                            information.totalForCompany1 = baseCharges + ApproximateKilometerTravel * perKm
                                    + peakTimeCharge;
                            System.out.println("\nYour day of travels does not falls under weekend categories");
                            System.out.println(
                                    "\nTime falls in peaktime category \n\nSo charges will be applied accordingly\n");
                        }
                    } else {
                        information.totalForCompany1 = baseCharges + ApproximateKilometerTravel * perKm;
                    }
                    System.out.println("The final charges under OLA is: " + information.totalForCompany1);
                    for (int i = 1; i < 70; i++) {
                        System.out.printf("*");
                    }
                    System.out.println("");
                    break;

                case 3:
                    System.out.println("Dispaly Charges under UBER");
                    TimeOfTravel = information.getTime();
                    ApproximateKilometerTravel = information.getKilometers();
                    float perKm2 = (float) 0.85;
                    float baseCharges2 = (float) 4.50;
                    float peakTimeCharge2 = (float) 2.00;
                    float weekendCharge2 = (float) 2.50;
                    dayOfWeek = information.getDayOfWeek();
                    System.out.println("Your travel details:- Day of the week on " + information.getDay()
                            + " of the month - " + Month.of(information.getMonth()) + " is "
                            + information.getDayOfWeek());
                    if (TimeOfTravel >= 7.00 && TimeOfTravel <= 9.00
                            || TimeOfTravel >= 16.00 && TimeOfTravel <= 18.00) {
                        if (dayOfWeek.getValue() == 6 || dayOfWeek.getValue() == 7) {
                            information.totalForCompany2 = baseCharges2 + ApproximateKilometerTravel * perKm2
                                    + peakTimeCharge2 + weekendCharge2;
                            System.out.println("\nYour day of travels does falls under weekend categories");
                            System.out.println(
                                    "\nTime falls in peaktime category and it is weekend \n\nSo charges will be applied accordingly\n");
                        } else {
                            information.totalForCompany2 = baseCharges2 + ApproximateKilometerTravel * perKm2
                                    + peakTimeCharge2;
                            System.out.println("\nYour day of travels does not falls under weekend categories");
                            System.out.println(
                                    "\nTime falls in peaktime category \n\nSo charges will be applied accordingly\n");
                        }
                    } else {
                        information.totalForCompany2 = baseCharges2 + ApproximateKilometerTravel * perKm2;
                    }
                    System.out.println("The final charges under UBER is: " + information.totalForCompany2);
                    for (int i = 1; i < 70; i++) {
                        System.out.printf("*");
                    }
                    System.out.println("");
                    break;

                case 4:
                    System.out.println("Dispaly Charges under RAPIDO: ");
                    TimeOfTravel = information.getTime();
                    ApproximateKilometerTravel = information.getKilometers();
                    float perKm3 = (float) 0.85;
                    float baseCharges3 = (float) 5.50;
                    float peakTimeCharge3 = (float) 2.00;
                    float weekendCharge3 = (float) 3.50;
                    dayOfWeek = information.getDayOfWeek();
                    System.out.println("Your travel details:- Day of the week on " + information.getDay()
                            + " of the month - " + Month.of(information.getMonth()) + " is "
                            + information.getDayOfWeek());
                    if (TimeOfTravel >= 7.00 && TimeOfTravel <= 9.00
                            || TimeOfTravel >= 16.00 && TimeOfTravel <= 18.00) {
                        if (dayOfWeek.getValue() == 6 || dayOfWeek.getValue() == 7) {
                            information.totalForCompany3 = baseCharges3 + ApproximateKilometerTravel * perKm3
                                    + peakTimeCharge3 + weekendCharge3;
                            System.out.println("\nYour day of travels does falls under weekend categories");
                            System.out.println(
                                    "\nTime falls in peaktime category and it is weekend \n\nSo charges will be applied accordingly\n");
                        } else {
                            information.totalForCompany3 = baseCharges3 + ApproximateKilometerTravel * perKm3
                                    + peakTimeCharge3;
                            System.out.println("\nYour day of travels does not falls under weekend categories");
                            System.out.println(
                                    "\nTime falls in peaktime category \n\nSo charges will be applied accordingly\n");
                        }
                    } else {
                        information.totalForCompany3 = baseCharges3 + ApproximateKilometerTravel * perKm3;
                    }
                    System.out.println("The final charges under RAPIDO is: " + information.totalForCompany3);
                    for (int i = 1; i < 70; i++) {
                        System.out.printf("*");
                    }
                    System.out.println("");
                    break;

                case 5:
                    System.out.println("Show Report");
                    if (information.totalForCompany1 > information.totalForCompany2) {
                        System.out.println("The OLA is Most Expensive Company: " + information.totalForCompany1);
                    } else if (information.totalForCompany2 > information.totalForCompany3) {
                        System.out.println("The UBER is Most Expensive Company: " + information.totalForCompany2);
                    } else {
                        System.out.println("The RAPIDO is Most Expensive Company: " + information.totalForCompany3);
                    }
                    break;

                case 6:
                    System.out.println("Exit");
                    System.out.print("Thank you " + information.getName() +
                            " for using the system \n All values have been resert to zero or null \n Good Bye......");
                    information.setDay(0);
                    information.setMonth(0);
                    information.setYear(0);
                    information.setKilometers(0);
                    information.setTime(0);
                    information.setDayOfWeek(null);
                    break;

                default:
                    System.out.println("Error!!!! You have enterd invalid value!!! Please enter valid value");
            }
        } while (choice != 6);
        sc.close();
    }
}
