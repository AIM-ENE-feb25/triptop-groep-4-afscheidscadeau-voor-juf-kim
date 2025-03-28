#*ADR-005 Gebruik van Adapter Pattern met betrekking tot bezienswaardigheden
28/03/2025

#### Context

Het probleem waarvoor we het Adapter Pattern kunnen gebruiken is het integreren van verschillende API's, in dit geval BookingCom en tripadvisor. Deze API's leveren de data in verschillede formaten waardoor het moeilijk is om het consistent te weergeven in ons systeem.


#### Besluit

We hebben besloten om dit toetepassen op ons systeem om zo de data gestructureerd op kunnen halen, en zo makkelijker de bezienswaardigheid data op te halen.

#### Status

Accepted

#### Gevolgen

Dit patroon maakt het mogelijk om data van verschillende providers te integreren zonder hoofd functionaliteiten aan te passen. Daarnaast zorgt dit er ook voor dat de consistent is binnen de applicatie.
