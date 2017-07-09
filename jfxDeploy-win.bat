REM Adjust paths to your own needs!!
REM ================================
REM
SET JAVA_HOME=C:\Program Files\Java\jdk1.7.0_80
SET PATH=C:\Program Files\Inno Setup 5;C:\Program Files (x86)\Inno Setup 5;C:\Program Files\WiX;%PATH%
cd /d "%~dp0"
REM gradlew clean jfxDeploy
gradlew jfxDeploy
