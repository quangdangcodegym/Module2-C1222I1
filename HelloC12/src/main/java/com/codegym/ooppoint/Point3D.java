package com.codegym.ooppoint;

public class Point3D extends Point2D{
    private float z;

    public Point3D(float x, float y, float z) {
        /**
        setX(x);
        setY(y);
         **/
        super(x, y);        // từ khóa super: gọi đến khởi tạo hoặc phương thức của lớp cha
        this.z = z;
    }
    public Point3D() {

    }

    public float getZ() {
        return z;
    }

    public void setZ(float z) {
        this.z = z;
    }

    public void setXYZ(float x, float y, float z) {
        this.z = z;
        setX(x);
        setY(y);
    }

    public float[] getXYZ() {
        float[] arr = { this.getX(), getY(), this.z};
//        float[] arr = { super.getX(), getY(), this.z};
        return arr;
    }

    public String toString() {
        return String.format("(%s,%s,%s)", this.getX(), this.getY(), this.getZ());
    }
}
