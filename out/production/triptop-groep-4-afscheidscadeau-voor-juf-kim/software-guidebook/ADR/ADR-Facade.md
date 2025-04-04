# ADR: Keuze voor PostgreSQL als databasesysteem

**Datum:** 21-03-2025  
**Status:**   ACCEPTED

---

##  Context

Voor het TripTop-project moeten we een databasesysteem kiezen dat voldoet aan onze eisen op het gebied van:

- Data consistentie en integriteit
- Schaalbaarheid en prestaties
- Flexibiliteit in datamodellering
- Ondersteuning voor complexe queries
- Onderhoud en beheer

We hebben vier systemen vergeleken: **PostgreSQL**, **MongoDB**, **CouchDB** en **Neo4J**.

---

## Overwogen opties

| Kracht                                | PostgreSQL | MongoDB | CouchDB | Neo4J |
|---------------------------------------|------------|---------|---------|--------|
| **Data Consistentie en Integriteit**  | ++         | 0       | 0       | +      |
| **Schaalbaarheid en Prestaties**      | 0          | +       | -       | +      |
| **Flexibiliteit in Data Modellering** | 0          | +       | +       | ++     |
| **Ondersteuning voor Complexe Query's** | ++       | ++      | -       | +      |
| **Onderhoud en Beheer**               | ++         | ++      | +       | +      |
| **Leercurve**                         | +          | +       | -       | 0      |

---

## Beslissing

We kiezen voor **PostgreSQL** als databaseoplossing voor TripTop, op basis van de volgende overwegingen:

### Data Consistentie en Integriteit
Voor een reisboekingssysteem is betrouwbaarheid cruciaal. PostgreSQL biedt volledige ACID-compliance, wat voorkomt dat boekingsdata verloren of corrupt raakt.

### Ondersteuning voor Complexe Queries
Omdat TripTop veel datarelaties bevat (bijv. tussen boekingen, gebruikers, locaties, voorkeuren), is geavanceerde query-ondersteuning nodig. PostgreSQL biedt hierin robuuste SQL-functionaliteiten.

---

##  Gevolgen

###  Voordelen
- **Betrouwbare transacties:** PostgreSQL is ACID-compliant, wat essentieel is voor betrouwbare boekingen.
- **Sterke query-ondersteuning:** Complexe data-opvragingen en analyses zijn goed mogelijk.
- **Actieve community:** Veel ondersteuning en documentatie beschikbaar.

###  Nadelen
- **Minder flexibel bij ongestructureerde data** dan NoSQL-oplossingen.