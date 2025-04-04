### 8.2. ADR-002 Gebruik van Adapter Pattern met betrekking tot bezienswaardigheden

**Datum:** 31-03-2025  
**Status:** Geaccepteerd

#### Context

We willen de adapter pattern gebruiken om de volgende ontwerpvragen te beantwoorden: 
* Hoe zorg je ervoor dat je bij een wijziging in de datastructuur van een externe service niet de hele applicatie hoeft aan te passen?
* Hoe zorg je ervoor dat je makkelijk een nieuwe externe service kan toevoegen? 

In dit geval om BookingCom en tripAdvisor te integreren. Deze API's leveren de data in verschillende formaten, waardoor het moeilijk is om de data
consistent weer te gegeven binnen ons systeem.

Daarnaast maakt dit ook gebruik van de volgende design principes: 
Single Responsibility Principle (SRP) 

* De adapter pattern isoleert de interactie tussen de verschillende API's. Door deze elk een eigen Adapter klasse te geven.
* Deze isolering zorgt ervoor dat alleen deze klasse hoeven worden aangepast als er veranderingen zijn aan de API.
  
Interface Segregation Principle (ISP)
* De Adapter interface voor bezienswaardigheden defineert alleen de benodigde methodes, dit zorgt ervoor dat klasse die dit implementeren geen irrelevant functionaliteiten hoeven te ondersteunen. 

 Open/Closed Principle (OCP)
 * Het adapter pattern zorgt ervoor dat er makkelijk nieuwe externe services kunnen worden toegevoegd zonder hiervoor een groot deel bestaande code te hoeven aanpassen.
#### Overwogen Opties

| Voordelen                                                                                                                                                              | Nadelen                                                                                                                                                                                 |
|------------------------------------------------------------------------------------------------------------------------------------------------------------------------|-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| Integratie:<br/>Het maakt integratie van verschillende API's (met verschillende data formaten) makkelijker, zonder hiervoor (veel) bestaande code te moeten aanpassen. | Complexiteit:<br/>Het verhoogt de complexiteit binnen de applicatie: voor iedere API moet ten minste één extra class worden toegevoegd.                                                 |
| Onderhoud:<br/>Het toepassen van dit pattern maakt het makkelijker om de code te onderhouden en uit te breiden.                                                        | Flexibiliteit:<br/>Het koppelen van de API's aan een interface kan de flexibiliteit beperken, maar er kan gebruik worden gemaakt van meerder adapters om dit te verhelpen.              |
| Consistentie:<br/>Het zorgt ervoor dat de data van alle bronnen in hetzelfde formaat wordt geformatteerd.                                                              | Tijd:<br/>Het kost in het begin extra tijd om dit pattern te implementeren, maar uiteindelijk kan het tijd besparen, doordat het implementeren van nieuwe API's veel eenvoudiger wordt. |

#### Beslissing

We hebben besloten om dit pattern toe te passen in ons systeem, zodat we de data gestructureerd op kunnen halen, en zo
makkelijker de bezienswaardigheid data op te halen.

#### Status

Geaccepteerd

#### Gevolgen

Dit pattern maakt het mogelijk om data van verschillende providers te integreren zonder hoofdfunctionaliteiten van het
systeem aan te passen. Daarnaast zorgt het voor consistentie binnen de applicatie.