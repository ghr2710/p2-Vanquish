Feature: view comments

	# Background: the user is logged in AND on the home page

	Scenario: view button selected
		Given the user is on the home page
		When the user clicks the view comments button
		Then the page will redirect to the comments page
		