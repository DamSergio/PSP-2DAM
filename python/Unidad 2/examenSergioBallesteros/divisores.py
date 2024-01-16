import sys

numero = int(sys.argv[1])
divisores = [i for i in range(1, numero + 1) if numero % i == 0]

if (len(divisores) == 0):
    print("EL NUMERO DEBE SER POSITIVO")
else:
    print(divisores)