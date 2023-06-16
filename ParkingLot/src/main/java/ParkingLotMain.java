import Command.CommandExecutorFactory;
import Model.Car;
import Model.Command;
import Service.ParkingLotService;
import Service.ParkingLotServicetFactory;
import Command.CommandExecutor;

import java.io.*;
import java.util.Scanner;

public class ParkingLotMain {


    public static void main(String[] args) throws Exception {
        System.out.println("Welcome to parking lot");


        fileEntry();
        //consoleEntry();
    }

    static void consoleEntry() throws Exception {
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
    }

    static void fileEntry() throws Exception {
        File file = new File("/Users/priyanshu/Documents/Project/MachineCoding/ParkingLot/src/main/java/input.txt");
        BufferedReader br = new BufferedReader(new FileReader(file));

        ParkingLotService parkingLotService = new ParkingLotService();
        CommandExecutorFactory commandExecutorFactor = new CommandExecutorFactory(parkingLotService);

        String st;
        while ((st = br.readLine()) != null) {
            String commandString = st;
            Command command = new Command(commandString);
            CommandExecutor commandExecutor =  commandExecutorFactor.getCommandExecutor(command);
            commandExecutor.validate(command);
            commandExecutor.execute(command);

            System.out.println("Output after executing command");
            parkingLotService.display();
        }
    }
}
