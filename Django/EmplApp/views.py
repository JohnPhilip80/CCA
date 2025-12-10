from django.http import HttpResponse
from django.shortcuts import render, redirect

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

def employee_form(request,id=0):
    if id == 0:
        if request.method == 'GET':
            form = EmployeeForm()
            return render(request, 'form_employee.html', {'form': form})
        if request.method == 'POST':
            form = EmployeeForm(request.POST)
            if form.is_valid():
                form.save()
                return redirect('/employee/list')
    else:
        if request.method == 'GET':
            employee = Employee.objects.get(pk=id)
            form = EmployeeForm(instance=employee)
            return render(request, 'form_employee.html', {'form': form})
        else:
            employee = Employee.objects.get(pk=id)
            form = EmployeeForm(request.POST,instance=employee)
            if form.is_valid():
                form.save()
                return redirect('/employee/list')


def employee_delete(request,id):
    employee = Employee.objects.get(pk=id)
    employee.delete()
    return redirect('/employee/list')
