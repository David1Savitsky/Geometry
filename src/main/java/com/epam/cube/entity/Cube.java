package com.epam.cube.entity;

public class Cube {

    private Point startingPoint;
    private double side;

    public Cube(Point startingPoint, double side){
        this.startingPoint = startingPoint;
        this.side = side;
    }

    public Point getStartingPoint() {
        return startingPoint;
    }
    public void setStartingPoint(Point startingPoint){
        this.startingPoint = startingPoint;
    }

    public double getSide() {
        return side;
    }
    public void setSide(double side){
        this.side = side;
    }

    @Override
    public String toString(){
        return "Cube{" +
               "startingPoint=" + startingPoint +
               "side" + side +
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
        Cube cube = (Cube) obj;
        return startingPoint.equals(cube.startingPoint) && Double.compare(side, cube.side) == 0;
    }

    @Override
    public int hashCode(){
        final int prime = 31;
        int result = 1;
        return startingPoint.hashCode() + prime * result * (int)side;
    }

}
