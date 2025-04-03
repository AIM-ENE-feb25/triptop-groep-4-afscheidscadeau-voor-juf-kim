# Toepassing van Design Principles in Strategy Pattern (TripTop)

Deze reflectie is gebaseerd op de gekozen **ontwerpvraag**:

>"Hoe zorg je voor een zo kort mogelijke reisroute waarbij gebruik gemaakt wordt van alle bouwstenen? Hoe zorg je ervoor dat de reisroute makkelijk aangepast kan worden als reisafstand geen issue is?"_

Om deze vraag op een flexibele en uitbreidbare manier aan te pakken, is gekozen voor het **Strategy Pattern**. 
Deze aanpak maakt het mogelijk om verschillende logica (zoals snelste, goedkoopste, of meest beschikbare reisoptie) dynamisch toe te passen. 
In deze tekst bekijken we welke **design principes** uit de lessen zijn toegepast in dit patroon en hoe goed deze aansluiten bij de architectuur van TripTop.

Binnen de Strategy Pattern-implementatie voor TripTop zijn meerdere belangrijke designprincipes uit de lijst correct en bewust toegepast. 
Hieronder volgt een overzicht van de belangrijkste principes en hoe deze in de praktijk zijn terug te zien:

---

### Encapsulate What Varies (EWV)
De logica voor het selecteren van een reisoptie (bijv. snelste, goedkoopste of meest beschikbare) is geëncapsuleerd in aparte strategieklassen. 
Deze logica verschilt per strategie, en door dit te encapsuleren in losse componenten is de rest van het systeem stabiel en herbruikbaar gebleven.

---

### Composition Over Inheritance (COI)
In plaats van te erven van een basisklasse, gebruikt `ReisplannerService` **compositie** om een `SelectieStrategie` in te voegen. 
Dit maakt het systeem flexibeler en losser gekoppeld. 
Je kunt op runtime strategieën wisselen, wat niet mogelijk zou zijn met een vaste overervingstructuur.

---

### Program to Interfaces, Not Implementations
De service (`ReisplannerService`) programmeert tegen de interface `SelectieStrategie` en niet tegen de concrete implementaties zoals `GoedkoopsteStrategie`. 
Hierdoor is de logica losgekoppeld van implementatiedetails en eenvoudig vervangbaar of uitbreidbaar.

---

### Single Responsibility Principle (SRP)
Elke klasse in het systeem heeft één duidelijke verantwoordelijkheid:
- `ReisplannerService`: gebruikt een strategie om reisopties te filteren.
- `SnelsteStrategie`, `GoedkoopsteStrategie`, etc.: bepalen hoe er gefilterd wordt.
- `ReisOptie`: bevat alleen reisgegevens.
- `ReisPlannerController`: handelt HTTP-verzoeken af.

---

### Open Closed Principle (OCP)
Het systeem is open voor uitbreiding (nieuwe strategieën kunnen worden toegevoegd), 
maar gesloten voor modificatie (bestaande code hoeft hiervoor niet aangepast te worden). 
Nieuwe strategieën implementeren gewoon `SelectieStrategie`.

---

### Dependency Inversion Principle (DIP)
`ReisplannerService` is afhankelijk van de abstractie `SelectieStrategie`, en niet van de concrete klassen. 
Dit vermindert afhankelijkheden en verhoogt flexibiliteit.

---

### Liskov Substitution Principle (LSP), Interface Segregation Principle (ISP)
Deze principes zijn minder relevant in deze specifieke context:
- LSP is impliciet toegepast: alle strategieën zijn vervangbaar via polymorfisme, zonder fouten.
- ISP is niet echt aan de orde, aangezien `SelectieStrategie` een simpele interface is met slechts één methode.

---

## Conclusie

Hiermee heb ik aangetoont dat de meeste relevante design principes uit de lijst correct en bewust zijn toegepast in het project. 
Dit draagt bij aan een flexibele, uitbreidbare en onderhoudbare architectuur, dat past bij de context van TripTop.
