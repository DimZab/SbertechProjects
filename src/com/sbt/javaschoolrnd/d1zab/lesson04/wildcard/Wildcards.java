package com.sbt.javaschoolrnd.d1zab.lesson04.wildcard;


import java.util.ArrayList;
import java.util.List;

public class Wildcards {
    public static void main(String[] args) {


        List<Vehicle> vehicles = new ArrayList<Vehicle>();
        List<Plane> planes = new ArrayList<>();

        planes.add(new Plane("Boeing"));


        getVehicleName(planes);


        List<Auto> autos = new ArrayList<>();
        autos.add(new Auto("Mercedes"));
        getVehicleName(autos);
    }


    static void getVehicleName(List<? extends Vehicle> vehicles) {
        for (Vehicle vehicle : vehicles) {
            System.out.println(vehicle.getName());
        }
    }
}
