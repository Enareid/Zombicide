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
- L'UML pour ce livrable est disponible dans le compte rendu de la semaine 3
- Le plateau se génére aléatoirement, en respectant les règles du jeu. La taille du plateau est demandé au joueur.

Un Makefile est mis a disposition avec les commandes suivante :
- `make` qui va lancer le "jeu" en créeant automatiquement le .jar 
- `make compile` : qui va compiler toutes les classes présentes
- `make jar` : qui va crée le jar
- `make run` : qui va exécuté le jar 
- `make test` : qui va exécuté les test
- `make doc` : qui va généré la doc
- `make clean` : supprimant les dossier doc et classes

### Difficultés restant à résoudre
- Théoriquement nous devrons encore touché a la fonction `Board` lorsque'on aura réussi a implémenté les portes

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


![UML V1](Images/CaseUML.png "UML case plateau V1")

Nous réfléchissons à l'implémentation des portes et avons deux approches :
1. générer quatre portes dans chaque salle puis faire correspondre les portes adjacentes. Selon on l'on veut se déplacer ("nord", "sud", "est", "ouest") on vérifie la case correspondante en lui donnant une variable `room` (si c'est une salle) et `null` (si elle n'existe pas / c'est un bord). Donc pour un immeuble de taille $n\times m$, nous avons : $n\times m \times 4$ portes.
2. Crée une classe `Door` ayant deux attributs `caseA` `caseB` étant des pièces (les deux pièces séparant la porte), et un booléen `isOpen`. Lors de la création d'une case on peut imaginer une méthode `addDoor(c neighbourCase)`

## Semaine 2

### Notes de la seconde séance de projet

#### Implémentation des cases 

##### 1. La classe `Building`
Il faut oublier l'idée des classes `drugstore` et `Continental` héritant de la classe building car cela posse un problème lors de la création, en effet les pièces étant dans un immeuble mais n'ayant rien de spécial ne peuvent pas être représenté. Nous faisons donc le chois d'avoir trois classes `DrugStore` `Continental` et `Building` représentant des pièces et héritant de la classe  `Case`.
On oublie donc les attributs `longueur` et `largeur` pour la classe building 
##### 2. Les portes
Nous avons pris le choix de générer quatre portes de classe `Door` pour chaque pièce (`Building`, `DrugStore` et `Continental`) cela rend l'implémentation plus simple et ne crée pas de porte entre les routes. Lorsque on essaye de passer d'une pièce a l'autre on utilisera les points cardinaux (NORD, SUD, EST, OUEST) et lorsque l'on veut passer de la porte A vers B : A -> B Il faudra donc vérifier la porte Est de A puis la porte Ouest de B Ce qui nous donne les quartes tuples suivants :
- Nord - Sud
- Sud - Nord
- Est - Ouest
- Ouest - Est
##### 3. Le cas SewerDrain
Pour la bouche d'égouts nous supprimons la classe `SewerDrain` et optons sur un booléen `canSpawn` présent dans la classe `Street` permettant de savoir si une case représentant une rue peut ou non faire apparaître des zombie, si oui la classe utilisera la méthode `Spawn()` permettant de faire apparaître des zombie, l'affichage de la case en sera impactée.
##### 4. L'affichage
Pour l'affichage nous réfléchissons a une implémentation du style `public static final char y = ~~~` que l'on pourra appeler a chaque fois que la case x et de type y.
#### Algorithme de création du plateau 

##### Comment défini t-on un plateau ?
Le plateau est composée de route et d'immeuble dont voici les contraintes :
- Une route est forcément de largeur 1
- Les deux première route vont d'un bord a l'autre en se croisant
- Les immeubles sont de taille minimum $2\times 2$ et max ?
- Les routes ne peuvent pas longer les bords
- Les immeubles ne peuvent pas longer les bords
- Deux immeubles distinct ne sont forcément séparé par une route
##### Comment le crée ?
Pour les deux premières routes nous savons que pour un plateau de taille $n\times m$ nous avons la première route qui part de la case $(i, 0)\text{ avec } 2\leq i\leq n-2$ jusqu'à la case $(i, m)$. Il en va de même pour la deuxième route qui part de la case $(0, j) \text{ avec } 2 \leq j \leq m-2$ jusqu'à $(n,j)$ 

Il nous semble logique de crée les routes puis de définir comme immeuble tous ce qui n'est pas une route.


## Semaine 3

Lors de cette séance nous avons revu la conception expliqué lors de la semaine 2. La case Building (maintenant appelé `BuildingCell`) est de nouveau d'actualité. En effet cette classe est devenue une case building simple et les case continental et drug store (respectivement `ContinentalCell` et `DrugStoreCell`) héritent de nouveau de Building. 

Nous nous somme concentré sur l'algorithme de création de plateau avec, dans un premier temps, l'affichage du TrainingBoard qui semble plus simple car posséde des cases prédéfinie. Nous nous sommes rendu compte d'un problème majeurs : comment afficher le plateau. Actuellement deux idées s'offre a nous :
1. Afficher ligne par ligne 
2. Afficher cases pasr cases

Dans un premier temps il nous fallait savoir si l'on faisait une méthode `toString()` dans la classe building qui vérifiant le type de la casses et agissait en consécance ou si l'on métait des méthode `toString()` au sein de chaque classes Cell qui va donc gérer lui même l'affichage de sa case. Nous avons finalement otpé pour la deuxième solution, qui nous semble plus lisible et abordable.

Voici le diagramme UML a la fin de cette séance :
![UMLS3](Images/UMLS3.png "UML a la fin de la troisième séance")


#### Maj dimanche 4 février 2024

Nous sommes vers la fin du premier livré.

**Méthodes `toString()` :**
Nous avons implémenté une méthode `toString()` dans chaque cells, ces méthodes nous assure d'avoir une chaîne de caractère à la fin contenant 6 caractères exactement de la forme "Tzn sn" avec :
- T le type de la case.
- zn le nombre de zombie.
- sn le nombre de survivant.

Toutes ces méthode `toString()` sont appelée dans la méthode `toString()` de la classe Board : en créant premièrement la première ligne de "-" représentant les murs supérieurs, puis pour chaque ligne, on ajoute une porte "|" si besoin puis les infos qui nous intéressent. On récupère les info grâce `toString().substring()` des cells.

**Algorithme de création du plateau :**
Pour créer un plateau aléatoire, on utilise trois méthodes. Le constructeur board qui va remplir le plateau de `BuildingCell()` ensuite la méthode récursive `fillBoard()` va rajouter les street en commençant avec le plateau de base. On aura deux ligne de street traversant le plateau de part et d'autre, ensuite on rappelle la fonction avec les quatre nouveaux minis plateaux puis on réitère jusqu'à ce qu'on ne puisse plus crée de street, dans notre cas, lorsque la longueur ou la largeur est inférieur à 5. Puis on fini avec la méthode `initBoard()` qui va prendre deux cases building aléatoire et les modifié en `ContinentalCell()` ou `DrugStoreCell()`.

Voici à quoi ressemble notre diagramme à la fin de cette troisième semaine :
![UMLFinS3](Images/UMLFinS3.png "Le diagramme a la fin de la troisième semaine")


## Semaine 4

Lors de la séance de la quatrième semaine, nous avons premièrement réglé trois problème concernant la génération de notre plateau. 
- En effet, parfois, la création du plateau était infinie, cela était dû au code de la méthode `initBoard()` qui ne vérifiait si deux coordonnées aléatoires étaient des StreetCell, lorsque c'est le cas, on rengrenait deux coordonnées aléatoires, l'erreur venait sur le fait qu'on ne changeait pas les deux coordonnée, mais une seule.
- Le deuxième problème était du a une modification de la méthode `random.nextInt()` d'une version de Java a une autre. En effet sur nos machines, on utilisait nextInt avec deux arguments, ce qui n'existe pas sur les machines de TP, on a dû revoir notre code pour fixer ce problème.
- Le dernier problème était dû au plateau rectangulaire, ce problème étant plus complexe avec notre implémentation, on a pris la liberté d'empêcher les plateaux rectangulaires pour ne permettre que des plateaux carré.

Après avoir réglé ces problèmes, nous avons de nouveau réfléchi à l'implémentation des portes. Avec deux idées majeures :
1. Inclure des portes EST, OUEST pour toutes les coordonnées dont l'abscisse est paire. Inclure des portes NORD, SUD pour toutes les coordonnées dont l'ordonnée est paire. Avec cette implémentation pour passer d'une pièce à une autre, on vérifie si notre pièce possède une porte vers l'autre pièce ou inversement.
2. Inclure des portes vers les points cardinaux dans toutes les cases building. L'implémentation d'une méthode (`canMove()`) par exemple, renvoyant toujours True si la case est une StreetCell. Cette méthode renvoie True ou False en fonction de l'ouverture ou non de la porte dans la case BuildingCell. Pour se déplacer d'une case a une autre, on vérifie si la méthode `canMove()` de la case de départ est True puis la méthode `canMove()` de la case d'arrivé est True.

## Semaine 5

Après avoir eu un retour sur notre premier livrable, nous avons réglé les petits problèmes de conception (interdiction de faire un plateau de taille inférieur à 5). Une fois cela fait nous avons réfléchi sur l'implémentation des acteurs et des équipement sans pour l'instant réfléchir aux méthodes utiles.
Nous avons donc :
- Une classe mère `Equipement`
    - Une sous classe `Weapon`
        1. Une sous classe `Crowbar`
        2. Une sous classe `Gun`
        3. Une sous classe `Rifle`
        4. Une sous classe `Axe`
        5. Une sous classe `Chainsaw`
    - Une sous classe `Item`
        1. Une sous classe `HealingVial`
        2. Une sous classe `MasterKey`
        3. Une sous classe `FirstAidKit`
        4. Une sous classe `Map`
        5. Une sous classe `InfraredGlasses`
- Une classe mère `Entities`
    - Une sous classe `Zombie`
        1. Une sous classe `Walkers`
        2. Une sous classe `Runners`
        3. Une sous classe `Broom`
        4. Une sous classe `Abomination`
    - Une sous classe `Player`
        1. Une sous classe `Snooper`
        2. Une sous classe `Lucky`
        3. Une sous classe `Fighter`
        4. Une sous classe `Healer`

Voici l'UML à la fin de cette semain :
![UMLS5](Images/UMLS5.png "L'UML lors de la cinquième semaine")

## Semaine 6

## Semaine 7

## Semaine 8

## Semaine 9

## Semaine 10

## Semaine 11

## Semaine 12
