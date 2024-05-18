package app;

/**
 * Class represeting a LGA from the Studio Project database
 * In the template, this only uses the code and name for 2016
 *
 * @author Timothy Wiley, 2022. email: timothy.wiley@rmit.edu.au
 */
public class SexStats {
   // SEO ID
   private int sex;

   // SEO TITLE
   private int sumAmount;

   /**
    * Create an LGA and set the fields
    */
   public SexStats (int sex, int sumAmount) {
      this.sex = sex;
      this.sumAmount = sumAmount;
   }

   public int getSex() {
      return sex;
   }

   public int getSumAmount() {
      return sumAmount;
   }
}
