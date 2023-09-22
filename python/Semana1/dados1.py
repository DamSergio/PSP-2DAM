import random

alvaro = random.randrange(1,7);
barbara = random.randrange(1,7);

print(f"Alvaro ha sacado un {alvaro}")
print(f"Barbara ha sacado un {barbara}")

if (alvaro == barbara):
    print("Empate")

elif (alvaro > barbara):
    print("gana alvaro")

else:
    print("Gana barbara")