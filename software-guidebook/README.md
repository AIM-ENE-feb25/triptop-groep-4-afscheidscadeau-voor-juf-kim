# Software Guidebook Triptop

## 1. Introduction
Dit software guidebook geeft een overzicht van de Triptop-applicatie. Het bevat een samenvatting van het volgende: 
1. De vereisten, beperkingen en principes. 
1. De software-architectuur, met inbegrip van de technologiekeuzes op hoog niveau en de structuur van de software. 
1. De ontwerp- en codebeslissingen die zijn genomen om de software te realiseren.
1. De architectuur van de infrastructuur en hoe de software kan worden geinstalleerd. 

## 2. Context
![contextDiagram.png](..%2Fafb%2FcontextDiagram.png)
> [!IMPORTANT]
> Werk zelf dit hoofdstuk uit met context diagrammen en een beschrijving van de context van de software.

Toelichting op de context van de software inclusief System Context Diagram:
* Functionaliteit
* Gebruikers
* Externe systemen

## 3. Functional Overview

Om de belangrijkste features toe te lichten zijn er user stories en twee domain stories gemaakt en een overzicht van het domein in de vorm van een domeinmodel. Op deze plek staat typisch een user story map maar die ontbreekt in dit voorbeeld.

### 3.1 User Stories

#### 3.1.1 User Story 1: Reis plannen

Als gebruiker wil ik een zelfstandig op basis van diverse variabelen (bouwstenen) een reis kunnen plannen op basis van mijn reisvoorkeuren (wel/niet duurzaam reizen, budget/prijsklasse, 's nachts reizen of overdag etc.) zodat ik op vakantie kan gaan zonder dat hiervoor een reisbureau benodigd is.

#### 3.1.2 User Story 2: Reis boeken

Als gebruiker wil ik een geplande reis als geheel of per variabele (bouwsteen) boeken en betalen zodat ik op vakantie kan gaan zonder dat hiervoor een reisbureau benodigd is.

#### 3.1.3 User Story 3: Reis cancelen

Als gebruiker wil ik een geboekte reis, of delen daarvan, kunnen annuleren zodat ik mijn geld terug kan krijgen zonder inmenging van een intermediair zoals een reisbureau.

#### 3.1.4 User Story 4: Reisstatus bewaren 

Als gebruiker wil ik mijn reisstatus kunnen bewaren zonder dat ik een extra account hoef aan te maken zodat ik mijn reis kan volgen zonder dat ik daarvoor extra handelingen moet verrichten.

#### 3.1.5 User Story 5: Bouwstenen flexibel uitbreiden

Als gebruiker wil ik de bouwstenen van mijn reis flexibel kunnen uitbreiden met een zelf te managen stap (bijv. met providers die niet standaard worden aangeboden zoals een andere reisorganisatie, hotelketen etc.) zodat ik mijn reis helemaal kan aanpassen aan mijn wensen.

### 3.2 Domain Story Reis Boeken (AS IS)

![Domain Story Reis Boeken AS IS](../opdracht-diagrammen/reis-boeken-asis-coursegrained_2024-06-11.egn.svg)

### 3.3 Domain Story Reis Boeken (TO BE)

![Domain Story Reis Boeken TO BE](../opdracht-diagrammen/reis-boeken-tobe-coursegrained_2024-06-11.egn.svg)

### 3.4 Domain Model

![Domain Model](../opdracht-diagrammen/Domain%20Model.png)

## 4. Quality Attributes

Voordat deze casusomschrijving tot stand kwam, heeft de opdrachtgever de volgende ISO 25010 kwaliteitsattributen benoemd als belangrijk:
* Compatibility -> Interoperability (Degree to which a system, product or component can exchange information with other products and mutually use the information that has been exchanged)
* Reliability -> Fault Tolerance (Degree to which a system or component operates as intended despite the presence of hardware or software faults)
* Maintainability -> Modularity (Degree to which a system or computer program is composed of discrete components such that a change to one component has minimal impact on other components)
* Maintainability -> Modifiability (Degree to which a product or system can be effectively and efficiently modified without introducing defects or degrading existing product quality)
* Security -> Integrity (Degree to which a system, product or component ensures that the state of its system and data are protected from unauthorized modification or deletion either by malicious action or computer error)
* Security -> Confidentiality (Degree to which a system, product or component ensures that data are accessible only to those authorized to have access)

## 5. Constraints

Ons proof of concept word gemaakt met java en springboot
 Data word overgedragen via HTTP/JSON
 De aplicatie moet een webaplicatie worden
 
> [!IMPORTANT]
> Beschrijf zelf de beperkingen die op voorhand bekend zijn die invloed hebben op keuzes die wel of niet gemaakt kunnen of mogen worden.

## 6. Principles
 
 

> [!IMPORTANT]
> Beschrijf zelf de belangrijkste architecturele en design principes die zijn toegepast in de software.


## 7. Software Architecture

###     7.1. Containers

 [!IMPORTANT]
Voeg toe: Container Diagram plus een Dynamic Diagram van een aantal scenario's inclusief begeleidende tekst.
![containerDiagram.png](..%2Fafb%2FcontainerDiagram.png)
Dit diagram is een Container Diagram van het TripTop-systeem en laat zien hoe de verschillende onderdelen (containers) van het systeem samenwerken, en hoe ze communiceren met externe systemen.

Acteur
Reiziger: De eindgebruiker van het systeem. Deze persoon stelt reizen samen, boekt accommodaties en beheert zijn reis.

Binnen het TripTop systeem
Triptop Web App (React):
Frontend van de applicatie.
Hier beheert de gebruiker zijn reis.
Stuurt via JSON/HTTPS verzoeken naar de backend.

Reisbeheer API-applicatie (Java MVC):
Backend van het systeem.
Ontvangt API-verzoeken van de frontend.
Verwerkt reisgegevens, regelt boekingen en beheert wijzigingen van de reis.

Database (PostgreSQL):
Slaat alle gebruikersdata, voorkeuren, boekingen en wijzigingen op.
Alleen toegankelijk voor de backend, niet voor de gebruiker of externe APIs.

Externe systemen (APIs)

De backend communiceert met verschillende externe APIs om gegevens op te halen of acties uit te voeren:
Bookingcom API & Airbnb API: Voor het boeken van accommodaties.

NS API, KLM API & Uber API: Voor vervoersinformatie (trein, vlucht, taxi).

TripAdvisor API: Voor bezienswaardigheden en excursies.

TheFork API & OpenTable API: Voor horecagegevens, zoals restaurants en cafés.

Google Login (OAuth 2.0): Voor authenticatie van gebruikers.Frontend van de applicatie.
Hier beheert de gebruiker zijn reis.
Stuurt via JSON/HTTPS verzoeken naar de backend.
![dynamischContainerInloggen.png](..%2Fafb%2FdynamischContainerInloggen.png)
![dynamischeContainerReisBoeken.png](..%2Fafb%2FdynamischeContainerReisBoeken.png)
###     7.2. Components
![componentDiagram.png](..%2Fafb%2FcomponentDiagram.png)![SOEX_Componentdiagram.png](..%2Fopdracht-diagrammen%2FSOEX_Componentdiagram.png)
> [!IMPORTANT]
> Voeg toe: Component Diagram plus een Dynamic Diagram van een aantal scenario's inclusief begeleidende tekst.

###     7.3. Design & Code

> [!IMPORTANT]
> Voeg toe: Per ontwerpvraag een Class Diagram plus een Sequence Diagram van een aantal scenario's inclusief begeleidende tekst.

## 8. Architectural Decision Records

> [!IMPORTANT]
> Voeg toe: 3 tot 5 ADR's die beslissingen beschrijven die zijn genomen tijdens het ontwerpen en bouwen van de software.

### 8.1. ADR-001 Keuze voor PostgreSQL als databasesysteem

**Datum:** 21-03-2025  
**Status:** Geaccepteerd

---

####  Context

Voor het TripTop-project moeten we een databasesysteem kiezen dat voldoet aan onze eisen op het gebied van:

- Data consistentie en integriteit
- Schaalbaarheid en prestaties
- Flexibiliteit in datamodellering
- Ondersteuning voor complexe queries
- Onderhoud en beheer

We hebben vier systemen vergeleken: **PostgreSQL**, **MongoDB**, **CouchDB** en **Neo4J**.

---

#### Overwogen opties

| Kracht                                | PostgreSQL | MongoDB | CouchDB | Neo4J |
|---------------------------------------|------------|---------|---------|--------|
| **Data Consistentie en Integriteit**  | ++         | 0       | 0       | +      |
| **Schaalbaarheid en Prestaties**      | 0          | +       | -       | +      |
| **Flexibiliteit in Data Modellering** | 0          | +       | +       | ++     |
| **Ondersteuning voor Complexe Query's** | ++       | ++      | -       | +      |
| **Onderhoud en Beheer**               | ++         | ++      | +       | +      |
| **Leercurve**                         | +          | +       | -       | 0      |

---

#### Beslissing

We kiezen voor **PostgreSQL** als databaseoplossing voor TripTop, op basis van de volgende overwegingen:

##### Data Consistentie en Integriteit
Voor een reisboekingssysteem is betrouwbaarheid cruciaal. PostgreSQL biedt volledige ACID-compliance, wat voorkomt dat boekingsdata verloren of corrupt raakt.

##### Ondersteuning voor Complexe Queries
Omdat TripTop veel datarelaties bevat (bijv. tussen boekingen, gebruikers, locaties, voorkeuren), is geavanceerde query-ondersteuning nodig. PostgreSQL biedt hierin robuuste SQL-functionaliteiten.

---

####  Gevolgen

#####  Voordelen
- **Betrouwbare transacties:** PostgreSQL is ACID-compliant, wat essentieel is voor betrouwbare boekingen.
- **Sterke query-ondersteuning:** Complexe data-opvragingen en analyses zijn goed mogelijk.
- **Actieve community:** Veel ondersteuning en documentatie beschikbaar.

#####  Nadelen
- **Minder flexibel bij ongestructureerde data** dan NoSQL-oplossingen.

### 8.2. ADR-002 Gebruik van Adapter Pattern met betrekking tot bezienswaardigheden


**Datum:** 31-03-2025  
**Status:** Geaccepteerd

#### Context

Het probleem waarvoor we het Adapter Pattern kunnen gebruiken is, het integreren van verschillende API's, in dit geval BookingCom en tripAdvisor. Deze API's leveren de data in verschillende formaten, waardoor het moeilijk is om de data consistent weer te gegeven binnen ons systeem.

#### Overwogen Opties

| Voordelen                                                                                                                                                              | Nadelen                                                                                                                                                                                 |
|------------------------------------------------------------------------------------------------------------------------------------------------------------------------|-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| Integratie:<br/>Het maakt integratie van verschillende API's (met verschillende data formaten) makkelijker, zonder hiervoor (veel) bestaande code te moeten aanpassen. | Complexiteit:<br/>Het verhoogt de complexiteit binnen de applicatie: voor iedere API moet ten minste één extra class worden toegevoegd.                                                 |
| Onderhoud:<br/>Het toepassen van dit patroon maakt het makkelijker om de code te onderhouden en uit te breiden.                                                        | Flexibiliteit:<br/>Het koppelen van de API's aan een interface kan de flexibiliteit beperken, maar er kan gebruik worden gemaakt van meerder adapters om dit te verhelpen.              |
| Consistentie:<br/>Het zorgt ervoor dat de data van alle bronnen in hetzelfde formaat wordt geformatteerd.                                                             | Tijd:<br/>Het kost in het begin extra tijd om dit patroon te implementeren, maar uiteindelijk kan het tijd besparen, doordat het implementeren van nieuwe API's veel eenvoudiger wordt. |

#### Besluit

We hebben besloten om dit patroon toe te passen in ons systeem, zodat we de data gestructureerd op kunnen halen, en zo makkelijker de bezienswaardigheid data op te halen.

#### Status

Geaccepteerd

#### Gevolgen

Dit patroon maakt het mogelijk om data van verschillende providers te integreren zonder hoofdfunctionaliteiten van het systeem aan te passen. Daarnaast zorgt het voor consistentie binnen de applicatie.

### 8.3. ADR-003 Waarom kiezen voor het Strategy Pattern

**Datum:** 28-03-2025  
**Status:** Geaccepteerd

---

#### Context

In TripTop willen we flexibel omgaan met keuzes van gebruikers. Denk aan dingen zoals:

- Wil de gebruiker de **goedkoopste**, **snelste** of **meest beschikbare** reisoptie?
- Moet er betaald worden via **Stripe**, **iDEAL**, of een andere provider?

Voor al die gevallen heb je verschillende strategieën om je gekozen doel te bereiken.

##### Ontwerp vraag
**"Hoe zorg je voor een zo kort mogelijke reisroute waarbij gebruik gemaakt wordt van alle bouwstenen?
Hoe zorg je ervoor dat de reisroute makkelijk aangepast kan worden als reisafstand geen issue is?"**

---

#### Overwogen Aspecten – Strategy Pattern voor Routeplanning

| Aspect                                      | Voordelen                                                                                       | Nadelen                                                                  |
|---------------------------------------------|--------------------------------------------------------------------------------------------------|---------------------------------------------------------------------------|
| **Flexibele route-optimalisatie**           | Strategieën kunnen gebaseerd zijn op o.a. tijd, afstand, beschikbaarheid of voorkeuren           | Vereist meerdere strategieklassen voor elk type logica                   |
| **Aanpasbaarheid op gebruikerswens**        | Gebruiker of systeem kan tijdens runtime bepalen welke route-logica gebruikt moet worden         | Meer logica om gebruikerskeuze om te zetten naar juiste strategie        |
| **Scheidt routeberekening van logica**      | Route-algoritmes zitten los van de rest van de business logica (Separation of Concerns)          | Kans op duplicatie als niet goed gedeeld wordt tussen strategieën        |
| **Uitbreidbaarheid met nieuwe scenario’s**  | Nieuwe soorten routevoorkeuren (bijv. “eco”, “sightseeing first”, “geen overnachtingen”) zijn makkelijk toe te voegen | Kan verwarrend worden als het aantal strategieën te groot wordt          |
| **Testbaarheid van routestrategieën**       | Elke routestrategie is zelfstandig te testen, los van UI en andere systemen                     | Afhankelijk van mockdata of simulatie voor complete route-validatie      |

---

#### Beslissing

Met deze overwegingen in gedachten gaan het strategy pattern toepassen op deze technologie.

Dit patroon is handig als je hetzelfde probleem op meerdere manieren wilt oplossen. Je stopt elke manier in een losse klasse, en je kunt makkelijk wisselen
tussen die strategieën zonder dat je de rest van de code moet aanpassen.

---

#### Wat betekent dit?

##### Voordelen

- Makkelijk uit te breiden: wil je in de toekomst een extra strategie (bijv. eco-vriendelijk reizen of iets anders raars)? Dan voeg je gewoon een nieuwe klasse toe.
- Je hoeft niet meer `if`-jes en `switch`es in te bouwen voor elk geval.
- De logica zit vanaf nu netjes los van de rest van je code.
- Je kunt het ook goed testen per strategie.

##### Nadelen

- Je gaat wat meer losse klassen hebben in je project.
- Je moet het patroon wel even snappen, anders wordt het rommelig.

---

Kortom: met Strategy kunnen we flexibel gedrag netjes organiseren, zonder dat de code een rommeltje wordt. En dat past goed bij hoe TripTop in elkaar zit.
### 8.4. ADR-004 TITLE

> [!TIP]
> These documents have names that are short noun phrases. For example, "ADR 1: Deployment on Ruby on Rails 3.0.10" or "ADR 9: LDAP for Multitenant Integration". The whole ADR should be one or two pages long. We will write each ADR as if it is a conversation with a future developer. This requires good writing style, with full sentences organized into paragraphs. Bullets are acceptable only for visual style, not as an excuse for writing sentence fragments. (Bullets kill people, even PowerPoint bullets.)

#### Context

> [!TIP]
> This section describes the forces at play, including technological, political, social, and project local. These forces are probably in tension, and should be called out as such. The language in this section is value-neutral. It is simply describing facts about the problem we're facing and points out factors to take into account or to weigh when making the final decision.

#### Considered Options

> [!TIP]
> This section describes the options that were considered, and gives some indication as to why the chosen option was selected.

#### Decision

> [!TIP]
> This section describes our response to the forces/problem. It is stated in full sentences, with active voice. "We will …"

#### Status

> [!TIP]
> A decision may be "proposed" if the project stakeholders haven't agreed with it yet, or "accepted" once it is agreed. If a later ADR changes or reverses a decision, it may be marked as "deprecated" or "superseded" with a reference to its replacement.

#### Consequences

> [!TIP]
> This section describes the resulting context, after applying the decision. All consequences should be listed here, not just the "positive" ones. A particular decision may have positive, negative, and neutral consequences, but all of them affect the team and project in the future.

### 8.5. ADR-005 TITLE

> [!TIP]
> These documents have names that are short noun phrases. For example, "ADR 1: Deployment on Ruby on Rails 3.0.10" or "ADR 9: LDAP for Multitenant Integration". The whole ADR should be one or two pages long. We will write each ADR as if it is a conversation with a future developer. This requires good writing style, with full sentences organized into paragraphs. Bullets are acceptable only for visual style, not as an excuse for writing sentence fragments. (Bullets kill people, even PowerPoint bullets.)

#### Context

> [!TIP]
> This section describes the forces at play, including technological, political, social, and project local. These forces are probably in tension, and should be called out as such. The language in this section is value-neutral. It is simply describing facts about the problem we're facing and points out factors to take into account or to weigh when making the final decision.

#### Considered Options

> [!TIP]
> This section describes the options that were considered, and gives some indication as to why the chosen option was selected.

#### Decision

> [!TIP]
> This section describes our response to the forces/problem. It is stated in full sentences, with active voice. "We will …"

#### Status

> [!TIP]
> A decision may be "proposed" if the project stakeholders haven't agreed with it yet, or "accepted" once it is agreed. If a later ADR changes or reverses a decision, it may be marked as "deprecated" or "superseded" with a reference to its replacement.

#### Consequences

> [!TIP]
> This section describes the resulting context, after applying the decision. All consequences should be listed here, not just the "positive" ones. A particular decision may have positive, negative, and neutral consequences, but all of them affect the team and project in the future.

## 9. Deployment, Operation and Support

> [!TIP]
> Zelf beschrijven van wat je moet doen om de software te installeren en te kunnen runnen.
