package wildanimals.mammals;

import java.text.DecimalFormat;

public abstract class Mammal extends Animal {

    protected String livingRegion;

    protected Mammal(String animalName, double animalWeight, String livingRegion) {
        super(animalName, animalWeight);
        this.livingRegion = livingRegion;
    }


    @Override
    public String toString() {
        DecimalFormat df = new DecimalFormat("#.##");
        return String.format("[%s, %s, %s, %d]",this.animalName,df.format(this.animalWeight),
                this.livingRegion,this.foodEaten);
    }
}
