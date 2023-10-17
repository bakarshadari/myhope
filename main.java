class Solution {


    public static List<String> invalidTransactions(String[] transactions) {
        Map<String, List<Transaction>> transactionMap = new HashMap<>();

        // Create a map of transactions by name
        for (String transaction : transactions) {
            Transaction t = new Transaction(transaction);
            transactionMap.putIfAbsent(t.name, new ArrayList<>());
            transactionMap.get(t.name).add(t);
        }

        List<String> invalidTransactions = new ArrayList<>();

        // Check each transaction for validity
        for (String transaction : transactions) {
            Transaction t = new Transaction(transaction);

            // Check if the amount exceeds $1000
            if (t.amount > 1000) {
                invalidTransactions.add(transaction);
                continue;
            }

            // Check for transactions with the same name but in different cities within 60 minutes
            for (Transaction sameNameTransaction : transactionMap.get(t.name)) {
                if (!sameNameTransaction.city.equals(t.city) && Math.abs(sameNameTransaction.time - t.time) <= 60) {
                    invalidTransactions.add(transaction);
                    break;
                }
            }
        }

        return invalidTransactions;
    }

    static class Transaction {
        String name;
        int time;
        int amount;
        String city;

        Transaction(String transactionStr) {
            String[] parts = transactionStr.split(",");
            name = parts[0];
            time = Integer.parseInt(parts[1]);
            amount = Integer.parseInt(parts[2]);
            city = parts[3];
        }
    }
}

.....................................................
class Solution {


    public static List<String> invalidTransactions(String[] transactions) {
        Map<String, List<Transaction>> transactionMap = new HashMap<>();

        // Create a map of transactions by name
        for (String transaction : transactions) {
            Transaction t = new Transaction(transaction);
            transactionMap.putIfAbsent(t.name, new ArrayList<>());
            transactionMap.get(t.name).add(t);
        }

        List<String> invalidTransactions = new ArrayList<>();

        // Check each transaction for validity
        for (String transaction : transactions) {
            Transaction t = new Transaction(transaction);

            // Check if the amount exceeds $1000
            if (t.amount > 1000) {
                invalidTransactions.add(transaction);
                continue;
            }

            // Check for transactions with the same name but in different cities within 60 minutes
            for (Transaction sameNameTransaction : transactionMap.get(t.name)) {
                if (!sameNameTransaction.city.equals(t.city) && Math.abs(sameNameTransaction.time - t.time) <= 60) {
                    invalidTransactions.add(transaction);
                    break;
                }
            }
        }

        return invalidTransactions;
    }

    static class Transaction {
        String name;
        int time;
        int amount;
        String city;

        Transaction(String transactionStr) {
            String[] parts = transactionStr.split(",");
            name = parts[0];
            time = Integer.parseInt(parts[1]);
            amount = Integer.parseInt(parts[2]);
            city = parts[3];
        }
    }
}
