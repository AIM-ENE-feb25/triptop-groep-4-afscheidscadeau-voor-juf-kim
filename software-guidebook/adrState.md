# ADR: Keuze voor Pattern binnen TripTop

**Datum:** 31-03-2025  
**Status:**  ACCEPTED

---

##  Context

Binnen het TripTop-project willen we op een flexibele manier kunnen omgaan met verchillende logica bij bijvoorbeeld het kiezen van reisopties of betalingsverwerking. 
Er zijn meerdere patterns beschikbaar om dit bereiken. Daarom hebben we vier bekende design patterns overwogen, Deze patterns moesten we toepassen als prototype:



##  Beslissing
Bij mijn designvraag werkte de pattern erg goed. Ik kon hiermee snel hetgene maken wat ik wilde en de state werd fijn beigehouden vanuit andere classes. De pattern paste goed bij mijn vraag en ik kon hierom snel veder. hetgeen wat ik wel moeilijk vond aan dit onderdeel is dat state een beetje overkill was 

---

##  Gevolgen
Er worden meer states gebruikt en klasse worden aangeroepen gebasseerd op wat er aan de state word terug gegeven. Dit is fijn want er is een soort van centrale plek die over de onderdelen gaat. Het nadeel is wel dat het allemaal stap voor stap gaat en het pas niet goed bij elk onderdeel.

