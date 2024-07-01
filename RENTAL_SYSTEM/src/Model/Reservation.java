package Model;

import java.time.LocalDate;

public class Reservation 
{
    private String reservationId;
    private Customer customer;
    private Car car;
    private LocalDate startDate;
    private LocalDate endDate;
    private double totalPrice;

    public Reservation(String reservationId,Customer customer,Car car,LocalDate startDate,LocalDate endDate,double totalPrice )
    {
        this.reservationId=reservationId;
        this.car=car;
        this.customer=customer;
        this.startDate=startDate;
        this.endDate=endDate;
        this.totalPrice=totalPrice;
    }

    public String getReservationId(){
        return this.reservationId;
    }

    public Customer getCustomer(){
        return this.customer;
    }

    public Car getCar(){
        return this.car;
    }

    public LocalDate getStartDate(){
        return this.startDate;
    }

    public LocalDate getEndDate(){
        return this.endDate;
    }

    public double getTotalPrice(){
        return this.totalPrice;
    }
}
