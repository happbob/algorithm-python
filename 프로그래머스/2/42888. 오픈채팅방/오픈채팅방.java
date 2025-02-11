import java.util.*;
class Action {
    public String id;
    public String command;
    
    public Action(String id,String command){
        this.id = id;
        this.command = command;
    }
}
class Solution {
    public String[] solution(String[] record) {
        ArrayList<String> answer = new ArrayList<String>();
        HashMap<String, String> database = new HashMap<String,String>();
        Deque<Action> records = new ArrayDeque<Action>();
        String command, id, name;
        
        // record배열 기반으로 아이템 순회
        for(String recordItem: record){
            // 각 변수 파싱
            String[] parts = recordItem.split(" "); // 공백 기준으로 문자열 분리
            command = parts[0];
            id = parts[1];

            if (command.equals("Enter") || command.equals("Change")) {
                name = parts[2]; // 이름이 존재하는 경우
                database.put(id, name);
            }
            
            // 이름 바꿀 땐 저장 안함
            if (command.equals("Enter") || command.equals("Leave")) records.offer(new Action(id,command));
        }
        
        while(!records.isEmpty()){
            Action userAction = records.poll();
            String userName = database.get(userAction.id);
            String userCommand = userAction.command;
            StringBuilder sb = new StringBuilder();
            sb.append(userName).append("님이 ");
            if(userCommand.equals("Enter")){
                sb.append("들어왔습니다.");    
            }else if(userCommand.equals("Leave")) {
                sb.append("나갔습니다.");   
            }
            answer.add(sb.toString());
        }
        
        return answer.toArray(new String[0]);
    }
}