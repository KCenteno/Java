public class BankAccount {

    private double checkingBal;
    private double savingsBal;
    // Need to track total amount of accounts
    static int numOfAccounts;
    // Need to track all monies stored in every account
    static double bigMoneys;

    public BankAccount() {
        // track all accounts as they are created
        numOfAccounts++;
    }

    public void transaction(String type, String account, int amt) {
        if(type == "deposit") {

            if (account == "checking") {
                this.checkingBal += amt;
                this.bigMoneys += amt;
                System.out.println("You have made a deposit to your checking account in the amount of " + amt + ". Your curent balance is now " + this.checkingBal);
            }
            else if (account == "savings"){
                this.savingsBal += amt;
                this.bigMoneys += amt;
                System.out.println("You have made a deposit to your savings account in the amount of " + amt + ". Your curent balance is now " + this.savingsBal);
            }else{
                System.out.println("Must enter either checking or savings to make a deposit!");
            }
        }
        else if(type == "withdrawal") {
            if (account == "checking") {
                if(this.checkingBal < amt ) {
                    System.out.println("Ah ah ah!! You dont get the monies that you dont have!");
                    return;
                }
                this.checkingBal -= amt;
                this.bigMoneys -= amt;
                System.out.println("You have taken monies from your checking account in the amount of " + amt + ". Your curent balance is now " + this.checkingBal);
            }
            else if (account == "savings"){
                if(this.checkingBal < amt ) {
                    System.out.println("Ah ah ah!! You dont get the monies that you dont have!");
                    return;
                }
                this.savingsBal -= amt;
                this.bigMoneys -= amt;
                System.out.println("You have taken monies from your savings account in the amount of " + amt + ". Your curent balance is now " + this.savingsBal);
            }
            else{
                System.out.println("Must enter either checking or savings to make a deposit!");
            }
        }else {
            System.out.println("Must enter either checking or savings to make a deposit!");
        }
    }

    // public void deposit(String account, int amt) {
    //     if (account == " checking") {
    //         this.checkingBal += amt;
    //         System.out.println("You have made a deposit to your checking account in the amount of " + amt + ". Your curent balance is now " + this.checkingBal);
    //     }
    //     else if (account == "savings"){
    //         this.savingsBal += amt;
    //         System.out.println("You have made a deposit to your savings account in the amount of " + amt + ". Your curent balance is now " + this.savingsBal);
    //     }
    //     else{
    //         System.out.println("Must enter either checking or savings to make a deposit!");
    //     }
    // }

    // public void withdrawal(String account, int amt) {
    //     if (account == " checking") {
    //         this.checkingBal -= amt;
    //         System.out.println("You have taken monies from your checking account in the amount of " + amt + ". Your curent balance is now " + this.checkingBal);
    //     }
    //     else if (account == "savings"){
    //         this.savingsBal -= amt;
    //         System.out.println("You have taken monies from your savings account in the amount of " + amt + ". Your curent balance is now " + this.savingsBal);
    //     }
    //     else{
    //         System.out.println("Must enter either checking or savings to make a deposit!");
    //     }
    // }

    // Method to see both checking and svings balance
    public void allBal() {
        double all = this.checkingBal+this.savingsBal;
        System.out.println("Total balance from both Checking and Saving: " + all);
    }

    // Setter for the checking balance
    public void setCheckingBal(double amt) {
        this.checkingBal = amt;
    }
    
    // Setter for the savings balance
    public void setSavingsBal(double amt) {
        this.savingsBal = amt;
    }

    // Getter for the checking balance
    public double getCheckingBal() {
        System.out.println("Checking account balance: " + this.checkingBal);
        return this.checkingBal;
    }
    // Getter for the savings balance
    public double getSavingsBal() {
        System.out.println("Saving account balance: " + this.savingsBal);
        return this.savingsBal;
    }

}
