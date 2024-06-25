Feature: WebDriver University - Contact Us page

Scenario: Validate the success message after submitting details in Contact Us page.

Given User accesses the webdriver university successfully.
When Enter the First Name
And Enter the last name
And Enter the email
And Enter the comments
And Hit the Submit button
Then Validate the success message in the page.