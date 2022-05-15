package Command;

import Model.Command;
import Service.ParkingLotService;
import Service.ParkingLotServicetFactory;


public class CreateParkingLotCommandExecutor extends CommandExecutor{
    public static String COMMAND_NAME = "create_parking_lot";

    public CreateParkingLotCommandExecutor(ParkingLotService parkingLotService) {
        super(parkingLotService);
    }

    @Override
    public boolean validate(Command command) {
        return true;
    }

    @Override
    public void execute(Command command) {
        final int parkingLotCapacity = Integer.parseInt(command.getParams().get(0));
        System.out.println("Creating parking lot of size " + parkingLotCapacity);
        //this.parkingLotService = ParkingLotServicetFactory.getParkingLot(parkingLotCapacity);
        this.parkingLotService.createParkingLotService(parkingLotCapacity);
        this.parkingLotService.display();

    }
}
