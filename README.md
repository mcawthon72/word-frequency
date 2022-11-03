# word-frequency
## turnitin word frequency exercise

This is a Java Spring Boot project demonstrating a single POST API endpoint to process and return the frequency of words within a collection in descending order.

Software needed to run this project: 

- openjdk-19
- Java version 17

To run: 

(Assuming you have maven installed on your machine)

Commands: 

- mvn clean
- mvn install
- run the project in the IDE of your choice (personally I prefer IntelliJ)


When running locally: 

- the local url to call: http://localhost:8080/word-frequency
- the POST endpoint, 'word-frequency', accepts a JSON body with a 'words' array containing single words, example payload below: 

{
    "words": ["hello", "world", "test", "world", "world", "hello", "world", "michael", "cawthon", "mike", "michael"]
}
