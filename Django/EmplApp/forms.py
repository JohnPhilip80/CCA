from django import forms

from EmplApp.models import Employee


class EmployeeForm(forms.ModelForm):
    class Meta:
        model = Employee
        #fields = '__all__'
        fields = ('fullname', 'mobile', 'empcode', 'position')
        labels = {
            'fullname': 'Full Name',
            'mobile': 'Mobile',
            'empcode': 'Employee Code',
            'position': 'Position'
        }