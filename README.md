# rock-paper-scissors
rock-paper-scissors game backend implementation with Java and Spring Boot

## Simplified parts
- Security part is skipped, server assume that in each http header called __"x-email"__ we got 
playing user __username(email)__ instead of user __sign-in/sign-up__ and __jwt__ token parsing
- Providing http header __"x-email"__ is __mandatory__ and if requests are not including it then server 
respond with __400(bad request) MissingRequestHeaderException__
- During game play we use __"/play"__ __POST request__ providing user choice of 
__"ROCK"__, __"PAPER"__ or __"SCISSORS"__ and responding with status 
__"WIN"__, __"LOSE"__ or __"DRAW"__
- Based on above we keep only one table in DB called __"user_scores"__ and containing few fields: 
__id__, __user_email__, __win_count__, __lose_count__ and __draw_count__
- If during __"/play"__ POST request there is no any record with provided __email__ then we create 
it on the fly assuming this is a __new user__
- Another __endpoint__ is __"/statistics"__ which is a __GET request__ and expecting as mention above 
header __"x-email"__, if record with provided __email__ not found server throw __404(not found)__ __UserNotFoundException__


## Endpoints and configuration
### Server starts under port __8081__ and contain mandatory path of __/api/v1__
- "localhost:8081/api/v1/game/statistics" GET request with custom header "x-email"
- "localhost:8081/api/v1/game/play" POST request with custom header "x-email" and request body: 
{"choice": __"CHOICE"__}, where __CHOICE__ is one of __"ROCK"__, __"PAPER"__ or __"SCISSORS"__
- In case of wrong value for __"CHOICE"__ in body Server respond with __400(bad request)__ __InvalidChoiceValueException__
- In case of missing header __"x-email"__ in http headers Server respond with __400(bad request)__ __MissingRequestHeaderException__
- In case of wrong value in header __"x-email"__ Server respond with __404(not found)__ __UserNotFoundException__

### As Database used __Postgres__ 
- you can start it in docker with follow command:
  ####  docker run --name my-postgres -e POSTGRES_USER=postgres -e POSTGRES_PASSWORD=postgres -d -p 5432:5432 -v pgdata:/var/lib/postgresql/data postgres
### Application will connect to mention port __5432__ with db named __game__ and schema named __game__
- For this configuration there is sql script __[db_and_schema_init.sql](src%2Fmain%2Fresources%2Fdb%2Fsql%2Fdb_and_schema_init.sql)__ which create db and schema in it called __game__
    #### NOTE: this must be done manually after connecting to database

### Application use FlyWay as migration tool, which will create needed table in db and schema called __game__

## Tech stack: 
- ### Java 17, 
- ### Gradle 8.8, 
- ### Spring Boot 3, 
- ### PostgresDB 16(latest image)