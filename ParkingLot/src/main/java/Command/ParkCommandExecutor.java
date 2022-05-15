package Command;

import Model.Car;
import Model.Command;
import Service.ParkingLotService;

public class ParkCommandExecutor extends CommandExecutor{

    public static String COMMAND_NAME = "park";

    public ParkCommandExecutor(final ParkingLotService parkingLotService) {
        super(parkingLotService);
    }

    @Override
    public boolean validate(Command command) {
        return true;
    }

    @Override
    public void execute(Command command) {
        final Car car = new Car(command.getParams().get(0), command.getParams().get(1));
        try {
            final Integer slot = parkingLotService.reserveParking(car);
        } catch (Exception exception) {
            System.out.println(exception);
        }

        parkingLotService.display();
    }
}
