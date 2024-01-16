# Dado un numero, suma sus divisores. Haz un programa main con un metodo para
# sumar los divisores


def suma_divisores(n):
    suma = 0
    for i in range(1, n + 1):
        if n % i == 0:
            suma += i
    return suma

if __name__ == "__main__":
    n = int(input("Introduce un número: "))
    print(f"La suma de los divisores de {n} es {suma_divisores(n)}")