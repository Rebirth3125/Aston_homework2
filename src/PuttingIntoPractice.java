import java.util.Arrays;
import java.util.List;
import java.util.Comparator;

public class PuttingIntoPractice {

    public static void main(String... args) {
        Trader raoul = new Trader("Raoul", "Cambridge");
        Trader mario = new Trader("Mario", "Milan");
        Trader alan = new Trader("Alan", "Cambridge");
        Trader brian = new Trader("Brian", "Cambridge");

        List<Transaction> transactions = Arrays.asList(
                new Transaction(brian, 2011, 300),
                new Transaction(raoul, 2012, 1000),
                new Transaction(raoul, 2011, 400),
                new Transaction(mario, 2012, 710),
                new Transaction(mario, 2012, 700),
                new Transaction(alan, 2012, 950)
        );
//Первое задание:
        List<Transaction> num1 = transactions.stream()
                .filter(transaction -> transaction.getYear() == 2011)
                .sorted(Comparator.comparingInt(Transaction::getValue))
                .toList();

        num1.forEach(System.out::println);

//Второе задание:
        List<String> num2 = transactions.stream()
                .map(transaction -> transaction.getTrader().getCity())
                .distinct()
                .toList();

        num2.forEach(System.out::println);

//Третье задание:
        List<Trader> num3 = transactions.stream()
                .map(Transaction::getTrader)
                .filter(trader -> "Cambridge".equals(trader.getCity()))
                .distinct()
                .sorted((t1, t2) -> t1.getName().compareTo(t2.getName()))
                .toList();

        num3.forEach(System.out::println);

//Четвёртое задание:
        String num4 = transactions.stream()
                .map(transaction -> transaction.getTrader().getName())
                .distinct()
                .sorted()
                .toList().toString();

        System.out.println(num4);

//Пятое задание:
        boolean num5 = transactions.stream()
                .map(Transaction::getTrader)
                .anyMatch(trader -> "Milan".equals(trader.getCity()));

        System.out.println(num5);

//Шестое задание:
        int num6 = transactions.stream()
                .filter(transaction -> "Cambridge".equals(transaction.getTrader().getCity()))
                .mapToInt(Transaction::getValue)
                .sum();

        System.out.println("Сумма всех транзакций трейдеров из Кембриджа: " + num6);
    }
}