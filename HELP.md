1. 安裝 Docker，執行以下指令，mssql 就會啟動
```bat
docker pull mcr.microsoft.com/mssql/server:2022-latest
docker run -e "ACCEPT_EULA=Y" -e "MSSQL_SA_PASSWORD=Aaa12345" -p 1433:1433 --name sql1 --hostname sql1 -d mcr.microsoft.com/mssql/server:2022-latest
```
2. 在 master database 建置 DDL
```sql
CREATE TABLE [dbo].[user](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[username] [nvarchar](50) NULL,
	[password] [nvarchar](50) NULL,
 CONSTRAINT [PK_user] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]



  CREATE TABLE [data](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[full_name] [nvarchar](50) NULL,
	[nick_name] [nvarchar](50) NULL,
	[slogan] [nvarchar](200) NULL,
	[price] [nvarchar](50) NULL,
	[lock_file_path] [nvarchar](50) NULL,
	[lock_file_name] [nvarchar](50) NULL,
 CONSTRAINT [PK_data] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
```
3. 自己随便新增資料
4. 啟動 Backend Server
5. 測試使用 postman 打 /api/user/login api，body 為以下， user 表將會被整張刪除
```json 
{
    "username": "1';delete from \"user\"--",
    "password": "123"
} 
```
6. 建立 Frontend server 串接 Backend Server