
public class PaymentTerminal {
	private double money;  // amount of cash in register
    private int affordableMeals; // number of sold affordable meals
    private int heartyMeals;  // number of sold hearty meals

    public PaymentTerminal() {
        this.money = 1000;// register initially has 1000 euros of money
    }

    public double eatAffordably(double payment) {
        // an affordable meal costs 2.50 euros
        // increase the amount of cash by the price of an affordable mean and return the change
        // if the payment parameter is not large enough, no meal is sold and the method should return the whole payment
    	if (payment >= 2.5) {
    		this.money += 2.5;
    		this.affordableMeals += 1;
    		return payment - 2.5;
    	} else return payment;
    }

    public double eatHeartily(double payment) {
        // a hearty meal costs 4.30 euros
        // increase the amount of cash by the price of a hearty mean and return the change
        // if the payment parameter is not large enough, no meal is sold and the method should return the whole payment
    	if (payment >= 4.3) {
    		this.money += 4.3;
    		this.heartyMeals += 1;
    		return payment - 4.3;
    	} else return payment;
    }
    //same method but different parameter
    public boolean eatAffordably(PaymentCard card) {
        // an affordable meal costs 2.50 euros
        // if the payment card has enough money, the balance of the card is decreased by the price, and the method returns true
        // otherwise false is returned
    	if (card.balance() >= 2.5) {
    		card.takeMoney(2.5);
    		this.affordableMeals += 1;
    		return true;
    	} else return false;
    }

    public boolean eatHeartily(PaymentCard card) {
        // a hearty meal costs 4.30 euros
        // if the payment card has enough money, the balance of the card is decreased by the price, and the method returns true
        // otherwise false is returned
    	if (card.balance() >= 4.2) {
    		card.takeMoney(4.3);
    		this.heartyMeals += 1;
    		return true;
    	} else return false;
    }
    
    public void addMoneyToCard(PaymentCard card, double sum) {
        card.addMoney(sum);
    }
    
    public String toString() {
        return "money: " + money + ", number of sold afforable meals: " + affordableMeals + ", number of sold hearty meals: " + heartyMeals;
    }
}
