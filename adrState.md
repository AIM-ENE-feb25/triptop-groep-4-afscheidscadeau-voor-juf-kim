# ADR: Keuze voor Pattern binnen TripTop

**Datum:** 28-03-2025  
**Status:**  ACCEPTED

---

##  Context

Binnen het TripTop-project willen we op een flexibele manier kunnen omgaan met verchillende logica bij bijvoorbeeld het kiezen van reisopties of betalingsverwerking. 
Er zijn meerdere patterns beschikbaar om dit bereiken. Daarom hebben we vier bekende design patterns overwogen:



##  Beslissing
Het nadeel met state is dat je het op een paar minder usecases in dit project kan geburuiken waar het redelijk op werkt maar het is niet groot genoeg om echt een verschil te kunnen maken. Hierom lijkt het mij niet handig om State te gaan gebuirken voor dit prject
Als je een project heb wat meer stapsgeweis werkt dan is het heel handig om state te gebruiken want voor elke stap of mogelijkheid kan je een state maken.


---

##  Gevolgen
State gaat minder gebruikt worden in bij ons. Hierdoor kunnen we niet gebruikmaken van de "Simplicitijd" die state kan bieden in een project. State kan zeker gebruikt worden voor dit project en een voordeel hebben, maar er zijn patterns die meer voordelen kunnen bieden

