package entity;

public enum JobDurationType {
    PERMANENT,TEMPORARY;

    @Override
    public String toString() {
        return this.name().charAt(0) + this.name().substring(1).toLowerCase();
    }
}
