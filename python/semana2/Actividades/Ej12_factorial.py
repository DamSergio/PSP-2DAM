numero = int(input("Dime un numero mayor que 0 para calcular su factorial: "))

for n in range(numero, 0, -1):
    numero *= n

print(numero)