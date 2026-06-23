# Control Flow in Python

"""
Concepts Covered:
1. If-Else
2. For Loop
3. While Loop
4. Break Statement
5. Continue Statement
6. Pass Statement
7. Loop Else

Banking System Examples
"""

# If-Else
# Example: Loan Eligibility Check

print("Loan Eligibility Check: ")

monthly_income = 50000
credit_score = 750

if monthly_income >= 40000 and credit_score >= 700:
    print("Loan Approved")
else:
    print("Loan Rejected")

print("\n" + "=" * 50)

# For Loop
# Example: Calculate Total Transactions

print("Transaction Summary: ")

transactions = [5000, 1200, 3500, 8000, 1500]

total_amount = 0

for amount in transactions:
    total_amount += amount

print("Transactions:", transactions)
print("Total Transaction Amount:", total_amount)

print("\n" + "=" * 50)

# While Loop
# Example: ATM PIN Verification

print("ATM PIN Verification: ")

correct_pin = 1234
attempts = 0
max_attempts = 3

while attempts < max_attempts:

    entered_pin = int(input("Enter your PIN: "))

    if entered_pin == correct_pin:
        print("PIN Verified Successfully")
        break

    print("Incorrect PIN")
    attempts += 1

else:
    print("Card Blocked. Maximum attempts exceeded.")

print("\n" + "=" * 50)

# Break Statement
# Example: Fraud Transaction Detection

print("Fraud Detection: ")

transactions = [500, 1200, 2500, 15000, 800]

for amount in transactions:

    if amount > 10000:
        print("Suspicious Transaction Detected:", amount)
        break

    print("Transaction Processed:", amount)

print("\n" + "=" * 50)

# Continue Statement
# Example: Skip Failed Transactions

print("Successful Transactions: ")

transaction_status = [
    {"id": 101, "status": "Success"},
    {"id": 102, "status": "Failed"},
    {"id": 103, "status": "Success"},
    {"id": 104, "status": "Failed"}
]

for transaction in transaction_status:

    if transaction["status"] == "Failed":
        continue

    print("Processed Transaction ID:", transaction["id"])

print("\n" + "=" * 50)

# Pass Statement
# Example: Future KYC Verification Feature

print("KYC Verification: ")

customer_type = "Premium"

if customer_type == "Premium":
    pass  # KYC verification logic will be added later

print("Customer Profile Loaded")

print("\n" + "=" * 50)

# Loop Else
# Example: Search Account Number

print("Account Search:  ")

account_numbers = [1001, 1002, 1003, 1004]

search_account = 1005

for account in account_numbers:

    if account == search_account:
        print("Account Found")
        break

else:
    print("Account Not Found")