@E2ETest
Feature: Login Features
This feature is to test valid and invalid Login

Background:
Given Login HTML page is opened
Then Login page heading as Hotel Booking Application 

@InvalidLogin
Scenario: Invalid Login of username or password
When Username is not entered
And Clicking on the Login button 
Then Please enter UserName error message is displayed
When Password is not entered
And Clicking on the Login button 
Then Please enter Password error message is displayed

@ValidLogin
Scenario: Valid Login and Field Validation in Hotel Booking
When User enters credentials as "admin" and "admin"
And Clicking on the Login button 
Then Login is successful
And Next page loaded as Hotel Booking

@ConfirmBooking
Scenario Outline: Valid Login and Field Validation in Hotel Booking
When User enters credentials as "admin" and "admin"
And Clicking on the Login button 
Then Login is successful
And Next page loaded as Hotel Booking 
When Clicking on the Confirm Booking
Then Alert box displays the message "Please fill the First Name"
When Enter First Name
And Clicking on the Confirm Booking
Then Alert box displays the message "Please fill the Last Name"
When Enter Last Name
And Clicking on the Confirm Booking
Then Alert box displays the message "Please fill the Email"
When Enter invalid Email
And Clicking on the Confirm Booking
Then Alert box displays the message "Please enter valid Email Id."
When Enter valid Email
And Clicking on the Confirm Booking
Then Alert box displays the message "Please fill the Mobile No."
When Enter valid mobile no
And Clicking on the Confirm Booking
Then Alert box displays the message "Please select city"
When Enter address
And Clicking on the Confirm Booking
Then Alert box displays the message "Please select city"
When Enter Number of guest staying
And Clicking on the Confirm Booking
Then Alert box displays the message "Please select city"
When Enter valid city
And Clicking on the Confirm Booking
Then Alert box displays the message "Please select state"
When Enter valid state
And Clicking on the Confirm Booking
Then Alert box displays the message "Please fill the Card holder name"
When Enter valid Card Holder Name
And Clicking on the Confirm Booking
Then Alert box displays the message "Please fill the Debit card Number"
When Enter valid Debit card Number and CVV
And Clicking on the Confirm Booking
Then Alert box displays the message "Please fill expiration month"
When Enter valid Card expiration month
And Clicking on the Confirm Booking
Then Alert box displays the message "Please fill the expiration year"
When Enter valid Card expiration year
When Enter mobile no is <InvalidPhone>
And Clicking on the Confirm Booking
Then Alert box displays the message "Please enter valid Contact no."
When Enter valid mobile no
And Clicking on the Confirm Booking
Then Page navigates to success page
And Page displays message "Booking Completed!!!"

Examples:
|InvalidPhone|
|1324244222|
|7800800|
|89035546|
|9876543|
|9807654321234|