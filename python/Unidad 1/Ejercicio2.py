import subprocess as sp

try:
    # sp.run(["Notepad.exe"])
    # sp.run(["C:/Windows/System32/notepad.exe"])
    sp.run(["notepad.exe", "C:/Users/Sergio/Desktop/PSP-2DAM/python/Unidad 1/texto.txt"])
except sp.CalledProcessError as e:
    print(e.output)