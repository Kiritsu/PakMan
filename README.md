# ATTENTION ! IL EST PREFERABLE DE LIRE CE FICHIER DEPUIS GITHUB : https://github.com/Kiritsu/pakMan/blob/master/README.md

# PakMan - simbad/j3d

PakMan est un projet pour notre module `M301 - Conception et Programmation Objet Avancée` de l'université. Le but final de cette implémentation de l'API simbad/j3d est de faire un pseudo-pacman simplifié.

Toutes les différentes implémentations à faire sont dans la partie [Issues](https://github.com/Kiritsu/PakMan/issues) avec les membres assignés.

Vous avez un historique des modifications du programme ici : [Commits](https://github.com/Kiritsu/pakMan/commits/master)

L'utilisation du jeu est recommandée sur une résolution `1920*1080` mais possible avec des résolutions plus basses `800*600`

## Installation

```
> git clone https://github.com/Kiritsu/PakMan.git
```

## Scripts 

Utilisateur windows ? Utilisez les scripts `build.ps1` et `run.ps1` dans le dossier `scripts` pour compiler et démarrer le programme.
Utilisateur linux/mac ? Il faut malheureusement passer par eclipse pour lancer le programme, il semblerait qu'il y ait des problèmes avec J3D avec notre .jar. Cependant, vous pouvez essayer les commandes ci-dessous.

## Compilation manuelle

*Assurez vous d'être dans le dossier src*

```
> mkdir bin
> javac -classpath ".\src;.\j3d\j3dcore.jar;.\j3d\j3dutils.jar;.\j3d\vecmath.jar;.\" -d ./bin ./src/game/*.java
> cp -r levels ./bin
```

Les fichiers seront générés/copiés dans ../bin. On précise notre classpath contenant les librairies j3d.

## Lancement manuel (fichiers déjà compilés, dans .\pakMan\bin)

*Assurez-vous d'être dans le dossier /bin.*

```
> javaw "-Djava.library.path=..\" -classpath "..\bin;..\j3d\j3dcore.jar;..\j3d\j3dutils.jar;..\j3d\vecmath.jar" game.PakMan "--from-script"
```

##Config.ini

Vous pouvez suivre ce fichier de configuration. (par défaut)

Changez les valeurs à droite du égal pour modifier les touches, ou le niveau de départ par défaut. Le TEXTS, goal, est un texte compatible avec le HTML (et CSS).

```ini
[KEYS]
start=t
up=z
down=s
left=q
right=d
[GAME_CONFIG]
level=1
[TEXTS]
goal=Le but du jeu est d'attraper tous les points sans se faire toucher par les robots ennemis.<br/><br/>Vous disposez de trois vies par niveau. Lorsque vous perdez vos trois vies, le jeu se ferme.<br/>Vous perdez une vie lorsque vous provoquez une collision avec un ennemi.<br/>À ce moment là, vous êtes retéléportés au point de départ. Le robot aussi.<br/>Les robots peuvent avoir des vitesses différentes et sont représentés en blanc.<br/><br/><br/>Le jeu a été réalisé par Allan, Gauthier et Rémi.<br/><br/>
```

Par exemple, si vous souhaitez utiliser la touche `o` pour lancer le jeu, il faut donc remplacer `start=t` par `start=o`. /!\ Attention, il n'est pas possible d'utiliser les flèches directionnelles ou les touches comme espace, et les touches qui n'ont pas d'output visuels.

## Les niveaux

Vous pouvez créer vos propres niveaux. Si nous avions eu un peu plus de temps, nous aurions fait un "créateur" de niveau. Mais voici une explication :

* W 11 0 0 22 1 1
Représente un mur, aux coordonnées X 11, Y 0, Z 0. Le mur fait une longueur de 22 et une hauteur de 1. Le dernier paramètre, 1, ici, est un booleen qui indique si nous devons faire une rotation de l'objet de 90 degrés.

* PAK 0 0 0
Représente notre personnages, aux coordonnées X 0, Y 0 et Z 0.

* GHOST 4 0 4 6
Représente un ennemi, aux coordonnées X 4, Y 0, Z 4. Le dernier nombre représente la vitesse (fixe) de l'ennemi.

* P 2.71 0 -3.2 1
Représente un point, aux coordonnées X 2.71, Y 0, Z -3.2. Le dernier chiffre représente un booleen qui indique si le point est un "gros" point bonus ou non. Ce n'est pas implémenté, mais un gros point est censé nous donnez un court lapse de temps d'invincibilité.

Nous gérons d'autres types de structures, mais l'API de simbad les gère assez mal.

**Vos niveaux doivent être nommés de 1 à +inf .txt `1.txt`, `2.txt`, etc. et doivent être placés dans le dossier `levels`

## Description du jeu

Le jeu a pour but de reprendre l'utilisation de PacMan. Pour démarrer un niveau, appuyez sur `t`, déplacez-vous avec `z` `q` `s` et `d`. Vous devez attraper tous les points pour passer au niveau suivant. Vous disposerez de trois vies par niveau. Si vous perdez, le jeu se termine.

## Analyse du code

La quasi-totalité de notre code est contenue dans le package [game](https://github.com/Kiritsu/pakMan/tree/master/src/game)

* NoLevelFrame.java : représente une frame spéciale qui est créée lorsqu'il n'y a plus de niveaux disponibles.
* PakConfiguration.java : classe qui sert à parser le fichier de configuration (donc les touches, le niveau de départ, les textes)
* PakCustomWindow.java : cette classe permet de gérer les panels/labels qui contiennent l'affichage de points, des vies, et des règles.
* PakEnvironment.java : cette classe permet d'initialiser l'environnement, celui qui va contenir tous les points, les robots, etc.
* PakEnvironmentParser.java : cette classe permet de lire les fichiers de niveaux (voir **Les niveaux**)
* PakGhostRobot.java : représente un ennemi. Il n'y a qu'un seul type d'ennemi, si nous voudrions en ajouter, il faudrait qui hérite de `Agent` et ajouter ce nouveau robot au parser.
* PakLevel.java : représente un niveau. C'est une classe centrale. Si nous avions eu le temps, nous aurions utilisé un système d'injections de dépendances pour éviter à avoir à faire nous même nos classes, et à les étendre à travers les autres classes. Cette classe contrôle le score, la vie, la création de l'environnement, de la frame, des listeners, du thread.
* PakListener.java : si nous l'avions voulu, nous aurions pu avoir autant de joueur que nous le voulons, le PakListener sert à controler un robot passé en paramètres (dans le ctor) grâce aux touches de clavier.
* PakMan.java : représente notre classe avec main. Celle-ci initialise la configuration (`PakConfiguration`) et le niveau (`PakLevel`).
* PakRobot.java : représente un joueur. Il est possible de changer sa vitesse, de changer sa direction en fonction de la configuration.
* PakThreading.java : workaround concernant le focus de la frame. Nous étions confrontés à un problème pour intercepter les touches de clavier pressées. Notre workaround est un thread qui demande le focus de la frame 4 fois par secondes.

## Nos objectifs complémentaires

Si nous avions eu le temps, nous aurions voulu mettre en place une petite intelligence au niveau des ennemis, pouvoir avoir des bonus grace aux "gros" points, jouer en multi-joueur (celà requiert d'adapter la configuration et son parser). Et encore en plus, un tableau de scores, puisque certains niveaux sont difficiles. Et pour aller plus loin, la création automatique de niveaux.
