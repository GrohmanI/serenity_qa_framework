Meta:

Narrative:
As a user
I want to perform an action
So that I can achieve a business goal

Scenario: Verfy user is able to detele created resource

Given user is deleted following resource with id '2'
Then resource should be not available

Scenario: Verify Json Sever fake Restfull API

Given user creates new post with following details:
|title                    |author     |
|New Test Automation Title|Hillel_User|
Then created post with id '2' should be available with next details:
|title                    |author     |
|New Test Automation Title|Hillel_User|

Scenario: Verify user is able to update created resource

Given user modified created post with id '2', using following details:
|title                             |author              |
|New Modified Test Automation Title|Modified_Hillel_User|
Then modified post with id '2' should be available with next details:
|title                             |author              |
|New Modified Test Automation Title|Modified_Hillel_User|