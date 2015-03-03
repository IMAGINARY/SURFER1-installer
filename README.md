Installer build scripts for SURFER2012
======================================

Scripts for creating platform dependent installers for SURFER 2012.

You need a recent Oracle Java version (1.7+).

On Linux/Unix/Mac systems build the setup for the specific system using
```
./gradlew clean jfxDeploy
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

Localization
------------

As of version 1.2.1 of SURFER, all localization specific files have been outsourced to separate jar files containing one language each. For example, the `libs/SurferLocalization_en.jar` file for English localization has the following structure:
```
META-INF/
META-INF/MANIFEST.MF
de/
de/mfo/
de/mfo/jsurfer/
de/mfo/jsurfer/fxgui/
de/mfo/jsurfer/fxgui/Impressum_en.png
de/mfo/jsurfer/fxgui/MessagesBundle_en.properties
de/mfo/jsurfer/gallery/
de/mfo/jsurfer/gallery/fantasy_en.pdf
de/mfo/jsurfer/gallery/record_en.pdf
de/mfo/jsurfer/gallery/tutorial_en.pdf
```

Since `.jar` is actually a ZIP file with meta data, you can just exchange the files using the ZIP compression tool of your choice. Before you start, copy the file `libs/SurferLocalization_en.jar` to `libs/SurferLocalization_XX.jar` where `XX` is the [two-letter IETF BCP 47 language tag](http://rishida.net/utils/subtags/) of the language you are localizing for.

### Impressum_XX.png

This image is shown in SURFER when you click on the copyright button. It is the only file that has to be updated every time a new language is added and therefore gets inconsistent quite quickly. It is not localized for most languages and you can just delete it from your `.jar` file if you want (meaning that the default localization is used as a fallback).

### MessagesBundle_XX.properties

This files contains localization strings for several labels of the user interface of SURFER. The English file looks like this:
```
variables=Variables
arithmeticOperations=Arithmetic operations
parameters=Parameters
start=Start
info=Info
colors=Colours
zoom=Zoom
imprintFile=Impressum_en.png
```
If you translate to a language which uses non-ascii characters (which are most Non-English languages), you need to convert your translation into the approriate format using the `native2ascii` tool which is part of the Java Development Kit. You can also use this [online tool](http://native2ascii.net/) to simplify the process.

If you did not translate the imprint file, you should delete the line `imprintFile=Impressum_en.png`. Otherwise, replace `imprintFile=Impressum_en.png` with `imprintFile=Impressum_XX.png`.

### de/mfo/jsurfer/gallery/*_XX.pdf

The gallery PDF files in `de/mfo/jsurfer/gallery/` are the ones you created based on https://github.com/IMAGINARY/SURFER-Galleries. 
