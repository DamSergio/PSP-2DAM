class Empleado:
    cargo = 0
    dias = 0
    estado_civil = 0
    sueldo_base = 0
    sueldo_dias = 0
    sueldo_bruto = 0
    irpf = 0

    def __init__(self, cargo, dias, estado_civil):
        self.cargo = cargo
        self.dias = dias
        self.estado_civil = estado_civil
    
    def calcular_sueldo_base(self):
        if self.cargo == 1:
            self.sueldo_base = 950
        elif self.cargo == 2:
            self.sueldo_base = 1200
        elif self.cargo == 3:
            self.sueldo_base = 1600
        else:
            return 0
    
    def calcular_irpf(self):
        if self.estado_civil == 1:
            self.irpf = 0.25
        elif self.estado_civil == 2:
            self.irpf = 0.20
        else:
            return 0
    
    def calcular_sueldo_dias(self):
        self.sueldo_dias = self.dias * 30
    
    def calcular_nomina(self):
        self.calcular_sueldo_base()
        self.calcular_irpf()
        self.calcular_sueldo_dias()

        if (self.sueldo_base == 0 or self.irpf == 0):
            print("Error al calcular el sueldo base o el IRPF")
            return

        print("----------------------------------------")
        print(f"Sueldo base: {self.sueldo_base}€")
        print(f"Dietas ({self.dias} viajes): {self.sueldo_dias}€")
        print("----------------------------------------")

        self.sueldo_bruto = self.sueldo_base + self.sueldo_dias
        print(f"Sueldo bruto: {self.sueldo_bruto}€")
        print(f"Retención IRPF ({self.irpf * 100}%): {self.sueldo_bruto * self.irpf}€")
        print("----------------------------------------")
        print(f"Sueldo neto: {self.sueldo_bruto - (self.sueldo_bruto * self.irpf)}€")

def main():
    menu()
    cargo = int(input("Introduza el cargo del empleado: "))
    dias = int(input("Introduzca los días trabajados: "))
    estado_civil = int(input("Introduzca el estado civil del empleado (1 - soltero, 2 - casado): "))

    empleado = Empleado(cargo, dias, estado_civil)
    empleado.calcular_nomina()

def menu():
    print(
"""****************************************
Cálculo de nómina:
****************************************
1)Programador junior
2)Programador senior
3)Jefe de proyecto"""
    )

if __name__ == "__main__":
    main()