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
The Employer class extends AbstractEntity class.  Inheritance
![employer](https://user-images.githubusercontent.com/35537679/157594173-05a9f793-e588-4a02-ae79-b9545102daf7.png)

The Skill class extends AbstractEntity class.  Inheritance
![skill](https://user-images.githubusercontent.com/35537679/157594231-0b893950-54e0-4b75-ac1f-5b251d7e25cd.png)

The Employer field is a One-to-Many Relationship.  In this application, any one Job object is affiliated with one employer while one Employer may contain several jobs.  Within the Employer class the annotations @OneToManyand @JoinColumn are on the jobs list in Employer to declare the relationship between data tables

![job annotation](https://user-images.githubusercontent.com/35537679/157594991-32198586-88fe-4c62-8203-beb7ac48af63.png)

Within the Job class the annotation @ManyToOne relationship to Employer class. This field has a many-to-many type relationship with skills.  The @ManyToMany annotation with an argument mappedBy="skills" to ensure this mapping.

![jobs](https://user-images.githubusercontent.com/35537679/157595289-14d23f71-c93b-4921-a399-c6675c4db72b.png)


![job](https://user-images.githubusercontent.com/35537679/157594725-b110f9ad-035d-4ad2-9256-de8dab7b4076.png)


## Screenshots

![techJobsMvcHome](https://user-images.githubusercontent.com/35537679/157591719-7abfbea4-954b-4762-8928-cff66f42554b.png)

![listTableOptions](https://user-images.githubusercontent.com/35537679/157591727-aec8bd9e-cd46-4b31-832d-914a22f37daa.png)

![list-jobsTableOptions](https://user-images.githubusercontent.com/35537679/157591769-222cfd75-2c44-463d-b6ed-6497e9ad7861.png)

