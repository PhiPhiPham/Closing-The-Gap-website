package app;

import java.util.ArrayList;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Class for Managing the JDBC Connection to a SQLLite Database.
 * Allows SQL queries to be used with the SQLLite Databse in Java.
 *
 * @author Timothy Wiley, 2022. email: timothy.wiley@rmit.edu.au
 * @author Santha Sumanasekara, 2021. email: santha.sumanasekara@rmit.edu.au
 */
public class JDBCConnection {

    // Name of database file (contained in database folder)
    private static final String DATABASE = "jdbc:sqlite:database/ctg.db";

    /**
     * This creates a JDBC Object so we can keep talking to the database
     */
    public JDBCConnection() {
        System.out.println("Created JDBC Connection Object");
    }

    /**
     * Get all of the LGAs in the database.
     * 
     * @return
     *         Returns an ArrayList of LGA objects
     */
    public ArrayList<LGA> getLGAs() {
        // Create the ArrayList of LGA objects to return
        ArrayList<LGA> lgas = new ArrayList<LGA>();

        // Setup the variable for the JDBC connection
        Connection connection = null;

        try {
            // Connect to JDBC data base
            connection = DriverManager.getConnection(DATABASE);

            // Prepare a new SQL Query & Set a timeout
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);

            // The Query
            String query = "SELECT * FROM LGA";

            // Get Result
            ResultSet results = statement.executeQuery(query);

            // Process all of the results
            while (results.next()) {
                // Lookup the columns we need
                int code16 = results.getInt("lga_code16");
                String name16 = results.getString("lga_name16");

                // Create a LGA Object
                LGA lga = new LGA(code16, name16);

                // Add the lga object to the array
                lgas.add(lga);
            }

            // Close the statement because we are done with it
            statement.close();
        } catch (SQLException e) {
            // If there is an error, lets just pring the error
            System.err.println(e.getMessage());
        } finally {
            // Safety code to cleanup
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                // connection close failed.
                System.err.println(e.getMessage());
            }
        }

        // Finally we return all of the lga
        return lgas;
    }

    /***************** Get Socioeconomic Outcome Description ****************/

    public ArrayList<SEO> getSEO() {
        ArrayList<SEO> seos = new ArrayList<SEO>();

        // Setup the variable for the JDBC connection
        Connection connection = null;

        try {

            // Connect to JDBC data base
            connection = DriverManager.getConnection(DATABASE);

            // Prepare a new SQL Query & Set a timeout
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);

            // The Query
            String query = "SELECT * FROM SocioeconomicOutcome";
            System.out.println(query);

            // Get Result
            ResultSet results = statement.executeQuery(query);

            // Process all of the results
            while (results.next()) {
                // Create a Movie Object
                int seoId = results.getInt("id");
                String seoTitle = results.getString("Title");
                String seoDescrip = results.getString("Descrip");

                // Create a LGA Object
                SEO seo = new SEO(seoId, seoTitle, seoDescrip);

                // Add the lga object to the array
                seos.add(seo);
            }

            // Close the statement because we are done with it
            statement.close();
        } catch (SQLException e) {
            // If there is an error, lets just pring the error
            System.err.println(e.getMessage());
        } finally {
            // Safety code to cleanup
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                // connection close failed.
                System.err.println(e.getMessage());
            }
        }

        return seos;
    }

    // Get Persona Attribute

    public String getPersonaAtt(int personaId, String attType) {
        String personaAttr = "";

        // Setup the variable for the JDBC connection
        Connection connection = null;

        try {

            // Connect to JDBC data base
            connection = DriverManager.getConnection(DATABASE);

            // Prepare a new SQL Query & Set a timeout
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);

            // The Query
            String query = "SELECT * FROM PersonaAttribute WHERE PersonaID = " + personaId
                    + " AND AttributeType like '" + attType + "' ;";
            System.out.println(query);

            // Get Result
            ResultSet results = statement.executeQuery(query);

            // Process all of the results
            personaAttr = results.getString("Descrip");

            // Close the statement because we are done with it
            statement.close();
        } catch (SQLException e) {
            // If there is an error, lets just pring the error
            System.err.println(e.getMessage());
        } finally {
            // Safety code to cleanup
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                // connection close failed.
                System.err.println(e.getMessage());
            }
        }

        return personaAttr;
    }

    public ArrayList<Persona> getPersona() {
        ArrayList<Persona> persona = new ArrayList<Persona>();

        // Setup the variable for the JDBC connection
        Connection connection = null;

        try {

            // Connect to JDBC data base
            connection = DriverManager.getConnection(DATABASE);

            // Prepare a new SQL Query & Set a timeout
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);

            // The Query
            String query = "SELECT * FROM Persona";
            System.out.println(query);

            // Get Result
            ResultSet results = statement.executeQuery(query);

            // Process all of the results
            while (results.next()) {
                // Create a Movie Object
                String name = results.getString("Name");
                String imgPath = results.getString("ImageFilePath");

                // Create a LGA Object
                Persona individualPersona = new Persona(name, imgPath);

                // Add the lga object to the array
                persona.add(individualPersona);
            }

            // Close the statement because we are done with it
            statement.close();
        } catch (SQLException e) {
            // If there is an error, lets just pring the error
            System.err.println(e.getMessage());
        } finally {
            // Safety code to cleanup
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                // connection close failed.
                System.err.println(e.getMessage());
            }
        }

        return persona;
    }

    // Population Stats
    public ArrayList<LGA> getOutcome1() {
        // Create the ArrayList of LGA objects to return
        ArrayList<LGA> lgas = new ArrayList<LGA>();

        // Setup the variable for the JDBC connection
        Connection connection = null;

        try {
            // Connect to JDBC data base
            connection = DriverManager.getConnection(DATABASE);

            // Prepare a new SQL Query & Set a timeout
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);

            // The Query
            String query = "SELECT * FROM LGA l JOIN PopulationStatistics s ON l.lga_code16 = s.code AND l.year = s.year;";

            // Get Result
            ResultSet results = statement.executeQuery(query);

            // Process all of the results
            while (results.next()) {
                // Lookup the columns we need
                int code = results.getInt("lga_code16");
                int year = results.getInt("year");
                String name = results.getString("lga_name16");
                String status = results.getString("indigenous_status");
                String sex = results.getString("sex");
                String age = results.getString("age");
                int count = results.getInt("count");

                // Create a LGA Object
                LGA lga = new LGA(code, year, name, status, sex, age, count);

                // Add the lga object to the array
                lgas.add(lga);
            }

            // Close the statement because we are done with it
            statement.close();
        } catch (SQLException e) {
            // If there is an error, lets just pring the error
            System.err.println(e.getMessage());
        } finally {
            // Safety code to cleanup
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                // connection close failed.
                System.err.println(e.getMessage());
            }
        }

        // Finally we return all of the lga
        return lgas;
    }

    // SchoolCompletion

    public ArrayList<LGA> getOutcome2() {
        // Create the ArrayList of LGA objects to return
        ArrayList<LGA> lgas = new ArrayList<LGA>();

        // Setup the variable for the JDBC connection
        Connection connection = null;

        try {
            // Connect to JDBC data base
            connection = DriverManager.getConnection(DATABASE);

            // Prepare a new SQL Query & Set a timeout
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);

            // The Query
            String query = "SELECT * FROM LGA l JOIN SchoolCompletion s ON l.lga_code16 = s.code AND l.year = s.year;";

            // Get Result
            ResultSet results = statement.executeQuery(query);

            // Process all of the results
            while (results.next()) {
                // Lookup the columns we need
                int code = results.getInt("lga_code16");
                int year = results.getInt("year");
                String name = results.getString("lga_name16");
                String status = results.getString("indigenous_status");
                String sex = results.getString("sex");
                String schoolyear = results.getString("schoolyear");
                int count = results.getInt("count");

                // Create a LGA Object
                LGA lga = new LGA(code, year, name, status, sex, schoolyear, count);

                // Add the lga object to the array
                lgas.add(lga);
            }

            // Close the statement because we are done with it
            statement.close();
        } catch (SQLException e) {
            // If there is an error, lets just pring the error
            System.err.println(e.getMessage());
        } finally {
            // Safety code to cleanup
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                // connection close failed.
                System.err.println(e.getMessage());
            }
        }

        // Finally we return all of the lga
        return lgas;
    }

    // LTHC

    public ArrayList<LGA> getOutcome3() {
        // Create the ArrayList of LGA objects to return
        ArrayList<LGA> lgas = new ArrayList<LGA>();

        // Setup the variable for the JDBC connection
        Connection connection = null;

        try {
            // Connect to JDBC data base
            connection = DriverManager.getConnection(DATABASE);

            // Prepare a new SQL Query & Set a timeout
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);

            // The Query
            String query = "SELECT * FROM LGA l JOIN LTHC s ON l.lga_code16 = s.code AND l.year = s.year;";

            // Get Result
            ResultSet results = statement.executeQuery(query);

            // Process all of the results
            while (results.next()) {
                // Lookup the columns we need
                int code = results.getInt("lga_code16");
                int year = results.getInt("year");
                String name = results.getString("lga_name16");
                String status = results.getString("indigenous_status");
                String sex = results.getString("sex");
                String condition = results.getString("condition");
                int count = results.getInt("count");

                // Create a LGA Object
                LGA lga = new LGA(code, year, name, status, sex, condition, count);

                // Add the lga object to the array
                lgas.add(lga);
            }

            // Close the statement because we are done with it
            statement.close();
        } catch (SQLException e) {
            // If there is an error, lets just pring the error
            System.err.println(e.getMessage());
        } finally {
            // Safety code to cleanup
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                // connection close failed.
                System.err.println(e.getMessage());
            }
        }

        // Finally we return all of the lga
        return lgas;
    }

    // Weekly Income

    public ArrayList<LGA> getOutcome4() {
        // Create the ArrayList of LGA objects to return
        ArrayList<LGA> lgas = new ArrayList<LGA>();

        // Setup the variable for the JDBC connection
        Connection connection = null;

        try {
            // Connect to JDBC data base
            connection = DriverManager.getConnection(DATABASE);

            // Prepare a new SQL Query & Set a timeout
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);

            // The Query
            String query = "SELECT * FROM LGA l JOIN LTHC s ON l.lga_code16 = s.code AND l.year = s.year;";

            // Get Result
            ResultSet results = statement.executeQuery(query);

            // Process all of the results
            while (results.next()) {
                // Lookup the columns we need
                int code = results.getInt("lga_code16");
                int year = results.getInt("year");
                String name = results.getString("lga_name16");
                String status = results.getString("indigenous_status");
                String sex = results.getString("sex");
                String incomebracket = results.getString("incomebracket");
                int count = results.getInt("count");

                // Create a LGA Object
                LGA lga = new LGA(code, year, name, status, sex, incomebracket, count);

                // Add the lga object to the array
                lgas.add(lga);
            }

            // Close the statement because we are done with it
            statement.close();
        } catch (SQLException e) {
            // If there is an error, lets just pring the error
            System.err.println(e.getMessage());
        } finally {
            // Safety code to cleanup
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                // connection close failed.
                System.err.println(e.getMessage());
            }
        }

        // Finally we return all of the lga
        return lgas;
    }

    public ArrayList<LGA> getTablest21(String outcome, String order, String pageNo, String sortBy) {
        // Create the ArrayList of LGA objects to return
        ArrayList<LGA> lgas = new ArrayList<LGA>();

        // Setup the variable for the JDBC connection
        Connection connection = null;

        try {
            // Connect to JDBC data base
            connection = DriverManager.getConnection(DATABASE);

            // Prepare a new SQL Query & Set a timeout
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);

            if (sortBy.equals("category")) {
                if (outcome.equals("PopulationStatistics")) {
                    sortBy = "age";
                } else if (outcome.equals("SchoolCompletion")) {
                    sortBy = "schoolyear";
                } else if (outcome.equals("LTHC")) {
                    sortBy = "condition";
                } else if (outcome.equals("WeeklyIncome")) {
                    sortBy = "incomebracket";
                }
            }

            

            // The Query

            String query = "SELECT * FROM LGA l JOIN " + outcome + " ON l.lga_code16 = code ORDER BY " + sortBy + " "
                    + order + " LIMIT 30 OFFSET (" + pageNo + " - 1) * 30 + 1;";

            // Get Result
            ResultSet results = statement.executeQuery(query);

            // Process all of the results
            while (results.next()) {
                // Lookup the columns we need
                int code = results.getInt("lga_code16");
                int year = results.getInt("year");
                String name = results.getString("lga_name16");
                String status = results.getString("indigenous_status");
                String sex = "";
                String categorey = "";

                if (outcome.equals("PopulationStatistics")) {
                    sex = results.getString("sex");
                } else if (outcome.equals("SchoolCompletion")) {
                    sex = results.getString("sex");
                } else if (outcome.equals("LTHC")) {
                    sex = results.getString("sex");
                } else if (outcome.equals("WeeklyIncome")) {
                    sex = "";
                }

                if (outcome.equals("PopulationStatistics")) {
                    categorey = results.getString("age");
                } else if (outcome.equals("SchoolCompletion")) {
                    categorey = results.getString("schoolyear");
                } else if (outcome.equals("LTHC")) {
                    categorey = results.getString("condition");
                } else if (outcome.equals("WeeklyIncome")) {
                    categorey = results.getString("incomebracket");
                }

                int count = results.getInt("count");

                // Create a LGA Object
                LGA lga = new LGA(code, year, name, status, sex, categorey, count);

                // Add the lga object to the array
                lgas.add(lga);
            }

            // Close the statement because we are done with it
            statement.close();
        } catch (SQLException e) {
            // If there is an error, lets just pring the error
            System.err.println(e.getMessage());
        } finally {
            // Safety code to cleanup
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                // connection close failed.
                System.err.println(e.getMessage());
            }
        }

        // Finally we return all of the lga
        return lgas;
    }

    public ArrayList<LGA> getTheGapst21(String outcome) {
        // Create the ArrayList of LGA objects to return
        ArrayList<LGA> lgas = new ArrayList<LGA>();

        // Setup the variable for the JDBC connection
        Connection connection = null;

        try {
            // Connect to JDBC data base
            connection = DriverManager.getConnection(DATABASE);

            // Prepare a new SQL Query & Set a timeout
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);

            
            String query = "";

            // The Query
            if (outcome.equals("PopulationStatistics")) {
                 query = "SELECT indigenous_status, age, SUM(count) FROM " + outcome + " WHERE Indigenous_status = 'indig' AND year = 2021 GROUP BY age UNION SELECT indigenous_status, age, SUM(count) FROM " + outcome + " WHERE Indigenous_status = 'non-indig' AND year = 2021 GROUP BY age";

            } else if (outcome.equals("SchoolCompletion")) {
                query = "SELECT indigenous_status, schoolyear, SUM(count) FROM " + outcome + " WHERE Indigenous_status = 'indig' AND year = 2021 GROUP BY schoolyear UNION SELECT indigenous_status, schoolyear, SUM(count) FROM " + outcome + " WHERE Indigenous_status = 'non-indig' AND year = 2021 GROUP BY schoolyear";

            } else if (outcome.equals("LTHC")) {
                query = "SELECT indigenous_status, condition, SUM(count) FROM " + outcome + " WHERE Indigenous_status = 'indig' AND year = 2021 GROUP BY condition UNION SELECT indigenous_status, condition, SUM(count) FROM " + outcome + " WHERE Indigenous_status = 'non-indig' AND year = 2021 GROUP BY condition";

            } else if (outcome.equals("WeeklyIncome")) {
                query = "SELECT indigenous_status, incomebracket, SUM(count) FROM " + outcome + " WHERE Indigenous_status = 'hhds_with_indig_persons' AND year = 2021 GROUP BY incomebracket UNION SELECT indigenous_status, incomebracket, SUM(count) FROM " + outcome + " WHERE Indigenous_status = 'other_hhds' AND year = 2021 GROUP BY incomebracket";
            }
            
            // Get Result
            ResultSet results = statement.executeQuery(query);

            // Process all of the results
            while (results.next()) {
                // Lookup the columns we need
                String status = results.getString("indigenous_status");
                String categorey = "";


                if (outcome.equals("PopulationStatistics")) {
                    categorey = results.getString("age");
                } else if (outcome.equals("SchoolCompletion")) {
                    categorey = results.getString("schoolyear");
                } else if (outcome.equals("LTHC")) {
                    categorey = results.getString("condition");
                } else if (outcome.equals("WeeklyIncome")) {
                    categorey = results.getString("incomebracket");
                }

                int count = results.getInt("SUM(count)");

                // Create a LGA Object
                LGA lga = new LGA(status, categorey, count);

                // Add the lga object to the array
                lgas.add(lga);
            }

            // Close the statement because we are done with it
            statement.close();
        } catch (SQLException e) {
            // If there is an error, lets just pring the error
            System.err.println(e.getMessage());
        } finally {
            // Safety code to cleanup
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                // connection close failed.
                System.err.println(e.getMessage());
            }
        }

        // Finally we return all of the lga
        return lgas;
    }

    public ArrayList<Categorey> getO2categorey() {
        // Create the ArrayList of LGA objects to return
        ArrayList<Categorey> categories = new ArrayList<Categorey>();

        // Setup the variable for the JDBC connection
        Connection connection = null;

        try {
            // Connect to JDBC data base
            connection = DriverManager.getConnection(DATABASE);

            // Prepare a new SQL Query & Set a timeout
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);

            // The Query
            String query = "SELECT schoolyear, SUM(count) AS count FROM SchoolCompletion WHERE year = 2021 GROUP BY schoolyear;";

            // Get Result
            ResultSet results = statement.executeQuery(query);

            // Process all of the results
            while (results.next()) {
                // Lookup the columns we need
                String cate = results.getString("schoolyear");
                int count = results.getInt("count");

                // Create a LGA Object
                Categorey categorey = new Categorey(cate, count);

                // Add the lga object to the array
                categories.add(categorey);
            }

            // Close the statement because we are done with it
            statement.close();
        } catch (SQLException e) {
            // If there is an error, lets just pring the error
            System.err.println(e.getMessage());
        } finally {
            // Safety code to cleanup
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                // connection close failed.
                System.err.println(e.getMessage());
            }
        }

        // Finally we return all of the lga
        return categories;
    }

    

    public ArrayList<Categorey> getO2Sex() {
        // Create the ArrayList of LGA objects to return
        ArrayList<Categorey> categories = new ArrayList<Categorey>();

        // Setup the variable for the JDBC connection
        Connection connection = null;

        try {
            // Connect to JDBC data base
            connection = DriverManager.getConnection(DATABASE);

            // Prepare a new SQL Query & Set a timeout
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);

            // The Query
            String query = "SELECT sex, SUM(count) AS count FROM SchoolCompletion WHERE year = 2021 GROUP BY sex;";

            // Get Result
            ResultSet results = statement.executeQuery(query);

            // Process all of the results
            while (results.next()) {
                // Lookup the columns we need
                String cate = results.getString("sex");
                int count = results.getInt("count");

                // Create a LGA Object
                Categorey categorey = new Categorey(cate, count);

                // Add the lga object to the array
                categories.add(categorey);
            }

            // Close the statement because we are done with it
            statement.close();
        } catch (SQLException e) {
            // If there is an error, lets just pring the error
            System.err.println(e.getMessage());
        } finally {
            // Safety code to cleanup
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                // connection close failed.
                System.err.println(e.getMessage());
            }
        }

        // Finally we return all of the lga
        return categories;
    }

    public ArrayList<Categorey> getO2Status() {
        // Create the ArrayList of LGA objects to return
        ArrayList<Categorey> categories = new ArrayList<Categorey>();

        // Setup the variable for the JDBC connection
        Connection connection = null;

        try {
            // Connect to JDBC data base
            connection = DriverManager.getConnection(DATABASE);

            // Prepare a new SQL Query & Set a timeout
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);

            // The Query
            String query = "SELECT indigenous_status, SUM(count) AS count FROM SchoolCompletion WHERE year = 2021 GROUP BY indigenous_status";

            // Get Result
            ResultSet results = statement.executeQuery(query);

            // Process all of the results
            while (results.next()) {
                // Lookup the columns we need
                String cate = results.getString("indigenous_status");
                int count = results.getInt("count");

                // Create a LGA Object
                Categorey categorey = new Categorey(cate, count);

                // Add the lga object to the array
                categories.add(categorey);
            }

            // Close the statement because we are done with it
            statement.close();
        } catch (SQLException e) {
            // If there is an error, lets just pring the error
            System.err.println(e.getMessage());
        } finally {
            // Safety code to cleanup
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                // connection close failed.
                System.err.println(e.getMessage());
            }
        }

        // Finally we return all of the lga
        return categories;
    }

    public ArrayList<Categorey> getO1categorey() {
        // Create the ArrayList of LGA objects to return
        ArrayList<Categorey> categories = new ArrayList<Categorey>();

        // Setup the variable for the JDBC connection
        Connection connection = null;

        try {
            // Connect to JDBC data base
            connection = DriverManager.getConnection(DATABASE);

            // Prepare a new SQL Query & Set a timeout
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);

            // The Query
            String query = "SELECT age, SUM(count) AS count FROM Populationstatistics WHERE year = 2021 GROUP BY age;";

            // Get Result
            ResultSet results = statement.executeQuery(query);

            // Process all of the results
            while (results.next()) {
                // Lookup the columns we need
                String cate = results.getString("age");
                int count = results.getInt("count");

                // Create a LGA Object
                Categorey categorey = new Categorey(cate, count);

                // Add the lga object to the array
                categories.add(categorey);
            }

            // Close the statement because we are done with it
            statement.close();
        } catch (SQLException e) {
            // If there is an error, lets just pring the error
            System.err.println(e.getMessage());
        } finally {
            // Safety code to cleanup
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                // connection close failed.
                System.err.println(e.getMessage());
            }
        }

        // Finally we return all of the lga
        return categories;
    }

    public ArrayList<Categorey> getO1Sex() {
        // Create the ArrayList of LGA objects to return
        ArrayList<Categorey> categories = new ArrayList<Categorey>();

        // Setup the variable for the JDBC connection
        Connection connection = null;

        try {
            // Connect to JDBC data base
            connection = DriverManager.getConnection(DATABASE);

            // Prepare a new SQL Query & Set a timeout
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);

            // The Query
            String query = "SELECT sex, SUM(count) AS count FROM PopulationStatistics WHERE year = 2021 GROUP BY sex;";

            // Get Result
            ResultSet results = statement.executeQuery(query);

            // Process all of the results
            while (results.next()) {
                // Lookup the columns we need
                String cate = results.getString("sex");
                int count = results.getInt("count");

                // Create a LGA Object
                Categorey categorey = new Categorey(cate, count);

                // Add the lga object to the array
                categories.add(categorey);
            }

            // Close the statement because we are done with it
            statement.close();
        } catch (SQLException e) {
            // If there is an error, lets just pring the error
            System.err.println(e.getMessage());
        } finally {
            // Safety code to cleanup
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                // connection close failed.
                System.err.println(e.getMessage());
            }
        }

        // Finally we return all of the lga
        return categories;
    }

    public ArrayList<Categorey> getO1Status() {
        // Create the ArrayList of LGA objects to return
        ArrayList<Categorey> categories = new ArrayList<Categorey>();

        // Setup the variable for the JDBC connection
        Connection connection = null;

        try {
            // Connect to JDBC data base
            connection = DriverManager.getConnection(DATABASE);

            // Prepare a new SQL Query & Set a timeout
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);

            // The Query
            String query = "SELECT indigenous_status, SUM(count) AS count FROM PopulationStatistics WHERE year = 2021 GROUP BY indigenous_status";

            // Get Result
            ResultSet results = statement.executeQuery(query);

            // Process all of the results
            while (results.next()) {
                // Lookup the columns we need
                String cate = results.getString("indigenous_status");
                int count = results.getInt("count");

                // Create a LGA Object
                Categorey categorey = new Categorey(cate, count);

                // Add the lga object to the array
                categories.add(categorey);
            }

            // Close the statement because we are done with it
            statement.close();
        } catch (SQLException e) {
            // If there is an error, lets just pring the error
            System.err.println(e.getMessage());
        } finally {
            // Safety code to cleanup
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                // connection close failed.
                System.err.println(e.getMessage());
            }
        }

        // Finally we return all of the lga
        return categories;
    }

    public ArrayList<Categorey> getO3Status() {
        // Create the ArrayList of LGA objects to return
        ArrayList<Categorey> categories = new ArrayList<Categorey>();

        // Setup the variable for the JDBC connection
        Connection connection = null;

        try {
            // Connect to JDBC data base
            connection = DriverManager.getConnection(DATABASE);

            // Prepare a new SQL Query & Set a timeout
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);

            // The Query
            String query = "SELECT indigenous_status, SUM(count) AS count FROM LTHC WHERE year = 2021 GROUP BY indigenous_status";

            // Get Result
            ResultSet results = statement.executeQuery(query);

            // Process all of the results
            while (results.next()) {
                // Lookup the columns we need
                String cate = results.getString("indigenous_status");
                int count = results.getInt("count");

                // Create a LGA Object
                Categorey categorey = new Categorey(cate, count);

                // Add the lga object to the array
                categories.add(categorey);
            }

            // Close the statement because we are done with it
            statement.close();
        } catch (SQLException e) {
            // If there is an error, lets just pring the error
            System.err.println(e.getMessage());
        } finally {
            // Safety code to cleanup
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                // connection close failed.
                System.err.println(e.getMessage());
            }
        }

        // Finally we return all of the lga
        return categories;
    }

    public ArrayList<Categorey> getO3Sex() {
        // Create the ArrayList of LGA objects to return
        ArrayList<Categorey> categories = new ArrayList<Categorey>();

        // Setup the variable for the JDBC connection
        Connection connection = null;

        try {
            // Connect to JDBC data base
            connection = DriverManager.getConnection(DATABASE);

            // Prepare a new SQL Query & Set a timeout
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);

            // The Query
            String query = "SELECT sex, SUM(count) AS count FROM LTHC WHERE year = 2021 GROUP BY sex;";

            // Get Result
            ResultSet results = statement.executeQuery(query);

            // Process all of the results
            while (results.next()) {
                // Lookup the columns we need
                String cate = results.getString("sex");
                int count = results.getInt("count");

                // Create a LGA Object
                Categorey categorey = new Categorey(cate, count);

                // Add the lga object to the array
                categories.add(categorey);
            }

            // Close the statement because we are done with it
            statement.close();
        } catch (SQLException e) {
            // If there is an error, lets just pring the error
            System.err.println(e.getMessage());
        } finally {
            // Safety code to cleanup
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                // connection close failed.
                System.err.println(e.getMessage());
            }
        }

        // Finally we return all of the lga
        return categories;
    }

    public ArrayList<Categorey> getO3categorey() {
        // Create the ArrayList of LGA objects to return
        ArrayList<Categorey> categories = new ArrayList<Categorey>();

        // Setup the variable for the JDBC connection
        Connection connection = null;

        try {
            // Connect to JDBC data base
            connection = DriverManager.getConnection(DATABASE);

            // Prepare a new SQL Query & Set a timeout
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);

            // The Query
            String query = "SELECT condition, SUM(count) AS count FROM LTHC WHERE year = 2021 GROUP BY condition;";

            // Get Result
            ResultSet results = statement.executeQuery(query);

            // Process all of the results
            while (results.next()) {
                // Lookup the columns we need
                String cate = results.getString("condition");
                int count = results.getInt("count");

                // Create a LGA Object
                Categorey categorey = new Categorey(cate, count);

                // Add the lga object to the array
                categories.add(categorey);
            }

            // Close the statement because we are done with it
            statement.close();
        } catch (SQLException e) {
            // If there is an error, lets just pring the error
            System.err.println(e.getMessage());
        } finally {
            // Safety code to cleanup
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                // connection close failed.
                System.err.println(e.getMessage());
            }
        }
        return categories;
    }

    public ArrayList<Categorey> getO4Status() {
        // Create the ArrayList of LGA objects to return
        ArrayList<Categorey> categories = new ArrayList<Categorey>();

        // Setup the variable for the JDBC connection
        Connection connection = null;

        try {
            // Connect to JDBC data base
            connection = DriverManager.getConnection(DATABASE);

            // Prepare a new SQL Query & Set a timeout
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);

            // The Query
            String query = "SELECT indigenous_status, SUM(count) AS count FROM WeeklyIncome WHERE year = 2021 GROUP BY indigenous_status";

            // Get Result
            ResultSet results = statement.executeQuery(query);

            // Process all of the results
            while (results.next()) {
                // Lookup the columns we need
                String cate = results.getString("indigenous_status");
                int count = results.getInt("count");

                // Create a LGA Object
                Categorey categorey = new Categorey(cate, count);

                // Add the lga object to the array
                categories.add(categorey);
            }

            // Close the statement because we are done with it
            statement.close();
        } catch (SQLException e) {
            // If there is an error, lets just pring the error
            System.err.println(e.getMessage());
        } finally {
            // Safety code to cleanup
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                // connection close failed.
                System.err.println(e.getMessage());
            }
        }

        // Finally we return all of the lga
        return categories;
    }

    public ArrayList<Categorey> getO4Sex() {
        // Create the ArrayList of LGA objects to return
        ArrayList<Categorey> categories = new ArrayList<Categorey>();

        // Setup the variable for the JDBC connection
        Connection connection = null;

        try {
            // Connect to JDBC data base
            connection = DriverManager.getConnection(DATABASE);

            // Prepare a new SQL Query & Set a timeout
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);

            // The Query
            String query = "SELECT sex, SUM(count) AS count FROM WeeklyIncome WHERE year = 2021 GROUP BY sex;";

            // Get Result
            ResultSet results = statement.executeQuery(query);

            // Process all of the results
            while (results.next()) {
                // Lookup the columns we need
                String cate = results.getString("sex");
                int count = results.getInt("count");

                // Create a LGA Object
                Categorey categorey = new Categorey(cate, count);

                // Add the lga object to the array
                categories.add(categorey);
            }

            // Close the statement because we are done with it
            statement.close();
        } catch (SQLException e) {
            // If there is an error, lets just pring the error
            System.err.println(e.getMessage());
        } finally {
            // Safety code to cleanup
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                // connection close failed.
                System.err.println(e.getMessage());
            }
        }

        // Finally we return all of the lga
        return categories;
    }

    public ArrayList<Categorey> getO4categorey() {
        // Create the ArrayList of LGA objects to return
        ArrayList<Categorey> categories = new ArrayList<Categorey>();

        // Setup the variable for the JDBC connection
        Connection connection = null;

        try {
            // Connect to JDBC data base
            connection = DriverManager.getConnection(DATABASE);

            // Prepare a new SQL Query & Set a timeout
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);

            // The Query
            String query = "SELECT incomebracket, SUM(count) AS count FROM WeeklyIncome WHERE year = 2021 GROUP BY incomebracket;";

            // Get Result
            ResultSet results = statement.executeQuery(query);

            // Process all of the results
            while (results.next()) {
                // Lookup the columns we need
                String cate = results.getString("incomebracket");
                int count = results.getInt("count");

                // Create a LGA Object
                Categorey categorey = new Categorey(cate, count);

                // Add the lga object to the array
                categories.add(categorey);
            }

            // Close the statement because we are done with it
            statement.close();
        } catch (SQLException e) {
            // If there is an error, lets just pring the error
            System.err.println(e.getMessage());
        } finally {
            // Safety code to cleanup
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                // connection close failed.
                System.err.println(e.getMessage());
            }
        }
        return categories;
    }

    /////////////////// PAGEST22 ///////////////////

    ////// POPULATION //////

    String findPop65(String lgaCode, String state_nomination, int year) {
        String pop65 = "";

        // Setup the variable for the JDBC connection
        Connection connection = null;

        try {
            // Connect to JDBC data base
            connection = DriverManager.getConnection(DATABASE);

            // Prepare a new SQL Query & Set a timeout
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);

            // The Query
            String query = "";
            if (lgaCode != null && state_nomination == null) {
                query = """
                        SELECT SUM(COUNT) AS pop65 FROM PopulationStatistics

                        WHERE code = """ + lgaCode + """

                        AND year = """ + year + """

                        AND age = '_65_yrs_ov'

                        AND indigenous_status = 'indig' ;
                        """;
            } else if (state_nomination != null) {
                query = """
                        SELECT substring(code, 1, 1) as state ,year, sum(count) as pop65 FROM PopulationStatistics

                        WHERE state <> '9'

                        AND state = '""" + state_nomination + """
                        '

                        AND year = """ + year + """

                        AND indigenous_status = 'indig'

                        AND age = '_65_yrs_ov'

                        GROUP BY state, year

                        ;

                            """;
            }

            // Get Result
            ResultSet results = statement.executeQuery(query);

            while (results.next()) {
                pop65 = results.getString("pop65");
            }

            // Close the statement because we are done with it
            statement.close();
        } catch (SQLException e) {
            // If there is an error, lets just pring the error
            System.err.println(e.getMessage());
        } finally {
            // Safety code to cleanup
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                // connection close failed.
                System.err.println(e.getMessage());
            }
        }

        // Finally we return all of the lga
        return pop65;
    }

    String findAttPop(String lgaCode, String state_nomination, int year) {
        String attPop = "";

        // Setup the variable for the JDBC connection
        Connection connection = null;

        try {
            // Connect to JDBC data base
            connection = DriverManager.getConnection(DATABASE);

            // Prepare a new SQL Query & Set a timeout
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);

            // The Query
            String query = "";
            if (lgaCode != null && state_nomination == null) {
                query = """
                        SELECT SUM(COUNT) FROM SchoolCompletion

                        WHERE code = """ + lgaCode + """

                        AND year = """ + year + """

                        AND indigenous_status = 'indig'

                        AND schoolyear = 'did_not_go_to_school' ;

                                        """;
            } else if (state_nomination != null) {
                query = """
                        SELECT substring(code, 1, 1) as state , SUM(COUNT) FROM SchoolCompletion

                        WHERE state <> '9'

                        AND state = '""" + state_nomination + """
                        '

                        AND year = """ + year + """

                        AND indigenous_status = 'indig'

                        AND schoolyear = 'did_not_go_to_school'

                        GROUP BY state, year
                        ;
                                        """;
            }

            // Get Result
            ResultSet results = statement.executeQuery(query);

            while (results.next()) {
                attPop = results.getString("SUM(COUNT)");
            }

            // Close the statement because we are done with it
            statement.close();
        } catch (SQLException e) {
            // If there is an error, lets just pring the error
            System.err.println(e.getMessage());
        } finally {
            // Safety code to cleanup
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                // connection close failed.
                System.err.println(e.getMessage());
            }
        }

        // Finally we return all of the lga
        return attPop;
    }

    // INCOME AVG
    String findIncomeAvg(String lgaCode, String state_nomination, int year) {
        String avgIncInd = "";

        // Setup the variable for the JDBC connection
        Connection connection = null;

        try {
            // Connect to JDBC data base
            connection = DriverManager.getConnection(DATABASE);

            // Prepare a new SQL Query & Set a timeout
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);

            // The Query
            String query = "";
            if (lgaCode != null && state_nomination == null) {
                query = """
                        SELECT COUNT as pop FROM WeeklyIncome

                        WHERE indigenous_status = 'hhds_with_indig_persons'

                        AND incomebracketmax = 1499

                        AND year = """ + year + """

                        AND code = """ + lgaCode + """
                        """;
            } else {
                query = """
                        SELECT substring(code, 1, 1) as state , sum(count) as pop FROM Weeklyincome

                        WHERE state <> '9'

                        AND state =  '""" + state_nomination + """
                        '

                        AND year = """ + year + """

                        AND indigenous_status = 'hhds_with_indig_persons'

                        AND incomebracket = '1500_1999'

                        GROUP BY state, year;
                            """;
            }
            // Get Result
            ResultSet results = statement.executeQuery(query);

            while (results.next()) {
                avgIncInd = results.getString("pop");
            }

            // Close the statement because we are done with it
            statement.close();
        } catch (SQLException e) {
            // If there is an error, lets just pring the error
            System.err.println(e.getMessage());
        } finally {
            // Safety code to cleanup
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                // connection close failed.
                System.err.println(e.getMessage());
            }
        }

        // Finally we return all of the lga
        return avgIncInd;
    }

    ////// PROPORTION //////
    String findProp65(String lgaCode, String state_nomination, int year) {

        String prop65 = "";

        // Setup the variable for the JDBC connection
        Connection connection = null;

        try {
            // Connect to JDBC data base
            connection = DriverManager.getConnection(DATABASE);

            // Prepare a new SQL Query & Set a timeout
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);

            // The Query
            // Make if statement checking if lgacode is not null
            String query = "";
            if (lgaCode != null && state_nomination == null) {
                query = """
                        SELECT

                        CAST( SUM(COUNT) AS REAL) * 100 /

                        (

                        SELECT SUM(COUNT) FROM PopulationStatistics

                        WHERE code = """ + lgaCode + """

                        AND year = """ + year + """

                        AND indigenous_status = 'indig'

                        )

                        AS prop65

                        FROM PopulationStatistics

                        WHERE code = """ + lgaCode + """

                        AND year = """ + year + """

                        AND age = '_65_yrs_ov'

                        AND indigenous_status = 'indig'
                        ;
                                        """;
            } else {
                // if lgacode is null use state query
                query = """
                        SELECT substring(code, 1, 1) as state ,year, CAST(sum(count) AS real) * 100

                        /

                        (

                        SELECT statepop FROM statetable

                        WHERE year = """ + year + """

                        AND State = '""" + state_nomination + """
                        '

                        )
                        AS prop65

                        FROM PopulationStatistics

                        WHERE state <> '9'

                        AND state = '""" + state_nomination + """
                        '

                        AND year = """ + year + """

                        AND indigenous_status = 'indig'

                        AND age = '_65_yrs_ov'

                        GROUP BY state, year

                        ;
                            """;
            }

            // Get Result
            ResultSet results = statement.executeQuery(query);

            while (results.next()) {
                double prop65D = results.getDouble("prop65");
                prop65 = String.format("%.2f", prop65D);
            }

            // Close the statement because we are done with it
            statement.close();
        } catch (SQLException e) {
            // If there is an error, lets just pring the error
            System.err.println(e.getMessage());
        } finally {
            // Safety code to cleanup
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                // connection close failed.
                System.err.println(e.getMessage());
            }
        }

        // Finally we return all of the lga
        return prop65;
    }

    String findIndigAttProp(String lgaCode, String state_nomination, int year) {

        String propAtt = "";

        // Setup the variable for the JDBC connection
        Connection connection = null;

        try {
            // Connect to JDBC data base
            connection = DriverManager.getConnection(DATABASE);

            // Prepare a new SQL Query & Set a timeout
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);

            // The Query
            // Make if statement checking if lgacode is not null
            String query = "";
            if (lgaCode != null && state_nomination == null) {
                query = """
                        SELECT CAST(SUM(COUNT) AS REAL)*100 /

                        (

                        SELECT SUM(COUNT) FROM SchoolCompletion

                        WHERE code = """ + lgaCode + """

                        AND year = """ + year + """

                        AND indigenous_status = 'indig'

                        )

                        AS PropDidNotAttendSchool

                        FROM SchoolCompletion

                        WHERE code = """ + lgaCode + """

                        AND year = """ + year + """

                        AND indigenous_status = 'indig'

                        AND schoolyear = 'did_not_go_to_school'

                        ;
                                            """;
            } else {
                // if lgacode is null use state query
                query = """
                        SELECT substring(code, 1, 1) as state, year, CAST(SUM(COUNT ) AS REAL) * 100

                        /

                        (

                        SELECT totalindattend FROM indschoolattend

                        WHERE state = '""" + state_nomination + """
                        '

                        AND year = """ + year + """

                        )

                        AS PropDidNotAttendSchool

                        FROM SchoolCompletion

                        WHERE state <> '9'

                        AND state = '""" + state_nomination + """
                        '

                        AND indigenous_status = 'indig'

                        AND year = """ + year + """

                        AND schoolyear = 'did_not_go_to_school'

                        GROUP BY state, year

                        ;
                                        """;
            }

            // Get Result
            ResultSet results = statement.executeQuery(query);

            while (results.next()) {
                double propAttD = results.getDouble("PropDidNotAttendSchool");
                propAtt = String.format("%.2f", propAttD);
            }

            // Close the statement because we are done with it
            statement.close();
        } catch (SQLException e) {
            // If there is an error, lets just pring the error
            System.err.println(e.getMessage());
        } finally {
            // Safety code to cleanup
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                // connection close failed.
                System.err.println(e.getMessage());
            }
        }

        // Finally we return all of the lga
        return propAtt;
    }

    String findPropInc(String lgaCode, String state_nomination, int year) {

        String propAvgInc = "";

        // Setup the variable for the JDBC connection
        Connection connection = null;

        try {
            // Connect to JDBC data base
            connection = DriverManager.getConnection(DATABASE);

            // Prepare a new SQL Query & Set a timeout
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);

            // The Query
            // Make if statement checking if lgacode is not null
            String query = "";
            if (lgaCode != null && state_nomination == null) {
                query = """
                        Select CAST(SUM(COUNT) AS REAL)*100 /
                        (
                        Select SUM(COUNT) from weeklyincome

                        WHERE code = """ + lgaCode + """

                        AND year = """ + year + """

                        AND indigenous_status = 'hhds_with_indig_persons'

                        )

                        AS PropAvgIncBr

                        from weeklyincome

                        WHERE code = """ + lgaCode + """

                        AND year = """ + year + """

                        AND indigenous_status = 'hhds_with_indig_persons'

                        AND incomebracket = '1500_1999';
                                    """;
            } else {
                // if lgacode is null use state query
                query = """
                        SELECT substring(code, 1, 1) as state , CAST(sum(count)AS REAL) * 100/

                        (

                        SELECT totalindhhd FROM totindhhd_table

                        WHERE state ='""" + state_nomination + """
                        '

                        AND year = """ + year + """

                        )

                        AS PropAvgIncBr

                        FROM Weeklyincome

                        WHERE state <> '9'

                        AND state = '""" + state_nomination + """
                        '

                        AND year = """ + year + """

                        AND indigenous_status = 'hhds_with_indig_persons'

                        AND incomebracket = '1500_1999'

                        GROUP BY state, year;
                                                """;
            }

            // Get Result
            ResultSet results = statement.executeQuery(query);

            while (results.next()) {
                double propAvgIncD = results.getDouble("PropAvgIncBr");
                propAvgInc = String.format("%.2f", propAvgIncD);
            }

            // Close the statement because we are done with it
            statement.close();
        } catch (SQLException e) {
            // If there is an error, lets just pring the error
            System.err.println(e.getMessage());
        } finally {
            // Safety code to cleanup
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                // connection close failed.
                System.err.println(e.getMessage());
            }
        }

        // Finally we return all of the lga
        return propAvgInc;
    }

    //// RANKING////
    int findRank65(String lgaCode, String state_nomination, int year) {
        ArrayList<String> arrayRank65 = new ArrayList<String>();
        int rank65 = 999;

        // Setup the variable for the JDBC connection
        Connection connection = null;

        try {
            // Connect to JDBC data base
            connection = DriverManager.getConnection(DATABASE);

            // Prepare a new SQL Query & Set a timeout
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);

            // The Query
            // Make if statement checking if lgacode is not null
            String query = "";
            if (lgaCode != null && state_nomination == null) {
                query = """

                        SELECT code AS coderank, (CAST(indigOv65 AS REAL) / totalPop )* 100 as prop65 FROM

                        (SELECT code, SUM(COUNT) as indigOv65 FROM PopulationStatistics

                        WHERE year = """ + year + """

                        AND indigenous_status = 'indig'

                        AND age = '_65_yrs_ov'

                        GROUP BY code)ov65

                        JOIN

                        (SELECT code as indigCode, SUM(COUNT) as totalPop FROM PopulationStatistics

                        WHERE year = """ + year + """

                        AND indigenous_status = 'indig' GROUP BY code)

                        total_indig ON ov65.code = total_indig.indigCode

                        ORDER BY prop65 DESC
                        ;

                                            """;
            } else if (state_nomination != null) {
                // if lgacode is null use state query
                query = """
                        SELECT state AS coderank,( CAST(indigstateov65 AS REAL)/indigstatepop )* 100 as stateprop from

                        (SELECT substring(code, 1, 1) as state, sum(count) as indigstateov65

                        FROM PopulationStatistics

                        WHERE state <> '9'

                        AND year = """ + year + """

                        AND indigenous_status = 'indig'

                        AND age = '_65_yrs_ov'

                        GROUP BY state, year)ind_ov65

                        JOIN

                        (SELECT state as state_2, statePop as indigstatepop FROM statetable

                        WHERE year = """ + year + """
                            )indpop ON ind_ov65.state = indpop.state_2

                        ORDER BY stateprop DESC

                        ;
                            """;
            }

            // Get Result
            ResultSet results = statement.executeQuery(query);

            while (results.next()) {
                // USE LGACODE TO SEARCH
                // add code and data to the object
                // String code = results.getString("code");
                // String data = results.getString("prop65");

                // Create a LGA Object
                String rank = results.getString("coderank");

                // Add the lga object to the array

                // get index of code that equals lgacode input
                arrayRank65.add(rank);
            }

            // Close the statement because we are done with it
            statement.close();
        } catch (SQLException e) {
            // If there is an error, lets just pring the error
            System.err.println(e.getMessage());
        } finally {
            // Safety code to cleanup
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                // connection close failed.
                System.err.println(e.getMessage());
            }
        }

        // if lgaCode is not null check for lgaCode ranking
        // if state is not null check for State ranking

        if (lgaCode != null && state_nomination == null) {
            rank65 = arrayRank65.indexOf(lgaCode) + 1;
        } else {
            rank65 = arrayRank65.indexOf(state_nomination) + 1;
        }

        return rank65;
    }

    int findRankAtt(String lgaCode, String state_nomination, int year) {
        ArrayList<String> arrayRankAtt = new ArrayList<String>();
        int rankAtt = 999;

        // Setup the variable for the JDBC connection
        Connection connection = null;

        try {
            // Connect to JDBC data base
            connection = DriverManager.getConnection(DATABASE);

            // Prepare a new SQL Query & Set a timeout
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);

            // The Query
            // Make if statement checking if lgacode is not null
            String query = "";
            if (lgaCode != null && state_nomination == null) {
                query = """

                        SELECT code as coderank, (CAST(indigNoSchool AS REAL) / totalIndigSchool )* 100 as propNoAtt FROM

                        (SELECT code, SUM(COUNT) as indigNoSchool FROM SchoolCompletion

                        WHERE year = """
                        + year + """

                                AND indigenous_status = 'indig'

                                AND schoolyear = 'did_not_go_to_school'

                                GROUP BY code

                                )indigNoAtt


                                JOIN

                                (SELECT code as indigCode, SUM(COUNT) as totalIndigSchool FROM SchoolCompletion

                                WHERE year = """ + year + """

                                AND indigenous_status = 'indig'

                                GROUP BY code)totalIndig on indigNoAtt.code = totalIndig.indigCode

                                ORDER BY propNoAtt ASC

                                ;

                                                        """;
            } else {
                // if lgacode is null use state query
                query = """
                        SELECT state as coderank, (CAST(totalIndabsent AS REAL)/totalindattend) * 100 as attendPropState FROM

                        (SELECT substring(code, 1, 1) as state, SUM(COUNT) as totalIndAbsent

                        FROM SchoolCompletion

                        WHERE state <> '9'

                        AND year = """
                        + year + """

                                AND indigenous_status = 'indig'

                                AND schoolyear = 'did_not_go_to_school'

                                GROUP BY state, year)absentTotal

                                JOIN

                                (SELECT state as state_2, totalindattend FROM indschoolattend

                                WHERE year = """ + year + """
                                )attendtotal_table ON absentTotal.state = attendtotal_table.state_2

                                ORDER BY attendPropState ASC

                                ;
                                    """;
            }

            // Get Result
            ResultSet results = statement.executeQuery(query);

            while (results.next()) {
                // USE LGACODE TO SEARCH
                // add code and data to the object
                // String code = results.getString("code");
                // String data = results.getString("prop65");

                // Create a LGA Object
                String rank = results.getString("coderank");

                // Add the lga object to the array

                // get index of code that equals lgacode input
                arrayRankAtt.add(rank);
            }

            // Close the statement because we are done with it
            statement.close();
        } catch (SQLException e) {
            // If there is an error, lets just pring the error
            System.err.println(e.getMessage());
        } finally {
            // Safety code to cleanup
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                // connection close failed.
                System.err.println(e.getMessage());
            }
        }

        // Finally we return all of the lga

        if (lgaCode != null && state_nomination == null) {
            rankAtt = arrayRankAtt.indexOf(lgaCode) + 1;
        } else {
            rankAtt = arrayRankAtt.indexOf(state_nomination) + 1;
        }
        return rankAtt;
    }

    int findRankInc(String lgaCode, String state_nomination, int year) {
        ArrayList<String> arrayRankInc = new ArrayList<String>();
        int rankInc = 0;

        // Setup the variable for the JDBC connection
        Connection connection = null;

        try {
            // Connect to JDBC data base
            connection = DriverManager.getConnection(DATABASE);

            // Prepare a new SQL Query & Set a timeout
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);

            // The Query
            // Make if statement checking if lgacode is not null
            String query = "";
            if (lgaCode != null && state_nomination == null) {
                query = """

                        SELECT code as state, (CAST(indhhdinc AS REAL)/totalhhdinc )* 100 AS propIndHhdInc FROM

                        (Select code, COUNT as indhhdinc from weeklyincome

                        WHERE year = """ + year + """

                        AND indigenous_status = 'hhds_with_indig_persons'

                        AND incomebracket = '1500_1999'

                        GROUP BY code)indig

                        JOIN

                        (Select code as totalcode, COUNT as totalhhdinc from weeklyincome

                        WHERE year = """ + year + """

                        and indigenous_status = 'total_hhds'

                        AND incomebracket = '1500_1999'

                        GROUP BY code)total ON indig.code = total.totalcode

                        ORDER BY propIndHhdInc DESC

                        ;

                                                """;
            } else {
                query = """
                        SELECT state, (CAST(st_br_1599_tot AS REAL)/totalindhhd) * 100 AS r_ind_prop_1599 FROM

                        (SELECT substring(code, 1, 1) as state , SUM(COUNT) as st_br_1599_tot

                        FROM Weeklyincome

                        WHERE state <> '9'

                        AND year =  """ + year + """

                        AND indigenous_status = 'hhds_with_indig_persons'

                        AND incomebracket = '1500_1999'

                        GROUP BY state, year)st_ind_hhd_1599_jt

                        JOIN

                        (SELECT state as state_2, totalindhhd FROM totindhhd_table

                        WHERE year =  """ + year + """
                                )indhhdtotal_jt ON st_ind_hhd_1599_jt.state = indhhdtotal_jt.state_2

                            ORDER BY r_ind_prop_1599 DESC
                        """;
            }

            // Get Result
            ResultSet results = statement.executeQuery(query);

            while (results.next()) {
                // USE LGACODE TO SEARCH
                // add code and data to the object
                // String code = results.getString("code");
                // String data = results.getString("prop65");

                // Create a LGA Object
                String rank = results.getString("state");

                // Add the lga object to the array

                // get index of code that equals lgacode input
                arrayRankInc.add(rank);
            }

            // Close the statement because we are done with it
            statement.close();
        } catch (SQLException e) {
            // If there is an error, lets just pring the error
            System.err.println(e.getMessage());
        } finally {
            // Safety code to cleanup
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                // connection close failed.
                System.err.println(e.getMessage());
            }
        }

        // Finally we return all of the lga
        if (lgaCode != null && state_nomination == null) {
            rankInc = arrayRankInc.indexOf(lgaCode) + 1;
        } else {
            rankInc = arrayRankInc.indexOf(state_nomination) + 1;
        }

        return rankInc;

    }

    ArrayList<Integer> findPopChange(String lgaCode, String state_nomination) {
        ArrayList<Integer> popChange = new ArrayList<Integer>();

        // Setup the variable for the JDBC connection
        Connection connection = null;

        try {
            // Connect to JDBC data base
            connection = DriverManager.getConnection(DATABASE);

            // Prepare a new SQL Query & Set a timeout
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);

            // The Query
            // Make if statement checking if lgacode is not null
            String query = "";
            // System.out.println(lgaCode);
            if (lgaCode != null && state_nomination == null) {
                query = """

                        SELECT SUM(count) as pop21,

                        (SELECT SUM(count)

                        FROM PopulationStatistics

                        WHERE code = """ + lgaCode + """

                        AND year = 2016
                        )
                        as pop16

                        FROM PopulationStatistics

                        WHERE code = """ + lgaCode + """

                        AND year = 2021

                        ;
                                                        """;
            } else if (state_nomination != null) {
                // if lgacode is null use state query
                query = """

                        SELECT substring(code, 1, 1) as state ,year, sum(count) as pop16 ,
                        (
                        SELECT statepop FROM statePoptable
                        WHERE year = 2021
                        AND state = '""" + state_nomination + """
                        '
                        )
                        as pop21
                        FROM PopulationStatistics

                        WHERE state <> '9'
                        AND year = 2016
                        AND state = '""" + state_nomination + """
                        '
                        GROUP BY state, year

                        ;
                                                """;
            }

            // Get Result
            // System.out.println(query);
            ResultSet results = statement.executeQuery(query);

            while (results.next()) {

                int pop21 = Integer.parseInt(results.getString("pop21"));
                int pop16 = Integer.parseInt(results.getString("pop16"));

                popChange.add(pop16);
                popChange.add(pop21);
            }

            // Close the statement because we are done with it
            statement.close();
        } catch (SQLException e) {
            // If there is an error, lets just pring the error
            System.err.println(e.getMessage());
        } finally {
            // Safety code to cleanup
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                // connection close failed.
                System.err.println(e.getMessage());
            }
        }

        return popChange;
    }

    String validLga(String slga_nomination) {
        String lgaVal = "";

        // Setup the variable for the JDBC connection
        Connection connection = null;

        try {
            // Connect to JDBC data base
            connection = DriverManager.getConnection(DATABASE);

            // Prepare a new SQL Query & Set a timeout
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);

            // The Query
            // Make if statement checking if lgacode is not null
            String query = "SELECT lga_code16 FROM LGA WHERE lga_name16 LIKE '" + slga_nomination + "'";

            // Get Result
            // System.out.println(query);
            ResultSet results = statement.executeQuery(query);

            while (results.next()) {

                lgaVal = results.getString("lga_code16");

            }

            // Close the statement because we are done with it
            statement.close();
        } catch (SQLException e) {
            // If there is an error, lets just pring the error
            System.err.println(e.getMessage());
        } finally {
            // Safety code to cleanup
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                // connection close failed.
                System.err.println(e.getMessage());
            }
        }

        return lgaVal;
    }

}
