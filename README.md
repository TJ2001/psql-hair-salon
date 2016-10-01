# _Salon de Feu Pur_

#### _It will display a list of stylists employed by the Salon as well as the clients, {September 16, 2016}_

#### By _**Tim Jung**_

## Description

_The purpose of this application is to take inputs, specifically stylists and their clients, from the user and display them in a visual output._

## Setup/Installation Requirements

* _Download zip or clone files to desktop._
* _Have Gradle installed on the system._
* _Have PostgreSQL on the system._
* _Open a terminal and run command "postgres"._
* _Open another terminal or another tab in the terminal run command "psql"._

User is welcome to use the database provided by doing the following:
* In PSQL: "CREATE DATABASE hairsalon;"_
* In another tab or terminal run these commands: "psql hairsalon < psql hairsalon.sql"

If user would(s) like to create his/her/their own database.
* In PSQL: "CREATE DATABASE hair_salon;" "CREATE TABLE clients(id serial PRIMARY KEY, name varchar, detail varchar, email varchar, phone number varchar, stylistid int);" "CREATE TABLE stylists(id serial PRIMARY KEY, artist varchar, detail varchar);" "CREATE DATABASE hairsalon_test WITH TEMPLATE hair_salon;"

* _Open console to the project package folder and run "gradle run" ._
* _Go to http://localhost:4567/ in a browser preferably Chrome._
* _Everything should just work fine, if directions are followed._

## Specifications

* _Input: Stylists and Clients._
* _Output: Display a list of the employed stylings and using dynamic routing link their clients can be displayed._

## Known Bugs

_It's mostly bug free. Older browsers might have issues._

## Support and contact details

_Feel free to make a branch and work on it. Contact git user: TJ2001 for any issues._

## Technologies Used

_Java, Gradle, PSQL, and Spark are utilized for the making of this application._

### License

*This is created under CC.*

CC Copyright (c) 2016
