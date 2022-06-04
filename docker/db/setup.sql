IF DB_ID('$(MSSQL_DB)') IS  NULL
begin
create DATABASE $(MSSQL_DB);
SELECT 'The Database $(MSSQL_DB) has been Created';
end
ELSE
begin
PRINT 'The Database $(MSSQL_DB) already exists';
END

ALTER DATABASE $(MSSQL_DB) SET AUTO_CLOSE OFF;

GO
--USE $(MSSQL_DB);
--GO
--CREATE LOGIN $(MSSQL_USER) WITH PASSWORD = '$(MSSQL_PASSWORD)';
--GO
--CREATE USER $(MSSQL_USER) FOR LOGIN $(MSSQL_USER);
--GO
--ALTER SERVER ROLE sysadmin ADD MEMBER [$(MSSQL_USER)];
--GO