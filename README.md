> 📘 **English Version**  
> This document is the English version of the original project README.  
> Looking for the Portuguese version? [Click here 🇵🇹](./README.pt.md)

---

# Migrant_Matcher

## Java project developed for the **Object-Centered Development** course unit  
### Faculty of Sciences of the University of Lisbon

---

## 📌 Project Description

**MigrantMatcher** is an application designed to facilitate and streamline humanitarian aid for migrants in emergency situations such as war, natural disasters, or social crises. The application allows volunteers to offer help (in the form of housing or goods), and enables migrants to easily locate and request available assistance.

---

## 👥 Authors

- Francisco Henriques - FC56348  
- Manuel Cardoso - FC56274

---

## 🚀 How to Run MigrantMatcher

To launch the application, simply run the `Main.java` class and follow the instructions displayed in the terminal.

### Running the test script: `casoDeUsoProcurarAjuda()`

1. The `input.txt` file is already prepared with:
   - 3 help offers
   - 3 help requests

2. When the script is executed, the application will automatically scan the `input.txt` file, which must follow the structured command format below:

#### Expected format for `input.txt`:

##### Use Case: Register Help
```
-volunteer
-999999999              // Volunteer’s phone number
-(type of help)
-(number of people it hosts OR item description)
-(region)
-yes                    // Confirm donation
-123456                 // Confirmation code
-no                     // End operation
```

##### Use Case: Search for Help
```
-migrant
-(phone number)
-(name)
-(region you’re moving to)
-(type of sorting: type or date)
-0                      // Select help
-no                     // Don’t add more help
-yes                    // Confirm reservation
-no                     // End operation
```

3. The result of the script execution will be written to the `output.txt` file.

---

## 📚 Use Cases

### 1️⃣ Register Help

Allows volunteers to offer accommodations or items to migrants.

**Steps:**
- The volunteer identifies themselves using their phone number.
- Chooses the type of help (accommodation or item).
- If accommodation: indicates the number of people it can host and the region.
- If item: provides a description of the item and the region.
- The system sends a confirmation code via SMS.
- The volunteer enters the code and confirms the offer.

---

### 2️⃣ Search for Help

Allows migrants to search for and reserve available assistance.

**Steps:**
- Migrant can register individually or with a family.
- Provides name and phone number (or head of household + members).
- Chooses the region they plan to move to.
- Views the list of available help (sorted by type or date).
- Selects the desired help.
- Confirms the reservation.
- The system notifies the corresponding volunteers via SMS.

---

### 🧩 Extension 5a

- If there’s no help available in the chosen region, the system notifies the user.
- The migrant can choose to be notified when help becomes available in that region.

---
