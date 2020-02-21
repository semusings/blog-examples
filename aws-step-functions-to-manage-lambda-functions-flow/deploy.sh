#!/usr/bin/env bash
./gradlew clean build

LOG_FILE=deploy.aws.log
serverless deploy -v | tee ${LOG_FILE}

export ServiceEndpoint=$(awk '/ServiceEndpoint:/' ${LOG_FILE} | cut -c18-200)
echo "API Service Endpoint: ${ServiceEndpoint}"
rm -rf cypress.json
cat cypress.bak.json |
  jq 'to_entries |
       map(if .key == "env"
          then . + {"value": {
                                "ordersEndpoint": "'${ServiceEndpoint}'/orders"
                            }
                   }
          else .
          end
         ) |
      from_entries' > cypress.json

npm run cypress:run