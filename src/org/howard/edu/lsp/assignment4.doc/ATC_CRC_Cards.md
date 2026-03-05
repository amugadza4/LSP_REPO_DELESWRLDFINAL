# Assignment 4 CRC CARDS
**Ropafadzo Mugadza**
**March 5, 2026**



CRC Card

Class: Transponder

Responsibilities:
- Encode aircraft type and flight data (altitude, speed, heading, position) into high-density packets
- Broadcast encoded packets continuously to the ground station
- Maintain and update outgoing data with the latest sensor readings

Collaborators (if any):
- GroundStation

Assumptions (if any):
- Each aircraft is equipped with exactly one transponder; the broadcast packet format is standardized.



CRC Card

Class: GroundStation

Responsibilities:
- Receive high-density packets transmitted by aircraft transponders
- Pass received packets to PacketDecoder for unpacking
- Forward decoded flight records to AircraftDatabase for storage

Collaborators (if any):
- Transponder
- PacketDecoder
- AircraftDatabase

Assumptions (if any):
- The ground station maintains continuous radio contact with all aircraft within the airport airspace.



CRC Card

Class: PacketDecoder

Responsibilities:
- Parse raw binary packet structure into named data fields
- Convert raw sensor values into standard engineering units (e.g., feet, knots, degrees)
- Flag and report malformed or incomplete packets as decoding errors

Collaborators (if any):
- GroundStation
- FlightRecord

Assumptions (if any):
- A single fixed high-density packet format is used; format versioning is out of scope.



CRC Card

Class: FlightRecord

Responsibilities:
- Store a single aircraft's current flight data (aircraft type, altitude, speed, heading, position)
- Update stored field values when new decoded data is received
- Provide read access to individual data fields for display and query purposes

Collaborators (if any):
- AircraftDatabase
- PacketDecoder

Assumptions (if any):
- One FlightRecord exists per aircraft; created on first contact and removed when the aircraft leaves airspace.



CRC Card

Class: AircraftDatabase

Responsibilities:
- Store and index all active FlightRecord objects by unique aircraft identifier
- Update an existing FlightRecord when new data arrives from GroundStation
- Retrieve a specific FlightRecord by aircraft identifier in response to a controller query
- Provide the complete set of current FlightRecords to DisplayManager and SafetyAnalyzer
- Remove FlightRecords for aircraft that have departed the airspace

Collaborators (if any):
- FlightRecord
- GroundStation
- DisplayManager
- SafetyAnalyzer
- ControllerInterface

Assumptions (if any):
- The database is maintained entirely in memory for real-time performance; persistence is out of scope.



CRC Card

Class: DisplayManager

Responsibilities:
- Retrieve the full set of current FlightRecords from AircraftDatabase every 10 seconds
- Obtain the list of flagged aircraft from SafetyAnalyzer before each refresh
- Instruct RadarDisplay to render updated aircraft positions and flight data
- Instruct RadarDisplay to apply visual alerts for flagged aircraft

Collaborators (if any):
- AircraftDatabase
- SafetyAnalyzer
- RadarDisplay

Assumptions (if any):
- The display refresh cycle is timer-driven at a fixed 10-second interval.



CRC Card

Class: RadarDisplay

Responsibilities:
- Render aircraft symbols at their correct geographic positions on screen
- Display flight data labels (callsign, altitude, speed) next to each aircraft symbol
- Apply visual alerts (color change, flashing) to aircraft flagged as dangerous
- Redraw the full display each time updated scene data is received from DisplayManager

Collaborators (if any):
- DisplayManager

Assumptions (if any):
- RadarDisplay is a passive rendering surface; all decisions about what to show are made by DisplayManager.



CRC Card

Class: SafetyAnalyzer

Responsibilities:
- Retrieve all current FlightRecords from AircraftDatabase for analysis
- Calculate projected flight paths based on each aircraft's current speed, heading, and altitude
- Detect potential collision conflicts between pairs of aircraft within a defined safety threshold
- Detect minimum safe altitude violations for individual aircraft
- Notify AlertSystem with the identities of aircraft involved in any detected dangerous situation

Collaborators (if any):
- AircraftDatabase
- FlightRecord
- AlertSystem

Assumptions (if any):
- Safety analysis runs once per 10-second update cycle; continuous real-time analysis is out of scope.



CRC Card

Class: AlertSystem

Responsibilities:
- Receive danger notifications from SafetyAnalyzer with involved aircraft identifiers
- Generate audible and visual alerts at the controller workstation
- Log each alert event with a timestamp and the identifiers of affected aircraft
- Dismiss an alert when the corresponding danger condition has been resolved

Collaborators (if any):
- SafetyAnalyzer
- ControllerInterface

Assumptions (if any):
- Alert acknowledgment by the controller is recorded but does not suppress continued safety analysis.



CRC Card

Class: ControllerInterface

Responsibilities:
- Accept query input from the air traffic controller (e.g., aircraft identifier or callsign)
- Request the matching FlightRecord from AircraftDatabase and display its details
- Present active alerts received from AlertSystem to the controller
- Provide a readable summary of any queried aircraft's current flight data

Collaborators (if any):
- AircraftDatabase
- AlertSystem

Assumptions (if any):
- The controller interacts via a single workstation terminal; simultaneous multi-user access is out of scope.

