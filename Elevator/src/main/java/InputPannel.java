import java.util.Scanner;

public class InputPannel {

    Integer pannelId;
    ElevatorRequestController elevatorRequestController;

     public Elevator sendRequest() {
        Scanner sc = new Scanner(System.in);
        Integer requestedFloor = sc.nextInt();
        Request r = new Request(requestedFloor);
        return elevatorRequestController.addRequest(r);
    }
}
