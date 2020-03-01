public class Schedule {
  int[][] schedule;

  Schedule(int nRooms, int nTimeSlots) {
    schedule = new int[nRooms][nTimeSlots];
  }
  
 
  
  public int randomRoom(SchedulingProblem a) {
	 return a.random.nextInt(schedule.length);
  }
  
  public int randomCourse(SchedulingProblem c, int randomRoom) {
	 return c.random.nextInt(schedule[randomRoom].length);
  }
  
  
  public Schedule copy() {
    Schedule sc = new Schedule(schedule.length, schedule[0].length);
    for(int i = 0; i < schedule.length; i++)
        for(int j = 0; j < schedule[i].length; j++)
            sc.schedule[i][j] = schedule[i][j];
    
    return sc;
}
  
  public Schedule getNeighbors(SchedulingProblem problem){
      Schedule sc = copy();
      int firstRandomRoom = randomRoom(problem); 
      int firstCourse = randomCourse(problem, firstRandomRoom); 
      
      int secondRandomRoom = randomRoom(problem); 
      while(firstRandomRoom == secondRandomRoom) {
          secondRandomRoom = randomRoom(problem);
      }
      int secondCourse = randomCourse(problem, secondRandomRoom);
      
      
      int temp = schedule[firstRandomRoom][firstCourse];
      
      sc.schedule[firstRandomRoom][firstCourse] = schedule[secondRandomRoom][secondCourse];
      sc.schedule[secondRandomRoom][secondCourse] = temp;
      
      return sc;
  }
}
