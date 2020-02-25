There was a problem connecting to h2database and maven when setting up project module namespaces.

To solve the problem with h2database, I had to completely remove IDEA, all loaded modules and drivers manually, as well as clean the PC registry. Then recompile the project with a newer version of JDK 11, and then recompile it with JDK 8.

To solve the problem with file names, I had to change the location of some individual classes and packages.

All further task are in progress.  