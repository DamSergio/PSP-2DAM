# Calcular la suma de los divisores de cada numero introducido por teclado.
# Terminaremos cuando el numero sea negativo

def suma_divisores(n):
    suma = 0
    for i in range(1, n + 1):
        if n % i == 0:
            suma += i
    return suma

def main():
    while True:
        n = int(input("Introduce un número: "))
        if n < 0:
            break
        print(f"La suma de los divisores de {n} es {suma_divisores(n)}")

if __name__ == "__main__":
    main()