import Model.Payment.CreditCardPaymentProcessor;
import Model.Payment.PaymentProcessor;
import Model.Customer;
import java.time.LocalDate;
import java.util.*;
import Model.Car;
import Model.Reservation;

public class RentalSystem 
{
    private Map<String,Car> cars;
    private Map<String,Reservation> reservations;
    private PaymentProcessor paymentProcessor;

    public RentalSystem() 
    {
       cars=new HashMap<>();
       reservations=new HashMap<>();
       paymentProcessor=new CreditCardPaymentProcessor();
    }

    public void addCar(Car car)
    {
        cars.put(car.getLicencePlate(),car);
        System.out.println("car added sussfully");
    }

    public void removeCar(String licencePlate)
    {
        cars.remove(licencePlate);
    }

    public List<Car> searchCars(String maker,String model,LocalDate startDate,LocalDate endDate)
    {
       List<Car> availableCars=new ArrayList<>();
       for(Car car:cars.values())
       {
        if(car.getMaker().equals(maker) && car.getModel().equals(model) && car.IsAvailable())
        {
            if(isCarAvailable(car,startDate,endDate))
            {
                availableCars.add(car);
            }
        }
       }
       return availableCars;
    }

    private boolean isCarAvailable(Car car,LocalDate startDate,LocalDate endDate)
    {
        for(Reservation reservation:reservations.values())
        {
            if(reservation.getCar().equals(car))
            {
                if(startDate.isBefore(reservation.getEndDate()) && endDate.isAfter(reservation.getStartDate()))
                {
                    return false;
                }
            }
        }
        return true;
    }

    public Reservation makeReservation(Customer customer,Car car,LocalDate startDate,LocalDate endDate)
    {
        if(isCarAvailable(car, startDate, endDate))
        {
            String reservationId=generateReservationID();
            Reservation reservation=new Reservation(reservationId, customer, car, startDate, endDate, 1500.0);
            reservations.put(reservationId, reservation);
            car.setIsAvailable(false);
            return reservation;
        }
        return null;
    }

    public void cancelReservation(String reservationId)
    {
        Reservation reservation=reservations.remove(reservationId);
        reservation.getCar().setIsAvailable(true);
    }

    private String generateReservationID()
    {
        return "RES"+UUID.randomUUID().toString().substring(0,8).toUpperCase();
    }

    public boolean processPayment(Reservation reservation)
    {
       return paymentProcessor.processPayment(reservation.getTotalPrice());
    }
}
