import random

alvaro = {
    "dado1" : random.randrange(1, 7),
    "dado2" : random.randrange(1, 7),
}

alvaroT = alvaro["dado1"] + alvaro["dado2"]

barbara = {
    "dado1" : random.randrange(1, 7),
    "dado2" : random.randrange(1, 7)
}

barbaraT = barbara["dado1"] + barbara["dado2"]

print(f"alvaro saco un {alvaro['dado1']} y un {alvaro['dado2']}")
print(f"barbara saco un {barbara['dado1']} y un {barbara['dado2']}")

if (alvaroT == barbaraT):
    print("Empate")

elif (alvaroT > barbaraT):
    print("gana alvaro")

else:
    print("Gana barbara")