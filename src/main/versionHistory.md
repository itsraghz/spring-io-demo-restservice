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

Date : 08 Feb 2021, Monday

    * Added the CorpCards Facilities
    * URLs
        - http://localhost:8080/acrs/corporates/ - will return only the Corporates
        - http://localhost:8080/acrs/corporates/cards - will embed the list of CardHolders inside each Corporate for all Corporates
        - http://localhost:8080/acrs/corporates/661/cards -  will embed the list of CardHolders inside each Corporate for a particular OrgId

## V5 - CorpCards Added

Date : 08 Feb 2021, Monday

    - Added @CrossOrigin to the Controller 
        `@CrossOrigin(origins="*", allowedHeaders = "*")`

## V6 - PUT Requests added, few GET requests for cardHolders and pgAdmins modified

Date : 10 Feb 2021, Wednesday

    * Added Update functionality for Corporate, CardHolder and PGAdmin
        - Added `update()` method in the POJOs - `Corporate`, `CardHolder` and `ProgramAdmin`
    * Added updateXXX() methods in `CorpPGAdminUtil` class
    * URLs
        GET - http://localhost:8080/acrs/corporates/
        GET - http://localhost:8080/acrs/corporates/486
        GET - http://localhost:8080/acrs/corporates/cards
        GET - http://localhost:8080/acrs/corporates/661/cards
        PUT - http://localhost:8080/acrs/corporates/1
        PUT - http://localhost:8080/acrs/corporates/1/Raghs
        GET - http://localhost:8080/acrs/cardHolders/
        GET - http://localhost:8080/acrs/cardHolders/corporate/486
        PUT - http://localhost:8080/acrs/cardHolder/1
        PUT - http://localhost:8080/arcs/cardHolder/1/Raghs
        GET - http://localhost:8080/acrs/pgAdmins/
        GET - http://localhost:8080/acrs/pgAdmins/1
        GET - http://localhost:8080/acrs/pgAdmins/corporate/540
        PUT - http://localhost:8080/acrs/pgAdmins/1
        PUT - http://localhost:8080/arcs/pgAdmins/1/Raghs

## V7 - GET Requests for CorpPGAdmins and CorpPGAdminsForCorpId added

Date : 11 Feb 2021, Thursday

    * Added GET Requests for CorpPGAdmins and CorpPGAdminForCorpId
    * URLs
        - http://localhost:8080/acrs/corporates/pgAdmins
        - http://localhost:8080/acrs/corporates/207/pgAdmins