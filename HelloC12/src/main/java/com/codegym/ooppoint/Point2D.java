package com.codegym.ooppoint;

public class Point2D {
    private float x = 1.0f;        // thuộc tính, fields, biến toàn cục, biến instance
    private float y = 1.0f;


    public Point2D(float x, float y) {
        this.x = x;
        this.y = y;
    }
    public Point2D(){

    }

    // getter/setter: kiểm soat quyền truy cập và chỉnh sửa sửa thuộc tính (trạng thái của đối tượng)
    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public float[] getXY() {
        // từ khóa this dại cho đối tượng hiện tại, nên có thể truy cập tới thuộc tính, phương thức
        float[] xy = new float[2];
        xy[0] = this.getX();
        xy[1] = this.y;
        return xy;
    }
    public void setXY(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public String toString() {
//        return "(" + this.x + "," + this.y + ")";
        return String.format("(%s,%s)", this.x, this.y);
    }
}
