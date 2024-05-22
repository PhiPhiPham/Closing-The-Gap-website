# What is the gap? 
In Australia, "The Gap" refers to the significant disparities in health, education, employment, and overall well-being between Indigenous Australians (Aboriginal and Torres Strait Islander peoples) and non-Indigenous Australians. These disparities are often collectively referred to as "Closing the Gap." The initiative aims to address and reduce these inequalities.

# Running the Main Web Server
To set up, follow these steps:
1. Open this project in VSCode.
2. Allow VSCode to read the pom.xml file:
3. Approve any pop-ups to enable VSCode to configure the build.
4. Allow VSCode to download the necessary Java libraries.
To build and run:
1. Open the src/main/java/app/App.java source file, and select "Run" from the pop-up above the main function.
2. Visit http://localhost:7001 in your web browser.

# Website Overview and User Guide
This is a project that my partner and I did that uses JDBC to connect java with the SQL database. 
Our website is designed to present comprehensive information on the socioeconomic disparities between Indigenous and non-Indigenous Australians. The content is structured into three levels: a "Big Picture" overview, a "Shallow Glance" at the data, and a "Deep Dive" into detailed analysis.

## Big Picture Content
### Landing Page
The landing page is the first point of contact for users, aiming to capture their attention and provide an overview of the website’s focus. This page will:

- Highlight all 17 socioeconomic outcomes of the National Agreement on Closing the Gap, retrieved from our database.
- Emphasize the specific socioeconomic outcomes that our website targets.
### Mission Statement
The mission statement page outlines the purpose and functionality of our website. This page will:

- Explain how the website addresses the social challenges.
- Describe the intended usage of the site.
- Present personas that the website targets, sourced from the database.
## Shallow Glance at the Data
### Latest Results from the 2021 Census
This section provides an overview of the disparities observed in the 2021 Census data, focusing on Local Government Areas (LGAs). It will:

- Allow users to select a specific outcome or dataset and compare information across all LGAs.
- Display raw and proportional values for selected outcomes/datasets.
- Compute and display the gap between Indigenous and non-Indigenous populations using proportional values.
- Enable users to sort the data by various categories, using SQL queries for sorting.
### Focused View by LGA or State
This section allows users to view changes between the 2016 and 2021 censuses for a selected LGA or state. It will:

- Enable selection of an LGA or state.
- Display key details of the selected LGA or state.
- Show changes in total population and selected datasets between 2016 and 2021.
- Compute and display rankings for the selected LGA or state based on various socioeconomic categories.
## Deep Dive into the Data
### Gap-Score between Indigenous and Non-Indigenous People
This section provides a detailed comparison of socioeconomic outcomes, presenting a "Gap-Score" to illustrate disparities. It will:

- Allow users to select multiple socioeconomic outcomes or datasets.
- Compute and display Gap-Scores for each category and combined scores across datasets for 2016 and 2021.
- Show changes in Gap-Scores between 2016 and 2021.
- Enable filtering and sorting of LGAs by Gap-Scores, using efficient SQL queries.
### Finding LGAs with Similar Characteristics
This feature helps users find LGAs with similar socioeconomic characteristics. It will:

- Allow users to select an LGA and specify constraints to find similar LGAs.
- Present the selected LGA and the most similar LGAs based on user-defined properties.
- Sort the similar LGAs from most to least similar.
- Retrieve relevant data using optimized SQL queries.

Our website provides a comprehensive tool for understanding and analyzing the socioeconomic gaps between Indigenous and non-Indigenous Australians, supporting informed decision-making and targeted interventions.




