# Implementa el algoritmo de la burbuja en Python para ordenar una lista.

def ordena_burbuja(lista):
    for i in range(len(lista) - 1):
        for j in range(len(lista) - 1 - i):
            if lista[j] > lista[j + 1]:
                lista[j], lista[j + 1] = lista[j + 1], lista[j]

def main():
    lista = [5, 3, 6, 2, 1, 4]
    print(lista)
    ordena_burbuja(lista)
    print(lista)

if __name__ == "__main__":
    main()