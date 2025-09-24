class MobileRepository:
    def __init__(self):
        self.mobileList = [
            {
                "id":"1001","brand":"Samsung","owner":"John","price":"45000"
             },
             {
                 "id":"1002","brand":"Apple", "owner":"Lakshmi","price":"65000"
             },
             {
                 "id":"1003","brand":"Redmi", "owner":"Saraswathi","price":"34500"
             }
        ]
        self.nextMobileId = 1004
    def readMobiles(self):
        return self.mobileList
    def insertMobile(self,br,ow,pr):
        mob={
            "id":str(self.nextMobileId),
            "brand":br,
            "owner":ow,
            "price":pr
        }
        self.mobileList.append(mob)
        self.nextMobileId = self.nextMobileId + 1

    def modifyMobile(self,id,br,ow,pr):
        for mob in self.mobileList:
            if mob["id"]== str(id):
                mob["brand"] = br
                mob["owner"] = ow
                mob["price"] = pr
                break
    
    def removeMobile(self,id):
        for mob in self.mobileList:
            if mob["id"] == str(id):
                self.mobileList.remove(mob)
                break
        
