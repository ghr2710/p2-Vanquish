Feature: create post

	# Background: the user is logged in


Scenario: successful login
		Given the user is on the home page
		When the user enters the correct username
		And the user enters the correct password
		And the user clicks the login button
		Then a message box will display welcoming the user
		
		
	Scenario: post option1 vs option2
		Given the user is on the home page
		 When the user enters option1
		 And  the user enters option2
		Then a post will be created by clicking the post button

	