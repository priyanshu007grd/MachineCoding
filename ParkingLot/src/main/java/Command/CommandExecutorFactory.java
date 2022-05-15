package Command;

import Model.Command;
import Service.ParkingLotService;

import java.util.HashMap;
import java.util.Map;

public class CommandExecutorFactory {
    private Map<String, CommandExecutor> commands = new HashMap<>();

    public CommandExecutorFactory(final ParkingLotService parkingLotService) {
        commands.put(CreateParkingLotCommandExecutor.COMMAND_NAME, new CreateParkingLotCommandExecutor(parkingLotService));
        commands.put(ParkCommandExecutor.COMMAND_NAME, new ParkCommandExecutor(parkingLotService));
        commands.put(LeaveCommandExecutor.COMMAND_NAME, new LeaveCommandExecutor(parkingLotService));
        commands.put(StatusCommandExecutor.COMMAND_NAME, new StatusCommandExecutor(parkingLotService));
    }

    public CommandExecutor getCommandExecutor(final Command command) throws Exception {
        final CommandExecutor commandExecutor = commands.get(command.getCommandName());
        if (commandExecutor == null) {
            throw new Exception("Invalid command ececuter");
        }
        return commandExecutor;
    }
}
