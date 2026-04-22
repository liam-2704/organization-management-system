public class Worker extends Component {
    public Worker(String name) {
        super(name);
    }

    @Override
    public void print(int indent) {
        System.out.println("   ".repeat(indent - 1) + "Worker: " + name);
    }
}
