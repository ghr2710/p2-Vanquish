Feature: delete user, post or comment

	# Background: the user is logged in

	Scenario: delete user
		Given the user is on the view profile page
		When the user clicks the delete account button
		Then a message box will display stating if the delete was successful

	Scenario: delete post
		Given the user is on the view profile page
		When the user clicks the delete button on a post
		Then a message box will display stating if the delete was successful
		
	Scenario: delete comment
		Given the user is on the view profile page
		When the user clicks the delete button on a comment
		Then a message box will display stating if the delete was successful