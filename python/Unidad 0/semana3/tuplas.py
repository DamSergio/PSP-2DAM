t = (1, "hola", True)
print(t)

print(t[0])
print(t[-1])

print(1 in t)

t = ("Manzana", "Pera", "Melon")
# t[1] = "Sandia" # Esto falla

t = list(t)
print(t)

t = tuple(t)
print(t)

t1 = ("Manzana", "Pera", "Melon")
print(t + t1)

print(len(t))

for fruta in t:
    print(fruta)

set = set([1, 2, 2, 3, 3, 3])
print(set)

set = {"hola", 2, True, 3 ,3}
print(set)

set = {"Hola", "Adios", "Buenas"}
print(set)

set = {1, "a", "o", "u", 2, 3, "i", 4, "e", 5}
print(set)

a = {1, 3, 5, 2}
b = {2, 4, 6}

print(a | b)
print(a & b)
print(a - b)

for i in a:
    print(i, end=" ")