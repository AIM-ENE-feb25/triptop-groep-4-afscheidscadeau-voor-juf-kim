# ADR: Waarom kiezen voor het Strategy Pattern

**Datum:** 28-03-2025  
**Status:** Geaccepteerd

---

## Context

In TripTop willen we flexibel omgaan met keuzes van gebruikers. Denk aan dingen zoals:

- Wil de gebruiker de **goedkoopste**, **snelste** of **meest beschikbare** reisoptie?
- Moet er betaald worden via **Stripe**, **iDEAL**, of een andere provider?

Voor al die gevallen heb je verschillende strategieën om je gekozen doel te bereiken.

### Onderzoeksvraag
**Hoe ontwerp je een systeem waarbij verschillende vormen van gedrag (zoals reisopties of betaalproviders) flexibel en uitbreidbaar ondersteund worden, zodat nieuwe vormen eenvoudig kunnen worden toegevoegd zonder bestaande logica aan te passen?**

---

## Overwogen Aspecten - Strategy Pattern

| Aspect                                    | Voordelen                                                                                  | Nadelen                                                                 |
|-------------------------------------------|---------------------------------------------------------------------------------------------|-------------------------------------------------------------------------|
| **Uitbreidbaarheid**                      | Nieuwe strategieën zijn makkelijk toe te voegen via aparte klassen           | Kan leiden tot veel losse klassen                                       |
| **Losse koppeling (Separation of Concerns)** | Gedrag zit los van de rest van de applicatielogica                                         | Extra complexiteit als het niet goed gestructureerd wordt               |
| **Wisselbaarheid op runtime**             | Strategieën zijn verwisselbaar tijdens uitvoering                                           | Strategie moet wel actief gekozen of geïnjecteerd worden                |
| **Testbaarheid**                          | Elke strategie is afzonderlijk te testen                                                   | Geen directe nadelen, behalve onderhoud bij veel varianten             |
| **Open/Closed Principle**                 | Bestaande code blijft onaangetast bij uitbreidingen                                        | Vereist consistent gebruik voor maximale winst                          |

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