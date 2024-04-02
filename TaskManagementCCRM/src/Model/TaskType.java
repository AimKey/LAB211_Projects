package Model;

public class TaskType {
    private String type;

    public TaskType(int typeId) throws Exception {
        setType(typeId);
    }

    public final void setType(int typeId) throws Exception {
        if (typeId < 1 || typeId > 4)
            throw new Exception("Type id should not < 1 or > 4");
        this.type = getType(typeId);
    }

    private String getType(int id) {
        switch (id) {
            case 1:
                return "Code";
            case 2:
                return "Test";
            case 3:
                return "Design";
            case 4:
                return "View";
            default:
                return "";
        }
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return type;
    }

}
