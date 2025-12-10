from django.urls import path
from EmplApp import views

urlpatterns = [
    path('',views.home_page),
    path('home/',views.home_page),
    path('aboutus/',views.aboutus_page),
    path('contactus/',views.contactus_page),
    path('list/',views.employee_list, name='empl_list'),
    path('form/',views.employee_form, name="empl_create"),
    path('form/<int:id>',views.employee_form, name="empl_update"),
    path('delete/<int:id>',views.employee_delete, name="empl_delete"),
]