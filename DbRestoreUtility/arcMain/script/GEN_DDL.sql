.RUN FILE data/Login_Info.properties
 
.EXPORT REPORT FILE = data/SHOWSQL.txt

.SET WIDTH 64000;
 
.SET TITLEDASHES OFF;

.SET FOLDLINE OFF;

SELECT 'SHOW TABLE '||TRIM(DATABASENAME)||'.'||TRIM(TABLENAME)||';' (TITLE '') FROM  DBC.TABLESV WHERE TABLEKIND ='T' AND TEMPORALPROPERTY <> 'N' AND DATABASENAME IN (sel databaseName from dbc.databases where ownername=user or databasename=user) ORDER BY CREATETIMESTAMP;


.EXPORT RESET ;


.EXPORT REPORT FILE = data/DDL.txt

.SET WIDTH 64000;
 
.SET TITLEDASHES OFF;

.SET FOLDLINE OFF;

.RUN FILE data/SHOWSQL.txt


.EXPORT RESET ;




.QUIT