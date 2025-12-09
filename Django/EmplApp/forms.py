from django import forms

from EmplApp.models import Employee


class EmployeeForm(forms.ModelForm):
    class Meta:
        model = Employee
        #fields = '__all__'
        fields = ['fullname','empcode','mobile','position']
        labels = {
            'fullname': 'Full Name',
            'empcode': 'Employee Code',
            'mobile': 'Mobile Number',
            'position': 'Position Name',
        }
    def __init__(self,*args,**kwargs):
        super(EmployeeForm,self).__init__(*args,**kwargs)
        print("Employee Form")
        self.fields['position'].empty_label = 'Select Position'
        self.fields['mobile'].required = False