Feature: create user

	# Background: a user is not logged in

	Scenario: create new user
		Given the user is on the home page
		When the user enters a username and password
		Then a message box will display stating that a user was successfully created
		
	Scenario: username taken
		Given the user is on the home page
		When the user enters a username that is already taken
		Then a message box will display stating that the username is taken