import java.util.ArrayList;
import java.util.LinkedList;

public class ElevatorFactory {

    public static Elevator getElevator(Integer nbrOfFloor,ElevatorRequestController elevatorRequestController) {

        elevatorRequestController.setElevatorId(elevatorRequestController.getElevatorId()+1);
        Elevator elevator = Elevator.builder().id(elevatorRequestController.getElevatorId())
                .currFloor(0)
                .nxtFloor(0)
                .displayPannelList(new ArrayList<>())
                .requestQ(new LinkedList<>())
                .build();

        for(int i=1;i<=nbrOfFloor;i++) {
            DisplayPannel displayPannel = new DisplayPannel(i,elevator.getId());
            elevator.getDisplayPannelList().add(displayPannel);
        }
        return  elevator;
    }
}
