import ftplib

HOST = 'localhost'
FTP_USER = 'usuario1'
FTP_PASS = 'usu1'

def ver_ftp() -> None:
    try:
        ftp = ftplib.FTP(HOST, FTP_USER, FTP_PASS)
        ftp.encoding = 'utf-8'

        print(ftp.getwelcome())

        # resp_message = ftp.retrlines('LIST') # Listar ficheros y directarios del directorio actual
        resp_message = ftp.retrlines('NLST /') # Listar ficheros y directarios del directorio raíz

        ftp.close()
        print(resp_message)
    except ftplib.all_errors as e:
        print(e)


def subir_fichero(fichero: str, fichero_remoto: str) -> None:
    try:
        ftp = ftplib.FTP(HOST, FTP_USER, FTP_PASS)
        ftp.encoding = 'utf-8'

        print(ftp.getwelcome())

        with open(fichero, 'rb') as f:
            ftp.storbinary(f'STOR {fichero_remoto}', f)
            print(f'Fichero {fichero} subido correctamente como {fichero_remoto}')
        
        ver_ftp() # Ver ficheros subidos
        
        ftp.close()
    except ftplib.all_errors as e:
        print(e)


def descargar_ftp(fichero_remoto: str, fichero: str) -> None:
    try:
        ftp = ftplib.FTP(HOST, FTP_USER, FTP_PASS)
        ftp.encoding = 'utf-8'

        print(ftp.getwelcome())

        with open(fichero, 'wb') as f:
            ftp.retrbinary(f'RETR {fichero_remoto}', f.write)
            print(f'Fichero {fichero_remoto} descargado correctamente como {fichero}')
        
        ftp.close()
    except ftplib.all_errors as e:
        print(e)


if __name__ == '__main__':
    # ver_ftp()

    fichero = 'Unidad 4/ficheros/nuevo.txt'
    fichero_remoto = '/sergio.txt'
    fichero_descargado = 'Unidad 4/ficheros/descargado.txt'

    subir_fichero(fichero, fichero_remoto)
    descargar_ftp(fichero_remoto, fichero_descargado)