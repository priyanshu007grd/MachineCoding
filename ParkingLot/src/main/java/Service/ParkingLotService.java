package Service;

import Model.*;
import ParkingStrategy.IParkingStrategy;
import ParkingStrategy.ParkingStrategy;
import Storage.ParkingLot;

import java.util.*;
import java.util.stream.IntStream;

public class ParkingLotService {

    private ParkingLot parkingLot;
    private IParkingStrategy parkingStrategy;

    public ParkingLotService() {
    }

    //not in use
    public ParkingLotService(ParkingLot parkingLot, IParkingStrategy parkingStrategy) {
        this.parkingLot = parkingLot;
        this.parkingStrategy = parkingStrategy;

        IntStream.rangeClosed(1, parkingLot.getCapacity()).forEach(slotNbr->{
            try {
                this.parkingStrategy.addFreeSlot(slotNbr);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public void createParkingLotService(Integer capacity) {

        this.parkingLot = ParkingLot.builder().capacity(capacity).slotM(new HashMap<>()).build();
        this.parkingStrategy = new ParkingStrategy();

        IntStream.rangeClosed(1, parkingLot.getCapacity()).forEach(slotNbr->{
            try {
                this.parkingStrategy.addFreeSlot(slotNbr);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }



    // there can be different type of vechile
    public Integer reserveParking(Car car) throws Exception {

        Integer nxtFreeParking = parkingStrategy.getNextFreeSlot();
        parkingLot.reserveParking(nxtFreeParking,car);
        parkingStrategy.removeFreeSlot(nxtFreeParking);
        display();
        return nxtFreeParking;
    }

    public void unreserveParking(final Integer slotNumber) throws Exception {
        parkingLot.unreserveParking(slotNumber);
        parkingStrategy.addFreeSlot(slotNumber);
        display();
    }

    public void display() {
        System.out.println("Free slot " + parkingStrategy);
        System.out.println(parkingLot.getSlotM());
        System.out.println();
    }
}
