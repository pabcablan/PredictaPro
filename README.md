# **PredictaPro**
## **Overview**

PredictaPro is a modular and efficient application designed to process, analyze, and visualize data intuitively. It provides essential functionalities for handling datasets and supports users in cleaning, 
analyzing, and predicting trends from data. PredictaPro is in its initial version and aims to be a user-friendly and flexible tool for datasets of any size.

---

## **Key Features**
### 1. **Data Cleaning**
Removes outliers from datasets using statistical techniques:
- Calculates mean and standard deviation.
- Removes data points that deviate significantly from the dataset's trends.
- Ensures data quality by keeping only relevant and realistic values.
 
### 2. **Value Prediction**
Uses simple linear regression to predict future trends:
- Predicts the next data point based on existing trends.
- Provides meaningful insights for future planning.

### 3. **Report Visualization**

Creates tabular reports that compare raw and cleaned data:
- Highlights adjustments made during data cleaning.
- Presents original and cleaned values alongside timestamps.

### 4. **Data Analysis**

Calculates statistical metrics for cleaned datasets:
- Average value.
- Minimum and maximum values.
- Range of data.

---

## **Upcoming Features**
PredictaPro is in its initial version. Future releases will include:
- **File Uploads:** Support for CSV and JSON datasets.
- **Graphical Visualization:** Charts to display trends and distributions.
- **Export Options:** Ability to save reports as PDF or Excel files.
- **Advanced Analytics:** Inclusion of metrics like medians, percentiles, and correlation coefficients.

---

## **Example of Usage**
### **Input Data**
```java
List<DataPoint> rawData = Arrays.asList(
    new DataPoint(1, 10.5, System.currentTimeMillis()),
    new DataPoint(2, -50.0, System.currentTimeMillis() - 86400000L),
    new DataPoint(3, 20.0, System.currentTimeMillis())
);
```

### **System Output**
#### **Prediction Result**
```text
Predicted Value: 15.25  
Message: Prediction successfully calculated using linear regression.
```

#### **Tabular Report**
```text
ID    ORIGINAL VALUE   CLEANED VALUE   TIMESTAMP  
================================================  
1     10.50            10.50           2024-12-15 12:00:00  
2     -50.00           ----            2024-12-14 12:00:00  
3     20.00            20.00           2024-12-15 12:00:00  
```
#### **Data Analysis**
```text
Average of Cleaned Values: 15.25  
Maximum Value: 20.00  
Minimum Value: 10.50  
Range of Values: 9.50  
```
---

## **System Requirements**
- **Java JDK 8** or higher.
- **Java-compatible IDE:** Recommended options include:
    - **IntelliJ IDEA**
    - **Eclipse**
    - **NetBeans**
- **Operating System:** Compatible with Windows, macOs, and Linux

---

## **Getting Started**
### **Installation**
1. Download the source code from the repository:
```bash
git clone https://github.com/pabcablan/PredictaPro.git
```
2. Open the project in your favorite IDE.

### **Execution**
1. Compile the project.
2. Run the main class: ``Main.java.``

---

## **Applications of the Software**
- **Data Cleaning and Processing:** Eliminate outliers and prepare data for deeper analysis.
- **Quick Reporting:** Generate clear, readable tabular reports comparing raw and cleaned data.
- **Future Predictions:** Use predictive insights for trend analysis.

---

## **Benefits of PredicTaPro**
- **Modularity:** Easily expandable and adaptable to new requirements.
- **Simplicity:** Designed with an intuitive structure for users of all levels.
- **Performance:** Efficiently handles large datasets with minimal delay.

---

## **Project Status**
PredictaPro is currently in its initial release. The focus has been on providing reliable core functionalities while creating a robust foundation for future improvements.

---

## **License**
This software is available for educational and reference use. For commercial or enterprise use, please contact us.

---

## **Contact and Support**
Do you have any questions or suggestions? Reach out to us:
📧 [soporte@predictapro.com](soporte@predictapro.com)

