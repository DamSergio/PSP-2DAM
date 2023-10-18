import sys
from time import sleep

time_sec = int(sys.argv[1])
print(f"Inicializo el contador para {time_sec} segundos")

for _ in range(time_sec):
    print(".", end="", flush=True)
    sleep(1)

print("Fin")