package app;

import java.util.ArrayList;
import java.util.Arrays;

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
public class PageST22 implements Handler {

  // URL of this page relative to http://localhost:7001/
  public static final String URL = "/page4.html";

  @Override
  public void handle(Context context) throws Exception {
    // Create a simple HTML webpage in a String
    String html = "<html>";

    // Add some Head information
    html = html + "<head>" +
        "<title> LGA/State in 2016/2021 </title>";

    // Add some CSS (external file)
    html = html + "<link rel='stylesheet' type='text/css' href='common.css' />";
    html = html + "<link rel='stylesheet' type='text/css' href='st22_focused.css' />";

    html = html
        + "<link rel='stylesheet' href='https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css' integrity='sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm' crossorigin='anonymous'>";
    html = html
        + """
            <script src='https://code.jquery.com/jquery-3.2.1.slim.min.js' integrity='sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN' crossorigin='anonymous'></script>
            <script src='https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js' integrity='sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q' crossorigin='anonymous'></script>
            <script src='https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js' integrity='sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl' crossorigin='anonymous'></script>




            <script>

            if(lga_selected=""){
              document.getElementById("Button").disabled = true;
            }
            else(){
              document.getElementById("Button").disabled = false;
            }

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

    // Add the body
    html = html + "<body>";

    // Add header content block
    html = html + """
        <section class='main'>
              <div class='header'>
              <h1>
              <a href='/'><img src='Logo_small.png' class='top-image' alt='RMIT logo' height='75'></a>
                  Focused LGA/State View
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
    String outcome_nomination = context.formParam("outcome_nomination");

    // html = html + """
    // <style>
    // label{
    // color:white;
    // }
    // </style>

    // """;

    // Dropdown Menu for LGA
    // MAKE IF STATEMENT, IF THEY CHOOSE A LGA/STATE, THEY CAN NO LONGER CHOOSE THE
    // ALTERNATIVE SELECTION
    String lga_nomination = context.formParam("lga_nomination");
    String slga_nomination = context.formParam("slga_nomination");
    html = html + """
        <form action='/page4.html' method='post'>
        """;

    html = html + """
        <div class='fcontainer'>
        <h3 style="color: white;"> Select LGA & Outcome : </h3>
        <select class='form-select' name='lga_nomination' >
         <option disabled selected>Select LGA</option>
             """;

    JDBCConnection jdbc = new JDBCConnection();
    ArrayList<LGA> lgas = jdbc.getLGAs();
    for (LGA lga : lgas) {
      html = html + "<option>" + lga.getName() + "</option>";
    }

    html = html + """
        </select>

        <input placeholder='Search LGAs' name='slga_nomination'>
        </input>

         """;

    // CLOSE FORM FOR LGA SELECTION

    html = html + """

         <div class='p-3'>

          <label class="container">Long & Healthy Lives
          <input name="outcome_nomination" type="radio" value='Long & Healthy Lives' required>
          <span class="checkmark"></span>
        </label>
        <label class="container">Education
          <input name="outcome_nomination" type="radio" value='Education'>
          <span class="checkmark"></span>
        </label>
        <label class="container">Economic Participation
          <input name="outcome_nomination" type="radio" value='Economic Participation'>
          <span class="checkmark"></span>
        </label>
         </div>





             <button type='submit' class='btn btn-outline-light'>Get Statistics</button>
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
        <form action='/page4.html' method='post'>
        """;

    String state_nomination = context.formParam("state_nomination");
    html = html + """
         <div class='fcontainer'>
         <h3 > Select State & Outcome: </h3>
         <select class="form-select" name="state_nomination" required>
          <option disabled selected>Select State</option>
          <option value='1'>NSW</option>
          <option value='2'>VIC</option>
          <option value='3'>QLD</option>
          <option value='4'>SA</option>
          <option value='5'>WA</option>
          <option value='6'>TAS</option>
          <option value='7'>NT</option>
          <option value='8'>ACT</option>

        </select>



         <div class='p-3'>

          <label class="container">Long & Healthy Lives
          <input name="outcome_nomination" type="radio" value='Long & Healthy Lives' required>
          <span class="checkmark"></span>
        </label>
        <label class="container">Education
          <input name="outcome_nomination" type="radio" value='Education'>
          <span class="checkmark"></span>
        </label>
        <label class="container">Economic Participation
          <input name="outcome_nomination" type="radio" value='Economic Participation'>
          <span class="checkmark"></span>
        </label>
         </div>

        <button id='statebutton' type='submit' class='btn  btn-outline-light'>Get Statistics</button>

        </form>
        </div>
         """;
    ArrayList<String> stateArray = new ArrayList<String>(Arrays.asList("New South Wales", "Victoria", "Queensland",
        "South Australia", "Western Australia", "Tasmania", "Nothern Territory", "Australia Capital Territory"));
    ///////// Section of sidebar showing Current LGA/STATE/OUTCOME
    html = html + "<div class='fcontainer' > <h3> Current Filters</h3>";

    if ((lga_nomination == null || lga_nomination == "") || (lga_nomination != null && state_nomination != null)) {
      // If NULL, nothing to show, therefore we make some "no results" HTML

      html = html + "<h4> Current LGA: None </h4>";

    } else {

      // If NOT NULL, then set current lga to lga nom
      html = html + "<h5> Current LGA: - " + lga_nomination + " </h5>";
    }

    if ((state_nomination == null || state_nomination == "") || (lga_nomination != null && state_nomination != null)) {
      // If NULL, nothing to show, therefore we make some "no results" HTML

      html = html + "<h4> Current State: None </h4>";
    } else {

      // If NOT NULL, then set current lga to lga nom
      html = html + "<h4> Current State: </h4>";
      html = html + "<h5> - " + stateArray.get(Integer.parseInt(state_nomination) - 1) + "</h5>";
    }

    if (outcome_nomination == null || outcome_nomination == ""
        || (lga_nomination != null && state_nomination != null)) {
      // If NULL, nothing to show, therefore we make some "no results" HTML

      html = html + "<h4> Current Outcome: None </h4>";
    } else {

      // If NOT NULL, then set current lga to lga nom
      html = html + "<h4> Current Outcome: </h4> <h5> - " + outcome_nomination + "</h5>";

    }
    // CLOSE CURRENT FILTER SECTION
    html = html + """
        <a href='/page4.html'>Clear Filters</a>
          </div>
              """;

    ////////// CLOSE SIDEBAR
    html = html + """

        </div>

        </div>
        """;

    String lgaCode = "";
    if (!(lga_nomination == null || lga_nomination == "")) {
      for (LGA lga : lgas) {
        if (lga_nomination.equals(lga.getName())) {
          lgaCode = Integer.toString(lga.getCode());
        }
      }
    }

    if (slga_nomination != null && lga_nomination == null) {

      // check normal format
      for (LGA lga : lgas) {
        if (slga_nomination.equals(lga.getName())) {
          lgaCode = Integer.toString(lga.getCode());
          lga_nomination = slga_nomination;

        }
      }
      if (!(validLGA(slga_nomination, jdbc).equals(""))) {
        // check case sensitivity
        lgaCode = validLGA(slga_nomination, jdbc);
        lga_nomination = slga_nomination;

      } else {
        state_nomination = "";
        lga_nomination = "";

      }

    }

    // Content of Data - Needs to be inside this main div so navbar can push content
    html = html
        + """
            <div id='main' class='flex-grow-1'>


              <div class='heading' >
              <h2>Select one Outcome and one LGA/State</h2>
              </div>
              <div class='filterbar'>
              <p>Click on the element below to open the filter selection menu to select one LGA or State, to compare between 2016 and 2021 for your chosen socioeconomic outcome.</p>
              <span style='font-size:30px;cursor:pointer' onclick='openNav()'>&#9776; Filters</span>
              </div>

              """;

    //////////// Layout of Grids ///////////

    // Continaer showing chosen lga/state and its change in population
    html = html + """
        <div class='container d-flex justify-content-around py-5 flex-wrap'>
           <div style='margin:30px;width:65.25rem;' class='outcomecontainer'>
               """;
    if (outcome_nomination == null || outcome_nomination == "")

    {
      // If NULL, nothing to show, therefore we make some "no results" HTML

      html = html + "<h2 class='octitle'> Statistics for: Outcome not selected </h2>";
    } else if (lga_nomination != null && state_nomination != null) {
      html = html
          + "<h2 class='octitle'> The LGA you searched for was invalid / does not exist. Please ensure you enter the correct LGA name  </h2>";

    } else if (outcome_nomination != null) {

      // If NOT NULL, then set current outcome to nomination
      html = html + "<h2 class='octitle'> Statistics for: " + outcome_nomination + " </h2>";

    }

    // if STATE IS CHOSEN
    if (state_nomination == null || state_nomination == "" || (lga_nomination != null && state_nomination != null)) {
      // If NULL, nothing to show, therefore we make some "no results" HTML

      html = html + "<p> State: Not Selected </p>";
    } else {

      // If NOT NULL, then set current outcome to nomination
      html = html + "<p> State: " + stateArray.get(Integer.parseInt(state_nomination) - 1) + " </p>";
      ArrayList<Integer> popChange = findPopulationChange(state_nomination,
          lgaCode, jdbc);
      html = html + "<p> Population in 2016: " + popChange.get(0) + "</p>";
      html = html + "<p> Population in 2021: " + popChange.get(1) + "</p>";
      html = html + "<p> Total Change in population: " + (popChange.get(1) -
          popChange.get(0)) + "</p>";
    }
    // IF LGA CHOSEN
    if (lga_nomination == null || lga_nomination == "" || (lga_nomination != null && state_nomination != null)) {
      // If NULL, nothing to show, therefore we make some "no results" HTML

      html = html + "<p> LGA: Not Selected </p>";
    } else {
      // If NOT NULL, then set current outcome to nomination
      html = html + "<p> LGA: " + lga_nomination + " </p>";
      ArrayList<Integer> popChange = findPopulationChange(state_nomination,
          lgaCode, jdbc);
      System.out.print(popChange);
      html = html + "<p> Population in 2016: " + popChange.get(0) + "</p>";
      html = html + "<p> Population in 2021: " + popChange.get(1) + "</p>";
      html = html + "<p> Total Change in population: " + (popChange.get(1) -
          popChange.get(0)) + "</p>";

    }

    // STATE/LGA INDIG POPULATION 2016 STATISTIC
    html = html + """
        </div>

        <div class='statcontainer'>
          <h4 class='stattitle'> 2016 - Indigenous Population Statistics</h4>
            """;

    if (outcome_nomination == null || (lga_nomination != null && state_nomination != null)) {

    } else {
      String mainstatpop = findMainStatPop(outcome_nomination, state_nomination, 2016, lgaCode, jdbc, lga_nomination);
      html = html + "<p>" + mainstatpop + " </p>";
    }
    // CLOSE INDIG POPULATION 2016 STATISTIC
    html = html + "</div>";

    // STATE/LGA INDIG PROPORTION 2016 STATISTIC
    html = html + """
        <div class='statcontainer'>
          <h4 > 2016 - Indigenous Proportion Statistics</h4>
          """;
    if (outcome_nomination == null || (lga_nomination != null && state_nomination != null)) {

    } else {

      String mainstatpop = findProp(outcome_nomination, state_nomination, 2016, lgaCode, jdbc, lga_nomination);
      html = html + "<p> " + mainstatpop + " </p>";
    }

    // CLOSE INDIG PROP 2016 STATISTIC
    html = html + "</div>";

    // STATE/LGA INDIG RANKING 2016 STATISTIC
    html = html + """

        <div class='statcontainer'>
          <h4 class='stattitle'> 2016 - Indigenous Population Ranking</h4>
          """;

    if (outcome_nomination == null || (lga_nomination != null && state_nomination != null)) {

    } else {

      String mainstatpop = findRank(outcome_nomination, state_nomination, 2016, lgaCode, jdbc, lga_nomination);
      html = html + "<p> " + mainstatpop + " </p>";
    }

    html = html + "</div>";

    // STATE/LGA INDIG POPULATION 2021 STATISTIC
    html = html + """

        <div class='statcontainer'>
          <h4 class='stattitle'> 2021 - Indigenous Population Statistics</h4>
          """;

    if (outcome_nomination == null || (lga_nomination != null && state_nomination != null)) {

    } else {

      // IF LGA is not null, output LGA STUFF
      String mainstatpop = findMainStatPop(outcome_nomination, state_nomination, 2021, lgaCode, jdbc, lga_nomination);
      html = html + "<p> " + mainstatpop + " </p>";

      // OUTPUT state stuff

    }

    // CLOSE INDIG POPULATION 2021 STATISTIC
    html = html + "</div>";

    // STATE/LGA INDIG PROPORTION 2021 STATISTIC
    html = html + """
        <div class='statcontainer'>
          <h4 class='stattitle'> 2021 - Indigenous Proportion Statistics</h4>
          """;
    if (outcome_nomination == null || (lga_nomination != null && state_nomination != null)) {

    } else {

      String mainstatpop = findProp(outcome_nomination, state_nomination, 2021, lgaCode, jdbc, lga_nomination);
      html = html + "<p> " + mainstatpop + " </p>";

    }

    html = html + "</div>";
    // STATE/LGA INDIG RANKING 2021 STATISTIC
    html = html + """
        <div class='statcontainer'>
          <h4 class='stattitle'> 2021 - Indigenous Population Ranking</h4>
          """;

    if (outcome_nomination == null || (lga_nomination != null && state_nomination != null)) {

    } else {

      String mainstatpop = findRank(outcome_nomination, state_nomination, 2021, lgaCode, jdbc, lga_nomination);
      html = html + "<p> " + mainstatpop + " </p>";
    }

    html = html + "</div>";

    html = html + "</div>";

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
