# Sequence Diagram - Reisopties Filteren met Strategie (TripTop)

Dit sequence diagram laat stap voor stap zien wat er gebeurt wanneer een gebruiker reisopties wil filteren, bijvoorbeeld op prijs, snelheid of beschikbaarheid. Het legt de interactie uit tussen de gebruiker, backendcomponenten en strategieklassen.

---

## Wat gebeurt er precies?

### 1. Gebruiker kiest een strategie
- De gebruiker kiest een filter via de webinterface (bijv. "snelste optie").
- Deze keuze wordt verstuurd naar de backend.
- → `setStrategie(Strategie)`

### 2. Gebruiker vraagt om gefilterde opties
- De gebruiker vraagt nu actief om een lijst met reisopties, gefilterd volgens de gekozen strategie.
- → `filterReisopties()`

### 3. Service haalt alle opties op
- De `ReisplannerService` roept de database aan om alle beschikbare reisopties op te halen.
- → `getReisOpties()`
- ← ontvangt: een lijst met alle reisopties

### 4. Strategie past de filter toe
- De gekozen strategie (zoals `GoedkoopsteStrategie`) wordt toegepast op de lijst.
- → `selecteer(opties)`
- ← ontvangt: de gefilterde lijst met reisopties

### 5. Gebruiker krijgt het resultaat
- De backend stuurt de gefilterde opties terug naar de gebruiker.
- → HTTP Response: `gefilterdeOpties`

---

## Waarom dit zo is opgezet

- **Duidelijke volgorde**: Door het sequence diagram zie je precies wie wat doet, in welke volgorde.
- **Losse verantwoordelijkheden**: Elke stap is goed gescheiden — ophalen, strategie toepassen, resultaat terugsturen.
- **Goed uitbreidbaar**: Als je een nieuwe strategie maakt (bijv. "eco-vriendelijk"), hoef je alleen die extra stap toe te voegen in het bestaande patroon.
