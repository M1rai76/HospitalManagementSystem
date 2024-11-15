# Hospital Management System

This project is a **console-based application** for managing patients and doctors in a simple healthcare system. It allows users to **sign up** and **log in** to access features such as inputting patient and doctor details, editing details, booking appointments, and displaying lists of doctors. The project demonstrates **object-oriented programming** principles in Java, such as inheritance and encapsulation, by organizing people (patients and doctors) with shared attributes and distinct behaviors.

---

## 💡 Features

### 1. **User Authentication**
   - **Signup**: New users can create an account with a unique ID, username, and password.
   - **Login**: Existing users can log in using their ID and password.

### 2. **Patient Management**
   - **Add Patient**: Input personal details for a patient, such as name, contact number, and age.
   - **Edit Patient Details**: Modify existing details for a patient by searching with their ID.
   - **Display Patient Details**: View specific patient details based on ID input.

### 3. **Doctor Management**
   - **Add Doctor**: Input personal details for a doctor, such as name, contact number, and age.
   - **Edit Doctor Details**: Modify existing details for a doctor by searching with their ID.
   - **Display Doctor Details**: View specific doctor details based on ID input.
   - **List All Doctors**: Display all added doctors with their complete details.

### 4. **Appointment Booking**
   - Allows a user to book an appointment between a patient and a doctor by providing both IDs.
   - Verifies if both patient and doctor exist before confirming the booking.

---

## 🛠️ Class Structure

### 1. **`LoginSignup` Class**
   - Manages user login and signup.
   - Stores user credentials in a 2D array for simplicity (up to 100 users).
   - Provides a menu-driven interface for user options after login.

### 2. **`Person` Class (Abstract)**
   - Serves as a base class for `Patient` and `Doctor`.
   - Common fields: `id`, `name`, `contactNumber`, and `age`.
   - Abstract method `inputDetails()` for child classes to implement specific input behavior.
   - Concrete method `displayDetails()` to show details of each person.

### 3. **`Patient` Class**
   - Extends the `Person` class, representing a patient in the system.
   - Implements the `inputDetails()` method to gather patient-specific details from the user.

### 4. **`Doctor` Class**
   - Extends the `Person` class, representing a doctor in the system.
   - Implements the `inputDetails()` method to gather doctor-specific details from the user.

---

## 📋 Usage Instructions

1. **Compile and Run**:
   - Compile the code using `javac oopj.java`.
   - Run the compiled code using `java oopj`.

2. **Menu Options**:
   - After logging in, the user can choose from the following options:
     - **1**: Input Patient Details
     - **2**: Input Doctor Details
     - **3**: Display Details (search by ID)
     - **4**: Book Appointment (enter Patient ID and Doctor ID)
     - **5**: Display All Doctors
     - **6**: Edit Patient Details (search by Patient ID)
     - **7**: Edit Doctor Details (search by Doctor ID)
     - **8**: Exit the system

3. **Example Workflow**:
   - A new user can select the **Signup** option to create an account.
   - After signup, the user logs in and is greeted with the main menu.
   - The user can then add patient and doctor details, book appointments, and manage records.

---

## 💾 Data Management

- **User Authentication Data**: Stored in a 2D array (`String[][] users`), where each entry holds user ID, username, and password.
- **Patient and Doctor Records**: Managed using `ArrayList<Patient>` and `ArrayList<Doctor>`, allowing for flexible record storage and management.
  
---

## 💻 Example Interaction

```
Choose an option:
1. Login
2. Signup
3. Exit
> 2

Enter your username:
> JohnDoe
Your ID is: U1
Choose a password:
> password123
Signup successful. You can now login.

Choose an option:
1. Login
2. Signup
3. Exit
> 1

Enter your ID:
> U1
Enter your password:
> password123
Login successful. Welcome, JohnDoe!

Choose an option:
1. Input Patient Details
2. Input Doctor Details
3. Display Details
4. Book Appointment
5. Display All Doctors
6. Edit Patient Details
7. Edit Doctor Details
8. Exit
> 1

Enter Patient's ID:
> P001
Enter Patient's Name:
> Alice Smith
Enter Patient's Contact Number:
> 1234567890
Enter Patient's Age:
> 30
Patient details added successfully.

Choose an option:
...
```

---

## 🔍 Key Object-Oriented Concepts Demonstrated

1. **Encapsulation**:
   - Patient and Doctor details are encapsulated within their respective classes.
   - Access to fields is controlled through the `inputDetails()` and `displayDetails()` methods.

2. **Inheritance**:
   - `Patient` and `Doctor` inherit from the abstract `Person` class, sharing common properties and behavior.

3. **Abstraction**:
   - The abstract `Person` class enforces that each subclass (Patient and Doctor) must implement the `inputDetails()` method.

---

## 🔧 Improvements and Future Enhancements

- **Database Integration**: Store user, patient, and doctor data in a database instead of using arrays and lists for persistent data storage.
- **Enhanced Authentication**: Add encryption for passwords and possibly multi-factor authentication.
- **Appointment Scheduling**: Introduce features for scheduling appointments with date and time management.
- **GUI Interface**: Develop a graphical user interface to replace the console-based interaction.

---

## 📝 Dependencies

- **Java Development Kit (JDK)**: Version 8 or later.
- **Scanner Class**: Used for console-based input.

---

This project serves as an excellent demonstration of **object-oriented programming** principles applied to a real-world scenario. It’s perfect for beginners looking to understand Java OOP concepts through a hands-on, interactive console application.
