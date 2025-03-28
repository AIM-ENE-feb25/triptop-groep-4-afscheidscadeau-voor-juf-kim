# ADR: We kiezen voor het Strategy Pattern

**Datum:** 28-03-2025  
**Status:**  Geaccepteerd

---

##  Context

In Triptop willen we flexibel omgaan met keuzes van gebruikers. Denk aan dingen zoals:

- Wil de gebruiker de **goedkoopste**, **snelste** of **meest beschikbare** reisoptie?
- Moet er betaald worden via **Stripe**, **iDEAL**, of een andere provider?

Voor al die gevallen heb je verschillende strategieen om je gekozen doel te bereiken.

---

## Beslissing

Mijn voorkeur is om het **Strategy Pattern** te gebruiken.

Dit patroon is handig als je hetzelfde probleem op meerdere manieren wilt oplossen. Je stopt elke manier in een losse klasse, en je kunt makkelijk wisselen 
tussen die strategieën zonder dat je de rest van de code moet aanpassen.

---

## Wat betekent dit?

###  Voordelen

- Makkelijk uit te breiden: wil je in de toekomst een extra strategie (bijv. eco-vriendelijk reizen of iets anders raars)? Dan voeg je gewoon een nieuwe klasse toe.
- Je hoeft niet meer `if`-jes en `switch`es in te bouwen voor elk geval.
- De logica zit vanaf nu netjes los van de rest van je code.
- Je kunt het ook goed testen per strategie.

### Nadelen

- Je gaat wat meer losse klassen hebben in je project.
- Je moet het patroon wel even snappen, anders wordt het rommelig.

---

Kortom: met Strategy kunnen we flexibel gedrag netjes organiseren, zonder dat de code een rommeltje wordt. En dat past goed bij hoe Triptop in elkaar zit.