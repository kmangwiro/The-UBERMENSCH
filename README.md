# 🧠 Product Association and Demand Forecasting Flask App

This Flask web application performs **Product Association Analysis** using the Apriori algorithm and **Demand Forecasting** based on frequent itemsets.

### 🚀 Features:
- Secure login & registration (Flask-Login)
- Upload CSV/XLSX data for analysis
- Product Association Mining using `mlxtend`
- Forecasting demand based on product association rules
- Beautiful dashboard display of top rules & forecast
- PostgreSQL Database integration

### 📂 Folder Structure:

### 🔧 How to Run Locally:
```bash
git clone https://github.com/kmangwiro/The-UBERMENSCH.git
cd The-UBERMENSCH
python -m venv venv
source venv/bin/activate  # On Windows: venv\Scripts\activate
pip install -r requirements.txt
python app.py
