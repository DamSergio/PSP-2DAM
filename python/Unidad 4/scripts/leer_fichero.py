def leer_fichero():
    fichero = open('Unidad 4/ficheros/ejemplo.txt', 'r')
    print(fichero.read())
    fichero.close()

def leer_fichero_lineas():
    fichero = open('Unidad 4/ficheros/ejemplo.txt', 'r')
    lineas = fichero.readlines()
    for linea in lineas:
        print(linea, end = '')
    fichero.close()

if __name__ == '__main__':
    # leer_fichero()
    leer_fichero_lineas()