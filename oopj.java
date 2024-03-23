import java.util.ArrayList;
import java.util.Scanner;

class LoginSignup {
    private static String[][] users = new String[100][3]; // Storing user data: [id, username, password]
    private static int userCount = 0;

    public static void options() {
        Scanner scanner = new Scanner(System.in);
        boolean loop = true;
        while (loop) {
            System.out.println("Choose an option:");
            System.out.println("1. Login");
            System.out.println("2. Signup");
            System.out.println("3. Exit");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    login(scanner);
                    break;
                case 2:
                    signup(scanner);
                    break;
                case 3:
                    loop = false;
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please choose again.");
            }
        }
    }

    public static void login(Scanner scanner) {
        System.out.println("Enter your ID:");
        String id = scanner.next();
        System.out.println("Enter your password:");
        String pass = scanner.next();

        for (int i = 0; i < userCount; i++) {
            if (users[i][0].equals(id) && users[i][2].equals(pass)) {
                System.out.println("Login successful. Welcome, " + users[i][1] + "!");

                ArrayList<Patient> patients = new ArrayList<>();
                ArrayList<Doctor> doctors = new ArrayList<>();
                Scanner scanner1 = new Scanner(System.in);
                int choice;
                boolean loop = true;

                while (loop) {
                    System.out.println("Choose an option:");
                    System.out.println("1. Input Patient Details");
                    System.out.println("2. Input Doctor Details");
                    System.out.println("3. Display Details");
                    System.out.println("4. Book Appointment");
                    System.out.println("5. Display All Doctors");
                    System.out.println("6. Edit Patient Details");
                    System.out.println("7. Edit Doctor Details");
                    System.out.println("8. Exit");

                    choice = scanner.nextInt();

                    switch (choice) {
                        case 1:
                            Patient patient = new Patient();
                            patient.inputDetails();
                            patients.add(patient);
                            break;
                        case 2:
                            Doctor doctor = new Doctor();
                            doctor.inputDetails();
                            doctors.add(doctor);
                            break;
                        case 3:
                            System.out.println("Enter ID to display details:");
                            scanner.nextLine();
                            String idToSearch = scanner.nextLine();
                            boolean found = false;
                            for (Patient p : patients) {
                                if (p.id.equals(idToSearch)) {
                                    System.out.println("Patient Details:");
                                    p.displayDetails();
                                    found = true;
                                    break;
                                }
                            }
                            if (!found) {
                                for (Doctor d : doctors) {
                                    if (d.id.equals(idToSearch)) {
                                        System.out.println("Doctor Details:");
                                        d.displayDetails();
                                        found = true;
                                        break;
                                    }
                                }
                            }
                            if (!found) {
                                System.out.println("No details found for the given ID.");
                            }
                            break;
                        case 4:
                            bookAppointment(scanner, patients, doctors);
                            break;

                        case 5:
                            displayAllDoctors(doctors);
                            break;

                        case 6:
                            editPatientDetails(scanner, patients);
                            break;
                        case 7:
                            editDoctorDetails(scanner, doctors);
                            break;

                        case 8:
                            loop = false;
                            System.out.println("Exiting...");
                            break;
                        default:
                            System.out.println("Invalid choice. Please choose again.");
                    }
                }

                scanner.close();

                return;
            }
        }
        System.out.println("Invalid ID or password. Please try again.");
    }

    public static void editPatientDetails(Scanner scanner, ArrayList<Patient> patients) {
        System.out.println("Enter Patient's ID to edit details:");
        String patientID = scanner.next();

        boolean patientExists = false;
        int patientIndex = -1;
        for (int i = 0; i < patients.size(); i++) {
            if (patients.get(i).id.equals(patientID)) {
                patientExists = true;
                patientIndex = i;
                break;
            }
        }

        if (patientExists) {
            System.out.println("Choose what to edit:");
            System.out.println("1. Name");
            System.out.println("2. Contact Number");
            System.out.println("3. Age");

            int editChoice = scanner.nextInt();
            switch (editChoice) {
                case 1:
                    System.out.println("Enter new name:");
                    String newName = scanner.nextLine();
                    patients.get(patientIndex).name = newName;
                    System.out.println("Patient name updated successfully.");
                    break;
                case 2:
                    System.out.println("Enter new contact number:");
                    String newContactNumber = scanner.nextLine();
                    patients.get(patientIndex).contactNumber = newContactNumber;
                    System.out.println("Patient contact number updated successfully.");
                    break;
                case 3:
                    System.out.println("Enter new age:");
                    String newAge = scanner.nextLine();
                    patients.get(patientIndex).age = newAge;
                    System.out.println("Patient age updated successfully.");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } else {
            System.out.println("Patient not found.");
        }
    }

    public static void editDoctorDetails(Scanner scanner, ArrayList<Doctor> doctors) {
        System.out.println("Enter Doctor's ID to edit details:");
        String doctorID = scanner.next();

        boolean doctorExists = false;
        int doctorIndex = -1;
        for (int i = 0; i < doctors.size(); i++) {
            if (doctors.get(i).id.equals(doctorID)) {
                doctorExists = true;
                doctorIndex = i;
                break;
            }
        }

        if (doctorExists) {
            System.out.println("Choose what to edit:");
            System.out.println("1. Name");
            System.out.println("2. Contact Number");
            System.out.println("3. Age");

            int editChoice = scanner.nextInt();
            switch (editChoice) {
                case 1:
                    System.out.println("Enter new name:");
                    String newName = scanner.nextLine();
                    doctors.get(doctorIndex).name = newName;
                    System.out.println("Doctor name updated successfully.");
                    break;
                case 2:
                    System.out.println("Enter new contact number:");
                    String newContactNumber = scanner.nextLine();
                    doctors.get(doctorIndex).contactNumber = newContactNumber;
                    System.out.println("Doctor contact number updated successfully.");
                    break;
                case 3:
                    System.out.println("Enter new age:");
                    String newAge = scanner.nextLine();
                    doctors.get(doctorIndex).age = newAge;
                    System.out.println("Doctor age updated successfully.");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } else {
            System.out.println("Doctor not found.");
        }
    }

    public static void displayAllDoctors(ArrayList<Doctor> doctors) {
        System.out.println("List of Doctors:");
        for (Doctor doctor : doctors) {
            doctor.displayDetails();
        }
    }

    public static void bookAppointment(Scanner scanner, ArrayList<Patient> patients, ArrayList<Doctor> doctors) {
        System.out.println("Enter Patient's ID:");
        String patientID = scanner.next();
        System.out.println("Enter Doctor's ID:");
        String doctorID = scanner.next();

        boolean patientExists = false;
        boolean doctorExists = false;

        for (Patient patient : patients) {
            if (patient.id.equals(patientID)) {
                patientExists = true;
                break;
            }
        }

        for (Doctor doctor : doctors) {
            if (doctor.id.equals(doctorID)) {
                doctorExists = true;
                break;
            }
        }

        if (patientExists && doctorExists) {
            System.out.println("Appointment booked successfully.");
        } else {
            System.out.println("Invalid Patient ID or Doctor ID.");
        }
    }

    public static void signup(Scanner scanner) {
        System.out.println("Enter your username:");
        String username = scanner.next();
        String id = "U" + (userCount + 1); // Generating unique ID
        System.out.println("Your ID is: " + id);
        System.out.println("Choose a password:");
        String pass = scanner.next();

        users[userCount][0] = id;
        users[userCount][1] = username;
        users[userCount][2] = pass;
        userCount++;

        System.out.println("Signup successful. You can now login.");
    }
}

// Abstract class for Person
abstract class Person {
    protected String id;
    protected String name;
    protected String contactNumber;
    protected String age;

    // Abstract method to input details
    public abstract void inputDetails();

    // Method to display details
    public void displayDetails() {
        System.out.println("ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Contact Number: " + contactNumber);
        System.out.println("Age: " + age);
    }
}

// Class for Patient extending Person
class Patient extends Person {

    // Implementation of inputDetails for Patient
    public void inputDetails() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Patient's ID: ");
        id = scanner.nextLine();
        System.out.println("Enter Patient's Name: ");
        name = scanner.nextLine();
        System.out.println("Enter Patient's Contact Number: ");
        contactNumber = scanner.nextLine();
        System.out.println("Enter Patient's Age: ");
        age = scanner.nextLine();
    }
}

// Class for Doctor extending Person
class Doctor extends Person {

    // Implementation of inputDetails for Doctor
    public void inputDetails() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Doctor's ID: ");
        id = scanner.nextLine();
        System.out.println("Enter Doctor's Name: ");
        name = scanner.nextLine();
        System.out.println("Enter Doctor's Contact Number: ");
        contactNumber = scanner.nextLine();
        System.out.println("Enter Doctor's Age: ");
        age = scanner.nextLine();
    }
}

// Main class to test the implementation
public class oopj {
    public static void main(String[] args) {

        LoginSignup user = new LoginSignup();
        user.options();

    }
}