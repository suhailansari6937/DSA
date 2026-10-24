# Write your MySQL query statement below
select eu.unique_id, e.name from EmployeeUNI as eu
right join Employees as e
on eu.id = e.id;