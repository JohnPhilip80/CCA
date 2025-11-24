from flask import Flask, render_template
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


if __name__ == "__main__":
    app.run(debug=True)