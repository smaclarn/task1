package com.klef.jfsd.exam;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ClientDemo {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(Vehicle.class)
                .addAnnotatedClass(Car.class)
                .addAnnotatedClass(Truck.class)
                .buildSessionFactory();

        try (Session session = factory.openSession()) {
            session.beginTransaction();

            // Insert Vehicle
            Vehicle vehicle = new Vehicle();
            vehicle.setName("Generic Vehicle");
            vehicle.setType("Utility");
            vehicle.setMaxSpeed(120);
            vehicle.setColor("White");
            session.save(vehicle);

            // Insert Car
            Car car = new Car();
            car.setName("Sedan");
            car.setType("Car");
            car.setMaxSpeed(180);
            car.setColor("Red");
            car.setNumberOfDoors(4);
            session.save(car);

            // Insert Truck
            Truck truck = new Truck();
            truck.setName("Cargo Truck");
            truck.setType("Truck");
            truck.setMaxSpeed(100);
            truck.setColor("Blue");
            truck.setLoadCapacity(1000);
            session.save(truck);

            session.getTransaction().commit();
        } finally {
            factory.close();
        }
    }
}
