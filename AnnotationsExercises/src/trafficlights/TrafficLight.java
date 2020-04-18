package trafficlights;

public class TrafficLight {
    private Signal light;

    //"RED GREEN YELLOW
    //vseki otdelen sfetofar trqvbva da si smenq cvetovete A CLASS IS A MODEL
    public TrafficLight(Signal signal) {
        this.light = signal;
    }

    public void changeColor() {
        switch (this.light) {
            case RED:
                this.light = Signal.GREEN;
                break;
            case GREEN:
                this.light = Signal.YELLOW;
                break;
            case YELLOW:
                this.light = Signal.RED;
                break;
        }
    }

    @Override
    public String toString() {
        return this.light.name();
    }
}
