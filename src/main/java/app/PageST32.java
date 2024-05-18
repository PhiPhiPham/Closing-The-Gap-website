package app;

import java.util.ArrayList;

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
public class PageST32 implements Handler {

  // URL of this page relative to http://localhost:7001/
  public static final String URL = "/page6.html";

  @Override
  public void handle(Context context) throws Exception {
    // Create a simple HTML webpage in a String
    String html = "<html>";

    // Add some Head information
    html = html + "<head>" +
        "<title>Subtask 2.1</title>";

    // Add some CSS (external file)
    html = html + "<link rel='stylesheet' type='text/css' href='common.css' />";

    html = html + "<link rel='stylesheet' type='text/css' href='bootstrap.min.css' />";

    // Code underneath is old CSS

    // html = html
    // + "<link rel='stylesheet'
    // href='https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css'
    // integrity='sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm'
    // crossorigin='anonymous'>";
    html = html
        + """
            <script src='https://code.jquery.com/jquery-3.2.1.slim.min.js' integrity='sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN' crossorigin='anonymous'></script>
            <script src='https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js' integrity='sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q' crossorigin='anonymous'></script>
            <script src='https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js' integrity='sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl' crossorigin='anonymous'></script>
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

                //Changing colour scheme
      html = html + "<style>";

      html = html + """
          .btn-outline-primary {
            --bs-btn-color: #40302D;
            --bs-btn-border-color: #40302D;
            --bs-btn-hover-color: #fff;
            --bs-btn-hover-bg: #40302D;
            --bs-btn-hover-border-color: #40302D;
            --bs-btn-focus-shadow-rgb: 55,90,127;
            --bs-btn-active-color: #fff;
            --bs-btn-active-bg: #40302D;
            --bs-btn-active-border-color: #40302D;
            --bs-btn-active-shadow: inset 0 3px 5pxrgba(0, 0, 0, 0.125);
            --bs-btn-disabled-color: #40302D;
            --bs-btn-disabled-bg: transparent;
            --bs-btn-disabled-border-color: #40302D;
            --bs-gradient: none;
        }

        .btn-primary {
          --bs-btn-color: #fff;
          --bs-btn-bg:#40302D;
          --bs-btn-border-color:#40302D;
          --bs-btn-hover-color: #fff;
          --bs-btn-hover-bg: #2f4d6c;
          --bs-btn-hover-border-color: #2c4866;
          --bs-btn-focus-shadow-rgb: 85,115,146;
          --bs-btn-active-color: #fff;
          --bs-btn-active-bg: #2c4866;
          --bs-btn-active-border-color: #29445f;
          --bs-btn-active-shadow: inset 0 3px 5px rgba(0, 0, 0, 0.125);
          --bs-btn-disabled-color: #fff;
          --bs-btn-disabled-bg:#40302D;
          --bs-btn-disabled-border-color:#40302D;
      }

      .table-primary {
        --bs-table-color: #fff;
        --bs-table-bg: #40302D;
        --bs-table-border-color: #40302D;
        --bs-table-striped-bg: #40302D;
        --bs-table-striped-color: #fff;
        --bs-table-active-bg: #40302D;
        --bs-table-active-color: #fff;
        --bs-table-hover-bg: #40302D;
        --bs-table-hover-color: #fff;
        color: var(--bs-table-color);
        border-color: var(--bs-table-border-color);
    }

    .table {
      border-collapse: separate;
    }

    .footer{
      background-color: #40302D;
      color:white;
    }

    .statcontainer h4{
      text-align: center;
      color:white;
      background-color: #40302D;
      padding:1rem;
      font-weight: 200;
    }
    
    .statcontainer p{
      padding-left: 1rem;
      padding-right: 1rem;
      color: #40302D;
      text-align: center;
    }

    .statcontainer{
      background-color:#D6D3CE;
      margin-right:30px;
      margin-left:30px;
      margin-bottom: 30px;
    }

    .nav-tabs .nav-item.show .nav-link, .nav-tabs .nav-link.active {
      color: var(--bs-nav-tabs-link-active-color);
      background-color: #40302D;
      border-color: var(--bs-nav-tabs-link-active-border-color);
  }

  .btn-check:checked+.btn, .btn.active, .btn.show, .btn:first-child:active, :not(.btn-check)+.btn:active {
    color: var(--bs-btn-active-color);
    background-color: #40302D;
    border-color: #40302D;
}

    
        """;

    
        
        html = html + "</style>";
    html = html + "</head>";

    // Add the body
    html = html + "<body>";

    html = html + """
            <div class='header'>
                <h1>
                <a href='/'><img src='Logo_small.png' class='top-image' alt='RMIT logo' height='75'></a>
                    Comparing LGAS
                </h1>
            </div>
        """;

    // Add the topnav
    // This uses a Java v15+ Text Block
    html = html + """
            <div class='topnav'>
                <a href='/'>Home</a>
                <a href='page3.html'>Latest Statistics (LGAs)</a>
                <a href='page4.html'>Focused LGA/State View</a>
                <a href='page5.html'>Gap Scores</a>
                <a href='page6.html'>Comparing LGAs</a>
                <a href='#' data-toggle="modal" data-target="#myModal" >Our Mission</a>
            </div>
        """;

    // Add header content block

    // Add Div for page Content
    html = html + "<div class='content' style='background-color: #934938;'>";

    html = html
        + """

            <ul class="nav nav-tabs" role="tablist">

            <li class="nav-item" role="presentation">
                <a class="nav-link active" data-toggle="tab" href="#populationstatistics" aria-selected="true" role="tab" tabindex="-1">Population Statistics</a>
              </li>

              <li class="nav-item" role="presentation">
                <a class="nav-link" data-toggle="tab" href="#schoolcompletion" aria-selected="false" role="tab">School Completion </a>
              </li>

              <li class="nav-item" role="presentation">
                <a class="nav-link" data-toggle="tab" href="#lthc" aria-selected="false" role="tab">Health Conditions</a>
              </li>

              <li class="nav-item" role="presentation">
                <a class="nav-link" data-toggle="tab" href="#weeklyincome" aria-selected="false" role="tab">Weekly Income</a>
              </li>

            </ul>
            """;

    // opening div for whole table
    html = html + "<div id='myTabContent' class='tab-content'>";

    // first whole panel
    html = html + "<div class='tab-pane fade active show' id='populationstatistics' role='tabpanel'>";

    // first panel content
    html = html + """
        <form action="/page3.html" method="post">
        <div class="row">
          <div class="col-md-3">
            <h3> Sort By </h3>
            
            <div class="row" >
              <div class="col-xs-8 col-md-12">
              <div class="btn-group" data-toggle="buttons">
                      <label class="btn btn-primary active">
                        <input type="checkbox" checked> Indigenous
                      </label>
                      <label class="btn btn-primary">
                        <input type="checkbox"> Non-Indigenous
                      </label>
                    </div>
              </div>
            </div>

            

            <div class="row" style='margin-top: 15;'>
              <div class="col-xs-8 col-md-12">
                            <div class="btn-group" role="group" aria-label="Basic radio toggle button group">
                            <input type="radio" class="btn-check" name="order" value="ASC" id="btnradio7" autocomplete="off" checked="">
                            <label class="btn btn-outline-primary" for="btnradio7">ASC</label>
                            <input type="radio" class="btn-check" name="order" value="DESC" id="btnradio8" autocomplete="off">
                            <label class="btn btn-outline-primary" for="btnradio8">DESC</label>
                            </div>
              </div>
            </div>

            <div class="row">
              <div class="col-xs-8 col-md-12">
                            <div class="form-group">
                            <label for="exampleSelect1" class="form-label mt-4">Number of similarities presented</label>
                            <select class="form-select" id="exampleSelect1" name="sortBy">
                              <option>5</option>
                              <option>10</option>
                              <option>25</option>
                              <option>50</option>
                            </select>
                          </div>
              </div>
            </div>
            

            <div class="row">
              <div class="col-xs-8 col-md-6">
                            <div class="form-group">
                            <label for="exampleSelect1" class="form-label mt-4">Age Min</label>
                            <select class="form-select" id="exampleSelect1" name="sortBy">
                              <option>0</option>
                              <option>5</option>
                              <option>10</option>
                              <option>15</option>
                              <option>20</option>
                              <option>25</option>
                              <option>30</option>
                              <option>35</option>
                              <option>40</option>
                              <option>45</option>
                              <option>50</option>
                              <option>55</option>
                              <option>60</option>
                              <option>65</option>

                            </select>
                          </div>
              </div>
            

            <div class="col-xs-8 col-md-6">
                            <div class="form-group">
                            <label for="exampleSelect1" class="form-label mt-4">Age Max</label>
                            <select class="form-select" id="exampleSelect1" name="sortBy">
                              <option>4</option>
                              <option>9</option>
                              <option>14</option>
                              <option>19</option>
                              <option>24</option>
                              <option>29</option>
                              <option>34</option>
                              <option>39</option>
                              <option>44</option>
                              <option>49</option>
                              <option>54</option>
                              <option>59</option>
                              <option>64</option>
                              <option>65+</option>
                            </select>
                          </div>
              </div>
              </div>

              <div class="row">
              <div class="col-xs-8 col-md-12">
                            <div class="form-group">
                            <label for="exampleSelect1" class="form-label mt-4">Select a LGA</label>
                            <select class="form-select" id="exampleSelect1" name="sortBy">
                            """;

                            JDBCConnection jdbc = new JDBCConnection();
                            ArrayList<LGA> lgas = jdbc.getLGAs();
                            for (LGA lga : lgas) {
                              html = html + "<option>" + lga.getName() + "</option>";
                            }
                                
                                
              html = html + """
                            </select>
                          </div>
              </div>
            </div>

            

            <div class="row" style='margin-top: 15;'>
              <div class="col-xs-8 col-md-12">
                            <button type="submit" class="btn btn-primary">Submit</button>
              </div>
            </div>
            
          
          </div>
          </form>
          """;
              
          // This is the second column
          html = html + """
          <div class="col-md-9">""";

          html = html + "<h3> Similarities </h3>";
          
          // This is nested in second column
          html = html + "<div class='row'>";

          // First section of second column
          html = html + "<div class='col-xs-8 col-sm-12'>";

          // Adding a container for the table

          html = html + "<div class='table-container'>";
          

        String outcome = context.formParam("outcome");
        String order = context.formParam("order");
        String pageNo = context.formParam("pageNo");
        String sortBy = context.formParam("sortBy");
        
        if (pageNo == null || pageNo == "") {
            // If NULL, nothing to show, therefore we make some "no results" HTML
            outcome = "PopulationStatistics";
            order = "ASC";
            pageNo = "1";
            sortBy = "code";

            html = html + "<table class='table table-hover'>";
            
            
            html = html + """
              <thead>
                <tr class='table-primary'>
                  <th scope="col">Name</th>
                  <th scope="col">Status</th>
                  <th scope="col">Sex</th>
                  """;
                      
                  if (outcome.equals("PopulationStatistics")) {
                  html = html + "<th scope='col'>Age</th>";
                }
                else if (outcome.equals("SchoolCompletion")) {
                  html = html + "<th scope='col'>School Year</th>";
                }
                else if (outcome.equals("LTHC")) {
                  html = html + "<th scope='col'>Condition</th>";
                }
                else if (outcome.equals("WeeklyIncome")) {
                  html = html + "<th scope='col'>Income Bracket</th>";
                }  
                
                html = html + """      
                  <th scope="col">Amount</th>
                </tr>
              </thead>

                """;

                html = html + outputTable(outcome, order, pageNo, sortBy);
                      
                // close table
                html = html + "</table>";
        } 
        else {
            // If NOT NULL, then lookup the movie by type!
            
            html = html + "<table class='table table-hover'>";
            
            
            html = html + """
              <thead>
                <tr class='table-primary'>
                  <th scope="col">Name</th>
                  <th scope="col">Status</th>
                  """;
                  if (outcome.equals("PopulationStatistics")) {
                    html = html + "<th scope='col'>Sex</th>;";
                  }
                  else if (outcome.equals("SchoolCompletion")) {
                    html = html + "<th scope='col'>Sex</th>;";
                  }
                  else if (outcome.equals("LTHC")) {
                    html = html + "<th scope='col'>Sex</th>;";
                  }
                  else if (outcome.equals("WeeklyIncome")) {
                    
                  }
                      
                  if (outcome.equals("PopulationStatistics")) {
                  html = html + "<th scope='col'>Age</th>";
                }
                else if (outcome.equals("SchoolCompletion")) {
                  html = html + "<th scope='col'>School Year</th>";
                }
                else if (outcome.equals("LTHC")) {
                  html = html + "<th scope='col'>Condition</th>";
                }
                else if (outcome.equals("WeeklyIncome")) {
                  html = html + "<th scope='col'>Income Bracket</th>";
                }  
                
                html = html + """      
                  <th scope="col">Amount</th>
                </tr>
              </thead>

                """;

                html = html + outputTable(outcome, order, pageNo, sortBy);

                // close table
                html = html + "</table>";
        }
        // CLOSING table container 
        html = html + "</div>";

        

        // CLOSING row of first section second column

        html = html + "</div>";

        // close row div
        html = html + "</div>";

        // APPARENTLY THIS ACTUALLY CLOSES ROW DIV

        html = html + "</div>";

        html = html + "</div>";

    html = html
        + "<p>Similarity is calcuated through the GAP score of the chosen LGA, applied by the chosen constraints and is then compared to other LGAS that have similar gap scores.</p>";

    // closing first whole panel
    html = html + "</div>";

    // second whole panel
    html = html + "<div class='tab-pane fade' id='schoolcompletion' role='tabpanel'>";

    // first panel content
    html = html + """
        <form action="/page3.html" method="post">
        <div class="row">
          <div class="col-md-3">
            <h3> Sort By </h3>

            <div class="row">
              <div class="col-xs-8 col-md-12">
              <div class="btn-group" data-toggle="buttons">
                      <label class="btn btn-primary active">
                        <input type="checkbox" checked> Indigenous
                      </label>
                      <label class="btn btn-primary">
                        <input type="checkbox"> Non-Indigenous
                      </label>
                    </div>
              </div>
            </div>

            <div class="row" style='margin-top: 15;'>
              <div class="col-xs-8 col-md-12">
                            <div class="btn-group" role="group" aria-label="Basic radio toggle button group">
                            <input type="radio" class="btn-check" name="order" value="ASC" id="btnradio7" autocomplete="off" checked="">
                            <label class="btn btn-outline-primary" for="btnradio7">ASC</label>
                            <input type="radio" class="btn-check" name="order" value="DESC" id="btnradio8" autocomplete="off">
                            <label class="btn btn-outline-primary" for="btnradio8">DESC</label>
                            </div>
              </div>
            </div>

            <div class="row">
              <div class="col-xs-8 col-md-12">
                            <div class="form-group">
                            <label for="exampleSelect1" class="form-label mt-4">Number of similarities presented</label>
                            <select class="form-select" id="exampleSelect1" name="sortBy">
                              <option>5</option>
                              <option>10</option>
                              <option>25</option>
                              <option>50</option>
                            </select>
                          </div>
              </div>
            </div>
            

            <div class="row">
              <div class="col-xs-8 col-md-12">
                            <div class="form-group">
                            <label for="exampleSelect1" class="form-label mt-4">Condition</label>
                            <select class="form-select" id="exampleSelect1" name="sortBy">
                              <option>arthiritis</option>
                              <option>asthma</option>
                              <option>cancer</option>
                              <option>dementia</option>
                              <option>diabetes</option>
                              <option>heart disease</option>
                              <option>kidney disease</option>
                              <option>lung condition</option>
                              <option>mental health</option>
                              <option>stroke</option>
                              <option>other</option>
                            

                            </select>
                          </div>
              </div>
            </div>

            <div class="row">
              <div class="col-xs-8 col-md-12">
                            <div class="form-group">
                            <label for="exampleSelect1" class="form-label mt-4">Select a LGA</label>
                            <select class="form-select" id="exampleSelect1" name="sortBy">
                            """;

                            for (LGA lga : lgas) {
                              html = html + "<option>" + lga.getName() + "</option>";
                            }
                                
                                
              html = html + """
                            </select>
                          </div>
              </div>
            </div>

              
            

            <div class="row" style='margin-top: 15;'>
              <div class="col-xs-8 col-md-12">
                            <button type="submit" class="btn btn-primary">Submit</button>
              </div>
            </div>
          
          </div>
          </form>
          """;
              
          // This is the second column
          html = html + """
          <div class="col-md-9">""";

          html = html + "<h3> Similarities </h3>";
          
          // This is nested in second column
          html = html + "<div class='row'>";

          // First section of second column
          html = html + "<div class='col-xs-8 col-sm-12'>";

          // Adding a container for the table

          html = html + "<div class='table-container'>";
          

       
        
        if (pageNo == null || pageNo == "") {
            // If NULL, nothing to show, therefore we make some "no results" HTML
            outcome = "PopulationStatistics";
            order = "ASC";
            pageNo = "1";
            sortBy = "code";

            html = html + "<table class='table table-hover'>";
            
            
            html = html + """
              <thead>
                <tr class='table-primary'>
                  <th scope="col">Name</th>
                  <th scope="col">Status</th>
                  <th scope="col">Sex</th>
                  """;
                      
                  if (outcome.equals("PopulationStatistics")) {
                  html = html + "<th scope='col'>Age</th>";
                }
                else if (outcome.equals("SchoolCompletion")) {
                  html = html + "<th scope='col'>School Year</th>";
                }
                else if (outcome.equals("LTHC")) {
                  html = html + "<th scope='col'>Condition</th>";
                }
                else if (outcome.equals("WeeklyIncome")) {
                  html = html + "<th scope='col'>Income Bracket</th>";
                }  
                
                html = html + """      
                  <th scope="col">Amount</th>
                </tr>
              </thead>

                """;

                html = html + outputTable(outcome, order, pageNo, sortBy);
                      
                // close table
                html = html + "</table>";
        } 
        else {
            // If NOT NULL, then lookup the movie by type!
            
            html = html + "<table class='table table-hover'>";
            
            
            html = html + """
              <thead>
                <tr class='table-primary'>
                  <th scope="col">Name</th>
                  <th scope="col">Status</th>
                  """;
                  if (outcome.equals("PopulationStatistics")) {
                    html = html + "<th scope='col'>Sex</th>;";
                  }
                  else if (outcome.equals("SchoolCompletion")) {
                    html = html + "<th scope='col'>Sex</th>;";
                  }
                  else if (outcome.equals("LTHC")) {
                    html = html + "<th scope='col'>Sex</th>;";
                  }
                  else if (outcome.equals("WeeklyIncome")) {
                    
                  }
                      
                  if (outcome.equals("PopulationStatistics")) {
                  html = html + "<th scope='col'>Age</th>";
                }
                else if (outcome.equals("SchoolCompletion")) {
                  html = html + "<th scope='col'>School Year</th>";
                }
                else if (outcome.equals("LTHC")) {
                  html = html + "<th scope='col'>Condition</th>";
                }
                else if (outcome.equals("WeeklyIncome")) {
                  html = html + "<th scope='col'>Income Bracket</th>";
                }  
                
                html = html + """      
                  <th scope="col">Amount</th>
                </tr>
              </thead>

                """;

                html = html + outputTable(outcome, order, pageNo, sortBy);

                // close table
                html = html + "</table>";
        }
        // CLOSING table container 
        html = html + "</div>";

        

        // CLOSING row of first section second column

        html = html + "</div>";

        // close row div
        html = html + "</div>";

        // APPARENTLY THIS ACTUALLY CLOSES ROW DIV

        html = html + "</div>";

        html = html + "</div>";

    // second panel content
    html = html
        + "<p>Similarity is calcuated through the GAP score of the chosen LGA, applied by the chosen constraints and is then compared to other LGAS that have similar gap scores.</p>";

    // closing second whole panel
    html = html + "</div>";

    // third whole panel
    html = html + "<div class='tab-pane fade' id='lthc' role='tabpanel'>";

    // first panel content
    html = html + """
        <form action="/page3.html" method="post">
        <div class="row">
          <div class="col-md-3">
            <h3> Sort By </h3>

            <div class="row">
              <div class="col-xs-8 col-md-12">
              <div class="btn-group" data-toggle="buttons">
                      <label class="btn btn-primary active">
                        <input type="checkbox" checked> Indigenous
                      </label>
                      <label class="btn btn-primary">
                        <input type="checkbox"> Non-Indigenous
                      </label>
                    </div>
              </div>
            </div>

            <div class="row" style='margin-top: 15;'>
              <div class="col-xs-8 col-md-12">
                            <div class="btn-group" role="group" aria-label="Basic radio toggle button group">
                            <input type="radio" class="btn-check" name="order" value="ASC" id="btnradio7" autocomplete="off" checked="">
                            <label class="btn btn-outline-primary" for="btnradio7">ASC</label>
                            <input type="radio" class="btn-check" name="order" value="DESC" id="btnradio8" autocomplete="off">
                            <label class="btn btn-outline-primary" for="btnradio8">DESC</label>
                            </div>
              </div>
            </div>

            <div class="row">
              <div class="col-xs-8 col-md-12">
                            <div class="form-group">
                            <label for="exampleSelect1" class="form-label mt-4">Number of similarities presented</label>
                            <select class="form-select" id="exampleSelect1" name="sortBy">
                              <option>5</option>
                              <option>10</option>
                              <option>25</option>
                              <option>50</option>
                            </select>
                          </div>
              </div>
            </div>
            

            <div class="row">
              <div class="col-xs-8 col-md-6">
                            <div class="form-group">
                            <label for="exampleSelect1" class="form-label mt-4">Year Min</label>
                            <select class="form-select" id="exampleSelect1" name="sortBy">
                              <option>Year 7</option>
                              <option>Year 8</option>
                              <option>Year 9</option>
                              <option>Year 10</option>
                              <option>Year 11</option>
                              <option>Year 12</option>
                            
                            </select>
                          </div>
              </div>
            

            <div class="col-xs-8 col-md-6">
                            <div class="form-group">
                            <label for="exampleSelect1" class="form-label mt-4">Year Max</label>
                            <select class="form-select" id="exampleSelect1" name="sortBy">
                              <option>Year 7</option>
                              <option>Year 8</option>
                              <option>Year 9</option>
                              <option>Year 10</option>
                              <option>Year 11</option>
                              <option>Year 12</option>
                            </select>
                          </div>
              </div>
              </div>

              <div class="row">
              <div class="col-xs-8 col-md-12">
                            <div class="form-group">
                            <label for="exampleSelect1" class="form-label mt-4">Select a LGA</label>
                            <select class="form-select" id="exampleSelect1" name="sortBy">
                            """;

                            for (LGA lga : lgas) {
                              html = html + "<option>" + lga.getName() + "</option>";
                            }
                                
                                
              html = html + """
                            </select>
                          </div>
              </div>
            </div>

            

            <div class="row" style='margin-top: 15;'>
              <div class="col-xs-8 col-md-12">
                            <button type="submit" class="btn btn-primary">Submit</button>
              </div>
            </div>
          
          </div>
          </form>
          """;
              
          // This is the second column
          html = html + """
          <div class="col-md-9">""";

          html = html + "<h3> Similarities </h3>";
          
          // This is nested in second column
          html = html + "<div class='row'>";

          // First section of second column
          html = html + "<div class='col-xs-8 col-sm-12'>";

          // Adding a container for the table

          html = html + "<div class='table-container'>";
        
        if (pageNo == null || pageNo == "") {
            // If NULL, nothing to show, therefore we make some "no results" HTML
            outcome = "PopulationStatistics";
            order = "ASC";
            pageNo = "1";
            sortBy = "code";

            html = html + "<table class='table table-hover'>";
            
            
            html = html + """
              <thead>
                <tr class='table-primary'>
                  <th scope="col">Name</th>
                  <th scope="col">Status</th>
                  <th scope="col">Sex</th>
                  """;
                      
                  if (outcome.equals("PopulationStatistics")) {
                  html = html + "<th scope='col'>Age</th>";
                }
                else if (outcome.equals("SchoolCompletion")) {
                  html = html + "<th scope='col'>School Year</th>";
                }
                else if (outcome.equals("LTHC")) {
                  html = html + "<th scope='col'>Condition</th>";
                }
                else if (outcome.equals("WeeklyIncome")) {
                  html = html + "<th scope='col'>Income Bracket</th>";
                }  
                
                html = html + """      
                  <th scope="col">Amount</th>
                </tr>
              </thead>

                """;

                html = html + outputTable(outcome, order, pageNo, sortBy);
                      
                // close table
                html = html + "</table>";
        } 
        else {
            // If NOT NULL, then lookup the movie by type!
            
            html = html + "<table class='table table-hover'>";
            
            
            html = html + """
              <thead>
                <tr class='table-primary'>
                  <th scope="col">Name</th>
                  <th scope="col">Status</th>
                  """;
                  if (outcome.equals("PopulationStatistics")) {
                    html = html + "<th scope='col'>Sex</th>;";
                  }
                  else if (outcome.equals("SchoolCompletion")) {
                    html = html + "<th scope='col'>Sex</th>;";
                  }
                  else if (outcome.equals("LTHC")) {
                    html = html + "<th scope='col'>Sex</th>;";
                  }
                  else if (outcome.equals("WeeklyIncome")) {
                    
                  }
                      
                  if (outcome.equals("PopulationStatistics")) {
                  html = html + "<th scope='col'>Age</th>";
                }
                else if (outcome.equals("SchoolCompletion")) {
                  html = html + "<th scope='col'>School Year</th>";
                }
                else if (outcome.equals("LTHC")) {
                  html = html + "<th scope='col'>Condition</th>";
                }
                else if (outcome.equals("WeeklyIncome")) {
                  html = html + "<th scope='col'>Income Bracket</th>";
                }  
                
                html = html + """      
                  <th scope="col">Amount</th>
                </tr>
              </thead>

                """;

                html = html + outputTable(outcome, order, pageNo, sortBy);

                // close table
                html = html + "</table>";
        }
        // CLOSING table container 
        html = html + "</div>";

        

        // CLOSING row of first section second column

        html = html + "</div>";

        // close row div
        html = html + "</div>";

        // APPARENTLY THIS ACTUALLY CLOSES ROW DIV

        html = html + "</div>";

        html = html + "</div>";
        

    // third panel content

    
    html = html
        + "<p>Similarity is calcuated through the GAP score of the chosen LGA, applied by the chosen constraints and is then compared to other LGAS that have similar gap scores.</p>";

    // closing third whole panel
    html = html + "</div>";

    // fourth whole panel
    html = html + "<div class='tab-pane fade' id='weeklyincome' role='tabpanel'>";

    // fourth panel content

    html = html + """
        <form action="/page3.html" method="post">
        <div class="row">
          <div class="col-md-3">
            <h3> Sort By </h3>

            <div class="row">
              <div class="col-xs-8 col-md-12">
              <div class="btn-group" data-toggle="buttons">
                      <label class="btn btn-primary active">
                        <input type="checkbox" checked> Indigenous
                      </label>
                      <label class="btn btn-primary">
                        <input type="checkbox"> Non-Indigenous
                      </label>
                    </div>
              </div>
            </div>

            <div class="row" style='margin-top: 15;'>
              <div class="col-xs-8 col-md-12">
                            <div class="btn-group" role="group" aria-label="Basic radio toggle button group">
                            <input type="radio" class="btn-check" name="order" value="ASC" id="btnradio7" autocomplete="off" checked="">
                            <label class="btn btn-outline-primary" for="btnradio7">ASC</label>
                            <input type="radio" class="btn-check" name="order" value="DESC" id="btnradio8" autocomplete="off">
                            <label class="btn btn-outline-primary" for="btnradio8">DESC</label>
                            </div>
              </div>
            </div>

            <div class="row">
              <div class="col-xs-8 col-md-12">
                            <div class="form-group">
                            <label for="exampleSelect1" class="form-label mt-4">Number of similarities presented</label>
                            <select class="form-select" id="exampleSelect1" name="sortBy">
                              <option>5</option>
                              <option>10</option>
                              <option>25</option>
                              <option>50</option>
                            </select>
                          </div>
              </div>
            </div>
            

            <div class="row">
              <div class="col-xs-8 col-md-6">
                            <div class="form-group">
                            <label for="exampleSelect1" class="form-label mt-4">Year Min</label>
                            <select class="form-select" id="exampleSelect1" name="sortBy">
                              <option>$1</option>
                              <option>$150</option>
                              <option>$300</option>
                              <option>$400</option>
                              <option>$500</option>
                              <option>$650</option>
                              <option>$800</option>
                              <option>$1000</option>
                              <option>$1250</option>
                              <option>$1500</option>
                              <option>$1750</option>
                              <option>$2000</option>
                              <option>$2500</option>
                              <option>$3000</option>
                              <option>$3500</option>
                            
                            </select>
                          </div>
              </div>
            

            <div class="col-xs-8 col-md-6">
                            <div class="form-group">
                            <label for="exampleSelect1" class="form-label mt-4">Year Max</label>
                            <select class="form-select" id="exampleSelect1" name="sortBy">
                            <option>$149</option>
                            <option>$299</option>
                            <option>$399</option>
                            <option>$499</option>
                            <option>$649</option>
                            <option>$799</option>
                            <option>$999</option>
                            <option>$1249</option>
                            <option>$1499</option>
                            <option>$1749</option>
                            <option>$1999</option>
                            <option>$2499</option>
                            <option>$2999</option>
                            <option>$3499</option>
                            <option>$3500+</option>
                            </select>
                          </div>
              </div>
              
            </div>

            <div class="row">
              <div class="col-xs-8 col-md-12">
                            <div class="form-group">
                            <label for="exampleSelect1" class="form-label mt-4">Select a LGA</label>
                            <select class="form-select" id="exampleSelect1" name="sortBy">
                            """;

                            
                            for (LGA lga : lgas) {
                              html = html + "<option>" + lga.getName() + "</option>";
                            }
                                
                                
              html = html + """
                            </select>
                          </div>
              </div>
            </div>

              
            

            <div class="row" style='margin-top: 15;'>
              <div class="col-xs-8 col-md-12">
                            <button type="submit" class="btn btn-primary">Submit</button>
              </div>
            </div>

            
          
          </div>
          </form>
          """;
              
          // This is the second column
          html = html + """
          <div class="col-md-9">""";

          html = html + "<h3> Similarities </h3>";
          
          // This is nested in second column
          html = html + "<div class='row'>";

          // First section of second column
          html = html + "<div class='col-xs-8 col-sm-12'>";

          // Adding a container for the table

          html = html + "<div class='table-container'>";
          

       
        
        if (pageNo == null || pageNo == "") {
            // If NULL, nothing to show, therefore we make some "no results" HTML
            outcome = "PopulationStatistics";
            order = "ASC";
            pageNo = "1";
            sortBy = "code";

            html = html + "<table class='table table-hover'>";
            
            
            html = html + """
              <thead>
                <tr class='table-primary'>
                  <th scope="col">Name</th>
                  <th scope="col">Status</th>
                  <th scope="col">Sex</th>
                  """;
                      
                  if (outcome.equals("PopulationStatistics")) {
                  html = html + "<th scope='col'>Age</th>";
                }
                else if (outcome.equals("SchoolCompletion")) {
                  html = html + "<th scope='col'>School Year</th>";
                }
                else if (outcome.equals("LTHC")) {
                  html = html + "<th scope='col'>Condition</th>";
                }
                else if (outcome.equals("WeeklyIncome")) {
                  html = html + "<th scope='col'>Income Bracket</th>";
                }  
                
                html = html + """      
                  <th scope="col">Amount</th>
                </tr>
              </thead>

                """;

                html = html + outputTable(outcome, order, pageNo, sortBy);
                      
                // close table
                html = html + "</table>";
        } 
        else {
            // If NOT NULL, then lookup the movie by type!
            
            html = html + "<table class='table table-hover'>";
            
            
            html = html + """
              <thead>
                <tr class='table-primary'>
                  <th scope="col">Name</th>
                  <th scope="col">Status</th>
                  """;
                  if (outcome.equals("PopulationStatistics")) {
                    html = html + "<th scope='col'>Sex</th>;";
                  }
                  else if (outcome.equals("SchoolCompletion")) {
                    html = html + "<th scope='col'>Sex</th>;";
                  }
                  else if (outcome.equals("LTHC")) {
                    html = html + "<th scope='col'>Sex</th>;";
                  }
                  else if (outcome.equals("WeeklyIncome")) {
                    
                  }
                      
                  if (outcome.equals("PopulationStatistics")) {
                  html = html + "<th scope='col'>Age</th>";
                }
                else if (outcome.equals("SchoolCompletion")) {
                  html = html + "<th scope='col'>School Year</th>";
                }
                else if (outcome.equals("LTHC")) {
                  html = html + "<th scope='col'>Condition</th>";
                }
                else if (outcome.equals("WeeklyIncome")) {
                  html = html + "<th scope='col'>Income Bracket</th>";
                }  
                
                html = html + """      
                  <th scope="col">Amount</th>
                </tr>
              </thead>

                """;

                html = html + outputTable(outcome, order, pageNo, sortBy);

                // close table
                html = html + "</table>";
        }
        // CLOSING table container 
        html = html + "</div>";

        

        // CLOSING row of first section second column

        html = html + "</div>";

        // close row div
        html = html + "</div>";

        // APPARENTLY THIS ACTUALLY CLOSES ROW DIV

        html = html + "</div>";

        html = html + "</div>";

    // second panel content
    html = html
        + "<p>Similarity is calcuated through the GAP score of the chosen LGA, applied by the chosen constraints and is then compared to other LGAS that have similar gap scores.</p>";

    // closing second whole panel
    html = html + "</div>";

    // third whole panel
    html = html + "<div class='tab-pane fade' id='lthc' role='tabpanel'>";

    // first panel content
    html = html + """
        <form action="/page3.html" method="post">
        <div class="row">
          <div class="col-md-3">
            <h3> Sort By </h3>

            <div class="row">
              <div class="col-xs-8 col-md-12">
              <div class="btn-group" data-toggle="buttons">
                      <label class="btn btn-primary active">
                        <input type="checkbox" checked> Indigenous
                      </label>
                      <label class="btn btn-primary">
                        <input type="checkbox"> Non-Indigenous
                      </label>
                    </div>
              </div>
            </div>

            <div class="row" style='margin-top: 15;'>
              <div class="col-xs-8 col-md-12">
                            <div class="btn-group" role="group" aria-label="Basic radio toggle button group">
                            <input type="radio" class="btn-check" name="order" value="ASC" id="btnradio7" autocomplete="off" checked="">
                            <label class="btn btn-outline-primary" for="btnradio7">ASC</label>
                            <input type="radio" class="btn-check" name="order" value="DESC" id="btnradio8" autocomplete="off">
                            <label class="btn btn-outline-primary" for="btnradio8">DESC</label>
                            </div>
              </div>
            </div>

            <div class="row">
              <div class="col-xs-8 col-md-12">
                            <div class="form-group">
                            <label for="exampleSelect1" class="form-label mt-4">Number of similarities presented</label>
                            <select class="form-select" id="exampleSelect1" name="sortBy">
                              <option>5</option>
                              <option>10</option>
                              <option>25</option>
                              <option>50</option>
                            </select>
                          </div>
              </div>
            </div>
            

            <div class="row">
              <div class="col-xs-8 col-md-6">
                            <div class="form-group">
                            <label for="exampleSelect1" class="form-label mt-4">Year Min</label>
                            <select class="form-select" id="exampleSelect1" name="sortBy">
                              <option>Year 7</option>
                              <option>Year 8</option>
                              <option>Year 9</option>
                              <option>Year 10</option>
                              <option>Year 11</option>
                              <option>Year 12</option>
                            
                            </select><div class="row">
                            <div class="col-xs-8 col-md-6">
                                          <div class="form-group">
                                          <label for="exampleSelect1" class="form-label mt-4">Year Min</label>
                                          <select class="form-select" id="exampleSelect1" name="sortBy">
                                            <option>Year 7</option>
                                            <option>Year 8</option>
                                            <option>Year 9</option>
                                            <option>Year 10</option>
                                            <option>Year 11</option>
                                            <option>Year 12</option>
                                          
                                          </select>
                                        </div>
                            </div>
                          
              
                          <div class="col-xs-8 col-md-6">
                                          <div class="form-group">
                                          <label for="exampleSelect1" class="form-label mt-4">Year Max</label>
                                          <select class="form-select" id="exampleSelect1" name="sortBy">
                                            <option>Year 7</option>
                                            <option>Year 8</option>
                                            <option>Year 9</option>
                                            <option>Year 10</option>
                                            <option>Year 11</option>
                                            <option>Year 12</option>
                                          </select>
                                        </div>
                            </div>
                            </div>
                          </div>
              </div>
            

            <div class="col-xs-8 col-md-6">
                            <div class="form-group">
                            <label for="exampleSelect1" class="form-label mt-4">Year Max</label>
                            <select class="form-select" id="exampleSelect1" name="sortBy">
                              <option>Year 7</option>
                              <option>Year 8</option>
                              <option>Year 9</option>
                              <option>Year 10</option>
                              <option>Year 11</option>
                              <option>Year 12</option>
                            </select>
                          </div>
              </div>
              </div>

              <div class="row">
              <div class="col-xs-8 col-md-12">
                            <div class="form-group">
                            <label for="exampleSelect1" class="form-label mt-4">Select a LGA</label>
                            <select class="form-select" id="exampleSelect1" name="sortBy">
                            """;

                            
                            for (LGA lga : lgas) {
                              html = html + "<option>" + lga.getName() + "</option>";
                            }
                                
                                
              html = html + """
                            </select>
                          </div>
              </div>
            </div>

            

            <div class="row" style='margin-top: 15;'>
              <div class="col-xs-8 col-md-12">
                            <button type="submit" class="btn btn-primary">Submit</button>
              </div>
            </div>
          
          </div>
          </form>
          """;
              
          // This is the second column
          html = html + """
          <div class="col-md-9">""";

          html = html + "<h3> Similarities </h3>";
          
          // This is nested in second column
          html = html + "<div class='row'>";

          // First section of second column
          html = html + "<div class='col-xs-8 col-sm-12'>";

          // Adding a container for the table

          html = html + "<div class='table-container'>";
        
        if (pageNo == null || pageNo == "") {
            // If NULL, nothing to show, therefore we make some "no results" HTML
            outcome = "PopulationStatistics";
            order = "ASC";
            pageNo = "1";
            sortBy = "code";

            html = html + "<table class='table table-hover'>";
            
            
            html = html + """
              <thead>
                <tr class='table-primary'>
                  <th scope="col">Name</th>
                  <th scope="col">Status</th>
                  <th scope="col">Sex</th>
                  """;
                      
                  if (outcome.equals("PopulationStatistics")) {
                  html = html + "<th scope='col'>Age</th>";
                }
                else if (outcome.equals("SchoolCompletion")) {
                  html = html + "<th scope='col'>School Year</th>";
                }
                else if (outcome.equals("LTHC")) {
                  html = html + "<th scope='col'>Condition</th>";
                }
                else if (outcome.equals("WeeklyIncome")) {
                  html = html + "<th scope='col'>Income Bracket</th>";
                }  
                
                html = html + """      
                  <th scope="col">Amount</th>
                </tr>
              </thead>

                """;

                html = html + outputTable(outcome, order, pageNo, sortBy);
                      
                // close table
                html = html + "</table>";
        } 
        else {
            // If NOT NULL, then lookup the movie by type!
            
            html = html + "<table class='table table-hover'>";
            
            
            html = html + """
              <thead>
                <tr class='table-primary'>
                  <th scope="col">Name</th>
                  <th scope="col">Status</th>
                  """;
                  if (outcome.equals("PopulationStatistics")) {
                    html = html + "<th scope='col'>Sex</th>;";
                  }
                  else if (outcome.equals("SchoolCompletion")) {
                    html = html + "<th scope='col'>Sex</th>;";
                  }
                  else if (outcome.equals("LTHC")) {
                    html = html + "<th scope='col'>Sex</th>;";
                  }
                  else if (outcome.equals("WeeklyIncome")) {
                    
                  }
                      
                  if (outcome.equals("PopulationStatistics")) {
                  html = html + "<th scope='col'>Age</th>";
                }
                else if (outcome.equals("SchoolCompletion")) {
                  html = html + "<th scope='col'>School Year</th>";
                }
                else if (outcome.equals("LTHC")) {
                  html = html + "<th scope='col'>Condition</th>";
                }
                else if (outcome.equals("WeeklyIncome")) {
                  html = html + "<th scope='col'>Income Bracket</th>";
                }  
                
                html = html + """      
                  <th scope="col">Amount</th>
                </tr>
              </thead>

                """;

                html = html + outputTable(outcome, order, pageNo, sortBy);

                // close table
                html = html + "</table>";
        }
        // CLOSING table container 
        html = html + "</div>";

        

        // CLOSING row of first section second column

        html = html + "</div>";

        // close row div
        html = html + "</div>";

        // APPARENTLY THIS ACTUALLY CLOSES ROW DIV

        html = html + "</div>";

        html = html + "</div>";

    html = html
        + "<p>Raw denim you probably haven't heard of them jean shorts Austin. Nesciunt tofu stumptown aliqua, retro synth master cleanse. Mustache cliche tempor, williamsburg carles vegan helvetica. Reprehenderit butcher retro keffiyeh dreamcatcher synth. Cosby sweater eu banh mi, qui irure terry richardson ex squid. Aliquip placeat salvia cillum iphone. Seitan aliquip quis cardigan american apparel, butcher voluptate nisi qui.</p>";

    // closing fourth whole panel
    html = html + "</div>";

    // closing div for the whole table
    html = html + "</div";

    // Close Content div
    html = html + "</div>";

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

  public String outputTable(String outcome, String order, String pageNo, String sortBy) {
    String html = "";

    JDBCConnection jdbc = new JDBCConnection();
    ArrayList<LGA> lgas = jdbc.getTablest21(outcome, order, pageNo, sortBy);

    html = html + "<tbody>";
      
    for (LGA lga : lgas) {
        if (lga.getYear() == 2021) {
          html = html + "<tr class='table-primary'>";
          html = html + "<td scope='row'>" + lga.getName() + "</td>"
                      + "<td>" + lga.getStatus() + "</td>";

                      
                      if (outcome.equals("PopulationStatistics")) {
                        html = html + "<td>" + lga.getSex() + "</td>";
                    } else if (outcome.equals("SchoolCompletion")) {
                      html = html + "<td>" + lga.getSex() + "</td>";
                    } else if (outcome.equals("LTHC")) {
                      html = html + "<td>" + lga.getSex() + "</td>";
                    } else if (outcome.equals("WeeklyIncome")) {
                        
                    } 
          
          html = html + "<td>" + lga.getCategorey() + "</td>"
                      + "<td>" + lga.getCount() + "</td>";
          html = html + "</tr>";
        }
        else{

        }
      }
      
      html = html + "</tbody>";

    return html;
  }

}
