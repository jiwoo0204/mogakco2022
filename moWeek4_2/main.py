
#입력 받기
n, m = map(int, input().split())
arr = [list(map(int, input())) for i in range(n)]
visit = [[False]*m for i in range(n)]
darr = [[-1, 0], [1, 0], [0, -1], [0, 1]]

queue = [[0, 0]]
visit[0][0] = True

while queue:
    px, py = queue.pop(0)

    for i in range(4):
        nx = px + darr[i][0]
        ny = py + darr[i][1]

        if nx < 0 or ny < 0 or nx >= n or ny >= m:
            continue
        if visit[nx][ny] or arr[nx][ny] == 0:
            continue

        queue.append([nx, ny])
        arr[nx][ny] = arr[px][py] + 1
        visit[nx][ny] = True

print(arr[n-1][m-1])