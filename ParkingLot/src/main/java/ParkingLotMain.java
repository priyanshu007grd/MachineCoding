import Command.CommandExecutorFactory;
import Model.Car;
import Model.Command;
import Service.ParkingLotService;
import Service.ParkingLotServicetFactory;
import Command.CommandExecutor;

import java.util.Scanner;

public class ParkingLotMain {


    public static void main(String[] args) throws Exception {
        System.out.println("Welcome to parking lot");
        Scanner scanner = new Scanner(System.in);
        ParkingLotService parkingLotService = new ParkingLotService();
        CommandExecutorFactory commandExecutorFactor = new CommandExecutorFactory(parkingLotService);


        while (true) {
            String commandString = scanner.nextLine();
            Command command = new Command(commandString);
            CommandExecutor commandExecutor =  commandExecutorFactor.getCommandExecutor(command);
            commandExecutor.validate(command);
            commandExecutor.execute(command);
            parkingLotService.display();
        }



//        try {
//            parkingLotService.reserveParking(new Car("1","red"));
//            parkingLotService.reserveParking(new Car("2","blue"));
//            parkingLotService.unreserveParking(1);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
    }
}
