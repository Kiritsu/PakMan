# PakMan - simbad/j3d

PakMan est un projet pour notre module `M301 - Conception et Programmation Objet Avancée` de l'université. Le but final de cette implémentation de l'API simbad/j3d est de faire un pseudo-pacman simplifié.

Toutes les différentes implémentations à faire sont dans la partie [Issues](https://github.com/Kiritsu/PakMan/issues) avec les membres assignés.

## Installation

```
> git clone https://github.com/Kiritsu/PakMan.git
```

## Compilation manuelle

*Assurez vous d'être dans le dossier src*

```
> javac -sourcepath . -d ../bin game/*.java
> cp -r ../levels/ ../bin
```

Les fichiers seront générés/copiés dans ../bin.

## Lancement manuel (fichiers déjà compilés, dans .\pakMan\bin)

*Assurez-vous d'être dans le dossier /bin.*

```
> javaw "-Djava.library.path={0}" -classpath "{1};{2};{3};{4}" game.PakMan
```

- {0} : chemin vers les fichiers binaires de j3d (j3dcore-ogl.dll)
- {1} : chemin vers les fichiers binaires du projet (.\pakMan\bin)
- {2} : chemin **complet** vers j3dcore.jar
- {3} : chemin **complet** vers j3dutils.jar
- {4} : chemin **complet** vers vecmaths.jar

Exemple :

```
> javaw "-Djava.library.path=C:\Program Files (x86)\Java\Java3D\1.5.1\bin" -classpath "C:\Users\Allan\eclipse-workspace\pakMan\bin;C:\Program Files (x86)\Java\Java3D\1.5.1\lib\ext\j3dcore.jar;C:\Program Files (x86)\Java\Java3D\1.5.1\lib\ext\j3dutils.jar;C:\Program Files (x86)\Java\Java3D\1.5.1\lib\ext\vecmath.jar" game.PakMan
```