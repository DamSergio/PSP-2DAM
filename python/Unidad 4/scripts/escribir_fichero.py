def escribir_fichero():
    fichero = open('Unidad 4/ficheros/nuevo.txt', 'w')
    fichero.write('Hola, soy un fichero nuevo\n')
    fichero.close()

if __name__ == '__main__':
    escribir_fichero()