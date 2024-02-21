def main():
    user_input = int(input('Introduce un número: '))
    file_name = f'Unidad 4/ficheros/tabla_multiplicar_{user_input}.txt'
    
    with open(file_name, 'w') as file:
        for i in range(1, 11):
            file.write(f'{user_input} x {i} = {user_input * i}\n')

if __name__ == '__main__':
    main()
