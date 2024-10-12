Feature: Services now incident record handling

Background:
Given set the base path of the service now incident table

@smoke
Scenario: Validate the incident record creation without request body
When send the post request for the incident service to create one record
Then ensure the record successfully create with status code of 201

@regression
Scenario: Validate the incident record creation with request body
When send the post request for the incident service to create one record with body '{"short_description": "RESTAPISEP2024"}'
Then ensure the record successfully create with status code of 201