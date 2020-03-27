package customlist;

public class CommandInterpreter{

    private CustomList<String> customList;
    private boolean endDispatch = false;

    public CommandInterpreter(CustomList<String> customList) {
        this.customList = customList;
    }


    public boolean isEndDispatch() {
        return endDispatch;
    }

    public void dispatch(String... args) {
        String command = args[0];

        switch (command) {
            case "Add":
                this.customList.add(args[1]);
                break;
            case "Remove":
                this.customList.remove(Integer.parseInt(args[1]));
                break;
            case "Contains":
                System.out.println(this.customList.contains(args[1]));
                break;
            case "Swap":
                this.customList.swap(Integer.parseInt(args[1]),Integer.parseInt(args[2]));
                break;
            case "Greater":
                System.out.println(this.customList.countGreaterThan(args[1]));
                break;
            case "Max":
                System.out.println(this.customList.getMax());
                break;
            case "Min":
                System.out.println(this.customList.getMin());
                break;
            case"Print":
                this.customList.print();
                break;
            case "Sort":
                this.customList.sort();
                break;
            case "Iter":
                for(String item: this.customList){
                    System.out.println(item);
                }
                break;
            case "END":
                this.endDispatch = true;
        }


    }
}
