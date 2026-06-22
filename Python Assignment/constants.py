# Constants in python
'''
Concepts Covered:
1. Constants in Python
2. Naming Convention for Constants
3. Constant Examples
Python does not provide built-in support for constants.
By convention, constants are written in UPPER_CASE letters.
Constants help improve code readability and maintainability.
'''

# creating constants
PI = 3.14159 # constant for pi
GRAVITY = 9.81 # constant for gravity

print("Creating constants: ")
print("PI:", PI)
print("GRAVITY:", GRAVITY)

# constants in calculations
print("\nUsing constants in calculations: ")
radius = 5
area = PI * radius ** 2
print("Area of circle with radius", radius, "is:", area)

#application constants

COMPANY_NAME = "ISS STOXX"
MAX_EMPLOYEES = 1000
COUNTRY = "INDIA"

print("\nApplication Constants: ")
print("Company Name:", COMPANY_NAME)
print("Maximum Employees:", MAX_EMPLOYEES)
print("Country:", COUNTRY)

# reassigning constants 
print("\nReassigning Constants: ")
# Although constants are not enforced in Python, it is a convention to treat them as immutable.


PI = 3.14 # This is not recommended, but possible
print("Reassigned PI:", PI)
