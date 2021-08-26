Feature: look for Volksbank at Google

	Scenario:
		Given User Launch Chrome Browser
		When User opens URL "http://www.google.com"
		And User enters Volksbank in the search textbox
		Then the first search result is the Volksbank home page



		