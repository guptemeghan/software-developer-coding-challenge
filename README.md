# Software Developer Coding Challenge

This is a coding challenge for software developer applicants applying through http://work.traderev.com/

## Goal:

#### You have been tasked with building a simple online car auction system which will allow users to bid on cars for sale and with the following funcitionalies: 

  - [ ] Fork this repo. Keep it public until we have been able to review it.
  - [ ] A simple auction bidding system
  - [ ] Record a user's bid on a car
  - [ ] Get the current winning bid for a car
  - [ ] Get a car's bidding history 

 ### Bonus:

  - [ ] Unit Tests on the above functions
  - [ ] Develop a UI on web or mobile or CLI to showcase the above functionality

## Evaluation:

 - [ ] Solution compiles. Provide a README to run/build the project and explain anything that you leave aside
 - [ ] No crashes, bugs, compiler warnings
 - [ ] App operates as intended
 - [ ] Conforms to SOLID principles
 - [ ] Code is easily understood and communicative
 - [ ] Commit history is consistent, easy to follow and understand
 
 
 ## Solution:
 
 I have created a spring boot app which exposes endpoint to create and view users, cars, auctions and bids. I have integrated swagger to make it easier to run and demo the application. I am using JPA to persist the data.
 
 - Users - Create and Get users
 - Cars - Create and Get cars
 - Auction - Create and Get auctions
 - Bids - Create bids, view bids history and winning bid
 
 ### Project working and assumptions: 
 - You need to create a car entity before creating an auction as you create an auction for a car
 - You need to create an user and an auction before placing a bid.
 
 
 ### Steps to run the application:
 
 Prerequisites :
 
 - Maven
 - Java (JDK 1.8)
 
 In intellij: 
 - Import the project as a maven project.
 - Run the AuctionApplication.java class
 - Navigate to http://localhost:8080/swagger-ui.html to view and make api calls
 
  In Terminal: 
 - cd into `path-to-project-directory`.
 - Compile it using `mvn clean install -U`
 - Run the application `mvn spring-boot:run`
 - Navigate to http://localhost:8080/swagger-ui.html to view and make api calls
 
 ### Future enhancements
 - Add more unit tests
 - Make the auction time based having a start time and an end time.
 
