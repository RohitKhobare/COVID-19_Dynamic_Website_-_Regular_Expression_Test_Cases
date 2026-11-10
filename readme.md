# COVID-19 Testing Management System and STQA Test Cases

A software testing and quality assurance mini-project containing a PHP/MySQL COVID-19 testing management website and Java/Selenium/TestNG browser tests, including form-validation and regular-expression scenarios.

**Project team:** Rohit Khobare

## Project contents

- `covid-tms/` — PHP website, public pages, administrator pages, styles, scripts, and vendor assets.
- `stqa_db.sql` — SQL schema for the `stqa_db` MySQL database. Sample records and the demo administrator account have been removed.
- `Test/` — Java Selenium and TestNG tests, with Maven configuration in `Test/pom.xml`.
- `STQA_Mini_Project_Report.pdf` — project report.

## Website features

- Public COVID-19 information pages, testing registration, live updates, and report lookup.
- An administrator dashboard for managing patients, test requests, phlebotomists, test statuses, and reports.
- Patient and test-management forms with input-validation scenarios covered by the browser tests.
- MySQL persistence for administrator, patient, phlebotomist, and test-record data.

## Technology

- PHP and MySQL/MariaDB
- HTML, CSS, JavaScript, Bootstrap, jQuery, and DataTables
- Java 17, Maven, Selenium WebDriver, and TestNG
- Chrome browser for the Selenium tests

## Run the website locally

### Requirements

- PHP with the `mysqli` extension (PHP 7 or later)
- MySQL or MariaDB
- A browser
- XAMPP is one option for providing PHP, Apache, and MySQL on Windows

### Setup

1. Start MySQL/MariaDB. Start Apache too if you plan to use the XAMPP URL.
2. Create a database named `stqa_db` and import [`stqa_db.sql`](./stqa_db.sql), for example through phpMyAdmin. The dump creates empty tables and does not provide an administrator account or patient/test records.
3. Configure the database connection in `covid-tms/includes/config.php`. The supplied local configuration expects MySQL at `localhost:3306`, database `stqa_db`, user `root`, and an empty password; adjust it to match your local installation.
4. From the project root, start PHP's built-in development server:

   ```sh
   php -S 127.0.0.1:8081 -t covid-tms
   ```

5. Open <http://127.0.0.1:8081/> in your browser.

Alternatively, copy `covid-tms` into XAMPP's `htdocs` directory, start Apache and MySQL, and open <http://localhost/covid-tms/>.

The VS Code task **Start COVID TMS PHP app** is also configured for XAMPP's PHP executable at `C:\xampp\php\php.exe` and serves the app at `http://127.0.0.1:8081/`.

## Run the browser tests

### Requirements

- JDK 17
- Maven, or Eclipse with Maven and TestNG support
- Google Chrome and a compatible Selenium WebDriver setup
- The website running locally with its database configured

The tests navigate to `http://localhost/covid-tms/`. Update those URLs for your local server before running them. Selenium Manager is used by Selenium to locate a compatible browser driver.

Import `Test/` as an existing Maven project in Eclipse, allow Maven to resolve dependencies, and run the desired TestNG test classes. The login test reads `COVID_TMS_ADMIN_USERNAME` and `COVID_TMS_ADMIN_PASSWORD` from the environment; provide test-only credentials for a local test account. The Maven Surefire configuration refers to `Test/testng.xml`, which is not included in this project; configure or add a TestNG suite file before relying on `mvn test` to run the suite.

The test sources submit registrations and other actions to the configured site. Create any required test records using synthetic values in a disposable local database; do not run the tests against a production system or real patient records.

## Deployment

### GitHub Pages limitation

GitHub Pages hosts static files only. It cannot execute this project's PHP code or provide its MySQL database, so publishing this repository with GitHub Pages will **not** make the registration, login, administration, or database-backed report features work. The PHP application has not been deployed by this repository documentation.

To run the complete application publicly, deploy it to a PHP-capable web host (for example, a PHP hosting service or a server/VM configured with PHP and MySQL/MariaDB). Configure the database connection and credentials using the host's secure configuration mechanism, provision the database, and deploy the `covid-tms/` application directory. Use HTTPS, initialize only synthetic test data, and provision a new administrator account before exposing the application. Do not commit production credentials or patient information.

**Deployment status:** No PHP host or public deployment URL has been provided, so a live deployment has not been performed. Add the selected provider, deployment URL, and provider-specific release steps here after deployment.

If only the static informational landing page is needed on GitHub Pages, publish a separate static version; PHP-backed links and forms must be removed or clearly disabled. Do not publish the PHP source tree as if GitHub Pages were a PHP runtime.

## Data and security notice

The SQL dump contains only table definitions; its prior sample patient, staff, test, and administrator rows were removed. The Selenium fixtures now use generic test values and load administrator credentials from environment variables. Generated test output and report PDFs are excluded from Git by the root `.gitignore`; review any new files before publishing. The local database settings in `covid-tms/includes/config.php` are development defaults, not production credentials.

## Repository

The requested GitHub repository is [RohitKhobare/COVID-19_Dynamic_Website_-_Regular_Expression_Test_Cases](https://github.com/RohitKhobare/COVID-19_Dynamic_Website_-_Regular_Expression_Test_Cases).
