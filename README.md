Projet de simulation d'un système de transport
==============================================

Contexte
--------

Le dépôt contient un projet de simulation de transport en commun en fesant voyager différent passagers. Ce projet est codé en Java. Il a été réalisé par Augustin Gauchet, Vincent Ridacker, Vincent Carton, Nicolas Lequec, Eloi Magon de la Villehuchet et Clément Préaut.

Fonctionnalités
---

Tous les fichiers évoqués ci-dessous sont dans le répertoire `src`.

Le programme permet de simuler un transport en commun qui comprend un nombre fini de place assises et debout. Ce véhicule avance de stations en stations. Des passagers aux comportements différents peuvent monter dans le véhicule en occupant les places. Lors de leur définition, les passagers ont un numéro d'arrêt pour lequel ils souhaitent s'arrêter.

Les classes de comportement des passagers concernent leur attitudes vis-à-vis des places :
* Un `PassagerStandard.java` monte en cherchant à s'assoir ou à défaut reste debout. Il ne change pas de position pendant le trajet.
* Un `PassagerStresse.java` monte en cherchant à s'assoir ou à défaut reste debout. Il se met debout durant les 3 arrêts qui précèdent sa descente.
* Un `PassagerIndecis.java` ne monte que si il y a des places debout. A chaque arrêt, il tente d'alterner entre place assise et place debout 

De plus, deux systèmes de stockage en mémoire des événements sont mis en place :
*`CollectMemo.java` stocke dans l'éxécution du programme et affiche le bilan des actions à l'écran.
*`CollectMemo.java` stocke dans un fichier (ici simple.txt) le bilan des actions.

Un scénario standard d'éxécution est codé dans les fichiers `Simple*.java` .

Instructions
-------

* `make run` permet de compiler `Simple.java` puis d'éxécuter le programme en affichant à l'écran le déroulé du scénario.
* `make memo` effectue le même travail que `make run` sur `SimpleMemo.java` et affiche en plus le bilan des actions.
* `make file` effectue le même travail que `make run` sur `SimpleFile.java` et stocke en plus le bilan des actions dans le fichier `simple.txt`.
* `make` éxécute les trois commandes précédentes.
* `make test` permet compiler les tests et de lancer l'exécutable.
* `make clean` permet de supprimer tous les fichiers inutiles et .class des répertoires.