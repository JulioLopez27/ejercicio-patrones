@echo off

REM Crear carpeta de salida
if not exist out mkdir out

REM Compilar todos los .java recursivamente
for /R src\main\java %%f in (*.java) do (
    javac -d out -cp out "%%f"
)

REM Ejecutar en modo debug
java -agentlib:jdwp=transport=dt_socket,server=y,suspend=y,address=5005 -cp out main.Main

pause
