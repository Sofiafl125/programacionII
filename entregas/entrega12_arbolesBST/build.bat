@echo off
setlocal enabledelayedexpansion

set PROJECT_NAME=semana12-bst-inventario
set SRC_DIR=src
set BIN_DIR=bin
set LIBS_DIR=libs
set DIST_DIR=dist
set MAIN_CLASS=aplicacion.Main
set MANIFEST_FILE=META-INF\MANIFEST.MF

set MODE=%~1
if "%MODE%"=="" set MODE=all

set CP_LIB=
if exist "%LIBS_DIR%" (
  for %%F in ("%LIBS_DIR%\*.jar") do (
    if "!CP_LIB!"=="" (set CP_LIB=%%~fF) else (set CP_LIB=!CP_LIB!;%%~fF)
  )
)

goto :dispatch

:dispatch
  if /i "%MODE%"=="compile" goto :do_compile
  if /i "%MODE%"=="run"     goto :do_run
  if /i "%MODE%"=="jar"     goto :do_jar
  if /i "%MODE%"=="all"     goto :do_all
  exit /b 1

:do_compile
  if not exist "%BIN_DIR%" mkdir "%BIN_DIR%"
  set FILES=
  for /r "%SRC_DIR%" %%F in (*.java) do set FILES=!FILES! "%%F"
  if "!FILES!"=="" (echo No se encontraron .java & exit /b 1)
  if "!CP_LIB!"=="" (javac -d "%BIN_DIR%" -encoding UTF-8 !FILES!) else (javac -cp "!CP_LIB!" -d "%BIN_DIR%" -encoding UTF-8 !FILES!)
  if errorlevel 1 (echo Error en compilacion & exit /b 1)
  echo Compilacion exitosa
  exit /b 0

:do_run
  call :do_compile
  if errorlevel 1 exit /b 1
  if "!CP_LIB!"=="" (java -cp "%BIN_DIR%" %MAIN_CLASS%) else (java -cp "%BIN_DIR%;!CP_LIB!" %MAIN_CLASS%)
  exit /b 0

:do_jar
  call :do_compile
  if errorlevel 1 exit /b 1
  if not exist "%DIST_DIR%" mkdir "%DIST_DIR%"
  set JAR_FILE=%DIST_DIR%\%PROJECT_NAME%.jar
  if exist "%MANIFEST_FILE%" (jar cfm "%JAR_FILE%" "%MANIFEST_FILE%" -C "%BIN_DIR%" .) else (jar cfe "%JAR_FILE%" %MAIN_CLASS% -C "%BIN_DIR%" .)
  if errorlevel 1 (echo Error al generar JAR & exit /b 1)
  echo JAR generado: %JAR_FILE%
  exit /b 0

:do_all
  call :do_compile
  if errorlevel 1 exit /b 1
  call :do_run
  call :do_jar
  exit /b 0
