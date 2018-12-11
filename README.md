# PakMan - simbad/j3d

PakMan est un projet pour notre module `M301 - Conception et Programmation Objet Avancée` de l'université. Le but final de cette implémentation de l'API simbad/j3d est de faire un pseudo-pacman simplifié.

Toutes les différentes implémentations à faire sont dans la partie [Issues](https://github.com/Kiritsu/PakMan/issues) avec les membres assignés.

## Installation

```
> git clone https://github.com/Kiritsu/PakMan.git
```

## Scripts 

Utilisateur windows ? Utilisez les scripts `build.ps1` et `run.ps1` dans le dossier `scripts` pour compiler et démarrer le programme.

## Compilation manuelle

*Assurez vous d'être dans le dossier src*

```
> mkdir ../bin
> javac -classpath "..\src;..\j3d\j3dcore.jar;..\j3d\j3dutils.jar;..\j3d\vecmath.jar" -d ../bin ../src/game/*.java
> cp -r ../levels ../bin
```

Les fichiers seront générés/copiés dans ../bin.

## Lancement manuel (fichiers déjà compilés, dans .\pakMan\bin)

*Assurez-vous d'être dans le dossier /bin.*

```
> javaw "-Djava.library.path=..\j3d\$run" -classpath "..\bin;..\j3d\j3dcore.jar;..\j3d\j3dutils.jar;..\j3d\vecmath.jar" game.PakMan "--from-script"
```

Exemple :

```
> javaw "-Djava.library.path=C:\Program Files (x86)\Java\Java3D\1.5.1\bin" -classpath "C:\Users\Allan\eclipse-workspace\pakMan\bin;C:\Program Files (x86)\Java\Java3D\1.5.1\lib\ext\j3dcore.jar;C:\Program Files (x86)\Java\Java3D\1.5.1\lib\ext\j3dutils.jar;C:\Program Files (x86)\Java\Java3D\1.5.1\lib\ext\vecmath.jar" game.PakMan "--from-script"
```

##Config.ini

Vous pouvez suivre ce fichier de configuration. (par défaut)

Changez les valeurs à droite du égal pour modifier les touches, ou le niveau par défaut. Le TEXTS, goal, est un texte compatible avec le HTML (et CSS).

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
goal=Le but du jeu est d'attraper tous les points sans se faire toucher par les robots ennemis.<br/><br/>Vous disposez de trois vies par niveau. Lorsque vous perdez, le jeu se ferme.<br/>Vous perdez une vie lorsque vous provoquez une collision avec un ennemi.<br/>À ce moment là, vous êtes retéléportés au point de départ. Le robot aussi.<br/>Les robots peuvent avoir des vitesses différentes et sont représentés en blanc.<br/><br/><br/>Le jeu a été réalisé par Allan, Gauthier et Rémi.<br/><br/>
```

## Description du jeu
Le jeu a pour but de reprendre l'utilisation de PacMan. Pour démarrer un niveau, appuyez sur t, déplacez-vous avec z q s et d. Vous devez attraper tous les points pour passer au niveau suivant. Vous disposerez de trois vies par niveau. Si vous perdez, le jeu se termine.