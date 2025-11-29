from flask import Flask, render_template, request, url_for, redirect
from dbrepository import read_mobiles,read_mobile,create_mobile,update_mobile,delete_mobile

app = Flask(__name__)

@app.route("/home-page")
def homePage():
    #return "<h1>Hello World</h1>"
    return render_template("homepage.html")

@app.route("/aboutus-page")
def aboutUsPage():
    return render_template("aboutuspage.html")

@app.route("/contactus-page")
def contactUsPage():
    return render_template("contactuspage.html")

@app.route("/list-mobiles")
def listMobiles():
    return render_template("mobile-list.html",mobiles=read_mobiles())


@app.route("/add-mobile", methods = ["GET", "POST"])
def addMobile():
    if request.method == "POST":
        create_mobile(request.form["brand"],request.form["owner"],request.form["price"])
        return redirect(url_for("listMobiles"))
    return render_template("mobile-add.html")

@app.route("/delete-mobile<string:id>")
def deleteMobile(id):
    delete_mobile(id)
    return redirect(url_for("listMobiles"))


@app.route("/update-mobile<string:id>", methods = ["GET", "POST"])
def updateMobile(id):
    if request.method == "POST":
        update_mobile(request.form["brand"],request.form["owner"],request.form["price"],id)
        return redirect(url_for("listMobiles"))
    return render_template("mobile-update.html",mobile=read_mobile(id))

if __name__ == "__main__":
    app.run(debug=True)