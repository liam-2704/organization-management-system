import java.util.ArrayList;

public class Group extends Component {

    private String boss;
    private ArrayList<Component> members = new ArrayList<>();

    public Group(String groupName, String bossName) {
        super(groupName);
        this.boss = bossName;
    }

    public void add(Component c) {
        members.add(c);
    }

    @Override
    public void print(int indent) {
        System.out.println(" ".repeat(indent) + name + " (Boss: " + boss + ")");
        for (Component c : members) {
            c.print(indent + 2);
        }
    }

    public Group findGroup(String groupName) {
        if (this.name.equals(groupName)) {
            return this;
        }
        for (Component c : members) {
            if (c instanceof Group) {
                Group found = ((Group) c).findGroup(groupName);
                if (found != null) {
                    return found;
                }
            }
        }
        return null;

    }

}
