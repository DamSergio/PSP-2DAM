numeroPalabras = int(input("Cuantas palabras tiene la lista: "))
palabras = []

for i in range(numeroPalabras):
    palabras.append(input(f"Dime la palabra {i + 1}: "))

print(f"Palabras: {palabras}")