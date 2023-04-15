# https://todomvc.com/examples/vanillajs/

## Setup Java
+ jdk 11 +
+ Add JAVA_HOME
+ Add JAVA_HOME/bin -> PATH
## Create new Maven project with intelliJ
 - add selenium-java to pom.xml
 - add testng to pom.xml
 - select chrome is main browser

## Define project structure
  - base <base*.java>
    - baseTest 
    - basePage
  - suites <*Test.java>
    - define test cases
  - pages <*Page.java>
    - define page object classes

## Define test cases for todo mvc
1. create a new todo successfully
2. mark a todo completed successfully
3. delete a todo successfully
4. edit a todo successfully


## How to define a test plan to execute
create a xml file like below:
```xml
<suite name="Todo MVC">
    <parameter name="browser" value="Chrome"/>
    <test name="Demo">
        <classes>
            <class name="suites.TodoMVCTest"/>
        </classes>
    </test>
</suite>
```
## How to run
```shell
mvn clean test
```g