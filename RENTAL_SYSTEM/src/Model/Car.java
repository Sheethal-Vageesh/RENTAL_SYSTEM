package Model;

public class Car 
{
  private String maker;
  private String model;
  private int year;
  private String licencePlate;
  private int rentalPricePerDay;
  private boolean available;

  public Car(String maker,String model,int year,String licencePlate,int rentalPricePerDay,boolean available)
  {
    this.maker=maker;
    this.model=model;
    this.year=year;
    this.licencePlate=licencePlate;
    this.rentalPricePerDay=rentalPricePerDay;
    this.available=available;
  }

  public String getMaker()
  {
    return this.maker;
  }

  public String getModel()
  {
    return this.model;
  }

  public int getYear()
  {
    return this. year;
  }

  public String getLicencePlate()
  {
    return this.licencePlate;
  }

  public int getRentalPriceperDay()
  {
    return this. rentalPricePerDay;
  }

  public boolean IsAvailable()
  {
    return this.available;
  }

  public void setIsAvailable(boolean IsAvailable)
  {
    this.available=IsAvailable;
  }
}
