# functions

'''
Concept covered:
1. Parameters and arguments
2. Return
3. Args and Kwargs
'''

# Parameters and Arguments
def greet_user(name):
    print(f"Hello, {name}!")


print("Parameters and Arguments!")

greet_user("Khushi")

# Return
def add_numbers(a, b):
    return a + b

print("\nReturn Example: ")
result = add_numbers(5, 10)
print("Sum:", result)

# example of checking balanced bracket

def check_balanced_brackets(brackets):

    count = 0

    for bracket in brackets:

        if bracket == "[":
            count += 1

        elif bracket == "]":
            count -= 1

        if count < 0:
            return False

    return count == 0


print("Balanced Brackets Check:")

print(check_balanced_brackets("[[[[[]]]]]"))
print(check_balanced_brackets("[[[[]]]"))
print(check_balanced_brackets("]][["))

#args

def calculate_sum(*numbers):

    return sum(numbers)


print("args example: ")
result = calculate_sum(10, 20, 30, 40, 50)

print("Total Sum:", result)

#kwargs - The arguments are stored as a dictionary inside the function.

def display_student_details(**details):

    print("Student Details:")

    for key, value in details.items():
        print(f"{key}: {value}")


print("kwargs Example: ")

display_student_details(
    name="Khushi",
    age=21,
    course="BAMMC",
    city="Mumbai"
)


# example of project details combining args and kwargs

def project_details(project_name, *technologies, **additional_info):

    print("Project Name: ", project_name)

    print("\nTechnologies: ")

    for technology in technologies:
        print("-", technology)

    print("\nAdditional Information: ")

    for key, value in additional_info.items():
        print(f"{key}: {value}")


print("Combined Example: ")

project_details(
    "Food Recommendation System",
    "Python",
    "Kafka",
    "PySpark",
    team_size=4,
    duration="3 Months"
)
