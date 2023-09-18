Feature: Sim Card Activator 
    Describe the behaviour of Sim Card Activator microservice 

    Scenario: Sim Card is activated successfully!
        Given a new sim card
        When a request to activate the sim card is posted
        Then the sim card is activated and its recorded to the database

    Scenario: A failing Sim Card activation
        Given a broken sim card 
        When a request to activate the sim card is posted
        Then the sim card is not activated and its state is recorded to the database