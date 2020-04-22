package solidLab.p02_OpenClosedPrinciple.p01_FileStream;

public class Progress {
    private final Streamer file;

    public Progress(Streamer file)

    {
        this.file = file;
    }

    public int getCurrentPercent()
    {
        return this.file.getSent() * 100 / this.file.getLength();
    }
}
