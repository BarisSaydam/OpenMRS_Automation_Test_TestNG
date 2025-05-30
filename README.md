# OpenMRS Test Automation Project

This project includes automation tests for essential user operations on the OpenMRS (Open Medical Record System) platform. Tests are written using **TestNG** and the **Page Object Model** architecture. User stories are implemented based on the demo environment provided at [openmrs.org](https://openmrs.org).

## 👥 Contributors

| Username            | Commits       | Lines Added     | Lines Deleted   |
|---------------------|---------------|------------------|------------------|
| **[Ömer Boncuk](https://github.com/palanque92)**       | 6             | 464              | 1                |
| **[Gamze Batmaz](https://github.com/GAMZE3845/)**         | 5             | 744              | 265              |
| **[Erdem Özkan](https://github.com/ErdemOzkann)**        | 5             | 2,133            | 1,010            |
| **[Barış Saydam](https://github.com/BarisSaydam)**       | 3             | 436              | 56              |
| **[Atilla Toros Avcı](https://github.com/AtillaTorosAvci)**    | 1             | 723              | 1                |
|**[Diyar ölmez](https://github.com/diyarolmezz)**       | 1             | 176              | 0                |
| **[Ebubekir Duvarcı](https://github.com/Ebubekir2025)**      | 1             | 3                | 0                |

## 🛠 Technologies Used

- Java
- Selenium WebDriver
- TestNG
- Page Object Model (POM)
- Maven
- Git / GitHub

## 📋 User Stories Covered

The following user stories have been automated in this project:

1. **Handling Invalid Login Attempts**
2. **Successful Login to the System**
3. **Secure Logout**
4. **Patient Registration**
5. **Accessing Account Settings (My Account)**
6. **Searching Within the Patient List**
7. **Deleting a Patient**
8. **Listing All Patients**
9. **Merging Patient Records**
10. **Error Message for Incorrect Time Zone During Appointment Scheduling**

For detailed user stories, please refer to the file `UserStories_TR_openmrs.org.pdf`.

## 🚀 Setup and Running

1. Clone this repository:
   ```bash
   git clone https://github.com/GAMZE3845/OpenMRSProject.git
   ```
2. Open it with an IDE (e.g., IntelliJ IDEA).
3. Load Maven dependencies.
4. Run the tests using the `testng.xml` file.

## ✅ Test Environment Requirements

- Browser: Chrome, Firefox, Safari (any of these)
- URL: [https://openmrs.org](https://openmrs.org)
- Demo Login Credentials:
  - Username: `admin`
  - Password: `Admin123`
  - Location: `Inpatient Ward` (or other valid options)

## 📊 Reporting

Test results are generated automatically in HTML format using TestNG.

## 📌 Notes

- The project utilizes advanced TestNG features such as `@DataProvider`, `priority`, and test grouping.
- Page interactions are implemented following the Page Object Model (POM) pattern.
