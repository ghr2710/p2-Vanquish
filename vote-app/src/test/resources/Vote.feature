Feature: vote on post

	# Background: the user is logged in

	Scenario: vote option1
		Given the user is on the home page
		When the user clicks the vote button for option1
		Then a message box will display thanking the user for voting

	Scenario: vote option2
		Given the user is on the home page
		When the user clicks the vote button for option2
		Then a message box will display thanking the user for voting