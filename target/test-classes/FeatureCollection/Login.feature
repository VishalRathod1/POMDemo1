#Author: Vishal Rathod
#Feature: Login feature of Mercury Tours Application
#Date: 27/04/2019
@SmokeTest
Feature: Login feature
Background: User should access login page of Mercury Tours Application
			When user opens "chrome" browser
			And user enters application url as "http://newtours.demoaut.com/mercurywelcome.php"
			And user waits for "15" seconds to load login page
			And user maximizes the window
			Then user is on login page
			
@SmokeTest
Scenario: Verify that valid user is able to login into Mercury Tours Application with valid username and password
		  Given user access login page
		  When user enters "Suvidyap1" as username
		  And user enters "P@ssword1" as password
		  And user clicks on Signin button
		  Then user is on Flight finder page
		  When user clicks on Signoff button
		  Then user is on Signon page
		  			