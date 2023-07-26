class Solution:
    def dfs(self,ind,i,j,board,word):
        if ind == len(word):
            return True
        if i<0 or i>=len(board) or j<0 or j>=len(board[0]) : #out of bound case
            return False
        ans=False
        if word[ind]==board[i][j]:
            board[i][j]="*"
            ans=self.dfs(ind+1,i+1,j,board,word) or self.dfs(ind+1,i,j+1,board,word) or self.dfs(ind+1,i-1,j,board,word) or self.dfs(ind+1,i,j-1,board,word) 
            board[i][j]=word[ind]
        return ans

    def exist(self, board: List[List[str]], word: str) -> bool:
        m=len(board[0])
        n=len(board)
        ind=0
        for i in range(n):
            for j in range(m):
                if word[ind]==board[i][j] :
                    if self.dfs(ind,i,j,board,word):
                        return True
        return False
