---
layout: default
title: Artifact 7
description: Tech Jobs Console Persistent (Java, Spring Boot, MySQL Server)
---

[**Click here to view Artifact 7**](https://github.com/Matt87c/java-web-dev-techjobs-persistent3/tree/master/java-web-dev-techjobs-persistent2/java-web-dev-techjobs-persistent-master)

# Artifact 7 - Tech Jobs Console Persistent

## About the Project


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

One-to-Many Relationship
In this application, any one Job object is affiliated with one employer while one Employer may contain several jobs.



## Screenshots

![techJobsMvcHome](https://user-images.githubusercontent.com/35537679/157591719-7abfbea4-954b-4762-8928-cff66f42554b.png)

![listTableOptions](https://user-images.githubusercontent.com/35537679/157591727-aec8bd9e-cd46-4b31-832d-914a22f37daa.png)

![list-jobsTableOptions](https://user-images.githubusercontent.com/35537679/157591769-222cfd75-2c44-463d-b6ed-6497e9ad7861.png)

