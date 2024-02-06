import socket as sc

HOST = "127.0.0.1" # Direccion IP del servidor / localhost
PORT = 2000 # Puerto del servidor

socket = sc.socket(sc.AF_INET, sc.SOCK_STREAM) # Creacion del socket
socket.bind((HOST, PORT)) # Asociacion del socket a la direccion IP y puerto
socket.listen(1) # Espera de una conexion entrante, 1 conexion maxima en espera
cliente, address = socket.accept() # Aceptacion de la conexion entrante, devuelve un nuevo socket y la direccion del cliente

print(f"Conexion establecida con el cliente: IP {address[0]} y puerto {address[1]}")

cliente.close() # Cierre del socket del cliente