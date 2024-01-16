import threading
import time

class Fabrica:
    def __init__(self):
        self.cinta = []
        self.lock = threading.Lock()

    def colocar_producto(self, producto):
        with self.lock:
            while len(self.cinta) >= 5:
                self.lock.release()
                time.sleep(0.1)
                self.lock.acquire()

            self.cinta.append(producto)
            print(f"Producto {producto} colocado en la cinta")

    def retirar_producto(self):
        with self.lock:
            while len(self.cinta)==0:
                self.lock.release()
                time.sleep(0.1)
                self.lock.acquire()

            producto = self.cinta.pop(0)
            print(f"Producto {producto} retirado de la cinta")


def productor(fabrica):
    for i in range(1, 21):
        fabrica.colocar_producto(i)
        time.sleep(1)

def consumidor(fabrica):
    for _ in range(20):
        fabrica.retirar_producto()
        time.sleep(2)




if __name__ == "__main__":
    fabrica = Fabrica()

    hilo_productor = threading.Thread(target=productor, args=(fabrica,))
    hilo_consumidor = threading.Thread(target=consumidor, args=(fabrica,))

    
    hilo_productor.start()
    hilo_consumidor.start()

    hilo_productor.join()
    hilo_consumidor.join()
