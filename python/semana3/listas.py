l = ["hola", 1, True]
print(l)

#Tamaño
print(len(l))

#Elementos
names = ["paco", "sergio", "andrea", "jaime", "pedro"]
print(names[0])
print(names[-1])
print(names[1:3])
print(names[:3])

#funciones
names.append("ultimo")
print(names)

names.insert(0, "primero")
print(names)

names2 = ["kasdnf", "sdfa", "asdf"]
names.extend(names2)
print(names)

#recorrer
for name in names:
    print(name, end = " ")

print(name)

print(f"hola {', '.join(names)}")

#count recibe un elemento y devuelve cuantas veces esta en la lista
l = [1,1,1,2,2]

numbers = []
counted = []
for i in l:
    if i not in numbers:
        numbers.append(i)
        counted.append(l.count(i))
print(counted)

#ordenar
counted.sort()
print(counted)

#al reves
names.reverse()
print(names)

#borrar
print(names.pop(0))
print(names)

del names[0]
print(names)

names.remove("paco")
print(names)

#crear lista
numeros = list(range(0, 10))
print(numeros)

numeros = [i for i in range(0, 10, 2)]
print(numeros)