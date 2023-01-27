package model;

public enum ERole {
    admin("admin", 1),
    customer("customer", 3);
    private String value;
    private long id;

    ERole(String value, long id) {
        this.value = value;
        this.id = id;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
    public static ERole toRole(long id) {
        for (ERole role : values()) {
            if (role.id == id) {
                return role;
            }
        }
        return null;
    }
    public static ERole getRoleByName(String name) {
        for (ERole role : values()) {
            if (role.toString().equals(name)) {
                return role;
            }
        }
        return null;
    }
}
