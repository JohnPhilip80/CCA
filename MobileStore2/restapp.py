from flask import Flask, jsonify, request
from dbrepository import create_mobile,read_mobiles,update_mobile,delete_mobile,read_mobile

app = Flask(__name__)

@app.route('/')
def welcome():
    return jsonify({"message": "Welcome to Mobile Store"})

@app.route('/home-page')
def home():
    return jsonify({"message": "Welcome to Home Page"})


@app.route('/show-mobiles',methods=['GET'])
def show_mobiles():
    return jsonify(read_mobiles())

@app.route('/add-mobile', methods=['POST'])
def add_mobile():
    mobile = request.get_json()
    create_mobile(mobile["brand"],mobile["owner"],mobile["price"])
    return jsonify({"message": "Mobile Successfully Added"})

@app.route('/modify-mobile',methods=['PUT'])
def modify_mobile():
    mobile = request.get_json()
    update_mobile(mobile["brand"],mobile["owner"],mobile["price"],mobile["id"])
    return jsonify({"message": "Mobile Successfully Updated"})

@app.route('/remove-mobile/<int:id>',methods=['DELETE'])
def remove_mobile(id):
    row_count = delete_mobile(id)
    if row_count == 0:
        return jsonify({"message": "Mobile Not Found"})
    else:
        return jsonify({"message": "Mobile Successfully Deleted"})

@app.route('/show-mobile/<int:id>',methods=['GET'])
def show_mobile(id):
    return jsonify(read_mobile(id))

if __name__ == '__main__':
    app.run(debug=True)