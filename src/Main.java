import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> listArrDip = new ArrayList<>();
        char isRunning = 't';
        while (isRunning == 't') {
            try {
                listArrDip.clear();
                System.out.print("Arrival day ");
                listArrDip.add(scanner.nextInt());
                invalidInputLoop(listArrDip, scanner, "day", 31, 0, "Arrival");
                System.out.print("Arrival month ");
                listArrDip.add(scanner.nextInt());
                invalidInputLoop(listArrDip, scanner, "month", 12, 1, "Arrival");
                System.out.print("Arrival hour ");
                listArrDip.add(scanner.nextInt());
                invalidInputLoop(listArrDip, scanner, "hour", 24, 2, "Arrival");
                System.out.print("Arrival minute ");
                listArrDip.add(scanner.nextInt());
                invalidInputLoop(listArrDip, scanner, "minute", 60, 3, "Arrival");
                System.out.print("Departure day ");
                listArrDip.add(scanner.nextInt());
                invalidInputLoop(listArrDip, scanner, "day", 31, 4, "Departure");
                System.out.print("Departure month ");
                listArrDip.add(scanner.nextInt());
                invalidInputLoop(listArrDip, scanner, "month", 12, 5, "Departure");
                System.out.print("Departure hour ");
                listArrDip.add(scanner.nextInt());
                invalidInputLoop(listArrDip, scanner, "hour", 24, 6, "Departure");
                System.out.print("Departure minute ");
                listArrDip.add(scanner.nextInt());
                invalidInputLoop(listArrDip, scanner, "minute", 60, 7, "Departure");
                calculationTime(listArrDip);
                System.out.print("Do you want to continue (t) => true or (f) => false ? ");
                isRunning = scanner.next().toLowerCase().charAt(0);
            } catch (InputMismatchException e) {
                System.out.println("Try again. You must input only numbers.");
            }
            scanner.nextLine();
        }


        scanner.close();
    }
    public static void invalidInputLoop(List<Integer> listArrDip, Scanner scanner, String time, int range, int index, String arrDepa){
        while (listArrDip.get(index) > range || listArrDip.get(index) < 1) {
            System.out.println("Incorrect, that value does not exist  -" + time + "- => " + listArrDip.get(index));
            listArrDip.remove(index);
            System.out.print(arrDepa + " " + time + " ");
            listArrDip.add(scanner.nextInt());
        }
    }
    public static void calculationTime(List<Integer> listArrDip){
        ArrivalAndDeparture arrival = new ArrivalAndDeparture(listArrDip.get(1), listArrDip.get(0), listArrDip.get(2), listArrDip.get(3));
        ArrivalAndDeparture departure = new ArrivalAndDeparture(listArrDip.get(5), listArrDip.get(4), listArrDip.get(6), listArrDip.get(7));
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d-M-yyyy-H:m:ss");
        String arrivalG = arrival.generateArrDipa();
        String departureG = departure.generateArrDipa();
        LocalDateTime dateTimeArrival = LocalDateTime.parse(arrivalG, formatter);
        LocalDateTime dateTimeDeparture = LocalDateTime.parse(departureG, formatter);
        long result = Duration.between(dateTimeArrival, dateTimeDeparture).toMinutes();
        long hour = result / 60;
        long minute = result % 60;
        System.out.println(hour + " hours and " + minute + " minutes.");
    }

}