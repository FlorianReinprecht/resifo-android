<img align="right" src="app/src/main/res/drawable/ic_launcher.png" />
# Meldezettel Österreich
Diese App wurde im Rahmen eines Studienprojekts der Lehrveranstaltung "Software Engineering Basic" vom Studiengang "Informationsmanagement" an der [FH Joanneum GmbH](http://fh-joanneum.at/) realisiert.

## Inhaltsverzeichnis
1. [Beschreibung](#beschreibung)
2. [Voraussetzungen](#voraussetzungen)
3. [Versionsverlauf](#versionsverlauf)
4. [Entwicklungsdetails](#entwicklungsdetails)
5. [Beteiligte](#beteiligte)
6. [Lizenz](#lizenz)

## Beschreibung
Es handelt sich um eine Android App, bei der das [Meldezettel-Formular](http://www.graz.at/cms/dokumente/10024916/e05a999a/Meldezettel.pdf) des Landes Österreich ausgefüllt und gespeichert werden kann. Der Fokus liegt auf einem simplen Design, einer übersichtlichen Bedienung und einem sinnvollen Funktionsumfang. Es besteht die Möglichkeit, mehrere unterschiedliche Formulare abzuspeichern, deren Details bei Bedarf zu betrachten und zuvor gespeicherte Datensätze zu löschen.

| Startbildschirm | Eintragung der Daten | Übersicht der Datensätze |
|:-------------:|:-------------:|:-----:|
| ![Startbildschirm](/images/welcomescreen.png "Startbildschirm") | ![Eintragung der Daten](/images/persdata.png "Eintragung der Daten") | ![Datenübersicht](/images/dataoverview.png "Datenübersicht") |

## Voraussetzungen
Diese App wurde für Android 5.1 "Lollipop" (API Level 22) und höher entwickelt. Auf niedrigeren Android Versionen könnte es zu Fehlern bei der Ausführung kommen.

## Versionsverlauf
#### 2017-02-06 - Version 1.0 - erste Veröffentlichung

## Entwicklungsdetails
Zur Entwicklung wurden Android Studio 2.2.3 und Gradle 2.14.1 mit der Programmiersprache Scala 2.11.7 genutzt. Um die App in Scala umzusetzen, wurde auf das [gradle-android-scala-plugin](https://github.com/rladstaetter/gradle-android-scala-plugin) zurückgegriffen.

Genauere Informationen bezüglich des Aufbaus und der internen Funktionsweise der App befinden sich in den Code-Kommentaren.

## Beteiligte
Folgende Studierende waren an der Umsetzung des Projekts beteiligt:
* Agnesa Haxha
* Andreas Krejan
* Dominik Krüger
* Florian Reinprecht

## Lizenz
[GNU GPLv3](LICENSE.txt)
