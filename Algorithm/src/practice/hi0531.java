package practice;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class hi0531 {
    // 학생 정보를 저장하는 HashMap: key는 학번(String), value는 학생 이름(String)
    private Map<String, String> studentMap = new HashMap<>();
    private Scanner scanner = new Scanner(System.in);

    // 메인 실행 메서드
    public void run() {
        while (true) {
            printMenu();
            int choice = getIntInput("메뉴를 선택하세요: ");
            switch (choice) {
                case 1:
                    addStudent();
                    break;
                case 2:
                    searchStudent();
                    break;
                case 3:
                    updateStudent();
                    break;
                case 4:
                    deleteStudent();
                    break;
                case 5:
                    printAllStudents();
                    break;
                case 6:
                    checkStudentExistence();
                    break;
                case 0:
                    System.out.println("프로그램을 종료합니다.");
                    return;
                default:
                    System.out.println("잘못된 입력입니다. 다시 선택하세요.");
            }
        }
    }

    // 메뉴 출력
    private void printMenu() {
        System.out.println("\n=== 학생 관리 시스템 ===");
        System.out.println("1. 학생 추가");
        System.out.println("2. 학생 조회");
        System.out.println("3. 학생 정보 수정");
        System.out.println("4. 학생 삭제");
        System.out.println("5. 전체 학생 목록 출력");
        System.out.println("6. 학생 존재 여부 확인");
        System.out.println("0. 종료");
    }

    // 학생 추가
    private void addStudent() {
        String id = getStringInput("학번을 입력하세요: ");
        if (studentMap.containsKey(id)) {
            System.out.println("이미 등록된 학번입니다.");
            return;
        }
        String name = getStringInput("이름을 입력하세요: ");
        studentMap.put(id, name);
        System.out.println("학생이 추가되었습니다.");
    }

    // 학생 조회
    private void searchStudent() {
        String id = getStringInput("조회할 학번을 입력하세요: ");
        String name = studentMap.get(id);
        if (name != null) {
            System.out.println("학번: " + id + ", 이름: " + name);
        } else {
            System.out.println("해당 학번의 학생이 없습니다.");
        }
    }

    // 학생 정보 수정
    private void updateStudent() {
        String id = getStringInput("수정할 학생의 학번을 입력하세요: ");
        if (!studentMap.containsKey(id)) {
            System.out.println("해당 학번의 학생이 없습니다.");
            return;
        }
        String newName = getStringInput("새 이름을 입력하세요: ");
        studentMap.put(id, newName);
        System.out.println("학생 정보가 수정되었습니다.");
    }

    // 학생 삭제
    private void deleteStudent() {
        String id = getStringInput("삭제할 학생의 학번을 입력하세요: ");
        String removed = studentMap.remove(id);
        if (removed != null) {
            System.out.println("학생이 삭제되었습니다.");
        } else {
            System.out.println("해당 학번의 학생이 없습니다.");
        }
    }

    // 전체 학생 목록 출력
    private void printAllStudents() {
        if (studentMap.isEmpty()) {
            System.out.println("등록된 학생이 없습니다.");
            return;
        }
        System.out.println("\n--- 전체 학생 목록 ---");
        // entrySet을 활용하여 모든 key-value 쌍을 출력
        for (Map.Entry<String, String> entry : studentMap.entrySet()) {
            System.out.println("학번: " + entry.getKey() + ", 이름: " + entry.getValue());
        }
    }

    // 학생 존재 여부 확인
    private void checkStudentExistence() {
        String id = getStringInput("존재 여부를 확인할 학번을 입력하세요: ");
        if (studentMap.containsKey(id)) {
            System.out.println("학번 " + id + "는 등록되어 있습니다.");
        } else {
            System.out.println("학번 " + id + "는 등록되어 있지 않습니다.");
        }
    }

    // 문자열 입력 받기
    private String getStringInput(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine().trim();
    }

    // 정수 입력 받기 (예외 처리 포함)
    private int getIntInput(String prompt) {
        while (true) {
            try {
                System.out.print(prompt);
                return Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("숫자를 입력하세요.");
            }
        }
    }

    // 메인 메서드
    public static void main(String[] args) {
        StudentManager manager = new StudentManager();
        manager.run();
    }
}