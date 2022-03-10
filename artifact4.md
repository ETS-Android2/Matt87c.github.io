---
layout: default
title: Artifact 4
description: Search and Rescue Animal Application
---

[**Click here to view Artifact 4**](https://github.com/Matt87c/Search_Rescue_Animal_Application)

# Artifact 4 - Search and Rescue Animal Application

## About the Project

The project is for an innovative international rescue-animal training company called Grazioso Salvare.  This software is used to identify dogs that will qualify for the search and rescue training.  The project collects and sorts the animal data from the MongoDB database.  Filtering the data for the desired traits such as age and breed will help find the qualified rescue dogs.   Some dog breeds are more proficient than others for different types of rescues.  Training dogs that are not more than two years has been shown to be more effective.
The search and rescue animal application is designed to search and filter animals by rescue type and animal breed.  The web application dashboard uses CRUD functionality to filter through the database.  CRUD functionality allows the app to be maintanable for future updates.  The advantages of CRUD functionality is that users will be able to create, read, update, and delete data within the database.  This functionality can be applied to many different applications besides search and rescue animals.  

The company Grazioso Salvare requested a way to search and filter through thier data for specific types of breeds that meet the requirments to thier search and rescue dog capabilities.  This application will help a Grazioso Salvare by being able to sift through large amounts data about the dogs to select the most capable for the rescue team.  As a computer scientists, one will look at the requirements of the company and provide software solutions to solve problems.
The radio button filter option allows the user to search for water, mountain, and disaster rescue type breeds.  The table will display all the available dogs for the rescue type chosen.  The dashboard features a geolocation chart and a pie graph that is filled with the selected variables. 

## Motivation

The project exists to provide an efficient way to filter data and find potential candidates for the search and rescue animal training company Grazioso Salvare.  A database can contain a large amount of data.  Applying CRUD functionality with MongoDB to the csv file will help the end user to manage large amounts of data.

## Getting Started

Creating a local copy of this program will require a Mongo Database.  Python will also be used to integrate the CRUD functionality to the database.  The first step is to create a Mongo Database and the one created is called AAC.  A user with read and write privileges must be assigned to the AAC database.  
Once this is completed, the AAC database will need data. 

 We must Import the aac_shelter_outcomes.csv file into the AAC database.  Make sure you put the port number in with the import.
 
 ![image](https://user-images.githubusercontent.com/35537679/130328182-392f5093-b40c-4b48-a2e7-3188a0a695f5.png)

After the csv file is imported, we must login as “aacuser”.

![image](https://user-images.githubusercontent.com/35537679/130328191-c2d5b0af-a50a-493f-97b5-0196a836363e.png)

In Jupyter Notebook we created a python.py file to implement CRUD functionality in MongoDB.  The port number on the local host is listed with the username and password that was created in MongoDB.

![image](https://user-images.githubusercontent.com/35537679/130328197-ebc0e0d5-1e53-4b7a-ad28-0b45885c5d97.png)

To create the create and read functionality we included the functionality in the py file.

![image](https://user-images.githubusercontent.com/35537679/130328206-416d56cd-ee06-4a38-bfb4-4c069482e1b2.png)

The challenges were connecting the database and user authentication.  I have found that restarting the MongoDB has helped to clear up the errors.

## Installation

The tools needed will include MondoDB, Dash, pymongo, Jupyter Notebook, and the Python command line.  Each one of theses can be installed onto your computer.  Going to the websites directly for theses tools will have an explanation of how to install them.  Here is the links for the tools for installation.
MongoDB:
https://docs.mongodb.com/manual/tutorial/install-mongodb-on-windows/
Python:
https://realpython.com/installing-python/
Jupyter Notebook:
https://jupyter.org/install

Install MongoDB first from the download page.  Dash will need to be installed next.  Dash will give the application an interactive dashboard. To install Dash, type these commands into the terminal.
•	pip install dash
•	pip install jupyter-dash
•	pip install jypyter-plotly-dash
•	pip install dash-leaflet
•	pip install pandas
Pymongo is used next and will need to be installed.
•	pip install pymongo
Jupyter notebooks will need to be installed.
•	pip install jupyterlab

Now that everything is installed the database with user authentication must be established.
Start MongoDB with no authentication with the command in the terminal
•	mongod_ctl start-noauth
The directory needs to be changed to the directory of the dataset.  
•	cd /usr/local/datasets

The data will need to be imported.

![image](https://user-images.githubusercontent.com/35537679/130328225-ff486da7-6619-4d5f-a81b-cace2752d372.png)

An admin account will need to be created.

![image](https://user-images.githubusercontent.com/35537679/130328228-6ad99a50-370e-4da0-9973-53aac5647b9d.png)

Once user authentication is established for the database, we need to create a user account for the AAC database.

![image](https://user-images.githubusercontent.com/35537679/130328239-70468551-76ee-466a-9cd1-fbdb354bacad.png)

## Code Example

CRUD functionality .py file

![image](https://user-images.githubusercontent.com/35537679/130328250-4c28a66e-ab90-43b5-be22-928bef9063d8.png)

![image](https://user-images.githubusercontent.com/35537679/130328255-1020a588-f87a-4f88-93f4-0e8d4b970ed9.png)

Tests

The .ipynb file is used for testing the dashboard.

![image](https://user-images.githubusercontent.com/35537679/130328263-500f2c24-7e1a-49b6-b52f-e9d6a175f645.png)

![image](https://user-images.githubusercontent.com/35537679/130328267-a131bbd5-3c35-4a2e-b9f2-77f6bfaf4174.png)

![image](https://user-images.githubusercontent.com/35537679/130328272-4ed621e9-ff58-4311-8ace-41fc49e9edf2.png)

## Screenshots

Here is the user dashboard.

![image](https://user-images.githubusercontent.com/35537679/130328282-07e997fa-61eb-4126-835d-6cb75527adff.png)

Water Rescue filter

![image](https://user-images.githubusercontent.com/35537679/130328285-9d5a6d09-66df-4382-a1a9-7e4b6725bec5.png)

Mountain or Wilderness Rescue filter

![image](https://user-images.githubusercontent.com/35537679/130328288-475f4791-c5b9-4fde-9154-34a0df607b97.png)

Disaster Rescue or Individual Tracking filter

![image](https://user-images.githubusercontent.com/35537679/130328309-8ba5fb2d-007d-4ff9-b168-ff278476839a.png)

## Contact

Matthew Clockel

Matthew.clockel@snhu.edu


