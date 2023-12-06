#!/bin/bash

java -jar -Xmx32m -Xss256k -XX:MaxRAM=150m -XX:MaxRAMPercentage=70 -XX:+UseSerialGC /home/budi/plugin-app-repo/target/springboot-mysql-docker.jar