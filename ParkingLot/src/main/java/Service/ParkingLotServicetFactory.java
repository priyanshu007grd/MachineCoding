package Service;

import ParkingStrategy.IParkingStrategy;
import Storage.ParkingLot;
import ParkingStrategy.ParkingStrategy;

import java.util.HashMap;

public class ParkingLotServicetFactory {

    public static ParkingLotService getParkingLot(Integer capacity) {
        ParkingLot parkingLot = ParkingLot.builder().capacity(capacity).slotM(new HashMap<>()).build();
        IParkingStrategy parkingStrategy = new ParkingStrategy();
        ParkingLotService parkingLotService = new ParkingLotService(parkingLot,parkingStrategy);

        return parkingLotService;
    }
}
