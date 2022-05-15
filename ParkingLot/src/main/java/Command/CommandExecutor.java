package Command;

import Model.Command;
import Service.ParkingLotService;

public abstract class CommandExecutor {

    protected ParkingLotService parkingLotService;

    CommandExecutor(final ParkingLotService parkingLotService) {
        this.parkingLotService = parkingLotService;
    }

    public abstract boolean validate(Command command);
    public abstract void execute(Command command);
}
