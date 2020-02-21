# Ehcache vs Redis in Hibernate


### Artillery.io:

It’s node js plug in and the tester has to install the plugin the application to do the load testing.

Artillery is a modern, powerful & easy-to-use load testing toolkit. Use it to make your applications stay scalable, performant & resilient under high load.


The tester can write the script for load testing in 2 ways. Either json or yaml.

     Explanation of the code:

Target : "target" : "http://localhost:8080/orders",

Mention the target server host name.

Phases:

(i) { “duration”   : 1000, “arrivaRate”: 1},

Create 1 virtual users every second (on average) for 17 minutes

(ii) { “duration”: 60, “arrivalCount”: 20 }

Create 20 virtual users in 60 seconds (one every 3 seconds on average)

(iii) { “duration”   :  100,  “arrivalRate” :10, “rampTo”: 1000}

Ramp up arrival rate from 10 to 1000 over 17 minutes:

(iii) { “duration”   :  1,  “arrivalRate” :10000 }

Attempting to send 10,000 requests over the 1-second duration of your test

