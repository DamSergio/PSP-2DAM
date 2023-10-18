import subprocess as sp
import time as t

def crear_proceso():
    # SW_SHOWMAXIMIZED = 3
    process = sp.Popen(["notepad"])
    return process

p = crear_proceso()
print(f"El pid es: {p.pid}")
t.sleep(5)