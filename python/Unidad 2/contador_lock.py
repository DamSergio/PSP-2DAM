import threading

#variable global compartida
contador = 0
lock = threading.Lock()

def incrementar():
    global contador
    for _ in range(100000):
        lock.acquire()
        contador += 1
        lock.release()
        print(f"suma: {contador}")   

def decrementar():
    global contador
    for _ in range(100000):
        lock.acquire()
        contador -= 1
        lock.release()
        print(f"resta: {contador}")     

def main():
    hilo1 = threading.Thread(target = incrementar)
    hilo2 = threading.Thread(target = decrementar)

    hilo1.start()
    hilo2.start()

    hilo1.join()
    hilo2.join()

    print(f"El valor del contador es: {contador}")

if __name__ == "__main__":
    main()