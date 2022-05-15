package Command;

import Model.Command;
import Service.ParkingLotService;

public class LeaveCommandExecutor extends CommandExecutor {
    public static String COMMAND_NAME = "leave";

    public LeaveCommandExecutor(ParkingLotService parkingLotService) {
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
