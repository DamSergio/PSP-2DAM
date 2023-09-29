def main():
    print("Hola mundo")

def saludar(nombre = "Pedro"):
    print(f"Buenos dias {nombre}!")

def dividir(a, b):
    c = a // b
    r = a % b
    return c, r

def suma(*numeros):
    return sum(numeros)

# main() # Esto se ejecuta cuando se importa el archivo
if __name__ == "__main__":
    main()
    saludar(nombre = "Juan")
    saludar()
    cociente, resto = dividir(10, 3)
    print(f"Cociente: {cociente}, rests: {resto}")
    print(dividir(10, 3))
    print(suma(1, 2, 3, 4, 5, 6, 7, 8, 9, 10))
    print(suma(1, 2, 3, 8, 9, 10, 100))