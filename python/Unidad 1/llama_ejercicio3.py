import subprocess

result = subprocess.run(["python", "Unidad 1/Ejercicio3.py"], capture_output=True, text=True)

print(result.stdout)