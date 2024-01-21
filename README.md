# l2s4-projet-2024

Vous devez *forker* ce projet dans votre espace de travail Gitlab (bouton `Fork`) et vidéo sur le [portail](https://www.fil.univ-lille.fr/portail/index.php?dipl=L&sem=S4&ue=Projet&label=Documents)
Un unique fork doit être réalisé par équipe.

Une fois cela réalisé, supprimer ces premières lignes et remplissez les noms des membres de votre équipe.
N'oubliez pas d'ajouter les autres membres de votre équipe aux membres du projet, ainsi que votre enseignant·e (statut Maintainer).

# Equipe

- Ali KERBOUS
- Duc NGUYEN
- Mazen KALAKECH
- Stéphane  BOUDIER

# Sujet

[Le sujet 2024](https://www.fil.univ-lille.fr/~varre/portail/l2s4-projet/sujet2024.pdf)

# Livrables

## Livrable 1

### Atteinte des objectifs

### Difficultés restant à résoudre

## Livrable 2

### Atteinte des objectifs

### Difficultés restant à résoudre

## Livrable 3

### Atteinte des objectifs

### Difficultés restant à résoudre

## Livrable 4

### Atteinte des objectifs

### Difficultés restant à résoudre

# Journal de bord

## Semaine 1

Lors de cette première semaine nous avons réfléchi à l'implémentation du plateau et des cases pour en arriver à cette version (non définitif) : 

![UML V1] (./Images/CaseUML.png "UML case plateau V1")

Nous réfléchissons à l'implémentation des portes et avons deux approches :
1. générer quatre portes dans chaque salle puis faire correspondre les portes adjacentes. Selon on l'on veut se déplacer ("nord", "sud", "est", "ouest") on vérifie la case correspondante en lui donnant une variable `room` (si c'est une salle) et `null` (si elle n'existe pas / c'est un bord). Donc pour un immeuble de taille $n\times m$, nous avons : $n\times m \times 4$ portes.
2. Crée une classe `Door` ayant deux attributs `caseA` `caseB` étant des pièces (les deux pièces séparant la porte), et un booléen `isOpen`. Lors de la création d'une case on peut imaginer une méthode `addDoor(c neighbourCase)`

## Semaine 2

## Semaine 3

## Semaine 4

## Semaine 5

## Semaine 6

## Semaine 7

## Semaine 8

## Semaine 9

## Semaine 10

## Semaine 11

## Semaine 12
