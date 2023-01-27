package model;

public enum EType {
    ACTION(1, "action"),

    HORROR(2, "horror"),

    ROMANCE(3, "romance"),

    OTHER(4, "other");
    private long id;
    String name;
    EType(long id, String name){
        this.id = id;
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static EType toType(long id) {
        for (EType type : values()) {
            if (type.id == id) {
                return type;
            }
        }
        return null;
    }
    public static EType getTypeByName(String name) {
        for (EType type : values()) {
            if (type.getName().equals(name)) {
                return type;
            }
        }
        return null;
    }
}
