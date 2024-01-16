import time
import threading

class Olla:
    def __init__(self):
        self.contenido = []
        self.cond = threading.Condition()
    
    def agregar(self, misionero):
        with self.cond:
            self.contenido.append(misionero)
            print(f"Se agrego el misionero {misionero}")
            self.cond.notify() # Despierta a un canibal (el primero de la lista de los que estan esperando, asi se asegura de que todos coman)
    
    def comer(self, canibal):
        with self.cond:
            while len(self.contenido) == 0:
                print(f"El canibal {canibal} esta esperando")
                self.cond.wait()
            
            misionero = self.contenido.pop(0)
            print(f"El canibal {canibal} se comio al misionero {misionero}")

def canibal(id, olla):
    while True:
        olla.comer(id)

def cocinero(olla):
    for i in range(20):
        olla.agregar(i)
        time.sleep(1)

def main():
    olla = Olla()
    hilos_canibales = [threading.Thread(target=canibal, args=(i, olla)) for i in range(3)]
    hilo_cocinero = threading.Thread(target=cocinero, args=(olla, ))

    for hilo in hilos_canibales:
        hilo.start()
    
    hilo_cocinero.start()

if __name__ == "__main__":
    main()