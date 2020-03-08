package functions;

public class HomeworkTwo {
    public static void main(String[] args) {
		
        eligibleForLoan("Ginka", 27,2,6500,90000);

    }
    
    private static void eligibleForLoan(String name, int age, int months, double salary, double amount){
        if(!name.isEmpty() && age !=0 && amount!=0.0 && months!=0){
             if(age < 18){
                 System.out.println("Трябва да имате навършени 18 години, за да изтеглите кредит.");
             }else{
                if(1000 < amount && amount <= 50000){
                    System.out.println(String.format("Вашата вноска е: %.2f BGN.", amount/months));
                }
                if(amount > 50000){
                    if(salary>2000){
                        System.out.println(String.format("Вашата вноска е: %.2f BGN.", amount/months));
                    }else{
                        System.out.println("Съжаляваме, но максимума за такъв доход е 20000 лева.");
                    }
                }
                 if(salary>5000 && amount < 100000){
                     System.out.println("С такъв доход можем да ви предложим 100 000 лева.");
                 }
                if(amount <= 1000 && months > 12){
                    System.out.println(String.format("Не може да изтеглите %.2f BGN за избрания период.", amount));
                } if(amount <= 1000 && months <= 12){
                    System.out.println(String.format("Вашата вноска е: %.2f BGN.", amount/months));
                }

             }
        }
        else{
           System.out.println("Моля,попълнете всички полета.");
        }


    }
}
