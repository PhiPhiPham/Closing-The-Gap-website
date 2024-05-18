package app;

/**
 * Class represeting a LGA from the Studio Project database
 * In the template, this only uses the code and name for 2016
 *
 * @author Timothy Wiley, 2022. email: timothy.wiley@rmit.edu.au
 */
public class StatusStats {
   // SEO ID
   private int status;

   // SEO TITLE
   private int sumAmount;

  

   /**
    * Create an LGA and set the fields
    */
   public StatusStats (int status, int sumAmount, int sumNotStated) {
      this.status = status;
      this.sumAmount = sumAmount;
   }

   public int getStatus() {
      return status;
   }

   public int getSumAmount() {
      return sumAmount;
   }

   


}
