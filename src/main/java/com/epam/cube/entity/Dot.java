package com.epam.cube.entity;

public class Dot {

    private double xCoordinate;
    private double yCoordinate;
    private double zCoordinate;

    public Dot(){
    }
    public Dot(double xCoordinate, double yCoordinate, double zCoordinate){
        this.xCoordinate = xCoordinate;
        this.yCoordinate = yCoordinate;
        this.zCoordinate = zCoordinate;
    }

    public double getXCoordinate() {
        return xCoordinate;
    }
    public void setXCoordinate(double xCoordinate) {
        this.xCoordinate = xCoordinate;
    }

    public double getYCoordinate() {
        return yCoordinate;
    }
    public void setYCoordinate(double yCoordinate) {
        this.yCoordinate = yCoordinate;
    }

    public double getZCoordinate() {
        return zCoordinate;
    }
    public void setZCoordinate(double zCoordinate) {
        this.zCoordinate = zCoordinate;
    }

    @Override
    public String toString(){
        return "Point{" +
               "xCoordinate=" + xCoordinate +
               "yCoordinate=" + yCoordinate +
               "zCoordinate=" + zCoordinate +
               "}";
    }

    @Override
    public boolean equals(Object obj){
        if (this == obj){
            return true;
        }
        if (obj == null || getClass() != obj.getClass()){
            return false;
        }
        Dot point = (Dot) obj;
        return Double.compare(xCoordinate, point.xCoordinate) == 0
               && Double.compare(yCoordinate, point.yCoordinate) == 0
               && Double.compare(zCoordinate, point.zCoordinate) == 0;
    }

    @Override
    public int hashCode(){
        final int prime = 31;
        int result = 17;
        return prime * result * (int)(xCoordinate + yCoordinate + zCoordinate);
    }
}
