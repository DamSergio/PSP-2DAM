import random

gloria = {
    "c1" : random.randrange(1, 11),
    "c2" : random.randrange(1, 11),
    "c3" : random.randrange(1, 11)
}

gloriaT = gloria["c1"] + gloria["c2"] + gloria["c3"]

david = {
    "c1" : random.randrange(1, 11),
    "c2" : random.randrange(1, 11),
    "c3" : random.randrange(1, 11)
}

davidT = david["c1"] + david["c2"] + david["c3"]

print(f"David saca {david['c1']}, {david['c2']} y {david['c3']}")
print(f"Gloria saca {gloria['c1']}, {gloria['c2']} y {gloria['c3']}")

if (davidT > 15 or gloriaT > 15):
    if (davidT > 15):
        print("David pierde")

    if (gloriaT > 15):
        print("Gloria pierde")
else:
    if (gloriaT == davidT):
        print("Empate")
    elif (gloriaT > davidT):
        print("Gana gloria")
    else:
        print("Gana david")