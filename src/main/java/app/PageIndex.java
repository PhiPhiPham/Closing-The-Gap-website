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
 * @author Timothy Wiley, 2022. email: timothy.wiley@rmit.edu.au
 * @author Santha Sumanasekara, 2021. email: santha.sumanasekara@rmit.edu.au
 */
public class PageIndex implements Handler {

  // URL of this page relative to http://localhost:7001/
  public static final String URL = "/";

  @Override
  public void handle(Context context) throws Exception {
    // Create a simple HTML webpage in a String
    String html = "<html>";

    // Add some Header information
    html = html + "<head>" +
        "<title>CTG Homepage</title>";

    // Add some CSS (external file)
    html = html + "<link rel='stylesheet' type='text/css' href='landingpage.css' />";
    html = html
        + "<link href='https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css' rel='stylesheet' integrity='sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC' crossorigin='anonymous'>";
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
    html = html + "</head>";

    // Add the body
    html = html + "<body style='margin:0;'>";

    // Add header content block
    html = html + """
        <section class='main'>
              <div class='header'>
                  <h1>
                      <img src='/Logo_small.png' class='top-image' alt='RMIT logo' height='75'>
                      CTG - Homepage
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

    // Add Div for page Content
    html = html + "<div class='content' >";

    // Add HTML for the list of pages (as well as topnav)
    html = html + """
        <h2 style='text-align:center;'> Socioeconomic outcomes </h2>
        """;

    // Close Content div
    html = html + "</div>";

    // JDBC Connection Setup

    // First we need to use your JDBCConnection class
    JDBCConnection jdbc = new JDBCConnection();

    // Next we will ask this *class* for the LGAs
    // String seoOne = jdbc.getSEOd(1); html = html + "<h1>" + seoOne + "</h1>";

    // ArrayList for SEO
    ArrayList<SEO> seos2 = jdbc.getSEO();
    // html = html + "<h1>" + seos2.get(1).getSeoT() + "</h1>";

    // Carousel
    html = html
        + """
            <div id='carouselExampleIndicators' class='carousel slide' data-bs-ride='carousel'>
              <div class='carousel-indicators'>
                <button type='button' data-bs-target='#carouselExampleIndicators' data-bs-slide-to='0' class='active' aria-current='true' aria-label='Slide 1'></button>
                <button type='button' data-bs-target='#carouselExampleIndicators' data-bs-slide-to='1' aria-label='Slide 2'></button>
                <button type='button' data-bs-target='#carouselExampleIndicators' data-bs-slide-to='2' aria-label='Slide 3'></button>
                <button type='button' data-bs-target='#carouselExampleIndicators' data-bs-slide-to='3' aria-label='Slide 4'></button>
                <button type='button' data-bs-target='#carouselExampleIndicators' data-bs-slide-to='4' aria-label='Slide 5'></button>
                <button type='button' data-bs-target='#carouselExampleIndicators' data-bs-slide-to='5' aria-label='Slide 6'></button>
              </div>
              <div style='height:37rem;padding:20;' class='carousel-inner top'>
                  """;

    // First Slide
    html = html
        + """
            <div class='carousel-item active '>

              <div class=' d-flex justify-content-sm-evenly align-items-center align-self-center' >

                <div class='card' style="background-image:url('carousel_img/SEO1.jpg');">

                  <div class='card-overlay'>
                    <h5 class='card-title'>"""
        + seos2.get(0).getSeoT()
        + """
            </h5>
            <p class='card-text'>"""
        + seos2.get(0).getSeoD()
        + """
                            </p>
                </div>
              </div>

            <div class='card' style="background-image:url('carousel_img/SEO2.jpg');">
              <div class='card-overlay'>
                <h5 class='card-title'>"""
        + seos2.get(1).getSeoT()
        + """
            </h5>
                  <p class='card-text'>"""
        + seos2.get(1).getSeoD()
        + """
                            </p>
              </div>
            </div>



            <div class='card' style="background-image:url('carousel_img/SEO3.jpg');">

              <div class='card-overlay'>
                <h5 class='card-title'>"""
        + seos2.get(2).getSeoT()
        + """
                          </h5>
            <p class='card-text'>"""
        + seos2.get(2).getSeoD()
        + """
                                  </p>
                    </div>
                  </div>

                </div>

              </div>
            """;

    // Slide 2
    html = html
        + """
            <div class='carousel-item'>

              <div class='d-flex justify-content-sm-evenly'>

                <div class='card' style="background-image:url('carousel_img/SEO4.jpg');">
                  <div class='card-overlay'>
                  <h5 class='card-title'>"""
        + seos2.get(3).getSeoT()
        + """
                          </h5>
            <p class='card-text'>"""
        + seos2.get(3).getSeoD()
        + """
                          </p>
              </div>
            </div>

            <div class='card' style="background-image:url('carousel_img/SEO5.jpg');">
              <div class='card-overlay'>
                <h5 class='card-title'>"""
        + seos2.get(4).getSeoT()
        + """
                          </h5>
            <p class='card-text'>"""
        + seos2.get(4).getSeoD()
        + """
                            </p>
              </div>
            </div>

            <div class='card' style="background-image:url('carousel_img/SEO6.jpg');">
              <div class='card-overlay'>
                <h5 class='card-title'>"""
        + seos2.get(5).getSeoT()
        + """
                          </h5>
            <p class='card-text'>"""
        + seos2.get(5).getSeoD()
        + """
                                </p>
                  </div>
                </div>

              </div>
            </div>
            """;

    // Slide 3
    html = html
        + """
            <div class='carousel-item'>

              <div class='d-flex justify-content-sm-evenly'>

                <div class='card' style="background-image:url('carousel_img/SEO7.jpg');">
                  <div class='card-overlay'>
                  <h5 class='card-title'>"""
        + seos2.get(6).getSeoT()
        + """
                          </h5>
            <p class='card-text'>"""
        + seos2.get(6).getSeoD()
        + """
                          </p>
              </div>
            </div>

            <div class='card' style="background-image:url('carousel_img/SEO8.jpg');">
              <div class='card-overlay'>
                <h5 class='card-title'>"""
        + seos2.get(7).getSeoT()
        + """
                          </h5>
            <p class='card-text'>"""
        + seos2.get(7).getSeoD()
        + """
                            </p>
              </div>
            </div>

            <div class='card' style="background-image:url('carousel_img/SEO9.jpg');">
              <div class='card-overlay'>
                <h5 class='card-title'>"""
        + seos2.get(8).getSeoT()
        + """
                          </h5>
            <p class='card-text'>"""
        + seos2.get(8).getSeoD()
        + """
                                    </p>
                      </div>
                    </div>

                  </div>

                </div>
            """;

    // Slide 4
    html = html
        + """
            <div class='carousel-item'>

              <div class='d-flex justify-content-sm-evenly'>

                <div class='card' style="background-image:url('carousel_img/SEO10.jpg');">
                  <div class='card-overlay'>
                  <h5 class='card-title'>"""
        + seos2.get(9).getSeoT()
        + """
                          </h5>
            <p class='card-text'>"""
        + seos2.get(9).getSeoD()
        + """
                          </p>
              </div>
            </div>

            <div class='card' style="background-image:url('carousel_img/SEO11.jpg');">
              <div class='card-overlay'>
                <h5 class='card-title'>"""
        + seos2.get(10).getSeoT()
        + """
                          </h5>
            <p class='card-text'>"""
        + seos2.get(10).getSeoD()
        + """
                            </p>
              </div>
            </div>

            <div class='card' style="background-image:url('carousel_img/SEO12.jpg');">
              <div class='card-overlay'>
                <h5 class='card-title'>"""
        + seos2.get(11).getSeoT()
        + """
                          </h5>
            <p class='card-text'>"""
        + seos2.get(11).getSeoD()
        + """
                                </p>
                  </div>
                </div>

              </div>

            </div>
            """;

    // Slide 5
    html = html
        + """
            <div class='carousel-item'>

              <div class='d-flex justify-content-sm-evenly'>

                <div class='card' style="background-image:url('carousel_img/SEO13.jpg');">
                  <div class='card-overlay'>
                  <h5 class='card-title'>"""
        + seos2.get(12).getSeoT()
        + """
                          </h5>
            <p class='card-text'>"""
        + seos2.get(12).getSeoD()
        + """
                  </p>
              </div>
            </div>

            <div class='card' style="background-image:url('carousel_img/SEO14.jpg');">
              <div class='card-overlay'>
                <h5 class='card-title'>"""
        + seos2.get(13).getSeoT()
        + """
                          </h5>
            <p class='card-text'>"""
        + seos2.get(13).getSeoD()
        + """
                            </p>
              </div>
            </div>

            <div class='card' style="background-image:url('carousel_img/SEO15.jpg');">
              <div class='card-overlay'>
                <h5 class='card-title'>"""
        + seos2.get(14).getSeoT()
        + """
                          </h5>
            <p class='card-text'>"""
        + seos2.get(14).getSeoD()
        + """
                                </p>
                  </div>
                </div>

              </div>

            </div>
            """;

    // Slide 6
    html = html
        + """
            <div class='carousel-item'>

              <div class='d-flex justify-content-sm-evenly'>

                <div class='card' style="background-image:url('carousel_img/SEO16.jpg');">
                  <div class='card-overlay'>
                  <h5 class='card-title'>"""
        + seos2.get(15).getSeoT()
        + """
                          </h5>
            <p class='card-text'>"""
        + seos2.get(15).getSeoD()
        + """
                          </p>
              </div>
            </div>

            <div class='card' style="background-image:url('carousel_img/SEO17.jpg');">
              <div class='card-overlay'>
                <h5 class='card-title'>"""
        + seos2.get(16).getSeoT()
        + """
                          </h5>
            <p class='card-text'>"""
        + seos2.get(16).getSeoD()
        + """
                                    </p>
                      </div>
                    </div>



                  </div>

                </div>


              </div>
              <button class='c-control-prev' type='button' data-bs-target='#carouselExampleIndicators' data-bs-slide='prev'>
                <span class='carousel-control-prev-icon' aria-hidden='true'></span>
                <span class='visually-hidden'>Previous</span>
              </button>
              <button class='c-control-next' type='button' data-bs-target='#carouselExampleIndicators' data-bs-slide='next'>
                <span class='carousel-control-next-icon' aria-hidden='true'></span>
                <span class='visually-hidden'>Next</span>
              </button>
            </div>
            </section>
                    """;

    // Persona Section
    // Title
    html = html + """
        <section class='persona'>
        <h1> Who is this site built for? </h1>
        """;

    // Get Persona and get HTML to view

    for (int i = 1; i < 4; i++) {
      ArrayList<Persona> persona = jdbc.getPersona();
      String personaDesc = jdbc.getPersonaAtt(i, "Description");
      String personaNeeds = jdbc.getPersonaAtt(i, "Needs_Goals");
      String personaExp = jdbc.getPersonaAtt(i, "Experience");
      html = html + """
          <div class='container persona-item' style='display:flex;'>
          <div>
          <img src="%s" alt ='Persona 1' style='width: 300px; height: 300px; position:relative; top:3.5rem;'>
          <h2 style='position:relative; top:3.5rem;''>%s</h2></div>
          """.formatted(persona.get(i - 1).getImgPath(), persona.get(i - 1).getName());

      html = html + "<div style='padding:3rem;'><h4> Description: </h4> <p>" + personaDesc + "</p>";
      html = html + "<h4> Needs and Goals: </h3> <p>" + personaNeeds + "</p>";
      html = html + "<h4> Skills and Experience: </h4> <p>" + personaExp + "</p></div> </div>";

    }

    html = html + """
        </section>

          """;

    // Footer
    html = html + """
            <div class='footer'>
                <p>COSC2803 - Studio Project: Close The Gap (Sep22)</p>
            </div>
        """;

    // Finish the HTML webpage
    html = html
        + """
            <script src='https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js' integrity='sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM' crossorigin='anonymous'></script>

            """;

    // DO NOT MODIFY THIS
    // Makes Javalin render the webpage
    context.html(html);
  }
}