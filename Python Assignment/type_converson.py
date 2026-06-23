# type conversion

'''
Concepts Covered:
1. Type Conversion in Python
2. Implicit Type Conversion
3. Explicit Type Conversion
'''

# implicit Type Conversion
print("Implicit Type Conversion: ")

num1 = 10 # integer
num2 = 5.5 # float
result = num1 + num2 # implicit conversion to float

print("Result:", result)
print("Type of result:", type(result))

# string to integer conversion
print("\nString to Integer Conversion: ")
age = "25" # string
converted_age = int(age) # explicit conversion to int

print("Original Value:", age)
print("Original Type:", type(age))
print("Converted Value:", converted_age)
print("Converted Type:", type(converted_age))

# float to integer conversion
print("\nFloat to Integer Conversion: ")
height = 5.9 # float
converted_height = int(height) #explicit conversion to integer

print("Original Value:", height)
print("Original Type:", type(height))

print("Converted Value:", converted_height)
print("Converted Type:", type(converted_height))

# int to string conversion
print("\nInteger to String Conversion: ")
score = 100 # integer
converted_score = str(score) # explicit conversion to string

print("Original Value:", score)
print("Original Type:", type(score))
print("Converted Value:", converted_score)
print("Converted Type:", type(converted_score))

