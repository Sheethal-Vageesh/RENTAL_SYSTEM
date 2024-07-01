package Model;

public class Customer 
{
   private String name;
   private String contactNumber;
   private String drivingLicenceNumber;

   public Customer(String name,String contactNumber,String drivingLicenceNumber)
   {
    this.name=name;
    this.contactNumber=contactNumber;
    this.drivingLicenceNumber=drivingLicenceNumber;
   }

   public String getName()
   {
    return this.name;
   }

   public String getContactNumber()
   {
    return this.contactNumber;
   }

   public String getdrivingLicenceNumber()
   {
    return this.drivingLicenceNumber;
   }
}
