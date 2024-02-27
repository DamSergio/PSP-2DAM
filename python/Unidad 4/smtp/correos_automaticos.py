import json
import os
import smtplib
from email.mime.multipart import MIMEMultipart
from email.mime.text import MIMEText


MAIL_FROM = 'sergioballesterospsp@outlook.es'
PSW = 'ribera1234'
JSON_FILE = 'Unidad 4/ficheros/datos.json'

def load_from_json() -> dict:
    with open(JSON_FILE, 'r') as file:
        data = json.load(file)
    return data


def send_email_smtp(mail_to: str, tag: str, body: str) -> None:
    message = MIMEMultipart()
    message['From'] = MAIL_FROM
    message['To'] = mail_to
    message['Subject'] = tag

    message.attach(MIMEText(body, 'plain'))

    # conexión al servidor
    session = smtplib.SMTP('smtp-mail.outlook.com', 587)
    session.starttls()

    session.login(MAIL_FROM, PSW)

    text = message.as_string()

    session.sendmail(MAIL_FROM, mail_to, text)

    session.quit()
    print(f'Correo enviado')


def send_email(mail_to: str, interest_list: list[str]) -> None:
    for tag in interest_list:
        file_name = f'Unidad 4/ficheros/tags/{tag}.txt'

        if (not os.path.exists(file_name)):
            continue

        with open(file_name, 'r', encoding = 'UTF-8') as file:
            body = file.read()

            send_email_smtp(mail_to, tag, body)
            


def main() -> None:
    data = load_from_json()

    for persona in data:
        mail_to = persona['correo_electronico']
        interests = persona['tags_de_intereses']

        send_email(mail_to = mail_to, interest_list = interests)


if __name__ == "__main__":
    main()