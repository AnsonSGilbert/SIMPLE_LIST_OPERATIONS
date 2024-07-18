import java.util.Scanner;
class Hell {
    private static final int MAX = 50;
    private static int[] arr = new int[MAX];
    private static int size = 0;
    public static void display() {
        if (size == 0) {
            System.out.println("List is empty");
        }
        for (int i = 0; i < size; i++) {
            System.out.println((i + 1) + ". " + arr[i]);
        }
    }
    public static void insertAtPos(int pos, int val) {
        for (int i = size - 1; i >= pos; i--) {
            arr[i + 1] = arr[i];
        }
        arr[pos] = val;
        size++;
        System.out.println("inserted" + val + "at position" + pos + ".");
    }

    public static void search(int val) {
        boolean found = false;
        for (int i = 0; i < size; i++) {
            if (arr[i] == val) {
                System.out.println("value" + val + "found AT" + i + ".");
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("value" + val + "not found in the list.");
        }
    }

    public static void replace(int pos, int val) {
        if (pos < 0 || pos >= size) {
            System.out.println("invalid position");
            return;
        }
        int oldval = arr[pos];
        arr[pos] = val;
        System.out.println("replaced value" + oldval + "with" + val + "at position" + pos + ".");
    }

    public static void deleteFrompos(int pos) {
        int del = arr[pos];
        for (int i = pos; i < size; i++) {
            arr[i] = arr[i + 1];
        }
        size--;
        System.out.println("deleted" + del + "at " + pos + ".");
    }
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int ch, val, pos;
        while (true) {
            System.out.println("--------------------List Menu------------------------");
            System.out.println("1,insert at end");
            System.out.println("2,insert at specified position");
            System.out.println("3,Delete at specified location");
            System.out.println("4,Dispaly");
            System.out.println("5,search");
            System.out.println("6,replace");
            System.out.println("7,Exit");
            System.out.println("____________+++++++++++_______________");
            System.out.print("Enter UR Choice:");
            ch = s.nextInt();
            switch (ch) {
                case 1:
                    if (size == MAX) {
                        System.out.println("aRrAy Is FuLl");
                        break;
                    }
                    System.out.println("Enter the data:");
                    val = s.nextInt();
                    arr[size] = val;
                    size++;
                    break;
                case 2:
                    if (size == MAX) {
                        System.out.println("aRrAy Is FuLl");
                        break;
                    }
                    System.out.print("enter the position(start at 0):");
                    pos = s.nextInt();
                    if (pos < 0 || pos > size) {
                        System.out.println("InVaLiD Pos_-iOn!");
                        break;
                    }
                    System.out.println("Enter the data:");
                    val = s.nextInt();
                    insertAtPos(pos, val);
                    break;

                case 3:
                    if (size == 0) {
                        System.out.println("LiSt Is EmPtY");
                        break;
                    }
                    System.out.println("Enter the position(poisiton start with 0):");
                    pos = s.nextInt();
                    if (pos < 0 || pos > size) {
                        System.out.println("InVaLiD Pos_-iOn!");
                        break;
                    }
                    deleteFrompos(pos);
                    break;
                case 4:
                    display();
                    break;
                case 5:

                    System.out.println("search value");
                    val = s.nextInt();
                    search(val);

                    break;
                case 6:
                    System.out.print("enter the position to replace");
                    pos = s.nextInt();
                    if (pos < 0 || pos >= size) {
                        System.out.println("invalid position");
                        break;
                    }
                    System.out.print("enter the new value:");
                    val = s.nextInt();
                    replace(pos, val);
                    break;
                case 7:
                    System.out.println("Exit...");
                    System.exit(0);
                default:
                    System.out.println("invalid Choice!");
            }


        }
    }
}
