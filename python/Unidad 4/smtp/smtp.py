import smtplib
from email.mime.multipart import MIMEMultipart
from email.mime.text import MIMEText
from email.mime.base import MIMEBase
from email import encoders


def enviar_correo(mail_to: str) -> None:
    body = '''Hola, esto es un ejemplo
de correo enviado desde un programa Python
Un saludo'''

    mail_from = 'sergioballesterospsp@outlook.es'
    password = 'ribera1234'
    
    message = MIMEMultipart()
    message['From'] = mail_from
    message['To'] = mail_to
    message['Subject'] = 'Correo de prueba'

    message.attach(MIMEText(body, 'plain'))

    # adjuntar archivo
    file_name = 'Unidad 4/ficheros/nuevo.txt'
    with open(file_name, 'rb') as attachment:
        part = MIMEBase('application', 'octet-stream')
        part.set_payload(attachment.read()) # leer el archivo

        encoders.encode_base64(part) # codificar el archivo adjunto

        part.add_header('Content-Disposition', f'attachment; filename= {file_name}') # añadir cabecera
        message.attach(part)

    # conexión al servidor
    session = smtplib.SMTP('smtp-mail.outlook.com', 587)
    session.starttls()

    session.login(mail_from, password)

    text = message.as_string()

    session.sendmail(mail_from, mail_to, text)

    session.quit()
    print(f'Correo enviado')


def main() -> None:
    enviar_correo('mariaperez@riberadeltajo.es')


if __name__ == "__main__":
    main()