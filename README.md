# JavaGenderDetector
Java lib to identify gender detector based on name. Based on other projects in other languages in github

## Description
A java project in github that you can fork and use in your project. It will help you in identify a possible gender of a person based in his/her name.

## Installation
By now, you need to fork or download the project and add it to your workspace or pom.xml as a local library.
In a future, I will add it to maven so you will be able to download it easily (after I enhance the code as needed).

## Example of use
Using it is as simple as you instance GenderDetector interface using GenderDetectorImpl without parameters.

```java
// Instance of detector
GenderDetector genderDectector = new GenderDetectorImpl();
```
And use its detector calling its main method:

```java
// Call detection
String name = "Samuel";
genderDectector.findGender(name);
```
