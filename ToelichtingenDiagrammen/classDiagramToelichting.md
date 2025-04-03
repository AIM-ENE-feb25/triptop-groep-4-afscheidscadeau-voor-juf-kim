# Class Diagram - TripTop

Dit diagram laat zien hoe we binnen het TripTop-project verschillende manieren hebben gebouwd om **reisopties te filteren**. Gebruikers kunnen bijvoorbeeld kiezen of ze de **goedkoopste**, **snelste**, of een **beschikbare** optie willen zien.

Hiervoor gebruiken we het **Strategy Pattern**, wat eigenlijk gewoon betekent:
> "We stoppen elke manier van selecteren in z’n eigen stukje code, zodat we makkelijk kunnen wisselen."

## Wat zie je allemaal in het diagram?

### SelectieStrategie (interface)
- Dit is een soort algemene afspraak: **alle filters** moeten een methode `selecteer(...)` hebben.
- Daardoor kunnen we makkelijk wisselen tussen strategieën **zonder dat we de rest van het systeem moeten veranderen**.

### ReisOptie
- Een klasse die één reisoptie beschrijft, zoals trein, bus of auto.
- Eigenschappen:
    - naam
    - prijs
    - reistijd
    - beschikbaarheid (boolean)

### Strategieklassen:
We hebben drie strategie-klassen gemaakt, elk met hun eigen manier van filteren:

- **GoedkoopsteStrategie**: kiest de optie met de laagste prijs.
- **SnelsteStrategie**: kiest de snelste manier van reizen.
- **BeschikbaarheidStrategie**: kiest alleen opties die op dat moment beschikbaar zijn.

Elke strategie doet dus z’n eigen ding. Dat houdt het **overzichtelijk** en **makkelijk uit te breiden**.

### ReisplannerService
- Deze klasse voert het filterwerk uit.
- Het weet zelf niet *hoe* er gefilterd moet worden — dat laat hij over aan de gekozen strategie.
- Methoden:
    - `setStrategie(...)`: stel in welke filter je wilt gebruiken (bijv. snelste).
    - `filterReisopties(...)`: voert de filtering uit met de gekozen strategie.

---

## Waarom is dit zo gedaan?

- **Makkelijk aan te passen**:
  > Stel dat je in de toekomst een nieuwe soort filter wil maken, zoals "eco-vriendelijk reizen" — dan hoef je alleen een **nieuwe strategieklasse** te maken.

- **Geen rommelige code**:
  > In plaats van een berg `if`-jes of `switch`-statements te schrijven, zeggen we gewoon: "gebruik deze strategie".

- **Je kunt het makkelijk testen**:
  > Elke strategie is losstaand, dus je kunt **goed testen** of hij werkt zoals het hoort.

