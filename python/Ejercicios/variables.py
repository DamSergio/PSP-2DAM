import keyword as kw
import random as rn

print(kw.kwlist)

#Variables
x = 1
print(x)

x = 'caca'
print(x)

nombre, edad = 'Sergio', 22
print(f'Tu nombre es {nombre} y edad {edad}')

nombre, edad = ['caca', 45]
print(f'Tu nombre es {nombre} y edad {edad}')

#operaciones aritmeticas

x = 3
x = 3 + 1
print(x)

print(type(x))

x = 'sdfsdf'
print(type(x))

#teclado
# x = input('Dame un numero: ')
# print(f'Tu numero es {x}')

# print(f'Tu numero es {round(float(x))}')

print(f'Potencias {pow(2, 3)}')
print(f'El valor absoluto es {abs(-9)}')

print(f'Hola {max(3,4,6,9,1,90,5)}')
print(f"HOla {max('Anaaaa', 'Juan')}")

suma = sum((1,5,5,7,9))
print(suma)
print(f"Ordenar {sorted([9,1,7,3,7,456,43,2,246,8,323,0])}")

diccionario = {
    "nombre" : "sergio",
    "edad" : 22
}

print(diccionario["edad"])

print("caca " * 5)
palabra = "me sudan los cojones"
print(palabra[3:8])

# try:   
#     edad = int(input("Dame un numero: "))
# except:
#     print("mal")

nombre = "Luisa"

if nombre.startswith("L"):
    print("si")

if nombre.endswith("a"):
    print("si")

if nombre.__contains__("uis"):
    print("si")

print(rn.randrange(1, 100))