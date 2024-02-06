import socket as sc

HOST = "127.0.0.1" # Direccion IP del servidor / localhost
PORT = 2000 # Puerto del servidor

socket = sc.socket(sc.AF_INET, sc.SOCK_STREAM) # Creacion del socket
socket.connect((HOST, PORT)) # Conexion con el servidor

print(f"Conexion establecida con el servidor: IP {HOST} y puerto {PORT}")

socket.close() # Cierre del socket del cliente