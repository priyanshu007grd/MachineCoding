package Model;

public interface IParkingStrategy {

    public void addFreeSlot(Integer slotNumber) throws Exception;
    public void removeFreeSlot(Integer slotNumber) throws Exception;
    public Integer getNextFreeSlot() throws Exception;
}
