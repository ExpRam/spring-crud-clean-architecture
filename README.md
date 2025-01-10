# Spring Boot CRUD Application with Clean Architecture or why you shouldn`t use CA for simple projects

## Some thoughts about Spring
At the stage of development of this application there were some points that in some places I didn't like very much. The most important thing is Spring Boot dependencies, which are scattered across different layers of the application, which could interfere with the conditional migration to other frameworks. To the question, “And how often are you going to change frameworks?” my answer is, “Then why do you need Clean Architecture in the first place? One of its features is its ability to be a soft transition. With that kind of dependency spread, that's where all the magic breaks down.”. But that's not the main problem, the main problem here is the validation problem in the controller. Lack of validation against Null made me waste my time on even more Boilerplate code than if this validation was already built into the framework. I don't deny that I might have missed this point somewhere, but this is the conclusion I have made for myself so far.

## CA in small projects
CA in small projects just spends a lot of your time. That`s all! Very obvious, but it's worth saying
