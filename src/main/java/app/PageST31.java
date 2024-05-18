package app;

import java.util.ArrayList;

import org.eclipse.jetty.http.HttpCookie.SetCookieHttpField;

import io.javalin.http.Context;
import io.javalin.http.Handler;

/**
 * Example Index HTML class using Javalin
 * <p>
 * Generate a static HTML page using Javalin
 * by writing the raw HTML into a Java String object
 *
 * @author Timothy Wiley, 2021. email: timothy.wiley@rmit.edu.au
 * @author Santha Sumanasekara, 2021. email: santha.sumanasekara@rmit.edu.au
 */
public class PageST31 implements Handler {

  // URL of this page relative to http://localhost:7001/
  public static final String URL = "/page5.html";

  @Override
  public void handle(Context context) throws Exception {
    // Create a simple HTML webpage in a String
    String html = "<html>";

    // Add some Head information
    html = html + "<head>" +
        "<title>Gap Scores</title>";

    // Add some CSS (external file)
    html = html + "<link rel='stylesheet' type='text/css' href='common.css' />";
    html = html + "<link rel='stylesheet' type='text/css' href='st31.css' />";

    html = html
        + "<link rel='stylesheet' href='https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css' integrity='sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm' crossorigin='anonymous'>";

    html = html
        + "<link href='https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css' rel='stylesheet' integrity='sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC' crossorigin='anonymous'>";
    html = html
        + """
            <script src='https://code.jquery.com/jquery-3.2.1.slim.min.js' integrity='sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN' crossorigin='anonymous'></script>
            <script src='https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js' integrity='sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q' crossorigin='anonymous'></script>
            <script src='https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js' integrity='sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl' crossorigin='anonymous'></script>

              """;

    // GRAPH
    // JS for GRAPH from
    // https://developers.google.com/chart/interactive/docs/gallery/barchart#dual-x-charts
    html = html +
        """
            <script type='text/javascript' src='https://www.gstatic.com/charts/loader.js'></script>
            <script type='text/javascript'>
              google.charts.load('current', {'packages':['bar']});
              google.charts.setOnLoadCallback(drawStuff);

              function drawStuff() {
                var data = new google.visualization.arrayToDataTable([
                  ['Outcomes', '2016', '2021'],


                  ['Health And Wellbeing', 30000, 14.3],
                  ['Education', 50000, 0.9],
                  ['Economic Participation', 60000, 13.1]
                ]);

                var options = {
                  width: 800,
                  chart: {
                    title: 'LGA Gap Scores',

                  },
                  bars: 'horizontal', // Required for Material Bar Charts.
                  series: {
                    0: { axis: 'distance' }, // Bind series 0 to an axis named 'distance'.
                    1: { axis: 'brightness' } // Bind series 1 to an axis named 'brightness'.
                  },
                  axes: {
                    x: {
                      distance: {label: 'Gap Score between non-indigenous and indigenous population (%)'}, // Bottom x-axis.
                      brightness: {side: 'top', label: 'Gap Scores'} // Top x-axis.
                    }
                  }
                };

              var chart = new google.charts.Bar(document.getElementById('dual_x_div'));
              chart.draw(data, options);
            };
            </script>
              """;

    // Modal Panel
    html = html
        + """

            <!-- Modal -->
            <div class='modal fade show' id='myModal' tabindex='-1' role='dialog' aria-labelledby='myModalLabel'>
              <div class='modal-dialog modal-lg' role='document'>
                <div class='modal-content'>

                  <div class='modal-header'>
                  <h4 class='modal-title' id='myModalLabel'>Mission Statement</h4>
                    <button type='button' class='close' data-dismiss='modal' aria-label='Close' data-target="#myModal"><span aria-hidden='true'>&times;</span></button>
                  </div>
                  <div class='modal-body'>
                  <h5>What is 'Closing The Gap'</h5>
                  <p>'Closing the gap' campaign is a course of action that aims to provide First Nations Peoples with the fundamental resources and opportunities in order to reach the same equal outcomes of non-indigenous communities. </p>
                  <h5>Our aim</h5>
                  <p>By this token, the purpose of our website is to provide information and statistics about the 'Close The Gap' campaign, to ultimately empower the First Nation People of Australia. </p>
                  </div>
                  
                </div>
              </div>
            </div>

              """;
    html = html + "</head>";

    JDBCConnection jdbc = new JDBCConnection();
    ArrayList<LGA> lgas = jdbc.getLGAs();
    // Add the body
    html = html + "<body>";

    // Add header content block
    html = html + """
        <section class='main'>
              <div class='header'>
              <h1>
              <a href='/'><img src='Logo_small.png' class='top-image' alt='RMIT logo' height='75'></a>
                  Gap Scores
                </h1>
              </div>
          """;

    // Add the topnav
    // This uses a Java v15+ Text Block
    html = html + """
            <div class='topnav' id='navbar'>
                <a href='/'>Home</a>
                <a href='page3.html'>Latest Statistics (LGAs)</a>
                <a href='page4.html'>Focused LGA/State View</a>
                <a href='page5.html'>Gap Scores</a>
                <a href='page6.html'>Comparing LGAs</a>
                <a href='#' data-toggle="modal" data-target="#myModal" >Our Mission</a>
            </div>
        """;

    // Add Div for page Content
    html = html + "</section>";

    //////////////// SIDE BAR OPENING////////////////

    html = html + """
        <div id='mySidenav' class='sidenav'>
        <a href='javascript:void(0)' class='closebtn' onclick='closeNav()'>&times;</a>
        <div class="d-flex flex-column-reverse">
        """;

    // Radio buttons for Outcome

    html = html + """
        <form action='/page5.html' pagemethod='post'>
        """;

    html = html + """
        <div class='fcontainer'>
        <h3 style="color: white;"> Filter LGA By Area Size: </h3>



        """;

    html = html + """




        """;

    // CLOSE FORM FOR LGA SELECTION

    html = html + """

            <div class="slidecontainer">
            <input type="range" min="1" max="100" value="50" class="slider" id="myRange">
          </div>
          <p style ='position : relative; left: 15rem;'>100,000 km^2 </p>
          <p style ='position : relative; bottom: 2.5rem;'>0 km^2</p>


          <h3 style="color: white;"> Filter LGA By Population: </h3>
          <div class="slidecontainer">
          <input type="range" min="1" max="100" value="50" class="slider" id="myRange">
        </div>
        <p style ='position : relative; left: 17rem;'>1.5MM </p>
        <p style ='position : relative; bottom: 2.5rem;'>0</p>





                   <button type='submit' class='btn btn-outline-light'>Filter</button>
                 </form>



                   </div>
                   """;

    // html = html + """
    // <form action='/page4.html' method='post'>
    // <input placeholder='Search LGAs' name='slga_nomination'></input>
    // </form>
    // """;
    // Dropdown Menu for State
    html = html + """
        <form action='/page5.html' method='post'>
        """;

    String state_nomination = context.formParam("state_nomination");
    html = html + """
         <div class='fcontainer'>
         <h3 > Filter LGA by Gap Score Level: </h3>
         <select class="form-select" name="state_nomination" required>
          <option disabled selected>Long & Healthy Lives</option>
          <option value='1'>1</option>
          <option value='2'>2</option>
          <option value='3'>3</option>
          <option value='4'>4</option>

        </select>

        <select class="form-select" name="state_nomination" required>
          <option disabled selected>Education</option>
          <option value='1'>1</option>
          <option value='2'>2</option>
          <option value='3'>3</option>
          <option value='4'>4</option>

        </select>

        <select class="form-select" name="state_nomination" required>
          <option disabled selected>Economic Participation</option>
          <option value='1'>1</option>
          <option value='2'>2</option>
          <option value='3'>3</option>
          <option value='4'>4</option>

        </select>






        </form>
        </div>
         """;

    ///////// Section of sidebar showing Current LGA/STATE/OUTCOME
    html = html + "<div class='fcontainer' > <h3> Select an LGA</h3>";

    html = html + """
        <input placeholder='Search LGAs' name='slga_nomination'>
          </input>

                    <select name="LGAs" size="5">


            """;

    for (LGA lga : lgas) {
      html = html + "<option>" + lga.getName() + "</option>";
    }
    html = html + """
        </select>
        <button id='statebutton' type='submit' class='btn  btn-outline-light'>Search LGA</button>
        """;

    // CLOSE CURRENT FILTER SECTION
    html = html + """

        </div>
            """;

    ////////// CLOSE SIDEBAR
    html = html + """

        </div>

        </div>
        """;

    // Content of Data - Needs to be inside this main div so navbar can push content
    html = html
        + """
            <div id='main' class='flex-grow-1'>


              <div class='heading' >
              <h2>Select an LGA to view Gap Scores from 2016 and 2021 </h2>
              </div>
              <div class='filterbar'>
              <p>Click on the element below to open the filter selection menu to select one LGA. You can filter the LGA selection based on Area Size, Population or Gap Score Level.</p>
              <span style='font-size:30px;cursor:pointer' onclick='openNav()'>&#9776; Filters</span>

              </div>
              <h2 style="color:white;text-align:center; padding-top: 10px; font-weight: 200;">Gap Score for LGA: Not Selected</h2>
              <div class ='center' id='dual_x_div' style='width: 900px; height: 500px;'></div>

              """;

    //////////// Layout of Grids ///////////
    html = html + """

        """;

    // Continaer showing chosen lga/state and its change in population

    html = html + "</div>";

    // JS for sidebar
    html = html + """
        <script>
        function openNav() {
          document.getElementById('mySidenav').style.width = '400px';
          document.getElementById('main').style.marginLeft = '400px';
        }

        function closeNav() {
          document.getElementById('mySidenav').style.width = '0';
          document.getElementById('main').style.marginLeft= '0';
        }
        </script>
            """;

    // JS for sticky navbar
    html = html + """
        <script>
        window.onscroll = function() {myFunction()};

        var navbar = document.getElementById('navbar');
        var sticky = navbar.offsetTop;

        function myFunction() {
          if (window.pageYOffset >= sticky) {
            navbar.classList.add('sticky')
          } else {
            navbar.classList.remove('sticky');
          }
        }
        </script>
          """;

    // Close Content div

    // Footer
    html = html + """
            <div class='footer'>
                <p>COSC2803 - Studio Project Starter Code (Sep22)</p>

            </div>
        """;

    // Finish the HTML webpage
    html = html + "</body>" + "</html>";

    // DO NOT MODIFY THIS
    // Makes Javalin render the webpage
    context.html(html);

  }

  public String findMainStatPop(String outcome_nomination, String state_nomination, int year,
      String lgaCode, JDBCConnection jdbc, String lga_nomination) {
    String mainStatPop = "";
    if (outcome_nomination.equals("Long & Healthy Lives")) {

      mainStatPop = jdbc.findPop65(lgaCode, state_nomination, year)
          + " indigenous individual(s) are over the age of 65";

    } else if (outcome_nomination.equals("Education")) {

      mainStatPop = jdbc.findAttPop(lgaCode, state_nomination, year)
          + " indigenous individual(s) did not attend school";

    } else if (outcome_nomination.equals("Economic Participation")) {

      mainStatPop = jdbc.findIncomeAvg(lgaCode, state_nomination, year)
          + " indigenous household(s) were within the average income bracket of $1500-1999 per week";
      ;
    }

    return mainStatPop;
  }

  public String findProp(String outcome_nomination, String state_nomination,
      int year,
      String lgaCode, JDBCConnection jdbc, String lga_nomination) {
    String propIndig = "";
    if (outcome_nomination.equals("Long & Healthy Lives")) {

      propIndig = "This accounts for " + jdbc.findProp65(lgaCode, state_nomination, year)
          + " % of the indigenous population within this area";

    } else if (outcome_nomination.equals("Education")) {

      propIndig = "This accounts for " + jdbc.findIndigAttProp(lgaCode, state_nomination, year)
          + " % of the total indigenous population within this area";

    } else if (outcome_nomination.equals("Economic Participation")) {

      propIndig = "This accounts for " + jdbc.findPropInc(lgaCode, state_nomination, year)
          + " % of the indigenous population within this area";

    }

    return propIndig;
  }

  public String findRank(String outcome_nomination, String state_nomination,
      int year,
      String lgaCode, JDBCConnection jdbc, String lga_nomination) {
    String rank = "";
    if (outcome_nomination.equals("Long & Healthy Lives")) {

      rank = "This places the area in rank number : " + jdbc.findRank65(lgaCode, state_nomination, year)
          + " for Long & Healthy Lives";

    } else if (outcome_nomination.equals("Education")) {
      int checkrank = jdbc.findRankAtt(lgaCode, state_nomination, year);

      if (lgaCode != null && state_nomination == null) {
        if (checkrank < 274) {
          rank = "This area is tied rank number 1 with a number of other areas with 0% school non-attendance";
        } else {
          rank = "This places the area in rank number : " + (checkrank - 274)
              + " for Education";
        }
      } else {
        rank = "This places the state in rank number : " + checkrank
            + " for Education";
      }

    } else if (outcome_nomination.equals("Economic Participation")) {

      int checkrank = jdbc.findRankInc(lgaCode, state_nomination, year);
      if (lgaCode != null && state_nomination == null) {
        if (checkrank < 6) {
          rank = "This area is tied rank number 1 with a number of other areas for indigenous household within an income bracket of $1500-1999 per week";
        } else {
          rank = "This places the area in rank number : " + (checkrank - 5)
              + " in terms of indigenous households within an income bracket of $1500-1999 per week";
        }
      } else {
        rank = "This places the state in rank number : " + checkrank +
            " in terms of indigenous households within an income bracket of $1500-1999 per week";
      }

    }

    return rank;
  }

  public ArrayList<Integer> findPopulationChange(String state_nomination,
      String lgaCode, JDBCConnection jdbc) {
    ArrayList<Integer> popchange = jdbc.findPopChange(lgaCode, state_nomination);

    return popchange;
  }

  public String validLGA(String slga_nomination, JDBCConnection jdbc) {
    String slgaCheck = jdbc.validLga(slga_nomination);
    // for every lga, check if slga_nomination is similar to anyone them

    return slgaCheck;
  }

}