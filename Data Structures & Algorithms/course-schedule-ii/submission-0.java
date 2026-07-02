class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<Integer> ans=new ArrayList<>();
        int[] indegree=new int[numCourses];
        List<Integer>[] graph=new ArrayList[numCourses];
        for(int i=0;i<numCourses;i++){
            graph[i]=new ArrayList<>();
        }
        for(int[] p:prerequisites){
            int course=p[0];
            int prerequest=p[1];
            graph[prerequest].add(course);
            indegree[course]++;
        }
        int count=0;
        Queue<Integer> queue=new LinkedList<>();
        for(int i=0;i<numCourses;i++){
            if(indegree[i]==0){
                queue.offer(i);
            }
        }
        while(!queue.isEmpty()){
            int current=queue.poll();
            count++;
            ans.add(current);
            for(int next:graph[current]){
                indegree[next]--;
                if(indegree[next]==0){
                    queue.offer(next);
                }
            }
        }
        if(count!=numCourses){
            return new int[]{};
        }
        int[] result = new int[numCourses];
        for(int i = 0; i < numCourses; i++){
            result[i] = ans.get(i);
        }
        return result;
    }
}