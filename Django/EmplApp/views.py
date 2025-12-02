from django.http import HttpResponse
from django.shortcuts import render

# Create your views here.

def home_page(request):
    return HttpResponse("<h1> Home Page </h1>")

def aboutus_page(request):
    return HttpResponse("<h1> Aboutus Page </h1>")

def contactus_page(request):
    return HttpResponse("<h1> Contact Us Page </h1>")

def employee_list(request):
    return HttpResponse("<h1> Employee List Page </h1>")

def employee_form(request):
    return HttpResponse("<h1> Employee Form Page </h1>")