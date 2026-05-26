class Solution {
    public boolean isValidSudoku(char[][] board) {
      boolean[] check=new boolean[9];
      for(int i=0;i<9;i++){
        Arrays.fill(check,false);
        for(int j=0;j<9;j++){
            if (board[i][j] == '.') continue;
            int x= board[i][j]-'1';
            if(check[x]==true){
                return false;
            }else{
                check[x]=true;
            }
        }
      }
      for(int i=0;i<9;i++){
        Arrays.fill(check,false);
        for(int j=0;j<9;j++){
            if (board[j][i] == '.') continue;
            int x=board[j][i]-'1';
            if(check[x]==true){
                return false;
            }else{
                check[x]=true;
            }
        }
      }
      for(int row = 0; row < 9; row += 3){

    for(int col = 0; col < 9; col += 3){

        Arrays.fill(check, false);

        for(int i = row; i < row + 3; i++){

            for(int j = col; j < col + 3; j++){

                if(board[i][j] == '.') continue;

                int x = board[i][j] - '1';

                if(check[x]){
                    return false;
                }

                check[x] = true;
            }
        }
    }
    }
        return true;
    }
}
