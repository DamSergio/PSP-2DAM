def sumar_numeros(cantidad):
    suma = 0
    for _ in range(cantidad):
        suma += float(input("Dime un numero para sumar: "))

    return suma

if __name__ == "__main__":
    cantidad = int(input("Dime cuantos numeros quieres sumar: "))
    print(sumar_numeros(cantidad))