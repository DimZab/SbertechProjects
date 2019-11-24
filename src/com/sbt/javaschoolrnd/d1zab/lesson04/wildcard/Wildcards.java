package com.sbt.javaschoolrnd.d1zab.lesson04.wildcard;


import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Wildcards {
    public static void main(String[] args) {


        List<Vehicle> vehicles = new ArrayList<Vehicle>();
        List<Auto> autos = new ArrayList<>();
        List<Plane> planes = new ArrayList<>();


        planes.add(new Plane("Boeing"));
        getVehicleName(planes);

        autos.add(new Auto("Mercedes"));
        getVehicleName(autos);


        planes.add(new Plane("Stealth"));
        autos.add(new Auto("bmw"));


        Comparator<Vehicle> vehicleComparator = new Comparator<Vehicle>() {

            @Override
            public int compare(Vehicle o1, Vehicle o2) {
                return o1.getName().compareTo(o2.getName());
            }
        };


        Comparator<Object> objectComparator = new Comparator<Object>() {

            @Override
            public int compare(Object o1, Object o2) {
                return Integer.compare(o1.hashCode(), o2.hashCode());
            }
        };

        compareWithPecs(planes, vehicleComparator);
        compareWithPecs(planes, objectComparator);


        compareWithPecs(planes, new Comparator<Plane>() {

            @Override
            public int compare(Plane o1, Plane o2) {
                return o1.getName().compareTo(o2.getName());
            }
        });
    }

    static <T extends Vehicle> Vehicle compareWithPecs(List<? extends T> vehicles, Comparator<? super T> comparator) {
        if (vehicles.isEmpty()) {
            return null;
        }

        T max = vehicles.get(0);

        for (T vehicle : vehicles) {
            if (comparator.compare(max, vehicle) < 0) {

//                The return value(not type, the type is int) tells the caller(the thing sorting the data):
//                - 1 : o1 < o2  ;
//                0   : o1 == o2 ;
//                + 1 : o1 > o2

                max = vehicle;
            }
        }
        // System.out.println(max.getName());
        return max;
    }


    static void getVehicleName(List<? extends Vehicle> vehicles) {
        for (Vehicle vehicle : vehicles) {
            System.out.println(vehicle.getName());
        }
    }
}
