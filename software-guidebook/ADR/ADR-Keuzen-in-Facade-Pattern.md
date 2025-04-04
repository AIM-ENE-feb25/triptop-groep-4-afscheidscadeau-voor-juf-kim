# ADR: Keuze design pattern makkelijk wijzigen van API

**Datum:** 03-04-2025  
**Status:**  ACCEPTED

---

##  Context
Hoe zorg je dat een wijziging in een of meerdere APIs niet leidt tot een grote wijziging in de applicatie?
Specifieker: hoe zorg je ervoor dat een wijziging in de API van een externe service niet leidt tot
een wijziging in de front-end maar flexibel kan worden opgevangen door de back-end?


##  Overwogen opties
- adapter pattern

### voordelen
- overzichtelijkheid: een facade is een enkele klasse waarmee de opsgeschoonde data van de API kan worden doorgegeven 
- consistentie: de facade zorgt er voor dat alle logica voor het opschonen en formatteren van de request op een centrale plek staat
- geen effect op andere code: de facade zorgt er voor dat alle requests bij elkaar komen en als een lijst worden teruggegeven.
het verwijderen of toevoegen van API's heeft dus geen effect op andere code.

### Nadelen
- minder bruikbaar voor andere, soortgelijke systemen: de facade pattern is specifiek voor een enkele use case en kan hier niet op worden aangepast
- moeilijke te debuggen: alles logica voor het verzamelen en debuggen staat in een enkele klassen wat debuggen moeilijker kan maken

## Beslissing
De fascade zorgt er voor dat alle data die een API meegeeft eerst wordt opgeschoond voordat deze wordt doorgegeven aan
code die dit nodig heeft, hierdoor kunnen API's ook makkelijk worden toegevoegd zonder dat er grote aanpassingen gemaakt
hoeven te worden aan de back- of front-end code zelf.

De facade geeft altijd een lijst met alle mogelijke reizen op een bruikbare manier terug aan de service. dit zorgt er
voor dat er in princiepe 0 aanpassingen gemaakt hoeven te worden aan de backend code, de code wordt namelijk al in de
facade opgeschoond en in de lijst gezet met de andere API's

hoewel de facade veel voordelen met zich mee brengt heeft het alsnog ook zijn nadelen. Een groot nadeel is dat de code onoverzichtelijk wordt
als er gebruik wordt gemaakt van te veel API's. dit kan als gevolg hebben dat de applicatie moeilijker wordt om te debuggen. in dit opzicht was de adapter pattern
dus beter geweest.

## Gevolgen

Door gebruik te maken van de facade pattern krijgen relevante service classes een overzichtelijke lijst van alle mogelijke routes, van alle API's.
dit zorgt er voor dat de service class het makkelijk kan verwerken en terug kan geven naar de gebruiker. Doordat er gebruik is gemaakt van een facade hoeft er geen 
gebruik gemaakt te worden van meerdere API's calls, alleen de facade hoeft aangeroepen te worden voor alle resultaten van alle reis API's.
Dit heeft ook als effect dat aanpassingen in de API's geen gevolgen hebben voor de backend code waardoor er op dat vlak ook 
minder fout kan gaan.