# Dada una lista con 7 temperaturas calcula la temperatura media y determinar
# entre todas ellas cuantas son superiores o iguales a esa media.
import random

def media_temperaturas(temperaturas):
    suma = 0
    for temperatura in temperaturas:
        suma += temperatura
    return suma / len(temperaturas)

def main():
    temperaturas = [10 * random.randint(1, 4) for _ in range(7)]
    print(temperaturas)

    media = media_temperaturas(temperaturas)
    print(f"La temperatura media es {media}")
    print(f"Temperaturas superiores o iguales a la media: {len([i for i in temperaturas if i >= media])}")

if __name__ == "__main__":
    main()