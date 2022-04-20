Feature: view user profile

	# Background: the user is logged in AND on the home page

	Scenario: profile button selected
		Given the user is on the home page
		When the user clicks the view profile button
		Then the page will redirect to the view profile page
		