
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> listArrDip = new ArrayList<>();
        while (true) {
            System.out.print("Arrival day ");
            listArrDip.add(scanner.nextInt());
            System.out.print("Arrival month ");
            listArrDip.add(scanner.nextInt());
            System.out.print("Arrival hour ");
            listArrDip.add(scanner.nextInt());
            System.out.print("Arrival minute ");
            listArrDip.add(scanner.nextInt());
            System.out.print("Departure day ");
            listArrDip.add(scanner.nextInt());
            System.out.print("Departure month ");
            listArrDip.add(scanner.nextInt());
            System.out.print("Departure hour ");
            listArrDip.add(scanner.nextInt());
            System.out.print("Departure minute ");
            listArrDip.add(scanner.nextInt());
            break;
        }
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
        scanner.close();
    }

}