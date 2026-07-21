# Selenium Interview Questions

Java + Selenium WebDriver programs covering common automation testing scenarios asked in interviews — alerts, frames, dropdowns, waits, file uploads, JavaScript execution, and more.

## Project Structure

```
selenium-interview-questions/
├── .github/
├── .vscode/
├── .gitignore
└── important-selenium-programs/
    ├── src/
    │   ├── main/java/com/automation/pages/   ← Page Object classes (LoginPage.java)
    │   └── test/java/com/automation/         ← Test classes (30+ files: BrokenLinksTest, FrameSwitchTest, etc.)
    ├── target/                               ← Compiled output
    └── pom.xml                               ← Maven configuration
    
```

> **Note:** The actual Maven project lives inside `important-selenium-programs/`, not the repository root. Always open/import that folder in your IDE.

---

## Prerequisites

- **Java 21 or higher** — [Download Amazon Corretto](https://docs.aws.amazon.com/corretto/)
- **Maven 3.9+** — [Download Maven](https://maven.apache.org/download.cgi)
- **Git** — [Download Git](https://git-scm.com/downloads)
- **Google Chrome** (latest) — [Download Chrome](https://www.google.com/chrome/)

We recommend **Amazon Corretto** over Oracle JDK since it's free for personal and commercial use with no licensing restrictions.

---

## Dependencies

| Dependency | Version | Purpose |
|---|---|---|
| **Selenium Java** | 4.45.0 | Browser automation framework |
| **TestNG** | 7.12.0 | Test framework |

All dependencies are configured in `pom.xml` for automatic download.

---

## Setup Instructions

### 1. Clone the Project
```bash
git clone https://github.com/ArulMani767/selenium-interview-questions.git
cd selenium-interview-questions/important-selenium-programs
```

### 2. Build with Maven
```bash
mvn clean install
```

### 3. View Compiled Classes
```bash
# .class files are generated in:
target/classes/com/automation/
```

---

## IDE Setup

### Eclipse

1. Go to **File → Import → Git → Projects from Git (with smart import)** → Next
2. Select **Clone URI** → Next
3. In the **URI field**, paste:
```
https://github.com/ArulMani767/selenium-interview-questions.git
```

> ⚠️ After pasting, the following fields must auto-fill like this — do not edit them manually:
>
> - **URI:** `https://github.com/ArulMani767/selenium-interview-questions.git`
> - **Host:** `github.com`
> - **Repository path:** `/ArulMani767/selenium-interview-questions.git`
>
> If the Repository path looks duplicated or incorrect, click **Back**, clear the URI field (`Ctrl+A` → `Delete`), and paste the URL again.

4. Enter your GitHub **username** and **Personal Access Token** as the password → Next
5. Select branch **main** → Next
6. Choose a local directory → Next
7. Eclipse detects the project type — when prompted, **import as an existing Maven project** and point it to the `important-selenium-programs` folder → **Finish**

---

### IntelliJ IDEA

1. Go to **File → New → Project from Version Control**
2. In the **URL field**, paste:
```
https://github.com/ArulMani767/selenium-interview-questions.git
```

> ⚠️ Paste only in the URL field. The directory field will auto-fill — do not modify it unless you want a custom save location.

3. Click **Clone**
4. When IntelliJ finishes cloning, open the **`important-selenium-programs`** subfolder specifically (not the repo root)
5. Click **Open as Maven Project** when prompted → Done

---

### VS Code

1. Open Command Palette (`Ctrl+Shift+P`) → type **Git: Clone**
2. Paste:
```
https://github.com/ArulMani767/selenium-interview-questions.git
```
3. Press **Enter** → choose a local folder to clone into
4. When prompted to open the folder, browse into it and select the **`important-selenium-programs`** subfolder
5. Install **Extension Pack for Java** if not already installed
6. VS Code auto-detects Maven and sets up the project — wait for the bottom-right status bar to finish loading → Done

---

### JetBrains (WebStorm / PyCharm / Other)

1. Go to **File → New → Project from Version Control**
2. In the **URL field**, paste:
```
https://github.com/ArulMani767/selenium-interview-questions.git
```

> ⚠️ Paste only in the URL field — do not click into other fields before pasting.

3. Click **Clone**
4. Open the **`important-selenium-programs`** subfolder as the project root → Done

---

## Running a Test

**From your IDE:** open any test class in `src/test/java/com/automation/` and click the green **Run** arrow.

**From terminal:**
```bash
mvn test -Dtest=BrokenLinksTest
```
Replace `BrokenLinksTest` with any test class name from the project.

---

## Build Commands

```bash
# Clean and compile all files
mvn clean compile

# Run tests
mvn test

# Create package
mvn package
```

---

## Common Build Issues & Solutions

| Problem | Solution |
|---|---|
| `mvn: command not found` | Install Maven 3.9+, add its `bin` folder to system PATH |
| Compilation failed | Run `mvn clean compile` |
| Import errors in IDE | Run `mvn clean install`, then clean/restart the IDE's language server |
| Java version error | Install JDK 21 or higher |
| Missing artifact `selenium-java` | Check `pom.xml` groupId is `org.seleniumhq.selenium` (not `org.openqa.selenium`) |

---

## Key Features

✅ **30+ Selenium Automation Programs**
- Alerts, frames, windows, and dropdown handling
- Waits (Fluent Wait, explicit waits)
- File upload, drag-and-drop, mouse actions
- JavaScript executor use cases
- Page Object Model example

✅ **Maven Build System**
- Automatic dependency management
- Easy IDE integration
- Selenium 4.6+ auto-manages the browser driver — no manual ChromeDriver download needed

---

## Learn More

- [Selenium Documentation](https://www.selenium.dev/documentation/)
- [TestNG Documentation](https://testng.org/doc/)
- [Maven Guide](https://maven.apache.org/guides/)
