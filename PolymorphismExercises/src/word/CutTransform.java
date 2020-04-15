package word;

public class CutTransform implements TextTransform {
    //will cut and remember the text in-memory can be pasted
    private static String personalCut;

    public static String getPersonalCut() {
        return personalCut;
    }

    @Override
    public void invokeOn(StringBuilder text, int startIndex, int endIndex) {
        personalCut = text.substring(startIndex, endIndex);
        text.delete(startIndex, endIndex);

    }


}
