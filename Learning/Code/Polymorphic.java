class Income {
    protected double income;

    public Income(double income){
        this.income = income;
    }

    public double getTax(){
        return this.income * 0.1;
    }
}

class Salary extends Income{
    public Salary(double income){
        super(income);
    }
    
    public double getTax(){
        if (income < 5000){
            return 0;
        } else {
            return (income - 5000) * 0.1;
        }
    }
}

class RoyaltyIncome extends Income{
    public RoyaltyIncome(double income){
        super(income);
    }

    public double getTax(){
        return income * 0.4;
    }
}

public class Polymorphic{
    /** 优化写法
    public static double getTotalTax(Income... incomes){
        double total = 0;

        for (Income income: incomes){
            total += income.getTax();
        }

        return total;
    }
    
    public static void main(String[] args){
        Income[] incomes = new Income[]{
            new Income(2000),
            new Salary(8000),
            new RoyaltyIncome(10000)
        };

        System.out.println(getTotalTax(incomes));

    }
    */

    public static double getTotalTax(Income... incomes){
        double total = 0;

        for (Income income: incomes){
            total += income.getTax();
        }

        return total;
    }


    public static void main(String[] args){
        Income income = new Income(2000);
        Income salary = new Salary(8000);
        Income royaltyIncome = new RoyaltyIncome(10000);

        Income[] incomes = new Income[]{income, salary, royaltyIncome};

        System.out.println(getTotalTax(incomes));
    }
}