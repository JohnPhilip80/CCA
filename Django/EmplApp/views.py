from django.http import HttpResponse
from django.shortcuts import render

from EmplApp.forms import EmployeeForm
from EmplApp.models import Employee


# Create your views here.

def home_page(request):
    return render(request,'home.html')

def aboutus_page(request):
    return render(request,'aboutus.html')

def contactus_page(request):
    return render(request,'contactus.html')

def employee_list(request):
    context = {'employees': Employee.objects.all()}
    return render(request,'list_employee.html',context)

def employee_form(request):
    #return render(request,'form_employee.html')
    form = EmployeeForm()
    return render(request, 'form_employee.html', {'form': form})