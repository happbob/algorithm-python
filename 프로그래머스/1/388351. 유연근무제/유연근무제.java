class Solution {
    public int solution(int[] schedules, int[][] timelogs, int startday) {
        int answer = 0;

        for(int i = 0; i < schedules.length; i++) {
            boolean canGetPresent = true;
            int scheduleMinutes=schedules[i]/100*60 + schedules[i]%100 + 10;
//            System.out.println("------------------------------");
//            System.out.println(scheduleMinutes);
            for(int j = 0; j < 7; j++) {

                if(j==7-startday || j==6-startday || (j==6 && 6-startday==-1)) continue;
                int buffMinute= timelogs[i][j]/100*60 + timelogs[i][j]%100;
//                System.out.println(buffMinute);
                if(buffMinute > scheduleMinutes) {
                    canGetPresent = false;
                    break;
                }
            }
            if(canGetPresent) answer++;
        }

        return answer;
    }
}