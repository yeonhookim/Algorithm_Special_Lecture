package pg;
import java.util.*;

public class pg0523 {

}
class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];

        // 중복되는 신고 없애기
        Set<String> reportSet = new HashSet<>(Arrays.asList(report));
        // System.out.println(reportSet);

        // 신고 받은 횟수 기록하기
        Map<String, Integer> reportCount = new HashMap<>();


        // 내가 누굴 신고했지? 기록
        Map<String, List<String>> iReportWho = new HashMap<>();
        for(String s : reportSet) {
            String[] part = s.split(" ");
            // System.out.println(Arrayys.toString(part));
            String from = part[0];
            String to = part[1];
            // System.out.println(s);

            reportCount.put(to, reportCount.getOrDefault(to, 0) + 1);
            //신고받은 사람한테 아무것도 없으면 0을 디폴트로 하고, 값이 있으면 그걸 가져와서 +1을 해라 그럼 카운트가 하나씩 하나씩 오름
            // System.out.println(reportCount);
            // System.out.println(s);

            //from 이 신고한 사람
            //내가 신고한 사람 입장에서 누굴 신고했는지를 리스트를 가지고있는데
            // 추가만 하면 된다.
            // get을 하려면 아무것도 없을 수 있음
            //그러면 조건문을 써줘야함
            if(!iReportWho.containsKey(from)){
                iReportWho.put(from, new ArrayList<>());
            }
            iReportWho.get(from).add(to);
            // System.out.println(iReportWho);

        }
        // K번 이상 신고받은 사람들 찾기
        Set<String> banned = new HashSet<>();
        for(int i = 0; i < id_list.length; i++){
            String reportee = id_list[i];
            if(reportCount.getOrDefault(reportee, 0) >= k){
                banned.add(reportee);
                // System.out.println(reportee + "는 제재 당하였습니다.");
            }
        }
        // 제재 받은 사람을 신고한 사람한테 알림주기 answer[i]++;
        for(int i = 0; i < id_list.length; i++){
            String reporter = id_list[i];
            List<String> targets = iReportWho.getOrDefault(reporter, new ArrayList<>());
            // System.out.println(iReportWho.getOrDefault(reporter, new ArrayList<>()));
            for(String target : targets){
                if(banned.contains(target)){
                    answer[i] += 1;
                }
            }
        }

        return answer;
    }
}
