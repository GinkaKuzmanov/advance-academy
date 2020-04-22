package solidLab.p02_OpenClosedPrinciple.p01_FileStream;

public class Main {
    public static void main(String[] args) {
        Streamer streamer = new File();
        streamer.setLength(34);
        streamer.setSent(3);
        Progress progress = new Progress(streamer);

        System.out.println(progress.getCurrentPercent());

    }
}

