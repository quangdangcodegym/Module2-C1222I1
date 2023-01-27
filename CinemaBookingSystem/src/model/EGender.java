package model;

public enum EGender {
    male(1,"male"),
    female(2, "female"),
    other(3, "other");

    private long id;
    private String name;

    EGender(long id, String name) {
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

    public static EGender toGender(long id) {
        for (EGender gender : values()) {
            if (gender.id == id) {
                return gender;
            }
        }
        return null;
    }
    public static EGender getEGenderByName(String name) {
        for (EGender gender : values()) {
            if (gender.getName().equals(name)) {
                return gender;
            }
        }
        throw new IllegalArgumentException("Please re-enter");
    }
}
