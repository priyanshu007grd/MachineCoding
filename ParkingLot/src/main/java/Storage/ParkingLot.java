package Storage;

import Model.Car;
import Model.Slot;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ParkingLot {
    Integer capacity;
    Map<Integer, Slot> slotM;

    // there can be different type of vechile
    public void reserveParking(Integer nxtFreeParking, Car car) throws Exception {

        if(!slotM.containsKey(nxtFreeParking)) {
            slotM.put(nxtFreeParking,new Slot(car,nxtFreeParking));
        } else {
            Slot slot = slotM.get(nxtFreeParking);
            slot.setParkedCar(car);
        }
    }

    public void unreserveParking(final Integer slotNumber) {
        Slot slot= slotM.getOrDefault(slotNumber,new Slot());
        slot.setParkedCar(null);
    }
}
