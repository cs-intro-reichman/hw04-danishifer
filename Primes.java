public class Primes {
    public static void main(String[] args) {
        if (args.length == 0) {
            return;
        }

        int n = Integer.parseInt(args[0]);
        System.out.println("Prime numbers up to " + n + ":");

        if (n < 2) {
            System.out.println("There are 0 primes between 2 and " + n + " (0% are primes)");
            return;
        }

        boolean[] isPrime = new boolean[n + 1];
        int i = 2;
        while (i <= n) {
            isPrime[i] = true;
            i++;
        }

        int p = 2;
        while (p * p <= n) {
            if (isPrime[p]) {
                int multiple = p * p;
                while (multiple <= n) {
                    isPrime[multiple] = false;
                    multiple += p;
                }
            }
            p++;
        }

        int count = 0;
        int num = 2;
        while (num <= n) {
            if (isPrime[num]) {
                System.out.println(num);
                count++;
            }
            num++;
        }

        int percent = (int) Math.round((count * 100.0) / n);
        System.out.println("There are " + count + " primes between 2 and " + n +
                           " (" + percent + "% are primes)");
    }
}
