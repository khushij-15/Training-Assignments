# Error Handling in Python

"""
Concepts Covered:
1. Try-Except
2. Else-Finally
3. Raise

"""

# Try-Except
# Example: Division Calculator

print("Try-Except Example: ")

try:

    numerator = int(input("Enter numerator: "))
    denominator = int(input("Enter denominator: "))

    result = numerator / denominator

    print("Result:", result)

except ZeroDivisionError:
    print("Cannot divide by zero.")

except ValueError:
    print("Please enter valid numbers.")

print("\n" + "=" * 50)

# Else-Finally
# Example: Age Validation

print("Else-Finally Example: ")

try:

    age = int(input("Enter your age: "))

except ValueError:
    print("Age must be a number.")

else:
    print("Age entered successfully:", age)

finally:
    print("Age validation completed.")

print("\n" + "=" * 50)

# Raise
# Example: Password Length Validation

print("Raise Example:  ")

try:

    password = input("Enter password: ")

    if len(password) < 8:
        raise ValueError("Password must contain at least 8 characters.")

    print("Password accepted.")

except ValueError as error:
    print("Error:", error)

print("\n" + "=" * 50)

# Additional Example
# Custom Marks Validation

print("Custom Validation Example: ")

try:

    marks = int(input("Enter marks: "))

    if marks < 0 or marks > 100:
        raise ValueError("Marks must be between 0 and 100.")

    print("Marks recorded successfully.")

except ValueError as error:
    print("Error:", error)