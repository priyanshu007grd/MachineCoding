public class ElevatorMain {

    public static void main(String[] args) {

        ElevatorRequestController elevatorRequestController = new ElevatorRequestController();
        addElevator(elevatorRequestController);

        for(int i=0;i<10;i++) {
            Request request = new Request(i);
            elevatorRequestController.addRequest(request);
        }
    }

    public static void addElevator(ElevatorRequestController elevatorRequestController) {
        Elevator elevator = ElevatorFactory.getElevator(5,elevatorRequestController);
        Thread object = new Thread(elevator);
        object.start();
        elevatorRequestController.addElevator(elevator);
    }
}
