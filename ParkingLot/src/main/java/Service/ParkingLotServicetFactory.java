package Service;

import Model.IParkingStrategy;
import Model.ParkingLot;
import Model.ParkingStrategy;
import Service.ParkingLotService;

import java.util.HashMap;

public class ParkingLotServicetFactory {

    public static ParkingLotService getParkingLot(Integer capacity) {
        ParkingLot parkingLot = ParkingLot.builder().capacity(capacity).slotM(new HashMap<>()).build();
        IParkingStrategy parkingStrategy = new ParkingStrategy();
        ParkingLotService parkingLotService = new ParkingLotService(parkingLot,parkingStrategy);

        return parkingLotService;
    }
}
