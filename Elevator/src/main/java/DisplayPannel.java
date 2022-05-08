import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DisplayPannel {
    Integer id;
    Integer elevatorId;
    Integer currFloorOfElevator;

    public DisplayPannel(Integer id, Integer elevatorId) {

        this.id = id;
        this.elevatorId = elevatorId;
    }

    public Integer getCurrFloorOfElevator() {
        return currFloorOfElevator;
    }

    public void setCurrFloorOfElevator(Integer currFloorOfElevator) {
        this.currFloorOfElevator = currFloorOfElevator;
        display();
    }

    public void display() {
        //System.out.println("Elevator Id = " + elevatorId + " : curr floor = " + currFloorOfElevator);
    }
}
