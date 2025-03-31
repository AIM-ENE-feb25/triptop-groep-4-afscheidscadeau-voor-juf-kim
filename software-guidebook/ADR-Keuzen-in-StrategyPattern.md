# ADR: Waarom kiezen voor het Strategy Pattern

**Datum:** 28-03-2025  
**Status:** Geaccepteerd

---

## Context

In TripTop willen we flexibel omgaan met keuzes van gebruikers. Denk aan dingen zoals:

- Wil de gebruiker de **goedkoopste**, **snelste** of **meest beschikbare** reisoptie?
- Moet er betaald worden via **Stripe**, **iDEAL**, of een andere provider?

Voor al die gevallen heb je verschillende strategieën om je gekozen doel te bereiken.

### Ontwerp vraag
**"Hoe zorg je voor een zo kort mogelijke reisroute waarbij gebruik gemaakt wordt van alle bouwstenen? 
Hoe zorg je ervoor dat de reisroute makkelijk aangepast kan worden als reisafstand geen issue is?"**

---

## Overwogen Aspecten – Strategy Pattern voor Routeplanning

| Aspect                                      | Voordelen                                                                                       | Nadelen                                                                  |
|---------------------------------------------|--------------------------------------------------------------------------------------------------|---------------------------------------------------------------------------|
| **Flexibele route-optimalisatie**           | Strategieën kunnen gebaseerd zijn op o.a. tijd, afstand, beschikbaarheid of voorkeuren           | Vereist meerdere strategieklassen voor elk type logica                   |
| **Aanpasbaarheid op gebruikerswens**        | Gebruiker of systeem kan tijdens runtime bepalen welke route-logica gebruikt moet worden         | Meer logica om gebruikerskeuze om te zetten naar juiste strategie        |
| **Scheidt routeberekening van logica**      | Route-algoritmes zitten los van de rest van de business logica (Separation of Concerns)          | Kans op duplicatie als niet goed gedeeld wordt tussen strategieën        |
| **Uitbreidbaarheid met nieuwe scenario’s**  | Nieuwe soorten routevoorkeuren (bijv. “eco”, “sightseeing first”, “geen overnachtingen”) zijn makkelijk toe te voegen | Kan verwarrend worden als het aantal strategieën te groot wordt          |
| **Testbaarheid van routestrategieën**       | Elke routestrategie is zelfstandig te testen, los van UI en andere systemen                     | Afhankelijk van mockdata of simulatie voor complete route-validatie      |

---

## Beslissing

Met deze overwegingen in gedachten gaan het strategy pattern toepassen op deze technologie.

Dit patroon is handig als je hetzelfde probleem op meerdere manieren wilt oplossen. Je stopt elke manier in een losse klasse, en je kunt makkelijk wisselen
tussen die strategieën zonder dat je de rest van de code moet aanpassen.

---

## Wat betekent dit?

### Voordelen

- Makkelijk uit te breiden: wil je in de toekomst een extra strategie (bijv. eco-vriendelijk reizen of iets anders raars)? Dan voeg je gewoon een nieuwe klasse toe.
- Je hoeft niet meer `if`-jes en `switch`es in te bouwen voor elk geval.
- De logica zit vanaf nu netjes los van de rest van je code.
- Je kunt het ook goed testen per strategie.

### Nadelen

- Je gaat wat meer losse klassen hebben in je project.
- Je moet het patroon wel even snappen, anders wordt het rommelig.

---

Kortom: met Strategy kunnen we flexibel gedrag netjes organiseren, zonder dat de code een rommeltje wordt. En dat past goed bij hoe TripTop in elkaar zit.