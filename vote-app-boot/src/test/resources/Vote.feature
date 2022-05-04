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
		
	Scenario: vote more than once
		Given the user is on the home page and is voting on a post they have already voted on
		When the user clicks the vote button for option1 or option2
		Then a message box will display stating that the user has already voted