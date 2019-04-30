# webflux r2dbc mysql 

## 결론은 아직은 쓰지마라... (2019-04-30 기준)
- 업데이트시 PreparedStatement 에 parameter 바인딩이 순서대로 안됨
- 나머지는 잘 되는 것처럼 보임
- 설정시 수많은 삽질이 들어감 (정식 버전은 아직 머~~얼리 있는 듯)
- 아직 mysql 은 blocking 걸리게 사용하자...

## docker mysql
```
docker run --name=mysql_test -d -p 3306:3306 -e MYSQL_ROOT_PASSWORD=root -e MYSQL_USER=test -e MYSQL_PASSWORD=test -e MYSQL_DATABASE=test mysql/mysql-server:5.7.24
```
