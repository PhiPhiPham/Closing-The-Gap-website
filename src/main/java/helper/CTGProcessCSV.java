package helper;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.Scanner;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Stand-alone Java file for processing the database CSV files.
 * <p>
 * You can run this file using the "Run" or "Debug" options
 * from within VSCode. This won't conflict with the web server.
 * <p>
 * This program opens a CSV file from the Closing-the-Gap data set
 * and uses JDBC to load up data into the database.
 * <p>
 * To use this program you will need to change:
 * 1. The input file location
 * 2. The output file location
 * <p>
 * This assumes that the CSV files are the the **database** folder.
 * <p>
 * WARNING: This code may take quite a while to run as there will be a lot
 * of SQL insert statments!
 *
 * @author Timothy Wiley, 2021. email: timothy.wiley@rmit.edu.au
 * 
 */
public class CTGProcessCSV {

   // MODIFY these to load/store to/from the correct locations

   private static final String DATABASE = "jdbc:sqlite:database/ctg.db";
   private static final String CSV_FILE = "database/lga_total_household_income_weekly_by_indigenous_status_of_household_2021.csv";

   public static void main(String[] args) {
      // The following arrays define the order of columns in the INPUT CSV.
      // The order of each array MUST match the order of the CSV.
      // These are specific to the given file and should be changed for each file.
      // This is a *simple* way to help you get up and running quickly wihout being
      // confusing
      // String category[] = {
      // "_0_4",
      // "_5_9",
      // "_10_14",
      // "_15_19",
      // "_20_24",
      // "_25_29",
      // "_30_34",
      // "_35_39",
      // "_40_44",
      // "_45_49",
      // "_50_54",
      // "_55_59",
      // "_60_64",
      // "_65_yrs_ov"
      // };

      // String category[] = {
      // "arthritis",
      // "asthma",
      // "cancer",
      // "dementia",
      // "diabetes",
      // "heartdisease",
      // "kidneydisease",
      // "lungcondition",
      // "mentalhealth",
      // "stroke",
      // "other"
      // };

      // String status[] = {
      // "indig",
      // "non-indig",
      // "indig_stat_notstated"
      // };

      String category[] = {
            "1_149",
            "150_299",
            "300_399",
            "400_499",
            "500_649",
            "650_799",
            "800_999",
            "1000_1249",
            "1250_1499",
            "1500_1999",
            "2000_2499",
            "2500_2999",
            "3000_more"
      };

      String status[] = {
            "hhds_with_indig_persons",
            "other_hhds",
            "total_hhds"
      };

      // String sex[] = {
      // "f",
      // "m"
      // };

      // Steven's added code
      // String agemin[] = {
      // "_0",
      // "_5",
      // "_10",
      // "_15",
      // "_20",
      // "_25",
      // "_30",
      // "_35",
      // "_40",
      // "_45",
      // "_50",
      // "_55",
      // "_60",
      // "_65"
      // };

      // String agemax[] = {
      // "_4",
      // "_9",
      // "_14",
      // "_19",
      // "_24",
      // "_29",
      // "_34",
      // "_39",
      // "_44",
      // "_49",
      // "_54",
      // "_59",
      // "_64",
      // "_yrs_ov"
      // };

      // String category[] = {
      // "did_not_go_to_school",
      // "y8_below",
      // "year9_equivalent",
      // "year10_equivalent",
      // "year11_equivalent",
      // "year12_equivalent"
      // };

      String bracketmin[] = {
            "1",
            "150",
            "300",
            "400",
            "500",
            "650",
            "800",
            "1000",
            "1250",
            "1500",
            "2000",
            "2500",
            "3000"
      };

      // 9999 representing infinite

      String bracketmax[] = {
            "149",
            "299",
            "399",
            "499",
            "649",
            "799",
            "999",
            "1249",
            "1499",
            "1999",
            "2499",
            "2999",
            "9999"
      };

      // JDBC Database Object
      Connection connection = null;

      // Like JDBCConnection, we need some error handling.
      try {
         // Open A CSV File to process, one line at a time
         // CHANGE THIS to process a different file
         Scanner lineScanner = new Scanner(new File(CSV_FILE));

         // Read the first line of "headings"
         String header = lineScanner.nextLine();
         System.out.println("Heading row" + header + "\n");

         // Setup JDBC
         // Connect to JDBC data base
         connection = DriverManager.getConnection(DATABASE);

         // Read each line of the CSV
         int row = 1;
         while (lineScanner.hasNext()) {
            // Always get scan by line
            String line = lineScanner.nextLine();

            // Create a new scanner for this line to delimit by commas (,)
            Scanner rowScanner = new Scanner(line);
            rowScanner.useDelimiter(",");

            // These indicies track which column we are up to
            int indexStatus = 0;
            int indexSex = 0;
            int indexCategory = 0;

            // Save the lga_code as we need it for the foreign key
            String lgaCode = rowScanner.next();

            // Skip lga_name
            // String lgaName = rowScanner.next();

            // Go through the data for the row
            // If we run out of categories, stop for safety (so the code doesn't crash)
            while (rowScanner.hasNext() && indexCategory < category.length) {
               String count = rowScanner.next();

               // Prepare a new SQL Query & Set a timeout
               Statement statement = connection.createStatement();

               // Create Insert Statement
               // There's usually a bracket right after count instead of that comma** changed
               // since added the categories
               String query = "INSERT into WeeklyIncome VALUES ("
                     + lgaCode + ","
                     + "'" + 2021 + "',"
                     + "'" + status[indexStatus] + "',"
                     // + "'" + sex[indexSex] + "',"
                     + "'" + category[indexCategory] + "',"
                     + count + ","
                     + "'" + bracketmin[indexCategory] + "',"
                     + "'" + bracketmax[indexCategory] + "')";

               // Execute the INSERT
               System.out.println("Executing: " + query);
               statement.execute(query);

               // Update indices - go to next sex
               // indexSex++;
               // if (indexSex >= sex.length) {
               // // Go to next status
               // indexSex = 0;
               // indexStatus++;

               // if (indexStatus >= status.length) {
               // // Go to next Category
               // indexStatus = 0;
               // indexCategory++;
               // }
               // }
               // row++;

               indexStatus++;
               if (indexStatus >= status.length) {
                  indexStatus = 0;
                  indexCategory++;
               }
               row++;
            }
         }

      } catch (Exception e) {
         e.printStackTrace();
      }

   }
}
