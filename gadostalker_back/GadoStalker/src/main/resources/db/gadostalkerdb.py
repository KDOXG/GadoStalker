import psycopg2
import db
from pathlib import Path
import os
import zipfile
import shutil

images_zip = "./img.zip"
images_dir = "./tmp/"

sql_script = open("gadostalkerdb.sql", "r", encoding="utf-8")
queries = sql_script.read().split(';')
sql_script.close()

with zipfile.ZipFile(images_zip, 'r') as zip_ref:
    zip_ref.extractall("./")

mydb = psycopg2.connect(
    host=db._host,
    database=db._database,
    user=db._user,
    password=db._password,
    port=db._port
)
mycursor = mydb.cursor()

#mycursor.execute("Show tables;")
#myresult = mycursor.fetchall()

#for x in myresult:
#    mycursor.execute("TRUNCATE {};".format(x[0]))

insert_imagem_query = """INSERT INTO imagem (ID, CONTENT, FILE_EXTENSION, FILE_NAME) VALUES
(%s,%s,%s,%s);"""

for path in Path(images_dir).iterdir():
    if not path.is_file():
        continue
    img = open(path, "rb")
    it_id = int(''.join(x for x in Path(path).stem if x.isdigit()))
    it_content = img.read()
    it_extension = os.path.splitext(path)[1].split(".")[-1].upper()
    it_filename = Path(path).stem

    it_content_insert = (it_id, it_content, it_extension, it_filename)

    mycursor.execute(insert_imagem_query, it_content_insert)

    img.close()

for query in queries:
    if not query.isspace():
        mycursor.execute(query)

mydb.commit()

shutil.rmtree(images_dir)

mycursor.close()
mydb.close()
