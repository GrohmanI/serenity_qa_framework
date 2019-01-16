Meta:

Narrative:
As a user
I want to perform an action
So that I can achieve a business goal

Scenario: compare search results with the text on the page
Given request with GET Method
When user opened CNN page, using following link: 'https://edition.cnn.com'
When type input Search 'bitcoin'

Then API search results should be same as on the Search Bitcoin result page