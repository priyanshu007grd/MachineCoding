package Command;

import Model.Command;
import Service.ParkingLotService;

public class StatusCommandExecutor extends CommandExecutor{
    public static String COMMAND_NAME = "status";

    public StatusCommandExecutor(ParkingLotService parkingLotService) {
        super(parkingLotService);
    }

    @Override
    public boolean validate(Command command) {
        return true;
    }

    @Override
    public void execute(Command command) {

    }
}
