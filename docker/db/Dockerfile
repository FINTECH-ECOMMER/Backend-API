FROM mcr.microsoft.com/mssql/server:2022-latest


RUN mkdir -p /usr/config
WORKDIR /usr/config

COPY . /usr/config
USER root

RUN chmod +x /usr/config/entrypoint.sh
RUN chmod +x /usr/config/configure-db.sh
#
#
ENTRYPOINT ["./entrypoint.sh"]
## Tail the setup logs to trap the process
CMD ["tail -f /dev/null"]

HEALTHCHECK --interval=15s CMD /opt/mssql-tools/bin/sqlcmd -U sa -P $SA_PASSWORD -Q "select 1" && grep -q "Recovery is complete" ./config.log