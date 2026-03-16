import { Component } from '@angular/core';
import { Employee } from '../employee';
import { EmployeeService } from '../employee.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-employee-list',
  templateUrl: './employee-list.component.html',
  styleUrls: ['./employee-list.component.css']
})

export class EmployeeListComponent {

  employees: Employee[] = [];
  searchTerm: string = '';

  constructor(private employeeService: EmployeeService, private router: Router) {}

  ngOnInit(): void {
    this.getEmployees();
  }

  getEmployees(){
    this.employeeService.getEmployeesList()
    .subscribe(data => {
      this.employees = data;
    });
  }

  searchEmployee(){

    if(!this.searchTerm){
      this.getEmployees();
      return;
    }

    this.employeeService.searchEmployee(this.searchTerm)
    .subscribe(data =>{
      this.employees = data;
    });

  }

  updateEmployee(id: number){
    this.router.navigate(['updating-by-id', id]);
  }

  deleteEmployee(id: number){

    if(confirm("Are you sure to delete Employee ID: "+id)){
      this.employeeService.deleteEmployee(id)
      .subscribe(data => {
        console.log(data);
        this.getEmployees();
      })
    }

  }

  detailsOfEmployee(id: number){
    this.router.navigate(['details-of-employee', id]);
  }

}