package Model;

import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Data
public class ParkingStrategy implements IParkingStrategy{

    Set<Integer> freeSlot;

    public ParkingStrategy() {
        this.freeSlot = new HashSet<>();
    }

    @Override
    public void addFreeSlot(Integer slotNumber) throws Exception {
        if(freeSlot.contains(slotNumber)) throw new Exception("Parking slot is already free");
        freeSlot.add(slotNumber);
    }

    @Override
    public void removeFreeSlot(Integer slotNumber) throws Exception {
        if(!freeSlot.contains(slotNumber)) throw new Exception("Parking slot is already empty");
        freeSlot.remove(slotNumber);
    }

    @Override
    public Integer getNextFreeSlot() throws Exception {
        if(freeSlot.isEmpty()) throw new Exception("Parking is full");
        return  freeSlot.iterator().next();
    }
}
