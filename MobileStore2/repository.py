
mobiles = [
    {"id":2001,"brand":"Samsung","owner":"John","price":42000.00},
    {"id":2002,"brand":"Apple","owner":"Bala","price":65000.00},
    {"id":2003,"brand":"Motorola","owner":"Subashini","price":31000.00},
    {"id":2004,"brand":"Redmi","owner":"Rajesh","price":37000.00}
]
next_id = 2005

def create_mobile(brand,owner,price,id=None):
    global next_id
    if len(brand) > 15:
        return None
    if id:
        mobiles.append(
            {"id":id,"brand":brand,"owner":owner,"price":price}
        )
        return id
    else:
        mobiles.append(
            {"id":next_id,"brand":brand,"owner":owner,"price":price}
        )
        next_id = next_id+1
        return next_id


def read_mobiles():
    return mobiles

def update_mobile(brand,owner,price,id):
    mobile_found = False
    for mobile in mobiles:
        if mobile["id"] == id:
            mobile_found = True
            mobile["brand"] = brand
            mobile["owner"] = owner
            mobile["price"] = price
            break
    return mobile_found

def delete_mobile(id):
    index= None
    i =0
    for mobile in mobiles:
        if mobile["id"] == id:
            index = i
            break
        i=i+1
    if index:
        mobiles.pop(index)
        return True
    else:
        return False

