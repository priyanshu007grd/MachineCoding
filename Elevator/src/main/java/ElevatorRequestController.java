import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.*;

@Data
@AllArgsConstructor
@Builder
public class ElevatorRequestController {

    List<Elevator> elevatorList;
    Integer elevatorId;

    public ElevatorRequestController() {
        elevatorList = new ArrayList<>();
        elevatorId=0;
    }

    public Elevator addRequest(Request request) {
        Random rand = new Random();
        Elevator elevator = elevatorList.get(rand.nextInt(0,elevatorList.size()));
        elevator.getRequestQ().add(request);
        return elevator;
    }

    public void addElevator(Elevator elevator) {
        elevatorList.add(elevator);
    }
}
