import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Elevator implements Runnable {
    Integer id;
    Integer currFloor;
    Integer nxtFloor;
    Queue<Request> requestQ;
    List<DisplayPannel> displayPannelList;

    Elevator(Integer id) {
        this.id = id;
        requestQ = new LinkedList<>();
        displayPannelList = new ArrayList<>();
    }

    public void openDoor(){
        System.out.println("Opening door");
    }

    public void closeDoor() {
        System.out.println("Closing door");
    }
    public void processRequest(Request request) throws InterruptedException {
        nxtFloor = request.getFloor();
        System.out.println("Next Floor " + nxtFloor);
        Thread.sleep(100);
        currFloor = nxtFloor;

        for(DisplayPannel displayPannel:displayPannelList) {
            displayPannel.setCurrFloorOfElevator(currFloor);
        }
        openDoor();
        Thread.sleep(100);
        closeDoor();
        System.out.println();
    }

    @Override
    public void run() {
        while(true) {
            if(!requestQ.isEmpty()) {
                Request request = requestQ.poll();
                try {
                    processRequest(request);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
