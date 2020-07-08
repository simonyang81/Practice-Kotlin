package sm.practice.java;

import java.util.Optional;

public class JavaOptional {

    class Person {
        private Optional<Car> car;

        Person(Optional<Car> car) {
            this.car = car;
        }

        public Optional<Car> getCar() {
            return car;
        }
    }

    class Car {
        private Optional<Insurance> insurance;

        Car(Optional<Insurance> insurance) {
            this.insurance = insurance;
        }

        public Optional<Insurance> getInsurance() {
            return insurance;
        }
    }

    class Insurance {
        private String name;
        public String getName() {
            return name;
        }
        public void setName(String name) {
            this.name = name;
        }
    }

    public void test() {
//        var optCar = Optional.empty();
        var insurance = new Insurance();
        insurance.setName("ABCs");
        var optInsurance = Optional.ofNullable(insurance);
        var optName = optInsurance.map(Insurance::getName);
        System.out.println("optName: " + optName.orElse("Unknown"));

        var car = new Car(optInsurance);
        var optCar = Optional.ofNullable(car);
        var person = new Person(optCar);
        var optPerson = Optional.ofNullable(person);
        var insuranceName = optPerson.flatMap(Person::getCar).flatMap(Car::getInsurance).map(Insurance::getName);
        System.out.println("insuranceName: " + (insuranceName.orElse("Unknown")));
    }

}
