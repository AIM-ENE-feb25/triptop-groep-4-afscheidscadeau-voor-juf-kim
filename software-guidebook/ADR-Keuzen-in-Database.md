# ADR: Keuze voor Pattern binnen TripTop

**Datum:** 28-03-2025  
**Status:**  ACCEPTED

---

##  Context

Binnen het TripTop-project willen we op een flexibele manier kunnen omgaan met verchillende logica bij bijvoorbeeld het kiezen van reisopties of betalingsverwerking.
Er zijn meerdere patterns beschikbaar om dit bereiken. Daarom hebben we vier bekende design patterns overwogen


---

##  Mogelijke opties
- **Strategy Pattern**
- **State Pattern**
- **Adapter Pattern**
- **Facade Pattern**

---

##  Beslissing

De facade design pattern zorgt er voor dat code niet onderling afhanekelijk is en dat alles via een methde gaat.
dit zorgt er voor dat de code heel overzichtelijk blijft en debuggen ook makkelijker wordt.
dit is dus een goede design pattern die wij in ons project meer willen gebruiken.

---

##  Gevolgen

###  Voordelen
- De code is heel overzichtelijk omdat methoden niet onderling van elkaar dingen kunnen vragen
###  Nadelen
- De code die alle de depencendies tussen methodes regelt kan heel groot worden