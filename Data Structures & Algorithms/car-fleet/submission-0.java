class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
      int n=position.length;
      Integer[] idx=new Integer[n];
      for(int i=0;i<n;i++){
        idx[i]=i;
      }
      Arrays.sort(idx,(a,b)->position[a]-position[b]);
      int fleets=0;
      double maxTime=0;
      for(int i=n-1;i>=0;i--){
        double time=(double)(target-position[idx[i]])/speed[idx[i]];
        if(time>maxTime){
          fleets++;
          maxTime=time;
        }
      }
      return fleets;
    }
}
