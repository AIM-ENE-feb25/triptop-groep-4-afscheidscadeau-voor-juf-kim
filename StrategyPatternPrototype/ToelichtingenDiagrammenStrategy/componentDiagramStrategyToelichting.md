# Component Diagram - Strategie voor Reisopties (TripTop)

Dit component diagram laat zien hoe de verschillende onderdelen in de **backend van TripTop** samenwerken als een gebruiker bijvoorbeeld wil filteren op **snelheid** of **prijs**.

---

## Wat zie je hier?

We zitten in de backend van TripTop, en daar zijn een aantal belangrijke onderdelen:

### 1. ReisPlannerController
- De **ingang** van de backend.
- Ontvangt verzoeken van de webapp, bijvoorbeeld: "ik wil de snelste optie".
- Stuurt deze verzoeken door naar de `ReisplannerService`.

### 2. ReisplannerService
- Hier gebeurt de **echte logica**.
- Deze component weet welke strategie is gekozen en past die toe op een lijst van `ReisOptie`-objecten.
- Roept de juiste `selecteer(...)` methode aan van de gekozen strategie.

### 3. Strategieklassen (Strategy Pattern)
- Deze klassen voeren de daadwerkelijke selectie uit:
    - **GoedkoopsteStrategie**: kiest de optie met de laagste prijs.
    - **SnelsteStrategie**: kiest degene met de kortste reistijd.
    - **BeschikbaarheidStrategie**: kiest alleen opties die beschikbaar zijn.
- Ze implementeren allemaal de `SelectieStrategie` interface.

### 4. ReisOptie (Model)
- Een simpele klasse met data over een reisoptie:
    - prijs
    - reistijd
    - beschikbaarheid (true/false)

### 5. NotificatieService + MailComponent
- Na het kiezen van een optie kan de gebruiker automatisch een bevestiging krijgen.
- De `NotificatieService` regelt dit.
- Deze gebruikt het `MailComponent` om de bevestiging via e-mail te versturen.

### 6. Externe API's
- De backend haalt reisdata op bij verschillende vervoersaanbieders:
    - **NS API**: voor treininformatie
    - **KLM API**: voor vluchten
    - **Uber API**: voor taxi’s

---

## Waarom zijn deze keuzes gemaakt?

- **Losse componenten = betere testbaarheid**:
  > Elk onderdeel doet zijn eigen taak. Dat maakt het makkelijk om te testen of elk stuk goed werkt.

- **Notificatie is apart gehouden**:
  > Zo kun je makkelijk overstappen van e-mail naar een andere vorm van melding (zoals push-notificaties), zonder alles aan te passen.

- **Externe API’s via service-laag**:
  > Als een API verandert, hoef je maar één component aan te passen: de service die ermee praat.

- **Herbruikbare strategieën**:
  > Doordat alle strategieën dezelfde interface gebruiken, kunnen we makkelijk wisselen zonder dat `ReisplannerService` hoeft te weten wat de strategie precies doet.

