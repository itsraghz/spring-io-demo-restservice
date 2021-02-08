# Version History

## V1 - Simple

Date: 05 Feb 2021, Friday

    * Starter Spring Boot Rest 
    * Simple Greeter Controller with two URLs
        - http://localhost:8080/greeting
        - http://localhost:8080/greeting?user=Raghs
    * Modified the Executable JAR for JDK8 version

## V2 - Corporate, CardHolder 

Date : 05 Feb 2021, Friday

    * Added Corporate, CardHolder facility
        -  BO, Util packages
    * CardController
    * Faker Libary for a few random data
    * My Own Custom logic for the random data for most part
    * URLs
        - http://localhost:8080/corporates
        - http://localhost:8080/cardHolders/
        - http://localhost:8080/cardHolders/712

## V3 - PGAdmin Added, Metadata Added (Non-Standard)

Date : 08 Feb 2021, Monday

    * Added the `versionHistory.md`
    * Added the `.meta` package with the `*MetaData` class
    * Added that MetaData class into the corresponding class (Non-Standard)
        - Tested with Corporate, CardHolders and PGAdmin
        - Added the Metadata in the last element of a collection
    * Added PGAdmin facility
        - BO, Util classes modified accordingly
        - CardController added with the relevant methods
    * Moved the JavaVersionCheckUtil from `restservice` package to `util` package
    * Added a defaultHandling method in `CardController`
    * URLs
        - Modified all of them to have /acrs as a prefix
        - http://localhost:8080/acrs/corporates/
        - http://localhost:8080/acrs/corporates/486
        - http://localhost:8080/acrs/cardHolders/
        - http://localhost:8080/acrs/cardHolders/483
        - http://localhost:8080/acrs/pgAdmins/
        - http://localhost:8080/acrs/pgAdmins/483

## V4 - CorpCards Added

Date : 08 Feb 2021, Friday

    * Added the CorpCards Facilities
    * URLs
        - http://localhost:8080/acrs/corporates/ - will return only the Corporates
        - http://localhost:8080/acrs/corporates/cards - will embed the list of CardHolders inside each Corporate for all Corporates
        - http://localhost:8080/acrs/corporates/661/cards -  will embed the list of CardHolders inside each Corporate for a particular OrgId