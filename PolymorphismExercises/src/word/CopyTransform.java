package word;

public class CopyTransform implements TextTransform {
    private final StringBuilder text;

    public CopyTransform(StringBuilder text) {
        this.text = text;
    }

    @Override
    public void invokeOn(StringBuilder text, int startIndex, int endIndex) {
        //we will receive the cut text, we shall be
        //able to replace the given text chars with the this.text chars
        text.replace(startIndex,endIndex,CutTransform.getPersonalCut());
    }
}
