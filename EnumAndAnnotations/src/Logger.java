import java.util.ArrayList;
import java.util.List;

public class Logger {
    private List<Message> messages;
    private Importance importanceLevel;

    public Logger(String importance){
        this.importanceLevel = Enum.valueOf(Importance.class, importance.toUpperCase());
        this.messages = new ArrayList<>();
    }

    public void log(Message message){
        if(message.getLevel().compareTo(this.importanceLevel) >= 0){
            messages.add(message);
        }
    }

    public Iterable<Message> getMessages(){
        return this.messages;
    }
}
