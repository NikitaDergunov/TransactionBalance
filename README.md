# TransactionBalance
To run clone either master(without to usd conversion functionality) or exchange_course(full functionality)
In folder .../TransactionBalance run: mvn package
to start the app run: java -jar target/balance-1.0-SNAPSHOT.jar

User error handling:
Utitlity class Helper.
methods checkTransaction(String transaction) use regex to verify if user input is correct.
