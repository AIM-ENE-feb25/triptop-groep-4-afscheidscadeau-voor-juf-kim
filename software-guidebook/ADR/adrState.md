# ADR: Keuze voor Pattern binnen TripTop

**Datum:** 31-03-2025  
**Status:**  ACCEPTED

---

##  Context

Binnen het TripTop-project willen we op een flexibele manier kunnen omgaan met verchillende logica bij bijvoorbeeld het kiezen van reisopties of betalingsverwerking. 
Er zijn meerdere patterns beschikbaar om dit bereiken. Daarom hebben we vier bekende design patterns overwogen, Deze patterns moesten we toepassen als prototype:

## Overwogen Opties

| Voordelen                                                                                                                                                                           | Nadelen                                                                                                                                                                                                     |
|-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| Duidelijkheid:<br/>De verantwoordelijkheden worden duidelijk gescheden hierdoor is het goed en makkelijk om te zien welk onderdeel waarvoor verantwoordelijk is                     | Aantal klassen:<br/> Omdat elke state zijn eigen klasse is heb je erg veel extra klasse nodig omdat elk onderdeel of state zijn eigen klasse heeft                                                          |
| Makkelijk uit te breiden:<br/> Wanneer je State gebruikt is het makkelijk om je project uit te breiden. Het enige wat je moet doen is een nieuwe state aan je project toe te voegen | Testen:<br/>Het is moeilijker om je code te Unit testen. Dit is omdat je ervoor moet zorgen dat de code die je wilt testen in de juiste state zit wanneer je deze test.                                     |
| Makkelijk te debuggen:<br/> Aangezien elk onderdeel een duidelijke functie heeft is het makkelijk om te debuggen omdat het erg duidelijk is welk onderdeel wat doen.                | Niet goed voor kleine projecten:<br/>Dit pattern is niet goed om te gebruiken bij kleinere projecten. Hier kwam ik met mijn prototype achter. Het project werd alleen maar onnodig groter en ingewikkelder. |


##  Beslissing
Bij mijn designvraag werkte de pattern erg goed. Ik kon hiermee snel hetgene maken wat ik wilde en de state werd fijn beigehouden vanuit andere classes. De pattern paste goed bij mijn vraag en ik kon hierom snel veder. hetgeen wat ik wel moeilijk vond aan dit onderdeel is dat state een beetje overkill was 

---

##  Gevolgen
Er worden meer states gebruikt en klasse worden aangeroepen gebasseerd op wat er aan de state word terug gegeven. Dit is fijn want er is een soort van centrale plek die over de onderdelen gaat. Het nadeel is wel dat het allemaal stap voor stap gaat en het pas niet goed bij elk onderdeel.

