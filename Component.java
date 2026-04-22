public abstract class Component implements ComponentIF {
    protected String name;

    public Component(String name) {
        this.name = name;
    }

    public abstract void print(int indent);

    public String getName() {
        return name;
    }
}