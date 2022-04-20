Feature: user login

	# Background: the user is not logged in

	Scenario: successful login
		Given the user is on the login page
		When the user enters the correct username
		And the user enters the correct password
		And the user clicks the login button
		Then the user will be directed to the home page
		
	Scenario: username does not exist
		Given the user is on the login page
		When the user enters an incorrect username
		And the user clicks the login button
		Then an incorrect credentials message will be displayed
		
	Scenario: incorrect password
		Given the user is on the login page
		When the user enters the correct username
		And the user enters the incorrect password
		And the user clicks the login button
		Then an incorrect credentials message will be displayed
		