## Installations-Guide:
Zuerst muss die neuste Version der JavaJDK heruntergeladen werden.
Die Instruktionen auf der Website von Oracle sind sehr gut und einfach zu befolgen.
Danach wird das Shifting-Game Projekt heruntergeladen und in einem beliebigen Ordner entpackt.
Nun muss die Konsole geöffnet werden und in den Ordner navigiert werden, in dem das Projekt entpackt wurde.
Dort wird der Befehl "javac ./bin/Main.java" ausgeführt, um das Projekt zu kompilieren.
Anschließend wird der Befehl "java ./bin/Main" ausgeführt, um das Spiel zu starten.

## Code-Dokumentation:
### Main.java:
Die Main Klasse ist die Hauptklasse des Spiels. Sie enthält die Main Methode, welche das Spiel startet.
Außerdem initialisiert diese den Scanner, welcher für die Eingabe des Spielers benötigt wird.
Der Scanner wird Anschließend an die Game Klasse übergeben, welche die Eingabe des Spielers verarbeitet.
Dieser wird hier initialisiert, da er nur einmal beim Start des Spiels initialisiert werden sollte.
Dies war eine Design-Entscheidung, da das Einbringen des Scanners in der Game-Klasse zur Folge hätte, dass dieser jedes Mal neu initialisiert werden müsste, wenn das Spiel neu gestartet wird.
Das ist schwer zu implementieren, denn der wenn der jedes Mal initialisiert wird, muss er auch geschlossen werden, was auch den System.in stream schließt, welcher für die Eingabe des Spiels benötigt wird.
Würden wir den Scanner nicht schließen, könnte dies zu einem Memory-Leak führen da wir bei Neustarts immer mehr Scanner initialisieren würden, welche nicht geschlossen werden können.

### Game.java:
Die Game Klasse ist die Klasse, welche das Spiel verwaltet. 
Sie enthält die Methoden
- "start" welche das Spiel startet, 
- "input" welche die Eingabe des Spielers verarbeitet, 
- "printBoard" welche das Spielfeld ausgibt und 
- "tryAgain" welche den Spieler fragt, ob er nochmal spielen möchte und das Spiel entsprechend neu startet
- "isGameOver" wleche einen Boolean zurück gibt, welcher angibt, ob das Spiel vorbei ist oder nicht
- und "initBoardRandom" welche das Spielfeld initialisiert.
Und die Attribute
- Scanner, welcher für die Eingabe des Spielers benötigt wird
- Pitch, welcher das Spielfeld repräsentiert
- gameOver, welcher angibt, ob das Spiel vorbei ist oder nicht
- und moves, welcher die Anzahl der Züge des Spielers zählt.

- start:
Diese Methode started das Spiel, indem sie das Spielfeld initialisiert, eine Willkommensnachricht ausgibt, und den Spieler fragt ob er eine zufällige oder eine eigene Konfiguration spielen möchte.
Anschließend werden die Felder überschrieben, wenn der Spieler eine eigene Konfiguration spielen möchte.
Danach wird ein While-Loop gestarted, welcher solange läuft, bis das Spiel vorbei ist, und immer wieder "printBoard" und "input" aufruft.

- input:
Diese Methode verarbeitet die Eingabe des Spielers, indem sie erst den Spieler fragt, welches Feld er verschieben möchte, oder ob er die AI diesen Zug tätigen lassen möchte.
Wenn der Spieler die AI spielen lassen möchte, wird ein While-Loop gestarted, welcher solange läuft, bis die AI einen gültigen Zug tätigt, und schlussendlich den gültigen Zug weiter gibt.
Zieht der Spieler selbst, wird die Eingabe des Spielers verarbeitet, indem erst überprüft wird, ob die Eingabe valid ist.
Ist die Eingabe nicht valide, wird der Spieler gefragt, ob er nochmal versuchen möchte, wird die "input" Methode neu aufgerufen.
Ist die Eingabe valide, wird der Zug ausgeführt, indem die "swapFields" Methode auf dem Spielfeld aufgerufen wird.
An dieser Stelle wird die "moves" Variable um 1 erhöht, da der Spieler einen Zug getätigt hat.
Da diese Method ein Feld erwartet, und wir zum jetzigen Zeitpunkt nur den Wert des Feldes haben und nicht das Feld selbst, wird die "getFieldByValue Methode auf dem Spielfeld aufgerufen, welche das Feld zurück gibt.
Anschließend wird überprüft, ob das Spiel vorbei ist, indem jede Koordinate auf dem Spielfeld auf Ihren momentanen Wert überprüft wird und mit dem Wert verglichen wird, welcher auf dem Feld sein sollte.
Ist das Spiel vorbei, wird "gameOver" auf "Wahr" gesetzt und die "tryAgain" Methode aufgerufen.

- tryAgain: 
Diese Method gratuliert den Spieler, wenn er gewonnen hat, und fragt ihn, ob er nochmal spielen möchte.
Nach der Eingabe des Spielers wird überprüft, ob der Spieler nochmal spielen möchte, und das Spiel entsprechend neu gestartet, oder das Programm beendet.

- initBoardRandom:
Diese Methode initialisiert zuerst das Spielfeld, indem sie eine neue "Pitch" Kasse initiiert.
Schließlich wird ein Array aus 9 Integern erstellt, welches die Werte 0 bis 8 enthält.
Diese Array wird anschließend in eine List konvertiert, randomisiert und wieder in ein Array konvertiert.
Schlussendlich wird es dem Spielfeld in der "init" Methode übergeben.

- printBoard:
Diese Methode holt sich erst die momentane Konfiguration des Spielfeldes, indem sie die "getFields" auf der "Pitch" Klasse aufruft.
Danach wird ein 2 Dimensionales Array erstellt, welches die momentane Konfiguration des Spielfeldes enthält.
Schließlich werden 2 While-Loops gestartet, mit einem Kopfgesteuertem For-Loop in der mitte. 
Diese geben das Spielfeld für den Spieler aus.

### Pitch.java:
Die Pitch Klasse ist die Klasse, welche das Spielfeld repräsentiert.
Sie enthält die Methoden
- "init" welche das Spielfeld initialisiert,
- "isValidSelection" welche überprüft, ob die übergebenen Parameter einen Validen Zug darstellen,
- "swapFields" welche die Werte der übergebenen Felder vertauscht,
- "isAdjacentFields" welche überprüft, ob die übergebenen Felder benachbart sind,
- "getFields" welche die momentane Konfiguration des Spielfeldes zurück gibt,
- "getFieldByValue" welche das Feld anhand des übergebenen Wertes zurück gibt,
- "getFieldByCoordinates" welche das Feld anhand der übergebenen Koordinaten zurück gibt,
- "getAdjacentFields" welche die benachbarten Felder des übergebenen Feldes als Array zurück gibt,
- und "getEmptyField" welches das Feld mit dem Wert 0 zurück gibt.
Und die Attribute
- "fields" welche als Array alle Felder des momentanen Spielfeldes enthält,
- und "emptyField" welches das Feld mit dem Wert 0 enthält.

- init
Diese Methode initialisiert das Spielfeld, indem sie das "fields" Array mit den übergebenen Werten initialisiert.

- isValidSelection
Diese Methode überprüft, ob die übergebenen Parameter einen Validen Zug darstellen.
Dafür überprüft sie erst, ob die übergebene Auswahl innerhalb der Grenzen des Spielfeldes liegt.
Danach wird mithilfen eines For-Loops das ausgewählte Feld gesucht, und überprüft, ob es benachbart zum leeren Feld ist.
Hierfür wird die "isAdjacentFields" Methode mit dem momentan leeren Feld aufgerufen, und anschließend mit einem For-Loop überprüft, ob das momentan ausgewählte Feld dabei ist.

- swapFields
Diese Methode vertauscht den Wert den es erhalten hat, mit dem Wert des momentan leeren Feldes.

- isAdjacentFields
Diese Methode errechnet den X und Y Koordinaten Unterschied zwischen den beiden übergebenen Feldern,
und gibt dann zurück, ob diese Unterschiede 1 und 0 sind, oder 0 und 1.

- getFields
Diese Methode gibt das momentane Spielfeld als Array zurück.

- getFieldByValue
Diese Methode erstellt einen Kopfgesteuerten For-Loop, welcher das momentane Spielfeld durchgeht, und überprüft, ob der Wert des momentanen Feldes dem übergebenen Wert entspricht.
Dann wird das momentane Feld zurück gegeben.

- getFieldByCoordinates
Diese Methode erstellt einen Kopfgesteuerten For-Loop, welcher das momentane Spielfeld durchgeht, und überprüft, ob die Koordinaten des momentanen Feldes den übergebenen Koordinaten entsprechen.
Dann wird das momentane Feld zurück gegeben.

- getAdjacentFields
Diese Methode erstellt ein Array, welches die benachbarten Felder des übergebenen Feldes enthält.
Dafür wird zuerst das momentane Spielfeld geholt, und dann mit einem Kopfgesteuerten For-Loop durchgegangen.
Dabei wird überprüft, ob die Koordinaten des momentanen Feldes benachbart zum übergebenen Feld sind.

- getEmptyField
Diese Methode erstellt einen Kopfgesteuerten For-Loop, und überprüft, ob das momentane Feld den Wert 0 hat.
Wenn ja, wird das momentane Feld zurück gegeben.

### Field.java:
Die Field Klasse ist die Klasse, welche ein Feld des Spielfeldes repräsentiert.
Sie enthält die Methoden
- "init" welche das Feld initialisiert,
- "getEmpty" welche zurück gibt, ob das Feld leer ist,
- "getX" welche die X Koordinate des Feldes zurück gibt,
- "getY" welche die Y Koordinate des Feldes zurück gibt,
- "getValue" welche den Wert des Feldes zurück gibt,
- "setValue" welche den Wert des Feldes setzt,
Und die Attribute
- "isEmpty" welches angibt, ob das Feld leer ist,
- "x" welches die X Koordinate des Feldes enthält,
- "y" welches die Y Koordinate des Feldes enthält,
- und "value" welches den Wert des Feldes enthält.

- init
Diese Methode initialisiert das Feld, indem sie die übergebenen Parameter setzt.
Außerdem prüft sie, ob der Wert des Feldes 0 ist, und setzt "isEmpty" entsprechend.

- getEmpty
Diese Methode gibt zurück, ob das Feld leer ist.

- getX
Diese Methode gibt die X Koordinate des Feldes zurück.

- getY
Diese Methode gibt die Y Koordinate des Feldes zurück.

- getValue
Diese Methode gibt den Wert des Feldes zurück.

- setValue
Diese Methode setzt den Wert des Feldes und prüft, ob der Wert 0 ist, und setzt "isEmpty" entsprechend.


## Qualitätssicherung 
Um sicherzustellen, dass das Programm korrekt funktioniert, haben wir es mit verschiedenen Eingaben getestet.
Dabei haben wir uns auf die Eingabe von ungültigen Zügen konzentriert, da diese die größte Fehlerquelle darstellen.
Außerdem haben wir das Programm mit verschiedenen Eingaben getestet, um sicherzustellen, dass es nicht abstürzt.
