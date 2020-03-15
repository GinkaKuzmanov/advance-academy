public class Message {
    private Importance importance;
    private String message;

    public Message(String importance, String message) {
        this.importance = Enum.valueOf(Importance.class, importance.toUpperCase());
        this.message = message;
    }

    public Importance getLevel(){
        return this.importance;
    }

    @Override
    public String toString() {
        return String.format("%s: %s", this.importance,this.message);
    }
}
