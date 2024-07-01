import java.util.*;
import java.time.LocalDate;
import Model.*;

public class App {
    public static void main(String[] args) throws Exception {
        RentalSystem rentalsystem=new RentalSystem();
       
        Car car1=new Car("Toyoto","Glanza",2022,"ABCD1234",600,true);
        Car car2=new Car("Honda","Civic",2023,"DEFG5678",700,true);
        Car car3=new Car("Ford","Mustang",2021,"HGFD89012",1200,true);

        rentalsystem.addCar(car1);
        rentalsystem.addCar(car2);
        rentalsystem.addCar(car3);

        Customer customer=new Customer("xyz","7842561962","DL65420");
        //Customer customer2=new Customer("abc","7642829651","DL67620");


        LocalDate startDate=LocalDate.now();
        LocalDate endDate=startDate.plusDays(3);

        List<Car> availableCars1=rentalsystem.searchCars("Toyoto","Glanza",startDate,endDate);
        //List<Car> availableCars2=rentalsystem.searchCars("Toyoto","Glanza",startDate,endDate);

        if(!availableCars1.isEmpty()){
          Car selectedCar=availableCars1.get(0);
          Reservation reservation=rentalsystem.makeReservation(customer, selectedCar, startDate, endDate);
          if(reservation!=null){
             boolean isPaymentSuccessful=rentalsystem.processPayment(reservation);
             if(isPaymentSuccessful==true){
                System.out.println("Reservation is successul with the reservation Id : "+reservation.getReservationId());
             }
             else{
                System.out.println("Payment unsuccessful,reservation cancelled with Id :"+reservation.getReservationId());
                rentalsystem.cancelReservation(reservation.getReservationId());
             }
          }
          else{
            System.out.println("Selected car is not available for given dates");
          }
        }
        else{
            System.out.println("No cars are available of given specifications");
        }

    }
}
