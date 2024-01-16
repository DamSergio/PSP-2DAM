# Crea un programa en Python que imprima los 10 primeros numeros pares
# comenzando en 2 e imprima tambien sus respectivos cubos.

def main():
    for i in range(2, 21, 2):
        print(f"{i} {i ** 3}")

if __name__ == "__main__":
    main()