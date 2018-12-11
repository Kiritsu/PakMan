mkdir ../bin
javac -classpath "..\src;..\j3d\j3dcore.jar;..\j3d\j3dutils.jar;..\j3d\vecmath.jar" -d ../bin ../src/game/*.java
cp -r ../levels ../bin

