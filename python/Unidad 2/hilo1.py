import threading
import logging
import time

def thread_function(name):
    logging.info(f"Hilo {name}: iniciando")
    time.sleep(2)
    logging.info(f"Hilo {name}: finalizando")

if __name__ == "__main__":
    format = "%(asctime)s: %(message)s"
    logging.basicConfig(format = format, level = logging.INFO, datefmt = "%H:%M:%S")

    logging.info("Main: antes de llamar al hilo")

    x = threading.Thread(target = thread_function, args = (1,))
    x.start()
    # x.join()

    logging.info("Main: despues de llamar al hilo")
    logging.info("FIN DE MAIN")