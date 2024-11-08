#!/bin/bash
set -eo pipefail

host="$(hostname --ip-address || echo '127.0.0.1')"

until cqlsh -u cassandra -p cassandra "$host" -e 'describe keyspaces'; do
  >&2 echo "Cassandra is unavailable - sleeping"
  sleep 5
done

>&2 echo "Cassandra is up - executing command"
cqlsh -f /docker-entrypoint-initdb.d/init.cql