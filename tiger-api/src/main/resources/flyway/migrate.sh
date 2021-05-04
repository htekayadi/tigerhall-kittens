FLYWAY_HOME=/Users/$(whoami)/Downloads/flyway-5.2.4
MIGRATION_HOME=/Users/$(whoami)/tigerhall-kittens/tiger-api/src/main/resources/flyway

$FLYWAY_HOME/flyway -configFiles=$MIGRATION_HOME/flyway.conf -locations=filesystem:$MIGRATION_HOME/sql migrate