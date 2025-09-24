from ls_repository import MobileRepository
repo = MobileRepository()


def showMobiles():
    mobiles = repo.readMobiles()
    print("Id".ljust(10),"Brand".ljust(20),"Owner".ljust(30),"Price".ljust(10))
    for mob in mobiles:
        print(str(mob["id"]).ljust(10), mob["brand"].ljust(20), mob["owner"].ljust(30), mob["price"].ljust(10))

def createMobile():
    brand=input("Enter Mobile Brand:")
    owner=input("Enter Mobile Owner:")
    price=input("Enter Mobile Price:")
    repo.insertMobile(brand,owner,price)  

def updateMobile():
    id=input("Enter Mobile Id to update:") 
    brand=input("Enter new Mobile Brand:")
    owner=input("Enter new Mobile Owner:")
    price=input("Enter new Mobile Price:")
    repo.modifyMobile(id,brand,owner,price)   

def deleteMobile():
    id=input("Enter Mobile Id to delete:") 
    repo.removeMobile(id) 
    

choice = 0
while choice!=5:
    choice = int(input("1.Create, 2.Read All, 3. Update, 4. Delete, 5. Exit. Enter your Choice:"))
    if choice == 1:
        createMobile()
    elif choice == 2:
        showMobiles()
    elif choice == 3:
        updateMobile()
    elif choice == 4:
        deleteMobile()
    else:
        print("Exiting the program")
        choice = 5
