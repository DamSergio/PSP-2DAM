import socket as sc
import random as rd

HOST = "127.0.0.1" # Direccion IP del servidor / localhost
PORT = 2000 # Puerto del servidor

def game():
    socket = sc.socket(sc.AF_INET, sc.SOCK_STREAM) # Creacion del socket
    socket.bind((HOST, PORT)) # Asociacion del socket a la direccion IP y puerto

    socket.listen() # Espera de una conexion entrante, 1 conexion maxima en espera

    while True:
        cliente, address = socket.accept() # Aceptacion de la conexion entrante, devuelve un nuevo socket y la direccion del cliente
        print(f"Conexion establecida con el cliente: IP {address[0]} y puerto {address[1]}")

        intentos = 4
        numero_secreto = rd.randint(1, 100)

        while True:
            client_data = cliente.recv(1024) # Recepcion de datos del cliente, buffer de 1024 bytes
            numero_cliente = int(client_data.decode())

            if numero_cliente == numero_secreto:
                cliente.send("Ganaste!".encode())
                break
            
            intentos -= 1
            if intentos == 0:
                cliente.send(f"Perdiste!, el numero era {numero_secreto}".encode())
                break

            if numero_cliente > numero_secreto:
                cliente.send(f"El numero secreto es menor, te quedan {intentos} intentos".encode())
            else:
                cliente.send(f"El numero secreto es mayor, te quedan {intentos} intentos".encode())
            

        cliente.close() # Cierre del socket del cliente 

if __name__ == "__main__":
    game()