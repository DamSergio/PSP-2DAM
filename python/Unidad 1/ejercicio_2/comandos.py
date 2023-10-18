import subprocess as sp

def main():
    comand = input("Ingrese el comando a ejecutar: ")
    output = crear_proceso(comand)

    print(output)

def crear_proceso(comand):
    result = sp.run(comand, capture_output=True, text=True, shell=True)

    err = result.returncode
    if (err != 0):
        print("Errores:")
        print(result.stderr)
        return f"El comando devolvio un codigo de salida {err}"
    
    return result.stdout
    

if __name__ == "__main__":
    main()