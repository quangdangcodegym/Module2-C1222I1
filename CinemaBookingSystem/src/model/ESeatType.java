package model;

public enum ESeatType {
    NORMAL(1, "normal seat", 0),
    COUPLE(1, "couple seat", 0);
    private long id;
    private String name;
    private double surcharge;

    ESeatType(long id, String name, double surcharge) {
        this.id = id;
        this.name = name;
        this.surcharge = surcharge;
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
}
