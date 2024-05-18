package app;

/**
 * Class represeting a LGA from the Studio Project database
 * In the template, this only uses the code and name for 2016
 *
 * @author Timothy Wiley, 2022. email: timothy.wiley@rmit.edu.au
 */
public class Categorey {
   // SEO ID
   private String Category;

   // SEO TITLE
   private int sumAmount;

  

   /**
    * Create an LGA and set the fields
    */
   public Categorey (String Category, int sumAmount) {
      this.Category = Category;
      this.sumAmount = sumAmount;
   }

   public String getCategory() {
      return Category;
   }

   public int getSumAmount() {
      return sumAmount;
   }

   


}