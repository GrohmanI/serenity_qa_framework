Meta:

Narrative:
As a user
I want to perform an action
So that I can achieve a business goal

Scenario: Verify user is able to perform the news search

Given user retrieved the cnn search results, using API
When user opens the cnn page, by following link: 'https://edition.cnn.com/search/?q=bitcoin'
And user filtering displayed results, using next filter criteria:
| category | type    |
| Travel   | Stories |
Then API search results should be same as on the Search result page