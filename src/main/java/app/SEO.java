package app;

/**
 * Class represeting a LGA from the Studio Project database
 * In the template, this only uses the code and name for 2016
 *
 * @author Timothy Wiley, 2022. email: timothy.wiley@rmit.edu.au
 */
public class SEO {
   // SEO ID
   private int seoId;

   // SEO TITLE
   private String seoTitle;

   // LGA 2016 Name
   private String seoDescrip;

   /**
    * Create an LGA and set the fields
    */
   public SEO(int seoId, String seoTitle, String seoDescrip) {
      this.seoId = seoId;
      this.seoTitle = seoTitle;
      this.seoDescrip = seoDescrip;
   }

   public int getSeoId() {
      return seoId;
   }

   public String getSeoT() {
      return seoTitle;
   }

   public String getSeoD() {
      return seoDescrip;
   }
}
