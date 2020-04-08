package vehicles;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Bus bus = null;
        Vehicle car = null;
        Vehicle truck = null;


        for (int i = 0; i < 3; i++) {
            //4 elements, 3 indices
            String[] vehicles = reader.readLine().split("\\s+");
            switch (vehicles[0]){
                case "Bus":
                   bus = new Bus(Double.parseDouble(vehicles[1]),
                            Double.parseDouble(vehicles[2]),
                            Double.parseDouble(vehicles[3]));
                    break;
                case "Car":
                    car = new Car(Double.parseDouble(vehicles[1]),
                            Double.parseDouble(vehicles[2]),
                            Double.parseDouble(vehicles[3]));
                    break;

                case "Truck":
                    truck = new Truck(Double.parseDouble(vehicles[1]),
                            Double.parseDouble(vehicles[2]),
                            Double.parseDouble(vehicles[3]));
                    break;
            }
        }

        int lines = Integer.parseInt(reader.readLine());

        while(lines-- > 0){
            String[] commands = reader.readLine().split("\\s+");
            switch (commands[0]){
                case "Drive":
                    switch (commands[1]){
                        case "Bus":
                            assert bus != null;
                            bus.drive(Double.parseDouble(commands[2]));
                            break;
                        case "Truck":
                            assert truck != null;
                            truck.drive(Double.parseDouble(commands[2]));
                            break;
                        case "Car":
                            assert car != null;
                            car.drive(Double.parseDouble(commands[2]));
                            break;
                    }
                    break;
                case "Refuel":
                    switch(commands[1]){
                        case "Bus":
                            assert bus != null;
                            bus.refuel(Double.parseDouble(commands[2]));
                            break;
                        case "Truck":
                            assert truck != null;
                            truck.refuel(Double.parseDouble(commands[2]));
                            break;
                        case "Car":
                            assert car != null;
                            car.refuel(Double.parseDouble(commands[2]));
                            break;
                    }
                    break;
                case "DriveEmpty":
                    assert bus != null;
                    bus.driveEmpty(Double.parseDouble(commands[2]));
                    break;

            }

        }
        System.out.println(car);
        System.out.println(truck);
        System.out.println(bus);
    }
}
