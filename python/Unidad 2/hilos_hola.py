import threading
import time

def imprimir_mensaje(mensaje):
    for _ in range(5):
        print(mensaje)
        time.sleep(0.5)

def main():
    hilo1 = threading.Thread(target = imprimir_mensaje, args = ("Hilo 1 : Hola",))
    hilo2 = threading.Thread(target = imprimir_mensaje, args = ("Hilo 2 : mundo",))

    hilo1.start()
    hilo2.start()

    # hilo1.join()
    # hilo2.join()

    print("Fin del programa")

if __name__ == "__main__":
    main()