func islandPerimeter(grid [][]int) int {
     col := len(grid[0])
     row := len(grid)
       perimeter :=0
     for r := 0; r<row;r++{
        for c:=0 ;c<col;c++{
            if grid[r][c] == 1{
                perimeter+=4
                if r>0 && grid[r-1][c]==1{
                    perimeter-=2
                }
                if c >0 && grid[r][c-1]==1{
                    perimeter -=2
                }
            }
        }
     } 
     return perimeter     
}