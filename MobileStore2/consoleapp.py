from dbrepository import create_mobile,read_mobiles,update_mobile,delete_mobile

choice = 0
while choice != 5:
    choice = int(input("1.Create 2.Read 3.Update 4.Delete 5.Exit.Enter your choice:"))
    if choice == 1:
        brand = input("Enter brand: ")
        owner = input("Enter owner: ")
        price = float(input("Enter price: "))
        if create_mobile(brand,owner,price):
            print("Mobile Created Successfully")
        else:
            print("Mobile Not Created")
    elif choice == 2:
        mobiles = read_mobiles()
        print("Id".ljust(10), "Brand".ljust(15), "Owner".ljust(15), "Price".ljust(15))
        for mobile in mobiles:
            print(str(mobile["id"]).ljust(10), mobile["brand"].ljust(15), mobile["owner"].ljust(15), str(mobile["price"]).ljust(15))
    elif choice == 3:
        id = int(input("Enter Mobile Id to update: "))
        brand = input("Enter updated Brand value: ")
        owner = input("Enter updated Owner value: ")
        price = float(input("Enter updated Price value: "))
        if update_mobile(brand,owner,price,id):
            print("Mobile Updated Successfully")
        else:
            print("Mobile Id Not Found")
    elif choice == 4:
        id = int(input("Enter Mobile Id to Delete: "))
        if delete_mobile(id):
            print("Mobile Deleted Successfully")
        else:
            print("Mobile Id Not Found")
    else:
        choice = 5
print("EXIT")