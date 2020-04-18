package trafficlights;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        //each color is separate traffic lighter
        String[] colors = reader.readLine().split("\\s+");

        TrafficLight[] trafficLights = new TrafficLight[colors.length];

        for (int i = 0; i < colors.length; i++) {
            TrafficLight trafficLight = new TrafficLight(Signal.valueOf(colors[i]));

            trafficLights[i] = trafficLight;
        }

        int timesToUpdate = Integer.parseInt(reader.readLine());

        for (int i = 0; i < timesToUpdate; i++) {
            for (int j = 0; j < trafficLights.length - 1; j++) {
                trafficLights[j].changeColor();
                System.out.print(trafficLights[j].toString() + " ");
            }
            TrafficLight lastOne = trafficLights[trafficLights.length - 1];
            lastOne.changeColor();
            System.out.println(lastOne);

        }

    }
}
