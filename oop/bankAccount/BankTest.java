public class BankTest {
    public static void main(String[] args) {
        
        BankAccount acct1 = new BankAccount();
        BankAccount acct2 = new BankAccount();

        acct1.transaction("deposit", "checking", 500);
        
        acct1.transaction("deposit", "savings", 500);

        acct2.transaction("deposit", "checking", 500);
        
        acct2.transaction("deposit", "savings", 500);

        acct1.transaction("withdrawal", "checking", 150);

        acct1.transaction("withdrawal", "savings", 175);

        acct1.transaction("withdrawal", "checking", 400);

        acct1.transaction("withdrawal", "savings", 400);

        acct1.allBal();

        System.out.println("Their are " + BankAccount.numOfAccounts + " accounts in total.");
        System.out.println("This Bank in total has $" + BankAccount.bigMoneys + ".");
    }
}
