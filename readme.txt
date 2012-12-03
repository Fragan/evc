Importer le projet en tant que projet maven.
Configurer le "Java Build Path" avec la jdk-6 et les différents jars contenus dans le répertoire lib.

Ajouter dans le "Run Configurations" de la classe App la variable d'environnement :
LD_LIBRARY_PATH avec le path où se trouvent les libraries (lib/i386 ou lib/amd64 correspondant à la version de votre jdk).