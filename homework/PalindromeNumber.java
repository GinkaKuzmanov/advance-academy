package homework;

public class PalindromeNumber {
    public static void main(String[] args) {
        System.out.println(largestPalindrome(3));
    }
    static int largestPalindrome(int n)
    {
        int upperLimit = 0;
        //поставяме горна граница 999;
        for (int i = 1; i <= n; i++)
        {
            upperLimit *= 10;
            upperLimit += 9;
        }
        //долна граница 100 = 1 + (999/10)=>99
        int lowerLimit = 1 + upperLimit / 10;
        // Initialize result
        int maxProduct = 0;
//външен фор от 999 до 100 вкл.
        for (int i = upperLimit; i >= lowerLimit; i--)
        {
            //вътрешен фор от 999 до 100 също
            for (int j = i; j >= lowerLimit; j--)
            {
                int product = i * j;
                if (product < maxProduct)
                    break;
                int number = product;
                int reverse = 0;

                while (number != 0)
                {
                    //обръщаме огледално всяка цифра и я запазваме в reverse
                    reverse = reverse * 10 + number % 10;
                    number /= 10;
                }

                if (product == reverse && product > maxProduct)
                    maxProduct = product;
            }
        }
        return maxProduct;
    }
}
