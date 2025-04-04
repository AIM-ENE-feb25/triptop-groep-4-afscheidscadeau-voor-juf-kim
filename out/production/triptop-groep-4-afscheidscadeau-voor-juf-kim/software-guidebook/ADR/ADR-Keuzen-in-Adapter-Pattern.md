# ADR-00N Gebruik van Adapter Pattern met betrekking tot bezienswaardigheden

31/03/2025

## Context

Het probleem waarvoor we het Adapter Pattern kunnen gebruiken is, het integreren van verschillende API's, in dit geval BookingCom en tripAdvisor. Deze API's leveren de data in verschillende formaten, waardoor het moeilijk is om de data consistent weer te gegeven binnen ons systeem.

## Overwogen Opties

| Voordelen                                                                                                                                                              | Nadelen                                                                                                                                                                                 |
|------------------------------------------------------------------------------------------------------------------------------------------------------------------------|-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| Integratie:<br/>Het maakt integratie van verschillende API's (met verschillende data formaten) makkelijker, zonder hiervoor (veel) bestaande code te moeten aanpassen. | Complexiteit:<br/>Het verhoogt de complexiteit binnen de applicatie: voor iedere API moet ten minste één extra class worden toegevoegd.                                                 |
| Onderhoud:<br/>Het toepassen van dit patroon maakt het makkelijker om de code te onderhouden en uit te breiden.                                                        | Flexibiliteit:<br/>Het koppelen van de API's aan een interface kan de flexibiliteit beperken, maar er kan gebruik worden gemaakt van meerder adapters om dit te verhelpen.              |
| Consistentie:<br/>Het zorgt ervoor dat de data van alle bronnen in hetzelfde formaat wordt geformatteerd.                                                             | Tijd:<br/>Het kost in het begin extra tijd om dit patroon te implementeren, maar uiteindelijk kan het tijd besparen, doordat het implementeren van nieuwe API's veel eenvoudiger wordt. |

## Besluit

We hebben besloten om dit patroon toe te passen in ons systeem, zodat we de data gestructureerd op kunnen halen, en zo makkelijker de bezienswaardigheid data op te halen.

## Status

Geaccepteerd

## Gevolgen

Dit patroon maakt het mogelijk om data van verschillende providers te integreren zonder hoofdfunctionaliteiten van het systeem aan te passen. Daarnaast zorgt het voor consistentie binnen de applicatie.
