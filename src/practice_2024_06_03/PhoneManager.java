package practice_2024_06_03;
//p185_4
import java.util.ArrayList;
import java.util.Scanner;

class Phone {
    private String name;
    private String phoneNumber;

    public Phone(String name, String phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return name + "의 번호는 " + phoneNumber + " 입니다.";
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }
}

public class PhoneManager {
    private ArrayList<Phone> phoneBook;

    public PhoneManager() {
        phoneBook = new ArrayList<>();
    }

    public void addContact(String name, String phoneNumber) {
        phoneBook.add(new Phone(name, phoneNumber));
    }

    public String findContact(String name) {
        for (Phone contact : phoneBook) {
            if (contact.getName().equals(name)) {
                return contact.getPhoneNumber();
            }
        }
        return null;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PhoneManager manager = new PhoneManager();

        System.out.print("인원수 >> ");
        int numContacts = scanner.nextInt();
        scanner.nextLine(); // 개행문자 소비

        for (int i = 0; i < numContacts; i++) {
            System.out.print("이름과 전화번호(번호는 연속적으로 입력)>> ");
            String name = scanner.next();
            String phoneNumber = scanner.next();
            manager.addContact(name, phoneNumber);
        }
        System.out.println("저장되었습니다...");

        while (true) {
            System.out.print("검색할 이름 >> ");
            String name = scanner.next();
            if (name.equals("exit")) {
                System.out.println("프로그램을 종료합니다");
                break;
            }
            String phoneNumber = manager.findContact(name);
            if (phoneNumber != null) {
                System.out.println(name + "의 번호는 " + phoneNumber + " 입니다.");
            } else {
                System.out.println(name + "이 없습니다.");
            }
        }
        scanner.close();
    }
}
