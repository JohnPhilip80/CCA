import mysql.connector

def read_mobiles():
    cursor = None
    try:
        connection = mysql.connector.connect(
            host="localhost",
            user="root",
            password="Admin@123",
            database="john_mobile"
        )
        cursor = connection.cursor(dictionary=True)
        cursor.execute("SELECT * FROM mobile")
        mobiles = cursor.fetchall()
    except mysql.connector.Error as error:
        print(error)
    except Exception as err:
        print(err)
    finally:
        cursor.close()
        connection.close()
    return mobiles

def read_mobile(id):
    cursor = None
    try:
        connection = mysql.connector.connect(
            host="localhost",
            user="root",
            password="Admin@123",
            database="john_mobile"
        )
        cursor = connection.cursor(dictionary=True)
        cursor.execute("SELECT id,brand,owner,price FROM mobile where id=%s",(id,))
        mobile = cursor.fetchone()
    except mysql.connector.Error as error:
        print(error)
    except Exception as err:
        print(err)
    finally:
        cursor.close()
        connection.close()
    return mobile

def create_mobile(brand,owner,price):
    cursor = None
    try:
        connection = mysql.connector.connect(
            host="localhost",
            user="root",
            password="Admin@123",
            database="john_mobile"
        )
        cursor = connection.cursor(dictionary=True)
        cursor.execute("INSERT INTO mobile(brand,owner,price) values(%s,%s,%s)",(brand,owner,price))
        connection.commit()
        return cursor.lastrowid
    except mysql.connector.Error as error:
        print(error)
    except Exception as err:
        print(err)
    finally:
        cursor.close()
        connection.close()

def update_mobile(brand,owner,price,id):
    cursor = None
    try:
        connection = mysql.connector.connect(
            host="localhost",
            user="root",
            password="Admin@123",
            database="john_mobile"
        )
        cursor = connection.cursor(dictionary=True)
        cursor.execute("UPDATE mobile SET brand=%s,owner=%s,price=%s WHERE id=%s", (brand, owner, price,id))
        connection.commit()
        return cursor.rowcount
    except mysql.connector.Error as error:
        print(error)
    except Exception as err:
        print(err)
    finally:
        cursor.close()
        connection.close()

def delete_mobile(id):
    cursor = None
    try:
        connection = mysql.connector.connect(
            host="localhost",
            user="root",
            password="Admin@123",
            database="john_mobile"
        )
        cursor = connection.cursor(dictionary=True)
        cursor.execute("DELETE FROM mobile WHERE id=%s", (id,))
        connection.commit()
        return cursor.rowcount
    except mysql.connector.Error as error:
        print(error)
    except Exception as err:
        print(err)
    finally:
        cursor.close()
        connection.close()
