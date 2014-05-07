Installer build scripts for SURFER2012
======================================

Scripts for creating platform dependent installers for SURFER 2012.

You need a recent Oracle Java version (1.7+).

On Linux/Unix/Mac systems build the setup for the specific system using
```
./gradlew jfxDeploy
```

On Windows you can use
```
jfxDeploy-win.bat
```
which sets some important environment variables. Note that `jfxDeploy-win.bat` possibly needs to be adjusted for your specific system.

After successful building, the setup/installer/package files can be found in
```
./build/distributions/bundles/
```
