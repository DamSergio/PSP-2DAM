def suma_cons(n1, n2):
    if n2 < n1:
        aux = n1
        n1 = n2
        n2 = aux
    
    suma = n1
    print(f"> {n1}", end="")
    for i in range(n1 + 1, n2 + 1):
        suma += i
        print(f" + {i}", end="")
    
    return f": {suma}"

if __name__ == "__main__":
    n1 = int(input("Dime el primer numero: "))
    n2 = int(input("Dime el segundo numero numero: "))

    print(suma_cons(n1, n2))