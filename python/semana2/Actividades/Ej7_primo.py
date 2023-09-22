def es_primo(numero):
    for i in range(2, int(numero / 2) + 1):
        if numero % i == 0:
            return f"{numero} no es primo"
    
    return f"{numero} es primo"

if __name__ == "__main__":
    numero = int(input("Dime un numero mayor que 0: "))
    print(es_primo(numero))