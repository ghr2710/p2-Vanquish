Feature: user logout

	# Background: the user is logged in

	Scenario: successful logout
		Given the user is on the home page
		When the user clicks the logout button
		Then the page will redirect to the main page
		