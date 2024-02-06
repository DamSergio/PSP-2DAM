numeros = [1, 2, 2, 4, 1, 6, 3, 3, 3, 5]

cont = 0
aux = 0

for i in numeros:
    if i == aux:
        cont += 1
    else:
        aux = i
        cont = 1
    
    if cont == 3:
        print(f"El numero {i} se repite 3 veces")
        break