# Supplementary Specification (FURPS+)

## Functionality

_Specifies functionalities that:_

- _are common across several US/UC;_
- _are not related to US/UC, namely: Audit, Reporting and Security._


> * To use the application, it is necessary to be authenticated 
   with password
> * Only the specialist doctor is allowed to access all
   client data
> * The application must allow ordering the clients by TIF and by name.


## Usability 

_Evaluates the user interface. It has several subcategories,
among them: error prevention; interface aesthetics and design; help and
documentation; consistency and standards._

> * The application must support the English language only
> * The user interface must be simple, intuitive and consistent

## Reliability
_Refers to the integrity, compliance and interoperability of the software. The requirements to be considered are: frequency and severity of failure, possibility of recovery, possibility of prediction, accuracy, average time between failures._

> * The application should use object serialization to ensure data persistence between two runs of the
    application
> * The system should not fail more than 5 days in one year. 
> * Whenever the system fails, there should be no data loss.

## Performance
_Evaluates the performance requirements of the software, namely: response time, start-up time, recovery time, memory consumption, CPU usage, load capacity and application availability._

> * Any interface between a user and the system shall have a maximum response time of 3
    seconds.
> * The system should start up in less than 10 seconds.
> * The system should run on all platforms for which there exists a Java Virtual
    Machine.
> * The application will be deployed to a machine with 8GB of RAM. 


## Supportability
_The supportability requirements gathers several characteristics, such as:
testability, adaptability, maintainability, compatibility,
configurability, installability, scalability and more._ 


> * Use Javadoc to generate useful documentation for Java code
> * Use of uni tests for all methods except methods that implement input/output operations
> * Unit tests should be implemented using JUnit 4 framework
> * The JaCoCo plugin should be used to generate the coverage report
> * The company is also required to generate daily (automatic) reports
	with all the information demanded by the NHS and should send them to the NHS using their API


## +

### Design Constraints

_Specifies or constraints the system design process. Examples may include: programming languages, software process, mandatory standards/patterns, use of development tools, class library, etc._
  

> * JavaFX 11
> * IntelliJ IDE or Netbeans
> * All the images/figures produced during the software development process should be recorded in
    SVG format
> * Adopt best practices for identifying requirements
    and for OO software analysis and design
> * The password to authentication needs to be holding seven alphanumeric characters, including
    three capital letters and two digits
> * The ordering algorithm to be used by the application must be defined through a configuration
    file


### Implementation Constraints

_Specifies or constraints the code or construction of a system such
such as: mandatory standards/patterns, implementation languages,
database integrity, resource limits, operating system._


> * Java Language
> * Adopt recognized coding standards (CamelCase)


### Interface Constraints
_Specifies or constraints the features inherent to the interaction of the
system being developed with other external systems._

> * It is necessary to use an external API to automatically generate a barcode to
> identify each sample
> * It is necessary to use an external module that is responsible for doing an 
> automatic validation using test reference values
> * It is necessary to use an external API to notify the client that the results are 
> already available via SMS and e-mail

### Physical Constraints

_Specifies a limitation or physical requirement regarding the hardware used to house the system, as for example: material, shape, size or weight._

