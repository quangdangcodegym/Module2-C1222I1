package model;

public enum EFormat {
    _2D(1, 0, "2D"),
    _3D(2, 20000, "3D"),
    IMAX(3, 30000, "IMAX"),
    _4D(4, 40000, "4D");
    private long id;
    private double surcharge;

    private String name;
    EFormat(long id, double surcharge, String name) {
        this.id = id;
        this.surcharge = surcharge;
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public double getSurcharge() {
        return surcharge;
    }

    public void setSurcharge(double surcharge) {
        this.surcharge = surcharge;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static EFormat toFormat(long id) {
        for (EFormat format : values()) {
            if (format.id == id) {
                return format;
            }
        }
        return null;
    }
    public static EFormat getFormatByName(String name) {
        for (EFormat format : values()) {
            if (format.getName().equals(name)) {
                return format;
            }
        }
        return null;
    }
}
