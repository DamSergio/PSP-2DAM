def divisores():
    numero = int(input("Dime un numero "))

    if numero <= 0:
        print("Numero no valido")
        return

    print(f"Los divisores de {numero} son: ", end="")
    for i in range(1, int(numero / 2 + 1)):
        if  numero % i == 0:
            print(i, end=" ")

    print(numero, end=" ")

if __name__ == "__main__":
    divisores()