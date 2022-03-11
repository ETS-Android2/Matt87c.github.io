---
layout: default
title: Artifact 7
description: Tech Jobs Console Persistent (Java, Spring Boot, MySQL Server)
---

[**Click here to view Artifact 7**](https://github.com/Matt87c/java-web-dev-techjobs-persistent3/tree/master/java-web-dev-techjobs-persistent2/java-web-dev-techjobs-persistent-master)

# Artifact 7 - Tech Jobs Console Persistent

## About the Project
This is a Spring Boot web application coded in java. This application allows you to browse and search listings of open jobs by employers. The application connects to MySQL Server database to store user-submitted job data. This artifact was created in Sept of 2020.

## Getting Started
This application requires IntelliJ, Spring Boot, and MySQL Server.  

## Installation
Download IntelliJ from here:
https://www.jetbrains.com/idea/download/?fromIDE=#section=windows


Set up a local copy of the project.  You can fork the project from my github or download the zip.  Open IntelliJ and you can use version control > GitHub to fork the repository.  Store the project in the parent directory where you would like and hit clone.  When asked Would you like to create an IDEA project… select Yes, and then accept all of the default options presented.  In the screens that follow, be sure to choose Create Project From Existing Sources on the first pane, and select the default values of all following panes.

The MySQL Server can be downloaded here:
https://www.mysql.com/downloads/

Once MySQL Server is downloaded and installed, Start MySQL Workbench and create a new schema named techjobs.  In the administration tab, create a new user, techjobs.  Update build.gradle with the necessary dependencies.  Update src/resources/application.properties with the right info. This will include spring.datasource.url set to the address of your database connection, as well as the username and password for a user you have created.
## Code Example
This application contains five controllers shown in this photo.

![controllers](https://user-images.githubusercontent.com/35537679/157592894-63559974-38c0-4cac-a2c7-073bfac94aa8.png)

The AbstractEntity class holds the fields and methods that are common across the Job class and the classes it contains as fields.
![abstract](https://user-images.githubusercontent.com/35537679/157593822-6c1558ab-3260-45ba-9b07-19a467747d51.png)

Models
The employer and skill information about a particular job will be stored in classes themselves. These items themselves will hold their own supplementary information.
The Employer class extends AbstractEntity class. 
![employer](https://user-images.githubusercontent.com/35537679/157594173-05a9f793-e588-4a02-ae79-b9545102daf7.png)

The Skill class extends AbstractEntity class. 
![skill](https://user-images.githubusercontent.com/35537679/157594231-0b893950-54e0-4b75-ac1f-5b251d7e25cd.png)

The Employer field is a One-to-Many Relationship.  In this application, any one Job object is affiliated with one employer while one Employer may contain several jobs.  Within the Employer class the annotations @OneToManyand @JoinColumn are on the jobs list in Employer to declare the relationship between data tables

![job annotation](https://user-images.githubusercontent.com/35537679/157594991-32198586-88fe-4c62-8203-beb7ac48af63.png)

Within the Job class the annotation @ManyToOne relationship to Employer class. This field has a many-to-many type relationship with skills.  The @ManyToMany annotation with an argument mappedBy="skills" to ensure this mapping.

![jobs](https://user-images.githubusercontent.com/35537679/157595289-14d23f71-c93b-4921-a399-c6675c4db72b.png)


![job](https://user-images.githubusercontent.com/35537679/157594725-b110f9ad-035d-4ad2-9256-de8dab7b4076.png)


## Screenshots

Here is the User interface of the Tech Jobs application.  This shows the available tech jobs in the database.  
![ui 1](https://user-images.githubusercontent.com/35537679/157898910-0983e92d-d454-4c14-ada7-052502b2d5e9.png)

The user selects the list tab, this will be shown.  The user can click on view all, employers, or skills.  When the user clicks on any of these, a page will be show that shows what is in the data base for the selected field.
![ui 2](https://user-images.githubusercontent.com/35537679/157898939-5268620f-5ed5-4029-a9fa-04e37d75da5c.png)

If the user clicks view all we get a nice display of all vailable jobs.
![listTableOptions](https://user-images.githubusercontent.com/35537679/157591727-aec8bd9e-cd46-4b31-832d-914a22f37daa.png)

Within these tabs we will get a layout of the job description.
![list-jobsTableOptions](https://user-images.githubusercontent.com/35537679/157591769-222cfd75-2c44-463d-b6ed-6497e9ad7861.png)

If the user clicks add jobs tab, then this page is shown. Lets run a test adding an Amazon job into the MySQL database. 
![ui add](https://user-images.githubusercontent.com/35537679/157900147-4d0e4772-c07c-43a3-a230-503153bc4408.png)

This is shown when the user selects the search tab.  This page allows the user to search a keyword within the database in the skill database, employer database, or all databases.  We must click add Employer first to make this available in the drop down menu to choose from.
![ui search](https://user-images.githubusercontent.com/35537679/157899777-8036af4e-d9ae-4a7e-b494-68145c72ba3b.png)

After the add employer link is clicked this page will be shown. 
![ui add employer](https://user-images.githubusercontent.com/35537679/157900726-abcf0155-a4d3-4eda-bbc7-2f07aa78c6f7.png)

Lets input the Employer Name and Employer Location which is Amazon Tampa Florida and click Add Employer.
![ui add employer tampa](https://user-images.githubusercontent.com/35537679/157900902-05973587-93e2-45e3-b091-ec27f9ae67da.png)

Now the employer name and location are saved into the MySQL database. The Amazon employer is now listed in the drop down menu to select to add a job.
![ui employer amazon dropdown](https://user-images.githubusercontent.com/35537679/157901364-44026f45-d771-4334-b58a-b02e1878e9e8.png)

The employer may need to add a skill to the job description.  Lets add python to the job skills.
![ui add skill python](https://user-images.githubusercontent.com/35537679/157901773-5344478f-0eee-43be-b54c-714172da13d2.png)

Now Python is in the MySQL database and available for selection for this job.
![ui Python skill](https://user-images.githubusercontent.com/35537679/157901840-a146cab4-586c-4366-8ed3-0f9e40402427.png)

The box is now selectable to add Python skills to add to the job description.
![ui python skills](https://user-images.githubusercontent.com/35537679/157902190-ed79f0e6-7e1a-4417-b217-6545575aa179.png)

Once the employer clicks to add a job the available position will now show up in the TechJobs database to click and view.
![ui software engineer](https://user-images.githubusercontent.com/35537679/157902357-34f72ebe-286a-4da4-9737-d1be036e1cb8.png)








