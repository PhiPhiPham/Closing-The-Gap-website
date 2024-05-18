package app;

/**
 * Class represeting a LGA from the Studio Project database
 * In the template, this only uses the code and name for 2016
 *
 * @author Timothy Wiley, 2022. email: timothy.wiley@rmit.edu.au
 */
public class LGA {
   // LGA 2016 Code
   private int code;

   // LGA 2016 Name
   private String name;

   private int year;

   private String status;

   private String sex;

   private String categorey;

   private int count;

   /**
    * Create an LGA and set the fields
    */
   public LGA(int code, String name) {
      this.code = code;
      this.name = name;
   }
   
   // Outcome2 constructor
   // code, year, name, status, sex, schoolyear, count
   public LGA(int code, int year, String name, String status, String sex, String categorey, int count) {
      this.code = code;
      this.year = year;
      this.name = name;
      this.status = status;
      this.sex = sex;
      this.categorey = categorey;
      this.count = count; 
   }

   public LGA(String status, String categorey, int count) {
      this.status = status;
      this.categorey = categorey;
      this.count = count; 
   }

   public int getCode() {
      return code;
   }

   public int getYear() {
      return year;
   }

   public String getName() {
      return name;
   }

   public String getStatus() {
      return status;
   }

   public String getSex() {
      return sex;
   }
   
   public String getCategorey() {
      return categorey;
   }

   public int getCount() {
      return count;
   }
}
