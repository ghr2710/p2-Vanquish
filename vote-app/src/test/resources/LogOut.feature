Feature: user logout

	# Background: the user is logged in

	Scenario: successful logout
		Given the user is on the home page
		When the user clicks the logout button
		Then a message box will display stating that the log out was successful
		