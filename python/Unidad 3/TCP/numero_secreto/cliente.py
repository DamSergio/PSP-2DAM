import socket as sc

HOST = "127.0.0.1" # Direccion IP del servidor / localhost
PORT = 2000 # Puerto del servidor

def main():
    socket = sc.socket(sc.AF_INET, sc.SOCK_STREAM) # Creacion del socket
    socket.connect((HOST, PORT)) # Conexion con el servidor

    print(f"Conexion establecida con el servidor: IP {HOST} y puerto {PORT}")
    while True:
        user_input = input("Ingrese un numero: ")
        try:
            int(user_input)
        except:
            print("Ingrese un numero valido")
            continue

        socket.send(user_input.encode()) # Envio de datos al servidor

        data_servidor = socket.recv(1024) # Recepcion de datos del servidor, buffer de 1024 bytes
        respuesta_servidor = data_servidor.decode()

        print(respuesta_servidor)

        if (respuesta_servidor == "Ganaste!" or "Perdiste!" in respuesta_servidor):
            break

    socket.close() # Cierre del socket del cliente

if __name__ == "__main__":
    main()