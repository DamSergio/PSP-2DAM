import random

ERROR_DADOS = "Numero de dados no valido"

def game():
    numero_dados = input("Dime el numero de dados a lanzar: ")

    try:
        numero_dados = int(numero_dados)
    except:
        return ERROR_DADOS

    if (numero_dados == 0):
        return ERROR_DADOS
    
    dados = [random.randrange(1, 7) for _ in range(numero_dados)]
    print(f"Dados: {' '.join(map(str, dados))}")

    pares = len([i for i in dados if i % 2 == 0])
    nones = len([i for i in dados if i % 2 == 1])

    if pares == nones:
        return "Empate"
    
    if pares > nones:
        return "Gana pares"
    
    return "Gana nones"

if __name__ == "__main__":
    print(game())