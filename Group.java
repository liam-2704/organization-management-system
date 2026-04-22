import java.util.ArrayList;

public class Group extends Component {

    private String boss;
    private String secretary;
    private ArrayList<Component> members = new ArrayList<>();

    public Group(String groupName, String bossName, String secretaryName) {
        super(groupName);
        this.boss = bossName;
        this.secretary = secretaryName;
    }

    public Group(String groupName, String bossName) {
        super(groupName);
        this.boss = bossName;
        this.secretary = null;
    }

    public void add(Component c) {
        members.add(c);
    }

    @Override
    public void print(int indent) {
        System.out.println(" ".repeat(indent) + name + " (Boss: " + boss + ")");
        if (indent == 0) {
            System.out.println(" ".repeat(indent + 1) + "Worker: " + secretary + " (secretary)");
            System.out.println();
        }

        for (Component c : members) {
            c.print(indent + 1);
        }
        System.out.println();
    }

    public Group findGroup(String groupName) {
        if (this.name.equalsIgnoreCase(groupName)) {
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

    public boolean removeWorker(String workerName) {
        for (Component c : members) {
            if (c instanceof Worker) {
                if (c.getName().equalsIgnoreCase(workerName)) {
                    members.remove(c);
                    return true;
                }
            }
        }

        for (Component c : members) {
            if (c instanceof Group) {
                boolean removed = ((Group) c).removeWorker(workerName);
                if (removed) {
                    return true;
                }
            }
        }
        return false;
    }
}
