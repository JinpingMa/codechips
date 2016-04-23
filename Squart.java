public class Squart {
  static int sqrt(int x) {
    if(x == 0) {
      return 0;
    }
    double pre;
    double cur = 1;
    do {
      pre = cur;
      cur = x /(2 * pre) +pre /2.0;
    } while (Math.abs(cur - pre) >0.00001);
    return (int)cur;
  }
  public static void main(String[] args) {
    int x = 999;
    int y = sqrt(x);
    System.out.println(y);
  }
}
