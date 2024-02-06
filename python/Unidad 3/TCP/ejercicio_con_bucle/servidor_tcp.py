import socket as sc

HOST = "172.16.191.177" # Direccion IP del servidor / localhost
PORT = 2000 # Puerto del servidor

socket = sc.socket(sc.AF_INET, sc.SOCK_STREAM) # Creacion del socket
socket.bind((HOST, PORT)) # Asociacion del socket a la direccion IP y puerto

socket.listen() # Espera de una conexion entrante, 1 conexion maxima en espera
while True:
    cliente, address = socket.accept() # Aceptacion de la conexion entrante, devuelve un nuevo socket y la direccion del cliente
    print(f"Conexion establecida con el cliente: IP {address[0]} y puerto {address[1]}")

    data = cliente.recv(1024) # Recepcion de datos del cliente, buffer de 1024 bytes
    print(f"Datos recibidos: {data.decode()}")

    cliente.send(b"Hola, soy sergio") # Envio de datos al cliente

    cliente.close() # Cierre del socket del cliente