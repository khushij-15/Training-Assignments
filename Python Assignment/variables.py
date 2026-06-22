# Variables in Python
'''
Concepts Covered:
1. Variables
2. Variable Naming Rules
3. Multiple Variable Assignment
4. Assigning Same Value to Multiple Variables
5. Updating Variables

A variable is a named memory location used to store data.
Python automatically determines the data type based on the value assigned.
'''
#creating variables
name = "John" #string variable
age = 25 #integer variable
height = 5.9 #float variable
is_employed = True #boolean variable

print("Creating variables: ")
print("Name:", name)
print("Age:", age)
print("Height:", height)
print("Is Employed:", is_employed)


# checking variable data types
print("\nChecking variable data types: ")
print("Data type of name:", type(name))
print("Data type of age:", type(age))
print("Data type of height:", type(height))
print("Data type of is_employed:", type(is_employed))

# multiple variable assignment
print("\nMultiple Variable Assignment: ")
x, y, z = 10, 20, 30
print("x:", x)
print("y:", y)
print("z:", z)

# assigning same value to multiple variables
print("\nAssigning Same Value to Multiple Variables: ")
a = b = c = 100
print("a:", a)
print("b:", b)
print("c:", c)

# updating variables
print("\nUpdating Variables: ")
print("Original value of x:", x)
x = 100
print("Updated value of x:", x)

#varible naming rules

student_name = "Rahul"
_student_id = 101

print("\nVariable Naming Rules: ")
print("Valid variable names:")
print("student_name:", student_name)
print("_student_id:", _student_id)

print("\nInvalid variable names:")
# 1name = "Test"
# class = "Python"
# first-name = "John"
# space name = "Invalid"



