package speedracing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        //HashMap = car model as key, car as value
        Map<String, Car> carMap = new LinkedHashMap<>();
        //adding of cars;
        int carsNum = Integer.parseInt(reader.readLine());
        while (carsNum > 0) {
            String[] tokens = reader.readLine().split("\\s+");
            String model = tokens[0];
            double fuelAmount = Double.parseDouble(tokens[1]);
            double costPerKm = Double.parseDouble(tokens[2]);
            carMap.putIfAbsent(model, new Car(model, fuelAmount, costPerKm));
            carsNum--;
        }

        //receiving commands different loop

        String cmd;
        StringBuilder result = new StringBuilder();
        while (!"End".equals(cmd = reader.readLine())) {
            String[] tokens = cmd.split("\\s+");
            String carModel = tokens[1];
            int distance = Integer.parseInt(tokens[2]);
            Car prototype = carMap.get(carModel);
            if (prototype.canTravelDistance(distance)) {
                double fuelDecrement = distance * prototype.getFuelCostPerKm();
                prototype.decreaseFuel(fuelDecrement);
                prototype.increaseDistance(distance);
            } else {
                result.append("Insufficient fuel for the drive").append(System.lineSeparator());
            }
        }

        System.out.print(result.toString());
        carMap.values().forEach(System.out::println);


    }
}
