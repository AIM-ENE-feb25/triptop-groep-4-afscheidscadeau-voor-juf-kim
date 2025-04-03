# ADR: Keuze design pattern makkelijk wijzigen van API

**Datum:** 03-04-2025  
**Status:**  ACCEPTED

---

##  Context
Hoe zorg je dat een wijziging in een of meerdere APIs niet leidt tot een grote wijziging in de applicatie?
Specifieker: hoe zorg je ervoor dat een wijziging in de API van een externe service niet leidt tot
een wijziging in de front-end maar flexibel kan worden opgevangen door de back-end?


##  Overwogen opties
adapter pattern

## Beslissing
De fascade zorgt er voor dat alle data die een API meegeeft eerst wordt opgeschoond voordat deze wordt doorgegeven aan
code die dit nodig heeft, hierdoor kunnen API's ook makkelijk worden toegevoegd zonder dat er grote aanpassingen gemaakt
hoeven te worden aan de back- of front-end code zelf.

De facade geeft altijd een lijst met alle mogelijke reizen op een bruikbare manier terug aan de service. dit zorgt er
voor dat er in princiepe 0 aanpassingen gemaakt hoeven te worden aan de backend code, de code wordt namelijk al in de
facade opgeschoond en in de lijst gezet met de andere API's

## Gevolgen

