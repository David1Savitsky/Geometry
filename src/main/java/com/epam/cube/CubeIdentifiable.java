package com.epam.cube;

import com.epam.cube.entity.Cube;
import com.epam.cube.entity.Point;

import java.util.ArrayList;
import java.util.List;

public class CubeIdentifiable extends Cube implements Observable {

    private final Integer id;
    private final List<Observer> observers = new ArrayList<>();

    public CubeIdentifiable(Integer id, Point startingPoint, double side) {
        super(startingPoint, side);
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    @Override
    public void setStartingPoint(Point startingPoint) {
        super.setStartingPoint(startingPoint);
        notifyObservers();
    }

    @Override
    public void setSide(double side) {
        super.setSide(side);
        notifyObservers();
    }

    @Override
    public void attach(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void detach(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for(Observer observer : observers){
            observer.update(this);
        }
    }


}
