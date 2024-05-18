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
public class PageST21 implements Handler {

    // URL of this page relative to http://localhost:7001/
    public static final String URL = "/page3.html";

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

        //Code underneath is old CSS

        // html = html
        // + "<link rel='stylesheet' href='https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css' integrity='sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm' crossorigin='anonymous'>";
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

    
        """;

    
        
        html = html + "</style>";

        html = html + "</head>";

        // Add the body
        html = html + "<body>";

        html = html + """
            <div class='header'>
                <h1>
                    <img src='Logo_small.png' class='top-image' alt='RMIT logo' height='75'>
                    Latest Statistics (LGAs)
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
        html = html + "<div class='content' style='background-color: 934938;'>";

        
        // This is the first column
        html = html + """
        <form action="/page3.html" method="post">
        <div class="row">
        
          <div class="col-md-3">
            <h3> View By </h3>

            <div class="row">
              <div class="col-xs-8 col-md-12">
              <div style='color: #40302D;'>
                            <div class="btn-group" role="group" aria-label="Basic radio toggle button group">
                            <input type="radio" class="btn-check" value="PopulationStatistics" name="outcome" id="btnradio1" autocomplete="off" checked="">
                            <label class="btn btn-outline-primary" for="btnradio1">Population Stats</label>
                            <input type="radio" class="btn-check" value="SchoolCompletion" name="outcome" id="btnradio2" autocomplete="off">
                            <label class="btn btn-outline-primary" for="btnradio2">School Completion</label>
                            <input type="radio" class="btn-check" value="LTHC" name="outcome" id="btnradio3" autocomplete="off">
                            <label class="btn btn-outline-primary" for="btnradio3">Health Condition</label>
                            <input type="radio" class="btn-check" value="WeeklyIncome" name="outcome" id="btnradio4" autocomplete="off">
                            <label class="btn btn-outline-primary" for="btnradio4">Weekly Income</label>
                            </div>
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
                            <label class="col-form-label mt-4" for="inputDefault">Page Number</label>
                            <input type="text" class="form-control" name="pageNo" placeholder="Must enter to work table to work" id="inputDefault">
                            </div>
              </div>
            </div>
            

            <div class="row">
              <div class="col-xs-8 col-md-12">
                            <div class="form-group">
                            <label for="exampleSelect1" class="form-label mt-4">Example select</label>
                            <select class="form-select" id="exampleSelect1" name="sortBy">
                              <option>code</option>
                              <option>sex</option>
                              <option>category</option>
                              <option>count</option>
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

          html = html + "<h3> FOR REFRENCE </h3>";
          
          // This is nested in second column
          html = html + "<div class='row'>";

          // First section of second column
          html = html + "<div class='col-xs-8 col-sm-12'>";

          // Adding a container for the table

          html = html + "<div class='table-container'>";
          
         
        // String btnradio1 = context.formParam("btnradio1", "");

        
        // String movietype_drop = context.queryParam("movietype_drop");
        // if (btnradio1.equals("Outcome 1")) {
        //   html = html + "<table class='table table-hover'>";
            
            
        //     html = html + """
        //       <thead>
        //         <tr>
        //           <th scope="col">Name</th>
        //           <th scope="col">Status</th>
        //           <th scope="col">Sex</th>
        //           <th scope="col">School Year</th>
        //           <th scope="col">Amount</th>
        //         </tr>
        //       </thead>

        //         """;
             
        //     html = html + outputOutcome1Table();

        //     //close table
        //     html = html + "</table>";
            
        // } 
        // else if (btnradio1.equals("Outcome 2")) {
        //     // If NOT NULL, then lookup the movie by type!
        //     //Open table
        //     html = html + "<table class='table table-hover'>";
            
            
        //     html = html + """
        //       <thead>
        //         <tr>
        //           <th scope="col">Name</th>
        //           <th scope="col">Status</th>
        //           <th scope="col">Sex</th>
        //           <th scope="col">School Year</th>
        //           <th scope="col">Amount</th>
        //         </tr>
        //       </thead>

        //         """;
             
        //     html = html + outputOutcome2Table();

        //     //close table
        //     html = html + "</table>";
        // }
        // else if (btnradio1.equals("Outcome 3")) {
        //   html = html + "<table class='table table-hover'>";
            
            
        //     html = html + """
        //       <thead>
        //         <tr>
        //           <th scope="col">Name</th>
        //           <th scope="col">Status</th>
        //           <th scope="col">Sex</th>
        //           <th scope="col">School Year</th>
        //           <th scope="col">Amount</th>
        //         </tr>
        //       </thead>

        //         """;
             
        //     html = html + outputOutcome3Table();

        //     //close table
        //     html = html + "</table>";

        // }  

        // else if (btnradio1.equals("Outcome 4")) {
        //   html = html + "<table class='table table-hover'>";
            
            
        //     html = html + """
        //       <thead>
        //         <tr>
        //           <th scope="col">Name</th>
        //           <th scope="col">Status</th>
        //           <th scope="col">Sex</th>
        //           <th scope="col">School Year</th>
        //           <th scope="col">Amount</th>
        //         </tr>
        //       </thead>

        //         """;
             
        //     html = html + outputOutcome4Table();

        //     //close table
        //     html = html + "</table>";

        // }

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

        // ADDING row of for the second row

        html = html + "<div class='row'>";

        // ADDING the columns for second row

        html = html + "<div class='col-xs-8 col-sm-4'>";

        // Content of second section second column
        JDBCConnection jdbc = new JDBCConnection();

        String secondColumn = context.formParam("outcome", "");
        
        if (secondColumn == null || secondColumn == "" || secondColumn.equals("PopulationStatistics")) {
          html = html + "<div class='statcontainer'>";
        
          // Information for Indigenous Status
        
        ArrayList<Categorey> categorey = jdbc.getO1Status();

        html = html + "<h4>Indigenous Status</h4>";

        html = html + "<p>Total number of Indigenous people: " + categorey.get(0).getSumAmount() + "</p>";
        
        html = html + "<p>Total number of non-Indigenous people: " + categorey.get(2).getSumAmount() + "</p>";
        
        html = html + "<p>Total number of non-stated: " + categorey.get(1).getSumAmount() + "</p>";
        
        

        double wholepop = categorey.get(0).getSumAmount() + categorey.get(2).getSumAmount() + categorey.get(1).getSumAmount();

        

        
        // Information for Sex 

        ArrayList<Categorey> sex = jdbc.getO1Sex();

        html = html + "<h4>Sex</h4>";

        html = html + "<p>Total number of Males: " + sex.get(1).getSumAmount() + "</p>";
        
        html = html + "<p>Total number of Females: " + sex.get(0).getSumAmount() + "</p>";
        
        
        

        // Information for Categorey
        ArrayList<Categorey> completion = jdbc.getO1categorey();
        

        html = html + "<h4>Age</h4>";

        html = html + "<p>Total number of people who are between the age of 0 and 4: " + completion.get(0).getSumAmount() + "</p>";
        
        html = html + "<p>Total number of people who are between the age of 5 and 9: " + completion.get(11).getSumAmount() + "</p>";
        
        html = html + "<p>Total number of people who are between the age of 10 and 14: " + completion.get(1).getSumAmount() + "</p>";
        
        html = html + "<p>Total number of people who are between the age of 15 and 19: " + completion.get(2).getSumAmount() + "</p>";
        
        html = html + "<p>Total number of people who are between the age of 20 and 24: " + completion.get(3).getSumAmount() + "</p>";
        
        html = html + "<p>Total number of people who are between the age of 25 and 29: " + completion.get(4).getSumAmount() + "</p>";
        
        html = html + "<p>Total number of people who are between the age of 30 and 34: " + completion.get(5).getSumAmount() + "</p>";
        
        html = html + "<p>Total number of people who are between the age of 35 and 39: " + completion.get(6).getSumAmount() + "</p>";
        
        html = html + "<p>Total number of people who are between the age of 40 and 44: " + completion.get(7).getSumAmount() + "</p>";
        
        html = html + "<p>Total number of people who are between the age of 45 and 49: " + completion.get(8).getSumAmount() + "</p>";
       
        html = html + "<p>Total number of people who are between the age of 50 and 54: " + completion.get(9).getSumAmount() + "</p>";
        
        html = html + "<p>Total number of people who are between the age of 55 and 59: " + completion.get(10).getSumAmount() + "</p>";
        
        html = html + "<p>Total number of people who are between the age of 60 and over: " + completion.get(12).getSumAmount() + "</p>";
        
        html = html + "<p>Total number of people who are between the age of 65 and over: " + completion.get(13).getSumAmount() + "</p>";
        
        // Closing container

        html = html + "</div>";
        
        // CLOSING First column second row
        html = html + "</div>";
        
        
        // Second Column for second row
        html = html + "<div class='col-xs-8 col-sm-4'>";

        //Container
        html = html + "<div class='statcontainer'>";

        html = html + "<h4>Proportion of Indigenous Status:</h4>";

        html = html + "<p>Indigenous: " + Math.round(categorey.get(0).getSumAmount()/ wholepop * 100) + "%</p>";

        html = html + "<p>Non-Indigenous: " + Math.round(categorey.get(2).getSumAmount()/ wholepop * 100) + "%</p>";
        
        html = html + "<p>Not-stated: " + Math.round(categorey.get(1).getSumAmount()/ wholepop * 100) + "%</p>";

        
        html = html + "<h4>Proportion of Sex:</h4>";

        html = html + "<p>Males: " + sex.get(1).getSumAmount()/ wholepop * 100 + "%</p>";

        html = html + "<p>Females: " + sex.get(0).getSumAmount()/ wholepop * 100 + "%</p>";


        html = html + "<h4>Proportion of Age:</h4>";

        html = html + "<p>Between age 0 and 4: " + Math.round(completion.get(0).getSumAmount()/ wholepop * 100 )+ "%</p>";
        
        html = html + "<p>Between age 5 and 9: " + Math.round(completion.get(11).getSumAmount()/ wholepop * 100) + "%</p>";
        
        html = html + "<p>Between age 10 and 14: " + Math.round(completion.get(1).getSumAmount()/ wholepop * 100 )+ "%</p>";
       
        html = html + "<p>Between age 15 and 19: " + Math.round(completion.get(2).getSumAmount()/ wholepop * 100 )+ "%</p>";
       
        html = html + "<p>Between age 20 and 24: " + Math.round(completion.get(3).getSumAmount()/ wholepop * 100 )+ "%</p>";
       
        html = html + "<p>Between age 25 and 29: " + Math.round(completion.get(4).getSumAmount()/ wholepop * 100 )+ "%</p>";
       
        html = html + "<p>Between age 30 and 34: " + Math.round(completion.get(5).getSumAmount()/ wholepop * 100 )+ "%</p>";
        
        html = html + "<p>Between age 35 and 39: " + Math.round(completion.get(6).getSumAmount()/ wholepop * 100 )+ "%</p>";
        
        html = html + "<p>Between age 40 and 44: " + Math.round(completion.get(7).getSumAmount()/ wholepop * 100 )+ "%</p>";
        
        html = html + "<p>Between age 45 and 49: " + Math.round(completion.get(8).getSumAmount()/ wholepop * 100 )+ "%</p>";
       
        html = html + "<p>Between age 50 and 54: " + Math.round(completion.get(9).getSumAmount()/ wholepop * 100 )+ "%</p>";
       
        html = html + "<p>Between age 55 and 59: " + Math.round(completion.get(10).getSumAmount()/ wholepop * 100) + "%</p>";
        
        html = html + "<p>Between age 60 and 64: " + Math.round(completion.get(12).getSumAmount()/ wholepop * 100) + "%</p>";
        
        html = html + "<p>Between age 65 and over: " + Math.round(completion.get(13).getSumAmount()/ wholepop * 100) + "%</p>";

        // Closing container

        html = html + "</div>";

        // CLOSING for second column second row

        html = html + "</div>";
        
        // Third Column for second row

        html = html + "<div class='col-xs-8 col-sm-4'>";
        
        // Container
        html = html + "<div class='statcontainer'>";

        ArrayList<LGA> lgas = jdbc.getTheGapst21(outcome);

        html = html + "<h4> The GAP </h4>";

        
        html = html + "<p>Between age 0 and 4: " + Math.abs(Math.round(lgas.get(0).getCount()/ wholepop * 100 ) - Math.round(lgas.get(14).getCount()/ wholepop * 100 )) + "%</p>";
        
        html = html + "<p>Between age 5 and 9: " + Math.abs(Math.round(lgas.get(11).getCount()/ wholepop * 100 ) - Math.round(lgas.get(25).getCount()/ wholepop * 100 )) + "%</p>";

        html = html + "<p>Between age 10 and 14: " + Math.abs(Math.round(lgas.get(1).getCount()/ wholepop * 100 ) - Math.round(lgas.get(15).getCount()/ wholepop * 100 )) + "%</p>";

        html = html + "<p>Between age 15 and 19: " + Math.abs(Math.round(lgas.get(2).getCount()/ wholepop * 100 ) - Math.round(lgas.get(16).getCount()/ wholepop * 100 )) + "%</p>";

        html = html + "<p>Between age 20 and 24: " + Math.abs(Math.round(lgas.get(3).getCount()/ wholepop * 100 ) - Math.round(lgas.get(17).getCount()/ wholepop * 100 )) + "%</p>";

        html = html + "<p>Between age 25 and 29: " + Math.abs(Math.round(lgas.get(4).getCount()/ wholepop * 100 ) - Math.round(lgas.get(18).getCount()/ wholepop * 100 )) + "%</p>";

        html = html + "<p>Between age 30 and 34: " + Math.abs(Math.round(lgas.get(5).getCount()/ wholepop * 100 ) - Math.round(lgas.get(19).getCount()/ wholepop * 100 )) + "%</p>";

        html = html + "<p>Between age 35 and 39: " + Math.abs(Math.round(lgas.get(6).getCount()/ wholepop * 100 ) - Math.round(lgas.get(20).getCount()/ wholepop * 100 )) + "%</p>";

        html = html + "<p>Between age 40 and 44: " + Math.abs(Math.round(lgas.get(7).getCount()/ wholepop * 100 ) - Math.round(lgas.get(21).getCount()/ wholepop * 100 )) + "%</p>";
        
        html = html + "<p>Between age 45 and 49: " + Math.abs(Math.round(lgas.get(8).getCount()/ wholepop * 100 ) - Math.round(lgas.get(22).getCount()/ wholepop * 100 )) + "%</p>";

        html = html + "<p>Between age 50 and 54: " + Math.abs(Math.round(lgas.get(9).getCount()/ wholepop * 100 ) - Math.round(lgas.get(23).getCount()/ wholepop * 100 )) + "%</p>";

        html = html + "<p>Between age 55 and 59: " + Math.abs(Math.round(lgas.get(10).getCount()/ wholepop * 100 ) - Math.round(lgas.get(24).getCount()/ wholepop * 100 )) + "%</p>";

        html = html + "<p>Between age 60 and 64: " + Math.abs(Math.round(lgas.get(12).getCount()/ wholepop * 100 ) - Math.round(lgas.get(26).getCount()/ wholepop * 100 )) + "%</p>";

        html = html + "<p>Between age 65 and over: " + Math.abs(Math.round(lgas.get(13).getCount()/ wholepop * 100 ) - Math.round(lgas.get(27).getCount()/ wholepop * 100 )) + "%</p>";

        // Closing container

        html = html + "</div>";

        // CLOSING for third column second row

        html = html + "<div";

            
        } 
        else if (secondColumn.equals("SchoolCompletion")) {
            
        

        // Information for Indigenous Status
        
        ArrayList<Categorey> categorey = jdbc.getO2Status();

        // Container
        html = html + "<div class='statcontainer'>";

        html = html + "<h4>Indigenous Status</h4>";

        html = html + "<p>Total number of Indigenous people: " + categorey.get(0).getSumAmount() + "</p>";
        
        html = html + "<p>Total number of non-Indigenous people: " + categorey.get(2).getSumAmount() + "</p>";
        
        html = html + "<p>Total number of non-stated: " + categorey.get(1).getSumAmount() + "</p>";
        
        

        double wholepop = categorey.get(0).getSumAmount() + categorey.get(2).getSumAmount() + categorey.get(1).getSumAmount();

        

        
        // Information for Sex 

        ArrayList<Categorey> sex = jdbc.getO2Sex();

        html = html + "<h4>Sex</h4>";

        html = html + "<p>Total number of Males: " + sex.get(1).getSumAmount() + "</p>";
        
        html = html + "<p>Total number of Females: " + sex.get(0).getSumAmount() + "</p>";
        
        
        

        // Information for Categorey
        ArrayList<Categorey> completion = jdbc.getO2categorey();

        html = html + "<h4>School Completion</h4>";

        html = html + "<p>Total number of people who did not go school: " + completion.get(0).getSumAmount() + "</p>";
        
        html = html + "<p>Total number of people who completed year 8 or below: " + completion.get(1).getSumAmount() + "</p>";
        
        html = html + "<p>Total number of people who completed year 9: " + completion.get(5).getSumAmount() + "</p>";

        html = html + "<p>Total number of people who completed year 10: " + completion.get(2).getSumAmount() + "</p>";
        
        html = html + "<p>Total number of people who completed year 11: " + completion.get(3).getSumAmount() + "</p>";
        
        html = html + "<p>Total number of people who completed year 12: " + completion.get(4).getSumAmount() + "</p>";
        
       
        
        // CLOSING container

        html = html + "</div>";

        // CLOSING First column second row
        html = html + "</div>";
        
        
        // Second Column for second row
        html = html + "<div class='col-xs-8 col-sm-4'>";

        // Container
        html = html + "<div class='statcontainer'>";

        html = html + "<h4>Proportion of Indigenous Status:</h4>";

        html = html + "<p>Indigenous: " + Math.round(categorey.get(0).getSumAmount()/ wholepop * 100) + "%</p>";

        html = html + "<p>Non-Indigenous: " + Math.round(categorey.get(2).getSumAmount()/ wholepop * 100) + "%</p>";
        
        html = html + "<p>Not-stated: " + Math.round(categorey.get(1).getSumAmount()/ wholepop * 100) + "%</p>";

        
        html = html + "<h4>Proportion of Sex:</h4>";

        html = html + "<p>Males: " + Math.round(sex.get(1).getSumAmount()/ wholepop * 100) + "%</p>";

        html = html + "<p>Females: " + Math.round(sex.get(0).getSumAmount()/ wholepop * 100) + "%</p>";


        html = html + "<h4>Proportion of School Completion:</h4>";

        html = html + "<p>Did not go school: " + Math.round(completion.get(0).getSumAmount()/ wholepop * 100) + "%</p>";

        html = html + "<p>Year 8 or below: " + Math.round(completion.get(1).getSumAmount()/ wholepop * 100) + "%</p>";
        
        html = html + "<p>Year 9: " + Math.round(completion.get(5).getSumAmount()/ wholepop * 100) + "%</p>";

        html = html + "<p>Year 10: " + Math.round(completion.get(2).getSumAmount()/ wholepop * 100) + "%</p>";

        html = html + "<p>Year 11: " + Math.round(completion.get(3).getSumAmount()/ wholepop * 100) + "%</p>";
        
        html = html + "<p>Year 12: " + Math.round(completion.get(4).getSumAmount()/ wholepop * 100) + "%</p>";

        // CLOSING container

        html = html + "</div>";

        // CLOSING for second column second row

        html = html + "</div>";

        // Third Column for second row

        html = html + "<div class='col-xs-8 col-sm-4'>";

        // Container
        html = html + "<div class='statcontainer'>";
        
        ArrayList<LGA> lgas = jdbc.getTheGapst21(outcome);

        // html = html + "<p>Did not go school: " + Math.abs(((double)Math.round(((lgas.get(0).getCount()) - (lgas.get(6).getCount()/ wholepop* 100)) * 100))) / 100 + "%</p>";

        // html = html + "<p>Year 8 or below: " + Math.abs(((double)Math.round(((lgas.get(1).getCount()/ wholepop * 100) - (lgas.get(7).getCount()/ wholepop* 100))) * 100)) / 100 + "%</p>";
        
        // html = html + "<p>Year 9: " + Math.abs(((double)Math.round(((lgas.get(5).getCount()/ wholepop * 100) - (lgas.get(11).getCount()/ wholepop* 100)) * 100))) / 100 + "%</p>";

        // html = html + "<p>Year 10: " + Math.abs(((double)Math.round(((lgas.get(2).getCount()/ wholepop * 100) - (lgas.get(8).getCount()/ wholepop* 100)) * 100))) / 100 + "%</p>";

        // html = html + "<p>Year 11: " + Math.abs(((double)Math.round(((lgas.get(3).getCount()/ wholepop * 100) - (lgas.get(9).getCount()/ wholepop* 100)) * 100))) / 100+ "%</p>";
        
        // html = html + "<p>Year 12: " + Math.abs(((double)Math.round(((lgas.get(4).getCount()/ wholepop * 100) - (lgas.get(10).getCount()/ wholepop* 100)) * 100))) / 100 + "%</p>";

        // html = html + "<p>Did not go school: " + Math.abs(((double)Math.round(((lgas.get(0).getCount()) - (lgas.get(6).getCount()/ wholepop* 100)) * 100))) / 100 + "%</p>";

        html = html + "<h4>The gap</h4>";

        html = html + "<p>Year 8 or below: " + Math.abs(Math.round(lgas.get(0).getCount()/ wholepop * 100 ) - Math.round(lgas.get(6).getCount()/ wholepop * 100 )) + "%</p>";
        
        html = html + "<p>Year 9: " + Math.abs(Math.round(lgas.get(1).getCount()/ wholepop * 100 ) - Math.round(lgas.get(7).getCount()/ wholepop * 100 )) + "%</p>";

        html = html + "<p>Year 10: " + Math.abs(Math.round(lgas.get(5).getCount()/ wholepop * 100 ) - Math.round(lgas.get(11).getCount()/ wholepop * 100 )) + "%</p>";

        html = html + "<p>Year 11: " + Math.abs(Math.round(lgas.get(3).getCount()/ wholepop * 100 ) - Math.round(lgas.get(9).getCount()/ wholepop * 100 )) + "%</p>";
        
        html = html + "<p>Year 12: " + Math.abs(Math.round(lgas.get(4).getCount()/ wholepop * 100 ) - Math.round(lgas.get(10).getCount()/ wholepop * 100 )) + "%</p>";

        // CLOSING container

        html = html + "</div>";

        // CLOSING for third column second row

        html = html + "<div";
        

            
        }
        else if (secondColumn.equals("LTHC")) {

        ArrayList<Categorey> categorey = jdbc.getO3Status();

        // Container
        html = html + "<div class='statcontainer'>";

        html = html + "<h4>Indigenous Status</h4>";

        html = html + "<p>Total number of Indigenous people: " + categorey.get(0).getSumAmount() + "</p>";
        
        html = html + "<p>Total number of non-Indigenous people: " + categorey.get(2).getSumAmount() + "</p>";
        
        html = html + "<p>Total number of non-stated: " + categorey.get(1).getSumAmount() + "</p>";
        
        html = html + "<h4>Proportion of Indigenous Status:</h4>";

        double wholepop = categorey.get(0).getSumAmount() + categorey.get(2).getSumAmount() + categorey.get(1).getSumAmount();

        html = html + "<p>Indigenous: " + Math.round(categorey.get(0).getSumAmount()/ wholepop * 100) + "%</p>";

        html = html + "<p>Non-Indigenous: " + Math.round(categorey.get(2).getSumAmount()/ wholepop * 100) + "%</p>";
        
        html = html + "<p>Not-stated: " + Math.round(categorey.get(1).getSumAmount()/ wholepop * 100) + "%</p>";


        
        // Information for Sex 

        ArrayList<Categorey> sex = jdbc.getO3Sex();

        html = html + "<h4>Sex</h4>";

        html = html + "<p>Total number of Males: " + sex.get(1).getSumAmount() + "</p>";
        
        html = html + "<p>Total number of Females: " + sex.get(0).getSumAmount() + "</p>";
        
        
        

        // Information for Categorey
        ArrayList<Categorey> completion = jdbc.getO3categorey();

        
        html = html + "<h4>Health Condition</h4>";

        html = html + "<p>Total number of people who have arthritis: " + completion.get(0).getSumAmount() + "</p>";

        html = html + "<p>Total number of people who have asthma: " + completion.get(1).getSumAmount() + "</p>";

        html = html + "<p>Total number of people who have cancer: " + completion.get(2).getSumAmount() + "</p>";

        html = html + "<p>Total number of people who have dementia: " + completion.get(3).getSumAmount() + "</p>";

        html = html + "<p>Total number of people who have diabetes: " + completion.get(4).getSumAmount() + "</p>";

        html = html + "<p>Total number of people who have heart disease: " + completion.get(5).getSumAmount() + "</p>";

        html = html + "<p>Total number of people who have kidney disease: " + completion.get(6).getSumAmount() + "</p>";

        html = html + "<p>Total number of people who have lung condition: " + completion.get(7).getSumAmount() + "</p>";

        html = html + "<p>Total number of people who have mental health: " + completion.get(8).getSumAmount() + "</p>";

        html = html + "<p>Total number of people who have stroke: " + completion.get(10).getSumAmount() + "</p>";

        html = html + "<p>Total number of people who have other: " + completion.get(9).getSumAmount() + "</p>";

        // CLOSING container

        html = html + "</div>";
        

        // CLOSING First column second row
        html = html + "</div>";
        
        
        // Second Column for second row
        html = html + "<div class='col-xs-8 col-sm-4'>";

        // Container
        html = html + "<div class='statcontainer'>";
        
        html = html + "<h4>Proportion of Indigenous Status:</h4>";

        html = html + "<p>Indigenous: " + categorey.get(0).getSumAmount()/ wholepop * 100 + "%</p>";

        html = html + "<p>Non-Indigenous: " + categorey.get(2).getSumAmount()/ wholepop * 100 + "%</p>";
        
        html = html + "<p>Not-stated: " + categorey.get(1).getSumAmount()/ wholepop * 100 + "%</p>";

        
        html = html + "<h4>Proportion of Sex:</h4>";

        html = html + "<p>Males: " + Math.round(sex.get(1).getSumAmount()/ wholepop * 100) + "%</p>";

        html = html + "<p>Females: " + Math.round(sex.get(0).getSumAmount()/ wholepop * 100) + "%</p>";


        html = html + "<h4>Proportion of Health Condition:</h4>";

        html = html + "<p>Arthritis: " + Math.round(completion.get(0).getSumAmount()/ wholepop * 100) + "%</p>";

        html = html + "<p>Asthma: " + Math.round(completion.get(1).getSumAmount()/ wholepop * 100) + "%</p>";

        html = html + "<p>Cancer: " + Math.round(completion.get(2).getSumAmount()/ wholepop * 100) + "%</p>";

        html = html + "<p>Dementia: " + Math.round(completion.get(3).getSumAmount()/ wholepop * 100) + "%</p>";

        html = html + "<p>Diabetes: " + Math.round(completion.get(4).getSumAmount()/ wholepop * 100) + "%</p>";

        html = html + "<p>Heart Disease: " + Math.round(completion.get(5).getSumAmount()/ wholepop * 100) + "%</p>";

        html = html + "<p>Kidney Disease: " + Math.round(completion.get(6).getSumAmount()/ wholepop * 100) + "%</p>";

        html = html + "<p>Lung Condition: " + Math.round(completion.get(7).getSumAmount()/ wholepop * 100) + "%</p>";

        html = html + "<p>Mental Health: " + Math.round(completion.get(8).getSumAmount()/ wholepop * 100) + "%</p>";

        html = html + "<p>Stroke: " + Math.round(completion.get(10).getSumAmount()/ wholepop * 100) + "%</p>";

        html = html + "<p>Other: " + Math.round(completion.get(9).getSumAmount()/ wholepop * 100) + "%</p>";

        // CLOSING container

        html = html + "</div>";

        // CLOSING for second column second row

        html = html + "</div>";

        // Third Column for second row

        html = html + "<div class='col-xs-8 col-sm-4'>";

        // Container
        html = html + "<div class='statcontainer'>";

        ArrayList<LGA> lgas = jdbc.getTheGapst21(outcome);

        // HEADING

        html = html + "<h4>The gap</h4>";

        html = html + "<p>Arthritis: " + Math.abs(Math.round(lgas.get(0).getCount()/ wholepop * 100 ) - Math.round(lgas.get(11).getCount()/ wholepop * 100 )) + "%</p>";

        html = html + "<p>Asthma: " + Math.abs(Math.round(lgas.get(1).getCount()/ wholepop * 100 ) - Math.round(lgas.get(12).getCount()/ wholepop * 100 )) + "%</p>";

        html = html + "<p>Cancer: " + Math.abs(Math.round(lgas.get(2).getCount()/ wholepop * 100 ) - Math.round(lgas.get(13).getCount()/ wholepop * 100 )) + "%</p>";

        html = html + "<p>Dementia: " + Math.abs(Math.round(lgas.get(3).getCount()/ wholepop * 100 ) - Math.round(lgas.get(14).getCount()/ wholepop * 100 )) + "%</p>";

        html = html + "<p>Diabetes: " + Math.abs(Math.round(lgas.get(4).getCount()/ wholepop * 100 ) - Math.round(lgas.get(15).getCount()/ wholepop * 100 )) + "%</p>";

        html = html + "<p>Heart Disease: " + Math.abs(Math.round(lgas.get(5).getCount()/ wholepop * 100 ) - Math.round(lgas.get(16).getCount()/ wholepop * 100 )) + "%</p>";

        html = html + "<p>Kidney Disease: " + Math.abs(Math.round(lgas.get(6).getCount()/ wholepop * 100 ) - Math.round(lgas.get(17).getCount()/ wholepop * 100 )) + "%</p>";

        html = html + "<p>Lung Condition: " + Math.abs(Math.round(lgas.get(7).getCount()/ wholepop * 100 ) - Math.round(lgas.get(18).getCount()/ wholepop * 100 )) + "%</p>";

        html = html + "<p>Mental Health: " + Math.abs(Math.round(lgas.get(8).getCount()/ wholepop * 100 ) - Math.round(lgas.get(19).getCount()/ wholepop * 100 )) + "%</p>";

        html = html + "<p>Stroke: " + Math.abs(Math.round(lgas.get(10).getCount()/ wholepop * 100 ) - Math.round(lgas.get(21).getCount()/ wholepop * 100 )) + "%</p>";

        html = html + "<p>Other: " + Math.abs(Math.round(lgas.get(9).getCount()/ wholepop * 100 ) - Math.round(lgas.get(20).getCount()/ wholepop * 100 )) + "%</p>";

        // CLOSING container

        html = html + "</div>";

        // CLOSING for third column second row
        

        html = html + "<div";

        }  

        else if (secondColumn.equals("WeeklyIncome")) {

          // Container
        html = html + "<div class='statcontainer'>";

        ArrayList<Categorey> categorey = jdbc.getO4Status();

        html = html + "<h4>Indigenous Status</h4>";

        html = html + "<p>Total number with households containing at least 1 Indigenous: " + categorey.get(0).getSumAmount() + "</p>";
        
        html = html + "<p>Total number of all other households: " + categorey.get(1).getSumAmount() + "</p>";
        
        html = html + "<p>Total number of households: " + categorey.get(2).getSumAmount() + "</p>";
      

        double wholepop = categorey.get(2).getSumAmount();

        
        
    

        // Information for Categorey
        ArrayList<Categorey> completion = jdbc.getO4categorey();

        html = html + "<h4>Income</h4>";

        html = html + "<p>Total number of people who income between $1 and $149: " + completion.get(4).getSumAmount() + "</p>";
        
        html = html + "<p>Total number of people who income between $150 and $299: " + completion.get(3).getSumAmount() + "</p>";

        html = html + "<p>Total number of people who income between $300 and $399: " + completion.get(8).getSumAmount() + "</p>";

        html = html + "<p>Total number of people who income between $400 and $499: " + completion.get(9).getSumAmount() + "</p>";

        html = html + "<p>Total number of people who income between $500 and $649: " + completion.get(10).getSumAmount() + "</p>";

        html = html + "<p>Total number of people who income between $650 and $799: " + completion.get(11).getSumAmount() + "</p>";

        html = html + "<p>Total number of people who income between $800 and $999: " + completion.get(12).getSumAmount() + "</p>";

        html = html + "<p>Total number of people who income between $1000 and $1249: " + completion.get(0).getSumAmount() + "</p>";

        html = html + "<p>Total number of people who income between $1250 and $1499: " + completion.get(1).getSumAmount() + "</p>";

        html = html + "<p>Total number of people who income between $1500 and $1999: " + completion.get(2).getSumAmount() + "</p>";

        html = html + "<p>Total number of people who income between $2000 and $2499: " + completion.get(5).getSumAmount() + "</p>";

        html = html + "<p>Total number of people who income between $2500 and $2999: " + completion.get(6).getSumAmount() + "</p>";

        html = html + "<p>Total number of people who income between $3000 and more: " + completion.get(7).getSumAmount() + "</p>";
        
        
        
        
        
        
        // CLOSING container

        html = html + "</div>";
        

        // CLOSING First column second row
        html = html + "</div>";
        
        
        // Second Column for second row
        html = html + "<div class='col-xs-8 col-sm-4'>";
        
        // Container
        html = html + "<div class='statcontainer'>";
        
        html = html + "<h4>Households with Indigenous people</h4>";

        html = html + "<p>At least One Indigenous: " + Math.round(categorey.get(0).getSumAmount()/ wholepop * 100) + "%</p>";

        html = html + "<p>All other households: " + Math.round(categorey.get(1).getSumAmount()/ wholepop * 100) + "%</p>";

        html = html + "<h4>Proportion of Income:</h4>";

        html = html + "<p>$1 and $149: " + Math.round(completion.get(4).getSumAmount()/ wholepop * 100) + "%</p>";

        html = html + "<p>$150 and $299: " + Math.round(completion.get(3).getSumAmount()/ wholepop * 100) + "%</p>";

        html = html + "<p>$300 and $399: " + Math.round(completion.get(8).getSumAmount()/ wholepop * 100) + "%</p>";

        html = html + "<p>$400 and $499: " + Math.round(completion.get(9).getSumAmount()/ wholepop * 100) + "%</p>";

        html = html + "<p>$500 and $649: " + Math.round(completion.get(10).getSumAmount()/ wholepop * 100) + "%</p>";

        html = html + "<p>$650 and $799: " + Math.round(completion.get(11).getSumAmount()/ wholepop * 100) + "%</p>";

        html = html + "<p>$800 and $999: " + Math.round(completion.get(12).getSumAmount()/ wholepop * 100) + "%</p>";

        html = html + "<p>$1000 and $1249: " + Math.round(completion.get(0).getSumAmount()/ wholepop * 100) + "%</p>";

        html = html + "<p>$1250 and $1499: " + Math.round(completion.get(1).getSumAmount()/ wholepop * 100) + "%</p>";

        html = html + "<p>$1500 and $1999: " + Math.round(completion.get(2).getSumAmount()/ wholepop * 100) + "%</p>";

        html = html + "<p>$2000 and $2499: " + Math.round(completion.get(5).getSumAmount()/ wholepop * 100) + "%</p>";

        html = html + "<p>$2500 and $2499: " + Math.round(completion.get(6).getSumAmount()/ wholepop * 100) + "%</p>";

        html = html + "<p>$3000 and more: " + Math.round(completion.get(7).getSumAmount()/ wholepop * 100) + "%</p>";

        // CLOSING container

        html = html + "</div>";

        // CLOSING for second column second row

        html = html + "</div>";
        

        // Third Column for second row

        html = html + "<div class='col-xs-8 col-sm-4'>";

        // Container
        html = html + "<div class='statcontainer'>";

        ArrayList<LGA> lgas = jdbc.getTheGapst21(outcome);

        // HEADING

        html = html + "<h4>The gap</h4>";


        html = html + "<p>$1 and $149: " + Math.abs(Math.round(lgas.get(4).getCount()/ wholepop * 100 ) - Math.round(lgas.get(17).getCount()/ wholepop * 100 )) + "%</p>";

        html = html + "<p>$150 and $299: " + Math.abs(Math.round(lgas.get(3).getCount()/ wholepop * 100 ) - Math.round(lgas.get(16).getCount()/ wholepop * 100 )) + "%</p>";

        html = html + "<p>$300 and $399: " + Math.abs(Math.round(lgas.get(8).getCount()/ wholepop * 100 ) - Math.round(lgas.get(21).getCount()/ wholepop * 100 )) + "%</p>";

        html = html + "<p>$400 and $499: " + Math.abs(Math.round(lgas.get(9).getCount()/ wholepop * 100 ) - Math.round(lgas.get(22).getCount()/ wholepop * 100 )) + "%</p>";

        html = html + "<p>$500 and $649: " + Math.abs(Math.round(lgas.get(10).getCount()/ wholepop * 100 ) - Math.round(lgas.get(23).getCount()/ wholepop * 100 )) + "%</p>";

        html = html + "<p>$650 and $799: " + Math.abs(Math.round(lgas.get(11).getCount()/ wholepop * 100 ) - Math.round(lgas.get(24).getCount()/ wholepop * 100 )) + "%</p>";

        html = html + "<p>$800 and $999: " + Math.abs(Math.round(lgas.get(12).getCount()/ wholepop * 100 ) - Math.round(lgas.get(25).getCount()/ wholepop * 100 )) + "%</p>";

        html = html + "<p>$1000 and $1249: " + Math.abs(Math.round(lgas.get(0).getCount()/ wholepop * 100 ) - Math.round(lgas.get(13).getCount()/ wholepop * 100 )) + "%</p>";

        html = html + "<p>$1250 and $1499: " + Math.abs(Math.round(lgas.get(1).getCount()/ wholepop * 100 ) - Math.round(lgas.get(14).getCount()/ wholepop * 100 )) + "%</p>";

        html = html + "<p>$1500 and $1999: " + Math.abs(Math.round(lgas.get(2).getCount()/ wholepop * 100 ) - Math.round(lgas.get(15).getCount()/ wholepop * 100 )) + "%</p>";

        html = html + "<p>$2000 and $2499: " + Math.abs(Math.round(lgas.get(5).getCount()/ wholepop * 100 ) - Math.round(lgas.get(18).getCount()/ wholepop * 100 )) + "%</p>";

        html = html + "<p>$2500 and $2499: " + Math.abs(Math.round(lgas.get(6).getCount()/ wholepop * 100 ) - Math.round(lgas.get(19).getCount()/ wholepop * 100 )) + "%</p>";

        html = html + "<p>$3000 and more: " + Math.abs(Math.round(lgas.get(7).getCount()/ wholepop * 100 ) - Math.round(lgas.get(20).getCount()/ wholepop * 100 )) + "%</p>";

        // CLOSING container

        html = html + "</div>";

        // CLOSING for third column second row

        html = html + "<div";


        }

        


        // CLOSING the second row
        
        html = html + "</div>"; 


        // Close Content div
        html = html + "</div>";

        html = html + "</div>";

        // Footer
        html = html + """
                    <div class='footer' style='background-color: #40302D, color: white;'>
                        <p>COSC2803 - Studio Project Starter Code (Sep22)</p>
                    </div>
                """;

        // Finish the HTML webpage
        html = html + "</body>" + "</html>";

        // DO NOT MODIFY THIS
        // Makes Javalin render the webpage
        context.html(html);
    }
    // USED AS REFERENCE CODE
  //   public String outputMovies(String type) {
  //       String html = "";
  //       html = html + "<h2>" + type + " Movies</h2>";

  //       // Look up movies from JDBC
  //       JDBCConnection jdbc = new JDBCConnection();
  //       ArrayList<Movie> movies = jdbc.getMoviesByType(type);
        
  //       // Add HTML for the movies list
  //       html = html + "<ul>";
  //       for (Movie movie : movies) {
  //           html = html + "<li>" + movie.name + "</li>";
  //       }
  //       html = html + "</ul>";

  //       return html;
  //   }

    public String outputSchoolCompletion() {
      String html = "";
      // html = html + "<h2>" + type + " Movies</h2>";

      // Look up movies from JDBC
      JDBCConnection jdbc = new JDBCConnection();
      ArrayList<LGA> lgas = jdbc.getOutcome2();
      
      // Add HTML for the movies list
      html = html + "<ul>";
      for (LGA lga : lgas) {
          html = html + "<li>" + lga.getName() + "</li>";
      }
      html = html + "</ul>";

      return html;
  }
  // <tbody>
  // <tr class="table-active">
  //     <th scope="row">Active</th>
  //     <td>Column content</td>
  //     <td>Column content</td>
  //     <td>Column content</td>
  //   </tr>
  
  public String outputOutcome1Table() {
    String html = "";

    JDBCConnection jdbc = new JDBCConnection();
    ArrayList<LGA> lgas = jdbc.getOutcome1();

    html = html + "<tbody>";
      
    for (LGA lga : lgas) {
        if (lga.getYear() == 2021) {
          html = html + "<tr class='table-active'>";
          html = html + "<td scope='row'>" + lga.getName() + "</td>"
                      + "<td>" + lga.getStatus() + "</td>"
                      + "<td>" + lga.getSex() + "</td>"
                      + "<td>" + lga.getCategorey() + "</td>"
                      + "<td>" + lga.getCount() + "</td>";
          html = html + "</tr>";
        }
        else{

        }
      }
      
      html = html + "</tbody>";

    return html;
  }

  public String outputOutcome2Table() {
    String html = "";

    JDBCConnection jdbc = new JDBCConnection();
    ArrayList<LGA> lgas = jdbc.getOutcome2();

    html = html + "<tbody>";
      
    for (LGA lga : lgas) {
        if (lga.getYear() == 2021) {
          html = html + "<tr class='table-active'>";
          html = html + "<td scope='row'>" + lga.getName() + "</td>"
                      + "<td>" + lga.getStatus() + "</td>"
                      + "<td>" + lga.getSex() + "</td>"
                      + "<td>" + lga.getCategorey() + "</td>"
                      + "<td>" + lga.getCount() + "</td>";
          html = html + "</tr>";
        }
        else{

        }
      }
      
      html = html + "</tbody>";

    return html;
  }

  public String outputOutcome3Table() {
    String html = "";

    JDBCConnection jdbc = new JDBCConnection();
    ArrayList<LGA> lgas = jdbc.getOutcome3();

    html = html + "<tbody>";
      
    for (LGA lga : lgas) {
        if (lga.getYear() == 2021) {
          html = html + "<tr class='table-active'>";
          html = html + "<td scope='row'>" + lga.getName() + "</td>"
                      + "<td>" + lga.getStatus() + "</td>"
                      + "<td>" + lga.getSex() + "</td>"
                      + "<td>" + lga.getCategorey() + "</td>"
                      + "<td>" + lga.getCount() + "</td>";
          html = html + "</tr>";
        }
        else{

        }
      }
      
      html = html + "</tbody>";

    return html;
  }

    public String outputOutcome4Table() {
      String html = "";
  
      JDBCConnection jdbc = new JDBCConnection();
      ArrayList<LGA> lgas = jdbc.getOutcome4();
  
      html = html + "<tbody>";
        
      for (LGA lga : lgas) {
          if (lga.getYear() == 2021) {
            html = html + "<tr class='table-active'>";
            html = html + "<td scope='row'>" + lga.getName() + "</td>"
                        + "<td>" + lga.getStatus() + "</td>"
                        + "<td>" + lga.getSex() + "</td>"
                        + "<td>" + lga.getCategorey() + "</td>"
                        + "<td>" + lga.getCount() + "</td>";
            html = html + "</tr>";
          }
          else{
  
          }
        }
        
        html = html + "</tbody>";
  
      return html;
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
